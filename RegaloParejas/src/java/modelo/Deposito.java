
package modelo;


public class Deposito {
    private int idDeposito;
    private double monto;
    private String fecha;
    private String nombreInvitado;
    private String apellidoInvitado;
    

    public Deposito(int idDeposito, double monto, String fecha, String nombreInvitado, String apellidoInvitado) {
        this.idDeposito = idDeposito;
        this.monto = monto;
        this.fecha = fecha;
        this.nombreInvitado = nombreInvitado;
        this.apellidoInvitado = apellidoInvitado;
        
    }

    public int getIdDeposito() {
        return idDeposito;
    }

    public double getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombreInvitado() {
        return nombreInvitado;
    }

    public String getApellidoInvitado() {
        return apellidoInvitado;
    }

    
    
    
}
