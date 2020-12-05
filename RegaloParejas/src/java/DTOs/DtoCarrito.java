
package DTOs;


public class DtoCarrito {
    private double precioArticulo;
    private String descripcion;
    private double totalCarrito;

    public DtoCarrito(double precioArticulo, String descripcion, double totalCarrito) {
        this.precioArticulo = precioArticulo;
        this.descripcion = descripcion;
        this.totalCarrito = totalCarrito;
    }

    public double getPrecioArticulo() {
        return precioArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getTotalCarrito() {
        return totalCarrito;
    }

    public void setPrecioArticulo(double precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTotalCarrito(double totalCarrito) {
        this.totalCarrito = totalCarrito;
    }
    
    
}
