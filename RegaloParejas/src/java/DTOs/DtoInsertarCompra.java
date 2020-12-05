
package DTOs;


public class DtoInsertarCompra {
   private double precioArticulo;
   
   private int idArticulo;
   private int idFactura;
   private int idPareja;
   private int cantidad;

    public DtoInsertarCompra(double precioArticulo, int idArticulo, int idFactura, int idPareja, int cantidad) {
        this.precioArticulo = precioArticulo;
        this.idArticulo = idArticulo;
        this.idFactura = idFactura;
        this.idPareja = idPareja;
        this.cantidad = cantidad;
    }

    public double getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(double precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
