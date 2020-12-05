
package Servlets;

import controlador.AccesoDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Articulo;


@WebServlet(name = "ListadoArticulos", urlPatterns = {"/ListadoArticulos"})
public class ListadoArticulos extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("usuario")!= null){
            
        
        AccesoDatos ad = new AccesoDatos();
        ArrayList<Articulo> articulos = ad.getArticulos();
        request.setAttribute("articulos", articulos);
        RequestDispatcher rd = request.getRequestDispatcher("/listadoArticulos.jsp");
        rd.forward(request, response);
        }
        else{
            RequestDispatcher rd = request.getRequestDispatcher("/logIn.jsp");
        rd.forward(request, response);
        }
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
