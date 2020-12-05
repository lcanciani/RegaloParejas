<%-- 
    Document   : listadoPrecio
    Created on : 09/11/2020, 10:27:59
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
        <h1>Listado de Precio</h1>

        <table class="table">
            <tr>
                <th>Descripcion</th>
                <th>Precio</th>             
            </tr>
            <c:forEach items="${articulos}" var="a">
                <tr>
                    <td>${a.getDescripcion()}</td>
                    <td>${a.getPrecio()}</td>            
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
