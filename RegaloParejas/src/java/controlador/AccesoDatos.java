
package controlador;

import DTOs.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.*;


public class AccesoDatos {
    
    Connection conexion;
    
    public AccesoDatos(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
    
    public void abrirConexion(){
        conexion = Conexion.getConnection();
    }
    
    public void cerrarConexion(){
        try {
        if(conexion != null && !conexion.isClosed()){
            
                conexion.close();
            }
        } catch (SQLException ex) {
                System.out.println(ex);
            }
        
    }
    
    public void insertarArticulo(Articulo a){
        
        String consulta = " insert into articulos values(?,?,?,?)";
        try {
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, a.getDescripcion());
            ps.setDouble(2, a.getPrecio());
            ps.setInt(3, a.getStock());
            ps.setBoolean(4, a.isBajaLogicaArticulo());
            ps.executeUpdate();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
            cerrarConexion();
        }
        
    }
    public void insertarPareja(Pareja p){
        
        String consulta = " insert into parejas values(?,?,?,?,?)";
        try {
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement(consulta);
            
            ps.setString(1, p.getPassword());
            ps.setString(2, p.getNombreUsuario());
            ps.setString(3, p.getEmail());
            ps.setBoolean(4, p.isBajaLogicaPareja());
            ps.setDouble(5, p.getMontoDisponible());
            
            ps.executeUpdate();
            cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex);
            cerrarConexion();
        }
        
    }
    
    public ArrayList getParejas(){
        ArrayList parejas = new ArrayList();
        String consultaSql = "select * from parejas";
        try{
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consultaSql);
            while(rs.next()){
                Pareja p = new Pareja(rs.getInt("idPareja"),rs.getString("usuarioPareja"),
                        rs.getString("password"),  rs.getString("email"),
                         rs.getDouble("montoDisponible"),rs.getBoolean("bajaLogicaParejas"));
                parejas.add(p);
            }
            rs.close();
            cerrarConexion();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return parejas;
    }
    
    public ArrayList<Articulo> getArticulos(){
        ArrayList<Articulo> articulos = new ArrayList<>();
        String consultaSql = "select * from articulos";
        try{
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consultaSql);
            while(rs.next()){
                Articulo a = new Articulo(rs.getInt("idArticulo"), rs.getString("descripcion"),
                        rs.getDouble("precio"), rs.getInt("stock"), rs.getBoolean("bajaLogicaArticulo"));
                articulos.add(a);
            }
            rs.close();
            cerrarConexion();
        }
        catch(SQLException e){
            cerrarConexion();
            System.out.println(e);
        }
        return articulos;
    }
    //devuelve true si no existe ese usuarion, si existe devuelve false
    public boolean validarUsuarioPareja(String usuario){
        boolean esValido = false;
        
        String consultaSql = "select usuarioPareja from parejas where usuarioPareja = ?";
        try{
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement(consultaSql);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                esValido = true;
            cerrarConexion();
        }
        catch(SQLException e){
            cerrarConexion();
            System.out.println(e);
        }
        
        return esValido;
    }
    public boolean validarPasswordPareja(String pass){
        boolean esValido = false;
        
        String consultaSql = "select password from parejas where password = ?";
        try{
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement(consultaSql);
            ps.setString(1, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                esValido = true;
            cerrarConexion();
        }
        catch(SQLException e){
            cerrarConexion();
            System.out.println(e);
        }
        
        return esValido;
    }
    public void insertarDeposito(DTOs.DtoDeposito d){
        String consultaSql = "{call uspRegistrarDeposito (?,?,?,?,?)}";
        try{
            abrirConexion();
            CallableStatement cs = conexion.prepareCall(consultaSql);
            
            cs.setDouble(1, d.getMonto());
            cs.setString(2, d.getFecha());
            cs.setString(3, d.getNombreInvitado());
            cs.setString(4, d.getApellidoInvitado());
            cs.setInt(5, d.getIdPareja());
            cs.execute();
            cerrarConexion();
        }
        catch(SQLException e){
            cerrarConexion();
            System.out.println(e);
            
        }
    }
    
    public void insertarCompra(DtoInsertarCompra c){
        String consultaSql = "{call uspRegistrarCompra (?,?,?,?,?)}";
        try{
            abrirConexion();
            CallableStatement cs = conexion.prepareCall(consultaSql);
            
            cs.setDouble(1, c.getPrecioArticulo());  
            cs.setInt(2, c.getIdArticulo());
            cs.setInt(3, 1);
            cs.setInt(4, c.getIdPareja());
            cs.setInt(5, c.getIdFactura());
            cs.execute();
            cerrarConexion();
        }
        catch(SQLException e){
            cerrarConexion();
            System.out.println(e);
            
        }
    }
    
    public Articulo getArticulosPoriD(int idArticulo){
        Articulo a = null;
        String consultaSql = "select * from articulos"
                + " where idArticulo = ?";
        try{
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement(consultaSql);
            ps.setInt(1, idArticulo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 a = new Articulo(rs.getInt("idArticulo"), rs.getString("descripcion"),
                        rs.getDouble("precio"), rs.getInt("stock"), rs.getBoolean("bajaLogicaArticulo"));   
            }
            rs.close();
            cerrarConexion();
        }
        catch(SQLException e){
            cerrarConexion();
            System.out.println(e);
        }
        return a;
    }
    public void actualizarArticulo(Articulo a){
        String consultaSql = "update articulos\n" +
"set descripcion = ?,\n" +
" precio = ?,\n" +
" stock = ?,\n" +
" bajaLogicaArticulo = ?\n" +
"where idArticulo = ?";
        try{
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement(consultaSql);
            ps.setString(1, a.getDescripcion());
            ps.setDouble(2,a.getPrecio());
            ps.setInt(3, a.getStock());
            ps.setBoolean(4, a.isBajaLogicaArticulo());
            ps.setInt(5, a.getIdArticulo());
            ps.execute();
            cerrarConexion();
        }
        catch(SQLException e){
            cerrarConexion();
            System.out.println(e);
        }
    }
    
    public int insertarFactura(Factura f){
        String consultaSql = "{call fInsertarFactura (?,?,?)}";
        int idFactura = 0;
        try{
            abrirConexion();
            CallableStatement cs = conexion.prepareCall(consultaSql);
            
            cs.setInt(1, f.getIdPareja());
            cs.setString(2, f.getFecha());
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            cs.execute();
            idFactura = cs.getInt(3);
            cerrarConexion();
            
        }
        catch(SQLException e){
            cerrarConexion();
            System.out.println(e);
            
        }
        return idFactura;
    }
    
    public double precioArticulo(int idAriculo){
        double precio = 0;
        String consultaSql = "select precio from articulos"
                + " where idArticulo = ?";
        try{
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement(consultaSql);
            ps.setInt(1, idAriculo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 precio = rs.getDouble("precio");   
            }
            rs.close();
            cerrarConexion();
        }
        catch(SQLException e){
            cerrarConexion();
            System.out.println(e);
        }
        return precio;
    }
     
    
    public ArrayList<TotalDepositadoPorPareja> totalDepositadoPorPareja(){
        String consultaSql = "select p.idPareja,p.usuarioPareja,sum(d.monto) as montoTotalDepositado, count(*) as cantidadDepositos\n" +
                            "  from parejas p \n" +
                            "  join depositosPorPareja dp on p.idPareja = dp.idPareja\n" +
                            "  join depositos d on dp.idDeposito = d.idDeposito\n" +
                            "  group by p.idPareja,p.usuarioPareja";
        ArrayList<TotalDepositadoPorPareja> parejas = new ArrayList();
        
        try{
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consultaSql);
            while(rs.next()){
                TotalDepositadoPorPareja p = new TotalDepositadoPorPareja(rs.getInt("idPareja"),rs.getString("usuarioPareja"),
                        rs.getDouble("montoTotalDepositado"));
                parejas.add(p);
            }
            rs.close();
            cerrarConexion();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return parejas;
        
    }
    
    public double totalFacturado(){
        String consultaSql = "select sum(precioUnitario*cantidad) as totalFacturado\n" +
"    from detalleFactura";
        double total = 0;
        try{
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consultaSql);
            if(rs.next()){
                total = rs.getDouble("totalFacturado");        
            }
            rs.close();
            cerrarConexion();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return total;
    }
    
    public ArrayList<DtoArticulosMasSolicitado> articulosMasSolicitados(){
        ArrayList<DtoArticulosMasSolicitado> articulos = new ArrayList<>();
        String consultaSql = "select top 5 df.idArticulo, a.descripcion,count(*) as cantParejas, sum(df.cantidad) as masSolicitado\n" +
                            " from facturas f\n" +
                            " join detalleFactura df on f.idFactura = df.idFactura\n" +
                            " join articulos a on df.idArticulo =a.idArticulo\n" +
                            " group by df.idArticulo, a.descripcion\n" +
                            " order by masSolicitado desc";
        try{
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consultaSql);
            while(rs.next()){
                DtoArticulosMasSolicitado a = new DtoArticulosMasSolicitado(rs.getInt("idArticulo"),
                        rs.getString("descripcion"),rs.getInt("cantParejas") ,rs.getInt("masSolicitado"));  
                articulos.add(a);
            }
            rs.close();
            cerrarConexion();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return articulos;
    }
    
}
