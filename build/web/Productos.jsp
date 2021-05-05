<%-- 
    Document   : Productos
    Created on : 03-may-2021, 16:55:47
    Author     : henry
--%>

<%@page import="domain.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="incluir/bootstrap.jsp"%>
        <link rel="stylesheet" href="CSS/estilos.css">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <!-- header  -->
            <%@ include file="incluir/header.jsp" %>
        </header>
        <main class="main__productos">
            <div class="container">
                <h2 class="main-title">Todos los productos</h2>
                <section class="container-products">
                    
                    <% 
                        List<Producto> lista=(List<Producto>)request.getAttribute("producto");
                        
                            for(int i=0;i<lista.size();i++){
                                
			
                                
                        %>
                    
                    
                    <div class="product">
                        <a href="" class="producto__unico" > 
                            <img src="Imagen?id=<%= lista.get(i).getCod_pro()%>" alt="" class="product__img">
                            <div class="product__description">
                                <h3 class="product__title"> <%= lista.get(i).getNom_pro() %> </h3>
                                <span class="product__price"><%= lista.get(i).getPrecio() %></span>
                            </div>
                            <i class="product__icon fas fa-cart-plus"></i>
                        </a>
                    </div>
                        <% 
                                }
                        %>

                  
                </section>
            </div>

        </main>


        <footer>
            <!-- footer  -->
            <%@ include file="incluir/footer.jsp" %>
        </footer>
        <script src="JS/menu.js"></script>
    </body>
</html>
