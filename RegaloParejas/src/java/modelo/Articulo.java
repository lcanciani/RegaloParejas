
package modelo;


public class Articulo {
    private int idArticulo;
    private String descripcion;
    private double precio;
    private int stock;
    private boolean bajaLogicaArticulo;

    public Articulo(int idArticulo, String descripcion, double precio, int stock, boolean bajaLogicaArticulo) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.bajaLogicaArticulo = bajaLogicaArticulo;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public boolean isBajaLogicaArticulo() {
        return bajaLogicaArticulo;
    }
    
    
}
