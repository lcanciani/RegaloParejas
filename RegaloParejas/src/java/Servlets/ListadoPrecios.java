/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author ferca
 */
@WebServlet(name = "ListadoPrecios", urlPatterns = {"/ListadoPrecios"})
public class ListadoPrecios extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccesoDatos ad = new AccesoDatos();
        ArrayList<Articulo> articulos = ad.getArticulos();
        request.setAttribute("articulos", articulos);
        RequestDispatcher rd = request.getRequestDispatcher("/listadoPrecio.jsp");
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
