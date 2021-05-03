<%-- 
    Document   : error
    Created on : 21-abr-2021, 12:46:04
    Author     : henry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <br>
        <!-- Page Content -->
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="panel panel-default">
                        <div class="panel-body text-center">
                            <h1>Ha ocurrido un error</h1>
                            <img src="img/404.jpg" class="img-responsive" alt="404">
                            <h2>
                                Ha ocurrido un error procesando su petición. <br /> Por favor, vuelva a intentarlo.
                            </h2>
                            <%
                                if (request.getAttribute("errorMsg") != null) {
                                    out.println("<p>Detalle del error: " + request.getAttribute("errorMsg") + "</p>");
                                }

                                if (request.getAttribute("errorMessage") != null) {
                                    out.println("<p>Detalle del error: " + request.getAttribute("errorMessage") + "</p>");
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
