<%-- 
    Document   : menu
    Created on : 08/11/2020, 21:06:12
    Author     : ferca
--%>

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
        
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
  <div class="container">
    <a class="navbar-brand" href="#">
          <img src="http://placehold.it/150x50?text=Logo" alt="">
        </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="compraArticulo">Compra articulo
                <span class="sr-only">(current)</span>
              </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Reportes">Reporte</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ListadoArticulos">ABMC artículos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="logIn.jsp">Log In</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ListadoParejas">Listado parejas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ListadoPrecios">Listado precios</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Deposito">Depositos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="LogOut">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Page Content -->

<!-- /.container -->
    </body>
</html>
