

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file = "bootstrap.html" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header><%@include  file = "menu.jsp" %></header>
        <div class="container">
  <h1 class="mt-4">Bienvenidos!!!!</h1>
  
</div>
        <form method="POST" action="Logear">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2 "></div>
                    <div class="col-12 col-sm-12 col-md-8 col-lg-4">
                        <label>Usuario:</label>
                        <input type="text" class="form-control" name="txtUsuario">
                        <label>Password:</label>
                        <input type="password" class="form-control" name="txtPassword">
                        <br>
                        <input type="submit" class="btn btn-primary">
                    </div>
                    <div class="col-2 "></div>
                </div>
            </div>
        </form>
        <br>
        
    </body>
</html>
