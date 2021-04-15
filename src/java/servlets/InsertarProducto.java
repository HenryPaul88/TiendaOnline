package servlets;

import domain.Descuento;
import domain.Familias;
import domain.Imagen;
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
import servicios.ServicioDescuento;
import servicios.ServicioFamilias;
import servicios.ServicioImagen;
import servicios.ServicioProducto;

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

        ServicioProducto productoServicio;
        String salida = null;
        int idProducto = 0;
        String insertadoExitoso= null;

        try {

            productoServicio = new ServicioProducto();
            idProducto = productoServicio.idProducto()+1;

            productoServicio.insertarProducto(new Producto(idProducto, request.getParameter("nombre"),
                    new Familias(Integer.parseInt(request.getParameter("familias"))), Double.parseDouble(request.getParameter("precio")),
                    request.getParameter("descripcion"), new Imagen(Integer.parseInt(request.getParameter("Imagen"))),
                    new Descuento(Integer.parseInt(request.getParameter("Descuento")))));

            salida = "/InsertadoPro.jsp";
            insertadoExitoso= "Se ha añadido nuevo producto con exito! ";
            request.setAttribute("Insertado", insertadoExitoso);

        } catch (ServiceException | DomainException e) {
            if (e.getCause() == null) {
                System.out.println(e.getMessage());
            } else {
                e.printStackTrace();// 
                System.out.println("ertor interno");
            }
        }

        getServletContext().getRequestDispatcher(salida).forward(request, response);

    }

}
