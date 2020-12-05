
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {
    public static Connection getConnection(){
        String cadenaConexion = "jdbc:sqlserver://localhost;Database=RegaloParejas";
        String user = "sa";
        String password = "sqlLove";
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(cadenaConexion, user, password);
        } catch (SQLException ex) {
            System.out.println(ex);;
        }
        return conexion;
    }
}
