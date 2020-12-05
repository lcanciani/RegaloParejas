/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTOs.TotalDepositadoPorPareja;
import controlador.AccesoDatos;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Reportes", urlPatterns = {"/Reportes"})
public class Reportes extends HttpServlet {

   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("usuario") == null){
            response.sendRedirect(request.getContextPath()+"/logIn.jsp");
        }else{
        ArrayList<TotalDepositadoPorPareja> parejas;
        ArrayList<DTOs.DtoArticulosMasSolicitado> articulos;
        double totalFacturado;
        AccesoDatos ad = new AccesoDatos();
        parejas = ad.totalDepositadoPorPareja();
        articulos = ad.articulosMasSolicitados();
        totalFacturado = ad.totalFacturado();
        
        request.setAttribute("parejas",parejas);
        request.setAttribute("articulos",articulos);
        request.setAttribute("totalFacturado",totalFacturado);
        
        RequestDispatcher rd = request.getRequestDispatcher("reportes.jsp");
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
