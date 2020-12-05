

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="bootstrap.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Pareja</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Bienvenidos al registra de parejas S2</h1>
        <form method="post" action="RegistroPareja">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2 "></div>
                    <div class="col-12 col-sm-12 col-md-8 col-lg-4">
                        <label>Usuario:</label>
                        <input type="text" class="form-control" name="txtUsuario">
                        <label>Password:</label>
                        <input type="password" class="form-control" name="txtPassword">
                        <label>Email:</label>
                        <input type="text" class="form-control" name="txtEmail">
                        <br>
                        <input type="submit" class="btn btn-primary">
                    </div>
                    <div class="col-2 "></div>
                </div>
            </div>
        </form>
    </body>
</html>
