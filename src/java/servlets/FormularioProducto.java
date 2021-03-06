
package servlets;

import domain.Descuento;
import domain.Familias;
import domain.Imagen;
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
import servicios.ServicioDescuento;
import servicios.ServicioFamilias;
import servicios.ServicioImagen;

/**
 *
 * @author henry
 */
@WebServlet(name = "FormularioProducto", urlPatterns = {"/FormularioProducto"})
public class FormularioProducto extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServicioFamilias familias;
        ServicioDescuento descuento;
        ServicioImagen imagen;
        List<Familias> listaFamilia = new ArrayList<Familias>();
        List<Descuento> listaDescuento = new ArrayList<Descuento>();
        List<Imagen> listaImagen = new ArrayList<Imagen>();
        String salida = null;

        try {

            familias = new ServicioFamilias();
            descuento = new ServicioDescuento();
            imagen = new ServicioImagen();

            listaFamilia = familias.recuperarTodosFamilias();
            listaDescuento = descuento.recuperarTodosDescuento();
            listaImagen = imagen.recuperarImagen();
            request.setAttribute("familias", listaFamilia);
            request.setAttribute("descuentos", listaDescuento);
            request.setAttribute("imagenes", listaImagen);

            salida = "/AddProducto.jsp";

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
