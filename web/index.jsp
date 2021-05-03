<%-- 
    Document   : index
    Created on : 14-abr-2021, 0:06:39
    Author     : henry
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="domain.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marie Party</title>
        <link rel="stylesheet" href="CSS/style-contenedor.css" />
        <link rel="stylesheet" href="CSS/estilos.css">
        <link rel="icon" type="image/png" href="imagen/logo.png">
    </head>

    <body>
        <header>
            <!-- header  -->
            <%@ include file="incluir/header.jsp" %>
        </header>

        <!-- CARRUSEL  -->
        <%@ include file="incluir/carrusel.jsp" %>

        <main class="main">
            <div class="container">
                <h2 class="main-title">New Arrival for you</h2>
                <section class="container-products">
                    <div class="product">
                        <img src="imagen/Globo-azul.jpg" alt="" class="product__img">
                        <div class="product__description">
                            <h3 class="product__title">Opium (Grey)</h3>
                            <span class="product__price">575.00€</span>
                        </div>
                        <i class="product__icon fas fa-cart-plus"></i>
                    </div>

                    <div class="product">
                        <img src="imagen/Globo-azul.jpg" alt="" class="product__img">
                        <div class="product__description">
                            <h3 class="product__title">Opium (Grey)</h3>
                            <span class="product__price">575.00€</span>
                        </div>
                        <i class="product__icon fas fa-cart-plus"></i>
                    </div>

                    <div class="product">
                        <img src="imagen/Globo-azul.jpg" alt="" class="product__img">
                        <div class="product__description">
                            <h3 class="product__title">Opium (Grey)</h3>
                            <span class="product__price">575.00€</span>
                        </div>
                        <i class="product__icon fas fa-cart-plus"></i>
                    </div>

                    <div class="product">
                        <img src="imagen/Globo-azul.jpg" alt="" class="product__img">
                        <div class="product__description">
                            <h3 class="product__title">Opium (Grey)</h3>
                            <span class="product__price">575.00€</span>
                        </div>
                        <i class="product__icon fas fa-cart-plus"></i>
                    </div>

                </section>
                <section class="container-tips">
                    <div class="tip">
                        <i class="far fa-hand-paper"></i>
                        <h2 class="tip__title">Satisfaction Guaranteed</h2>
                        <p class="tip__txt">duis mollis, est nom comodo luictus,
                            nisi erat porttitor ligula, eget lacinia odio sem 
                            nec elit</p>
                        <a href="" class="btn-shop">Shop Now</a>
                    </div>
                    <div class="tip">
                        <i class="fas fa-rocket"></i>
                        <h2 class="tip__title">Fast Shipping</h2>
                        <p class="tip__txt">duis mollis, est nom comodo luictus,
                            nisi erat porttitor ligula, eget lacinia odio sem 
                            nec elit</p>
                        <a href="" class="btn-shop">Shop Now</a>
                    </div>
                    <div class="tip">
                        <i class="fas fa-cog"></i>
                        <h2 class="tip__title">UV Protection</h2>
                        <p class="tip__txt">duis mollis, est nom comodo luictus,
                            nisi erat porttitor ligula, eget lacinia odio sem 
                            nec elit</p>
                        <a href="" class="btn-shop">Shop Now</a>
                    </div>
                </section>
            </div>
        </main>

        <footer>
            <!-- footer  -->
            <%@ include file="incluir/footer.jsp" %>
        </footer>
    </body>
    <script src="JS/slider.js"></script>
    <script src="JS/menu.js"></script>
</html>

