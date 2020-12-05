
package modelo;

public class Factura {
    private int idFactura;
    private int idPareja;
    private String fecha;

    public Factura(int idFactura, int idPareja, String fecha) {
        this.idFactura = idFactura;
        this.idPareja = idPareja;
        this.fecha = fecha;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    
}
