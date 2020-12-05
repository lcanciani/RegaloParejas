
package Servlets;

import controlador.AccesoDatos;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Articulo;


@WebServlet(name = "EditarArticulo", urlPatterns = {"/EditarArticulo"})
public class EditarArticulo extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idArticulo = Integer.parseInt(request.getParameter("idArticulo"));
        AccesoDatos ad = new AccesoDatos();
        Articulo a = ad.getArticulosPoriD(idArticulo);
        request.setAttribute("articulo", a);
        RequestDispatcher rd = request.getRequestDispatcher("/EditarArticulo.jsp");
        rd.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       AccesoDatos ad = new AccesoDatos();
       int idArticulo = Integer.parseInt(request.getParameter("txtIdArticulo"));
       String descripcion = request.getParameter("txtDescripcion");
       double precio = Double.parseDouble(request.getParameter("txtPrecio"));
       int stock = Integer.parseInt(request.getParameter("txtStock"));
       boolean bajaLogica = Boolean.parseBoolean(request.getParameter("chkBajaLogica"));
       
       Articulo a = new Articulo(idArticulo, descripcion, precio, stock, bajaLogica);
       ad.actualizarArticulo(a);
       response.sendRedirect(getServletContext().getContextPath()+"/ListadoArticulos");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
