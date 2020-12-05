<%@page import="DTOs.DtoCarrito"%>


<%@page import="java.util.ArrayList"%>
<%@page import="DTOs.DtoParejasArticulos"%>
<%@page import="modelo.Pareja"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="bootstrap.html" %>
<!DOCTYPE html>
<c:choose>
    <c:when test="${not empty usuario}">
        
    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form action="RegistroCompra" method="post">
                        <label class="">Listado de artículos disponibles para la compra:</label>


                        <table class="table">
                            <tr>
                                <th>Id</th>
                                <th>Descripcion</th>
                                <th>Precio</th>
                                <th>Stock</th>
                                <th>Seleccionar</th>
                            </tr>
                            <c:forEach items="${dtoParejasArticulos.getArticulos()}" var="a">
                                <tr>
                                    <td>${a.getIdArticulo()}</td>
                                    <td>${a.getDescripcion()}</td>
                                    <td>${a.getPrecio()}</td>
                                    <td>${a.getStock()}</td>
                                    <th><input type="checkbox" name="list" value="${a.getIdArticulo()}"></th>
                                </tr>
                            </c:forEach>
                        </table>
                        
                        
                        <%--  <select name="cboArticulos" class="form-control">
                         <c:forEach items="${dtoParejasArticulos.getArticulos()}" var="a">
                             <option value="${a.idArticulo}">${a.descripcion} $${a.precio}</option>
                         </c:forEach>
                         </select>--%>

                        <label class="">Parejas</label>
                        <select name="cboParejas" class="form-control" onchange="">
                            <c:forEach items="${dtoParejasArticulos.getParejas()}" var="p">
                                <option value="${p.idPareja}">${p.nombreUsuario} $${p.montoDisponible}</option>
                            </c:forEach>
                        </select>
                        <br>

                        <input type="submit" value="Comprar" class="btn btn-succes">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
</c:when>
</c:choose>