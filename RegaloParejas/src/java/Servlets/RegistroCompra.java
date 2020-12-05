package Servlets;

import DTOs.DtoInsertarCompra;
import controlador.AccesoDatos;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Articulo;
import modelo.Factura;
import modelo.Pareja;

@WebServlet(name = "RegistroCompra", urlPatterns = {"/RegistroCompra"})
public class RegistroCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

            String[] ids = request.getParameterValues("list");
            if (ids != null) {

                AccesoDatos ad = new AccesoDatos();
                String fechaValida;
                int[] valores;

                valores = convertirSringAInt(ids);
                LocalDate fecha = LocalDate.now();
                int idPareja = Integer.parseInt(request.getParameter("cboParejas"));
                fechaValida = obtenerFechaFormateada(fecha, "dd/LL/yyyy");
                Factura f = new Factura(0, idPareja, fechaValida);
                int idParejaSeleccionada = Integer.parseInt(request.getParameter("cboParejas"));
                double montoPareja = 0, precioArticulo = 0;

                ArrayList<Pareja> parejas = ad.getParejas();
                ArrayList<Articulo> articulos = ad.getArticulos();
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
                System.out.println(precioArticulo);
                System.out.println(montoPareja);

                if (montoPareja < precioArticulo) {
                    RequestDispatcher rd = request.getRequestDispatcher("/compraFallida.jsp");
                    rd.forward(request, response);
                } else {
                    for (int i = 0; i < ids.length; i++) {
                        DtoInsertarCompra dic = new DtoInsertarCompra(ad.precioArticulo(valores[i]), valores[i], ad.insertarFactura(f), idPareja, 1);
                        ad.insertarCompra(dic);
                        RequestDispatcher rd = request.getRequestDispatcher("/compraExitosa.jsp");
                        rd.forward(request, response);
                    }
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher("/compraSinArticulo.jsp");
            rd.forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private String obtenerFechaFormateada(LocalDate fecha, String formato) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formato);
        return fecha.format(dtf);
    }

    private int[] convertirSringAInt(String[] ids) {
        int[] valores = new int[ids.length];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = Integer.parseInt(ids[i]);
        }
        return valores;
    }
}
