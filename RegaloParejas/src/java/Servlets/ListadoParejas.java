
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


@WebServlet(name = "ListadoParejas", urlPatterns = {"/ListadoParejas"})
public class ListadoParejas extends HttpServlet {

    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       AccesoDatos ad = new AccesoDatos();
        ArrayList<Pareja> parejas = ad.getParejas();
        request.setAttribute("parejas", parejas);
        RequestDispatcher rd = request.getRequestDispatcher("/listadoParejas.jsp");
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
