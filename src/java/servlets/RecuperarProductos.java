/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.Producto;
import exceptions.DomainException;
import exceptions.ServiceException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.ServicioProducto;

/**
 *
 * @author henry
 */
@WebServlet(name = "RecuperarProductos", urlPatterns = {"/RecuperarProductos"})
public class RecuperarProductos extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServicioProducto productoServicio;
        List<Producto> listaProducto= new ArrayList<>();
        String salida = null;
        
        try {
         
            productoServicio = new ServicioProducto();
            listaProducto = productoServicio.recuperarTodosProducto();
            
            request.setAttribute("producto", listaProducto);
            salida = "/Productos.jsp";
            System.out.println(listaProducto.size());
            
            
        } catch (ServiceException | DomainException e) {
            if (e.getCause() == null) {//Error Logico para usuario
                request.setAttribute("error", e.getMessage());
                salida = "/DevolverPaginaError.jsp";

            } else {

                request.setAttribute("error", "error interno");
                salida = "/DevolverPaginaError.jsp";
                e.printStackTrace();// para administrador

            }
        }
        getServletContext().getRequestDispatcher(salida).forward(request, response);
    }


}
