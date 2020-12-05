<%-- 
    Document   : listadoArticulos
    Created on : 06/11/2020, 20:32:51
    Author     : ferca
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="bootstrap.html" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Listado de Articulos</h1>

        <table class="table">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Precio</th>
                <th>Stock</th>
                <th> Esta de Baja?</th>
                <th>Accion</th>
            </tr>
            <c:forEach items="${articulos}" var="a">
                <tr>
                    <td>${a.getIdArticulo()}</td>
                    <td>${a.getDescripcion()}</td>
                    <td>${a.getPrecio()}</td>
                    <td>${a.getStock()}</td>
                    <td>${a.isBajaLogicaArticulo()}</td>
                    <td><a class="btn btn-primary" href="EditarArticulo?idArticulo=${a.getIdArticulo()}" role="button">Editar</a></td>

                </tr>
            </c:forEach>
        </table>

    </body>
</html>
