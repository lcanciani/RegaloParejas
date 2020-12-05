
package Servlets;

import controlador.AccesoDatos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Articulo;


@WebServlet(name = "AltaArticulo", urlPatterns = {"/AltaArticulo"})
public class AltaArticulo extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descripcion = request.getParameter("txtDescripcion");
        double precio = Double.parseDouble(request.getParameter("txtPrecio"));
        int stock = Integer.parseInt(request.getParameter("txtStock"));
        boolean bajaLogica = Boolean.parseBoolean(request.getParameter("chkBajaLogica"));
        Articulo a = new Articulo(0, descripcion, precio, stock, bajaLogica);
        AccesoDatos ad = new AccesoDatos();
        ad.insertarArticulo(a);
        response.sendRedirect(getServletContext().getContextPath()+"/ListadoArticulos");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
