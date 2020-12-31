<%@page import="com.gussoft.shop.dto.CarritoDTO"%>
<%@page import="com.gussoft.shop.dto.ProductoDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//cdn.materialdesignicons.com/5.3.45/css/materialdesignicons.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Material Design Bootstrap -->
        <link rel="stylesheet" href="css/mdb.min.css">
        <!-- Your custom styles (optional) -->
        <link rel="stylesheet" href="css/style.css">
        
        <title>Carrito</title>
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
                            <a class="nav-link" href="#">Ofertas</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="ProductoServlet?accion=home" tabindex="-1" aria-disabled="true">
                                Seguir Comprando</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    <ul class="navbar-nav mr-auto">
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
        <div class="container mt-4">
            <h3>Carrito</h3>
            <div class="row">
                <div class="col-sm-8">
                    <div class="table-responsive">
                        <table class="table table-hover table-dark table-sm">
                            <thead>
                                <tr>
                                    <th>Item</th>
                                    <th>Nombres</th>
                                    <th>Descripcion</th>
                                    <th>Foto</th>
                                    <th>Precio</th>
                                    <th>Cant</th>
                                    <th>SubTotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="car" items="${carrito}">
                                    <tr>
                                        <td>${car.getItem()}</td>
                                        <td>${car.getNombres()}</td>
                                        <td>${car.getDesc()}</td>
                                        <td>
                                            <img class="img-responsive" src="${car.getFoto()}" width="100" height="100">
                                        </td>
                                        <td>${car.getPrecioc()}</td>
                                        <td style="width: 70px;">
                                            <input type="hidden" id="idpro" value="${car.getIdProducto()}" />
                                            <input type="number" name="" id="cantidad" value="${car.getCantidad()}" 
                                                   class="form-control text-center" min="1" />
                                        </td>
                                        <td>${car.getSubtotal()}</td>
                                        <td>
                                            <div class="text-center">
                                                <input type="hidden" id="idp" value="${car.getIdProducto()}"/>
                                                <a href="#" id="delete" class="btn btn-danger mt-2">Eliminar</a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            Generar Compra
                        </div>
                        <div class="card-body">
                            <label for="subtotal">Sub Total</label>
                            <input type="text" id="subtotal" value="S/ ${totalpagar}0" readonly="readonly" class="form-control" />
                            <label for="desc">Descuento</label>
                            <input type="text" id="desc" value="0" readonly="readonly" class="form-control" />
                            <label for="total">Total a Pagar</label>
                            <input type="text" id="total" value="S/ ${totalpagar}0" readonly="readonly" class="form-control" />
                        </div>
                        <div class="card-footer">
                            <a href="#" class="btn btn-info btn-block">Realizar Pago</a>
                            <a href="ProductoServlet?accion=GenerarCompra" class="btn btn-danger btn-block mt-2">Generar Compra</a>
                        </div>
                    </div>
                </div>
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
        <!-- sweet alert JavaScript -->
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
        
        
        <script src="js/funciones.js" type="text/javascript"></script>
    </body>
</html>
