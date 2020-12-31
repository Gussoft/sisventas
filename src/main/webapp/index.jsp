
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://use.fontawesome.com/030c303ec1.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Material Design Bootstrap -->
        <link rel="stylesheet" href="css/mdb.min.css">
        <!-- Your custom styles (optional) -->
        <link rel="stylesheet" href="css/style.css"> <title>Tienda Guss</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Guss Shop</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="ProductoServlet?accion=home">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ProductoServlet?accion=oferta"><i class="far fa-caret-square-right">Ofertas</i></a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="ProductoServlet?accion=Carrito" tabindex="-1" aria-disabled="true">
                                <i class="fas fa-cart-plus">(<label style="color: orangered">${con}</label>)</i>Carrito</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    <ul class="navbar-nav ">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Iniciar Session
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                    </ul>
                </div>

            </div>
        </nav>
        <div class="container mt-2">
            <div class="row">
                <c:forEach var="p" items="${productos}">
                    <div class="col-sm-4 mt-2">
                        <div class="card">
                            <div class="card-header">${p.getNombres()}</div>
                            <div class="card-body">
                                <i>S/ ${p.getPrecio()}</i>
                                <img class="img-responsive" src="${p.getFoto()}" width="200" height="180">
                            </div>

                            <div class="card-footer text-center">
                                <label>${p.getDesc()}</label>
                                <div>
                                    <a href="ProductoServlet?accion=AgregarCarrito&id=${p.getId()}" class="btn btn-outline-info btn-sm">Agregar al Carrito</a>
                                    <a href="ProductoServlet?accion=Comprar&id=${p.getId()}" class="btn btn-outline-success btn-sm">Comprar</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>


        </div>


        <!-- jQuery -->
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="js/mdb.min.js"></script>  
    </body>
</html>
