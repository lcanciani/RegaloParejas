/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;


public class TotalDepositadoPorPareja {
    private int idPareja;
    private String usuario;
    private double montoTotal;

    public TotalDepositadoPorPareja(int idPareja, String usuario, double montoTotal) {
        this.idPareja = idPareja;
        this.usuario = usuario;
        this.montoTotal = montoTotal;
    }

    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    
}
