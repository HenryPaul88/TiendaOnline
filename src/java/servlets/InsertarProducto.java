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
 * Servlet implementation class InsertarProducto
 */
@WebServlet("/InsertarProducto")
public class InsertarProducto extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param request
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);

    }

    /**
     * @param request
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
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
