
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
@WebServlet(name = "RecuperarProductoPrincipal", urlPatterns = {"/RecuperarProductoPrincipal"})
public class RecuperarProductoPrincipal extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServicioProducto productoServicio;
        List<Producto> listaProducto= new ArrayList<>();
        String salida = null;
        
        
        try {
            productoServicio = new ServicioProducto();
            listaProducto = productoServicio.recuperarTodosProductoPrincipal();
            request.setAttribute("producto", listaProducto);
            
            
            
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
