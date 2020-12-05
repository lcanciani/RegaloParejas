/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTOs.DtoParejasArticulos;
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
import modelo.Pareja;

/**
 *
 * @author ferca
 */
@WebServlet(name = "pruebas", urlPatterns = {"/pruebas"})
public class pruebas extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccesoDatos ad = new AccesoDatos();
        int idParejaSeleccionada = Integer.parseInt(request.getParameter("cboParejas"));
        ArrayList<Pareja> parejas = ad.getParejas();
        double monto = 0;
        for (Pareja p : parejas) {
            if (p.getIdPareja() == idParejaSeleccionada) {
                monto = p.getMontoDisponible();
            }

        }
        request.setAttribute("monto", monto);
        RequestDispatcher rd = request.getRequestDispatcher("/compraArticulo.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccesoDatos ad = new AccesoDatos();
        int idParejaSeleccionada = Integer.parseInt(request.getParameter("cboParejas"));
        int idArticuloSeleccionado = Integer.parseInt(request.getParameter("cboArticulos"));
        ArrayList<Pareja> parejas = ad.getParejas();
        ArrayList<Articulo> articulos = ad.getArticulos();
        double montoPareja = 0;
        double precioArticulo = 0;
        int[] valores = new int [3];
        for (Pareja p : parejas) {
            if (p.getIdPareja() == idParejaSeleccionada) {
                montoPareja = p.getMontoDisponible();
            }
            
        }
        for (int i = 0; i < valores.length; i++) {
            for (Articulo a : articulos) {
            if (a.getIdArticulo() == valores[i]) {
                precioArticulo += a.getPrecio();
            }
        }
        }
        
        
        
        
        if(montoPareja<precioArticulo){
            RequestDispatcher rd = request.getRequestDispatcher("/compraArticulo.jsp");
        rd.forward(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
