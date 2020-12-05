
package Servlets;

import controlador.AccesoDatos;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Articulo;
import modelo.Pareja;
import DTOs.DtoParejasArticulos;


@WebServlet(name = "compraArticulo", urlPatterns = {"/compraArticulo"})
public class compraArticulo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("usuario")!= null){
            
        AccesoDatos ad = new AccesoDatos();
        ArrayList<Articulo> articulos =  ad.getArticulos();
        ArrayList<Pareja> parejas = ad.getParejas();
        DtoParejasArticulos dpa = new DtoParejasArticulos();
        dpa.setArticulos(articulos);
        dpa.setParejas(parejas);
        request.setAttribute("dtoParejasArticulos", dpa);
        RequestDispatcher rd = request.getRequestDispatcher("/compraArticulo.jsp");
        rd.forward(request, response);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/logIn.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
