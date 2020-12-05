<%-- 
    Document   : reportes
    Created on : 09/11/2020, 10:45:01
    Author     : ferca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Monto total depositado por pareja</h1>

        <table class="table">
            <tr>
                <th>Id</th>
                <th>Usuario</th>
                <th>Monto total depositado</th>
                
       
            </tr>
            <c:forEach items="${parejas}" var="p">
                <tr>
                    <td>${p.getIdPareja()}</td>
                    <td>${p.getUsuario()}</td>
                    <td>${p.getMontoTotal()}</td>
                </tr>
            </c:forEach>
        </table>
        <h1>Articulos</h1>

        <table class="table">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Cantidad parejas</th>
                <th>Mas solicitado</th>  
                
            </tr>
            <c:forEach items="${articulos}" var="p">
                <tr>
                    <td>${p.getIdArticulo()}</td>
                    <td>${p.getDescripcion()}</td>
                    <td>${p.getCantParejas()}</td>
                    <td>${p.getMasSolicitado()}</td>                    
                </tr>
            </c:forEach>
        </table>
        
        <h1>Total de todo lo facturado</h1>
        <input type="text" readonly value="${totalFacturado}">
        
    </body>
</html>
