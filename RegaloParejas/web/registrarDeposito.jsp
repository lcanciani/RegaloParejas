<%-- 
    Document   : deposito
    Created on : 05/11/2020, 10:37:42
    Author     : ferca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "bootstrap.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Depositos!</h1>
        
        <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2 "></div>
                    <div class="col-12 col-sm-12 col-md-8 col-lg-4">
                        <form method="post" action="Deposito">
        <label class="">Seleccione la pareja</label>
            <select name="cboParejas" class="form-control" onchange=" ">
                <c:forEach items="${parejas}" var="p">
                    <option value="${p.getIdPareja()}">${p.getNombreUsuario()}</option>
            </c:forEach>
            </select>
            <label class="">Nombre</label>
            <input type="text" name="txtNombreInvitado" class="form-control" value="">
            
            <label class="">Apellido</label>
            <input type="text" name="txtApellidoInvitado" class="form-control">
            
            <label class="">Ingrese el monto</label>
            <input type="text" name="txtMontoDeposito" class="form-control">
            
            <label >Seleccione fecha:</label>
            <input type="datetime-local" name="dtpFechaDeposito" id="datetime" class="form-control" >
            
            <input type="submit" value="Registrar Deposito" class="btn btn-success">

            </form>
            </div>
                    <div class="col-2 "></div>
                </div>
            </div>
            
    </body>
</html>
