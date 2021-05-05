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
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServicioProducto productoServicio;
        List<Producto> listaProducto = new ArrayList<>();
        String salida = null;
        String familia;

        try {

            productoServicio = new ServicioProducto();
            listaProducto = productoServicio.recuperarTodosProducto();
            request.setAttribute("producto", listaProducto);
            boolean encontrado=true;
            familia = (request.getParameter("familia"));
            if(familia!=null){
                int cod_fam= Integer.parseInt(familia);
                 switch (cod_fam) {
                
                case 1:
                    
                    while(encontrado){
                            encontrado=buscar(listaProducto,cod_fam);
                    }
                    break;
                case 2:
                    
                    while(encontrado){
                            encontrado=buscar(listaProducto,cod_fam);
                    }
                    break;
                default:

            }
                
            }

            salida = "/Productos.jsp";
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
    
    public boolean buscar(List<Producto> lista,int elem){
        boolean encontrado=false;
        for (int i = 0; i < lista.size() && !encontrado; i++) {
                if(lista.get(i).getCod_fam().getCod_fam()!=elem){
                    lista.remove(i);
                    encontrado=true;
                }
        }
        return encontrado;
    }

}
