<%-- 
    Document   : DevolverPaginaError
    Created on : 21-abr-2021, 12:40:03
    Author     : henry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pagina de errores</title>
    </head>
    <body>
           error :

        <H1>por contexto <%=application.getAttribute("ErrorContexto")%></H1>
        <H1> por peticion <%=request.getAttribute("error")%></H1>

    </body>
</html>
