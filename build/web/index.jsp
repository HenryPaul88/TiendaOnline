<%-- 
    Document   : index
    Created on : 14-abr-2021, 0:06:39
    Author     : henry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="incluir/bootstrap.jsp"%>
        <title>Tienda de Regalos</title>
        

    <body>
        <!-- header  -->
        <%@ include file="incluir/header.jsp" %>

        <!-- CARRUSEL  -->

        <%@ include file="incluir/carrusel.jsp" %>

        <!-- fotos  -->
        <div class="container">
            <h2> Todos lo que buscas  </h2>
            <div class="col-sm-12">
                <div class="form-row">
                    <div class="col-sm-2"></div>
                    <div class="col">
                        <img src="imagen/globo-amarrillo.jpg">
                        <p id="precio">20 EUROS</p>
                    </div>
                    <div class="col-sm-4"></div>
                    <div class="col">
                        <img src="imagen/Globo-azul.jpg">
                        <p id="precio">20 EUROS</p>
                    </div>


                </div>
            </div>
            <div class="col-sm-12">
                <div class="form-row">
                    <div class="col-sm-2"></div>
                    <div class="col">
                        <img src="imagen/DiaDeLaMadre/Regalo-Madre-30.png">
                        <p id="precio">40 EUROS</p>
                    </div>
                    <div class="col-sm-4"></div>
                    <div class="col">
                        <img src="imagen/DiaDeLaMadre/Regalo-Madre-20.jpg">
                        <p id="precio">25 EUROS</p>
                    </div>

                </div>
            </div>
            <div class="col-sm-12">
                <div class="form-row">
                    <div class="col-sm-2"></div>
                    <div class="col">
                        <img src="imagen/Regalo-Padre-30.png">
                        <p id="precio">40 EUROS</p>
                    </div>
                    <div class="col-sm-4"></div>
                    <div class="col">
                        <img src="imagen/Regalo-Padre-20.jpg">
                        <p id="precio">25 EUROS</p>
                    </div>

                </div>
            </div>
            <div class="pag">
                <ul class="pagination">
                    <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </div>
        </div>

        <!-- footer  -->

        <%@ include file="incluir/footer.jsp" %>

    </body>

</html>

