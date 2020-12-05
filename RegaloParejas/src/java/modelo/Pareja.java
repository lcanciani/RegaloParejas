
package modelo;


public class Pareja {
    private int idPareja;
    private String nombreUsuario;//agregar
    private String password;//agregar
    private String email;
    private double montoDisponible;
    private boolean bajaLogicaPareja;

    public Pareja(int idPareja, String nombreUsuario, String password, String email, double montoDisponible, boolean bajaLogicaPareja) {
        this.idPareja = idPareja;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
        this.montoDisponible = montoDisponible;
        this.bajaLogicaPareja = bajaLogicaPareja;
    }

    public int getIdPareja() {
        return idPareja;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public double getMontoDisponible() {
        return montoDisponible;
    }

    public boolean isBajaLogicaPareja() {
        return bajaLogicaPareja;
    }

    

       
    
}
