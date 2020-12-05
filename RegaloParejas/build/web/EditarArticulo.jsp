<%-- 
    Document   : EditarArticulo
    Created on : 07/11/2020, 00:08:09
    Author     : ferca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="bootstrap.html" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Editar artículo</h1>
        <form action="EditarArticulo" method="post">
        <label>Identificador de Articulo</label>
        <input type="text" value="${articulo.getIdArticulo()}" class="form-control" readonly name="txtIdArticulo">
        
        <label>Descripcion</label>
        <input type="text" name="txtDescripcion" value="${articulo.getDescripcion()}">
        
        <label>Precio</label>
        <input type="text" name="txtPrecio" value="${articulo.getPrecio()}">
        <label>Stock</label>
        <input type="text" name="txtStock" value="${articulo.getStock()}">
        
        <label>Seleccione para dar de baja el articulo</label>
        <input type="checkbox" name="chkBajaArticulo" value="${articulo.isBajaLogicaArticulo()}">
        
        <input type="submit" value="Actualizar articulo" class="btn-succes">
        </form>
    </body>
</html>
