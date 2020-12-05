/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import controlador.AccesoDatos;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pareja;


@WebServlet(name = "RegistroPareja", urlPatterns = {"/RegistroPareja"})
public class RegistroPareja extends HttpServlet {

   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccesoDatos ad = new AccesoDatos();
        String usuario = request.getParameter("txtUsuario");
        String password = request.getParameter("txtPassword");
        String email = request.getParameter("txtEmail");
        
        if(ad.validarUsuarioPareja(usuario)){
        Pareja p = new Pareja(0, usuario, password, email, 0, false);
        ad.insertarPareja(p);
        RequestDispatcher rd = request.getRequestDispatcher("/logIn.jsp");
        rd.forward(request, response);
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
