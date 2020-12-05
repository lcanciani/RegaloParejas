<%-- 
    Document   : listadoParejas
    Created on : 09/11/2020, 00:52:02
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
        <h1>Listado de Parejas</h1>

        <table class="table">
            <tr>
                <th>Id</th>
                <th>Usuario</th>
                <th>Email</th>
                <th>Monto diponible</th>
                <th> Esta de Baja?</th>
                
            </tr>
            <c:forEach items="${parejas}" var="p">
                <tr>
                    <td>${p.getIdPareja()}</td>
                    <td>${p.getNombreUsuario()}</td>
                    <td>${p.getEmail()}</td>
                    <td>${p.getMontoDisponible()}</td>                    
                    <td>${p.isBajaLogicaPareja()}</td>
                    

                </tr>
            </c:forEach>
        </table>

    </body>
</html>
