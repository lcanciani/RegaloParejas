
package Servlets;

import controlador.AccesoDatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Logear", urlPatterns = {"/Logear"})
public class Logear extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/logIn.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("txtUsuario");
        String password = request.getParameter("txtPassword");
        AccesoDatos ad = new AccesoDatos();
        if(ad.validarUsuarioPareja(usuario) && ad.validarPasswordPareja(password)){
            request.getSession().setAttribute("usuario", usuario);
            response.sendRedirect( getServletContext().getContextPath()+"/compraArticulo");
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("/logIn.jsp");
        rd.forward(request, response);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
