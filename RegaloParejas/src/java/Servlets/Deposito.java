
package Servlets;

import DTOs.*;
import controlador.AccesoDatos;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pareja;


@WebServlet(name = "Deposito", urlPatterns = {"/Deposito"})
public class Deposito extends HttpServlet {  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getSession().getAttribute("usuario")!= null){
        
       AccesoDatos ad = new AccesoDatos();
      
        ArrayList<Pareja> parejas = ad.getParejas();
        
        request.setAttribute("parejas", parejas);
        RequestDispatcher rd = request.getRequestDispatcher("/registrarDeposito.jsp");
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
    
        if(request.getSession().getAttribute("usuario")!= null){ 
        AccesoDatos ad = new AccesoDatos();
        int idPareja = Integer.parseInt(request.getParameter("cboParejas"));
        String nombreInvitado = request.getParameter("txtNombreInvitado");
        String apellidoInvitado = request.getParameter("txtApellidoInvitado");
        double monto = Double.parseDouble(request.getParameter("txtMontoDeposito"));
        String fecha = request.getParameter("dtpFechaDeposito");
        String fechaValida = fecha.substring(0, 10);
        
        DtoDeposito d = new DtoDeposito(monto, idPareja, nombreInvitado, apellidoInvitado,fechaValida);
        ad.insertarDeposito(d);
        response.sendRedirect(request.getContextPath() + "/compraArticulo");
        }
        else{
            RequestDispatcher rd = request.getRequestDispatcher("/logIn.jsp");
        rd.forward(request, response);
        }   
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
