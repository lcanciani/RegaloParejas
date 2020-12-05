
package DTOs;

import java.util.ArrayList;
import modelo.Articulo;
import modelo.Pareja;


public class DtoParejasArticulos {
    private ArrayList<Pareja> parejas;
    private ArrayList<Articulo> articulos;

    public ArrayList<Pareja> getParejas() {
        return parejas;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setParejas(ArrayList<Pareja> parejas) {
        this.parejas = parejas;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }
    
    
}
