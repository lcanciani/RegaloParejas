
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="bootstrap.html" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta artículo</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="container-fluid">
            <header class="page-header">
                <h1 >Alta Artículo</h1>
            </header>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-8">


                    <form method="POST" action="AltaArticulo" >
                        <label>Descripcion</label>
                        <input type="text" name="txtDescripcion" class="form-control">
                        <br>
                        <label>Precio</label>

                        <input type="number" name="txtPrecio" class="form-control">
                        <br>
                        <label>Stock disponible</label>

                        <input type="number" name="txtStock" class="form-control">
                        <br>



                        <div class = "checkbox">
                            <label class="form-control">
                                <input type = "checkbox"  name="chkBajaLogica"> Baja lógica 
                            </label>
                        </div>

                        <br>
                        <input type="submit"  value="Alta articulo" class="btn btn-success">
                    </form>

                </div>
            </div>
        </div>

    </body>
</html>
