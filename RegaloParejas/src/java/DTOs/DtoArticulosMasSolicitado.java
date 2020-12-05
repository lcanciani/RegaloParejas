
package DTOs;


public class DtoArticulosMasSolicitado {
    private int idArticulo;
    private String descripcion;
    private int cantParejas;
    private int masSolicitado;

    public DtoArticulosMasSolicitado(int idArticulo, String descripcion, int cantParejas, int masSolicitado) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.cantParejas = cantParejas;
        this.masSolicitado = masSolicitado;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantParejas() {
        return cantParejas;
    }

    public void setCantParejas(int cantParejas) {
        this.cantParejas = cantParejas;
    }

    public int getMasSolicitado() {
        return masSolicitado;
    }

    public void setMasSolicitado(int masSolicitado) {
        this.masSolicitado = masSolicitado;
    }
    
    
}
