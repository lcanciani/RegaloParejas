/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

/**
 *
 * @author ferca
 */
public class DtoDeposito {
    private double monto;
    private int idPareja;
    private String nombreInvitado;
    private String apellidoInvitado;
    private String fecha;

    public DtoDeposito(double monto, int idPareja, String nombreInvitado, String apellidoInvitado, String fecha) {
        this.monto = monto;
        this.idPareja = idPareja;
        this.nombreInvitado = nombreInvitado;
        this.apellidoInvitado = apellidoInvitado;
        this.fecha = fecha;
    }

    
    
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }

    public String getNombreInvitado() {
        return nombreInvitado;
    }

    public void setNombreInvitado(String nombreInvitado) {
        this.nombreInvitado = nombreInvitado;
    }

    public String getApellidoInvitado() {
        return apellidoInvitado;
    }

    public void setApellidoInvitado(String apellidoInvitado) {
        this.apellidoInvitado = apellidoInvitado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
