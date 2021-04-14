package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Descuento;
import servicios.ServicioDescuento;
import exceptions.DomainException;
import exceptions.ServiceException;

/**
 * Servlet implementation class RecuperarDescuentos
 */
@WebServlet("/RecuperarDescuentos")
public class RecuperarDescuentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarDescuentos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServicioDescuento descuento;
		List<Descuento> lista = new ArrayList<Descuento>();
        String salida = null;
        
        try {
        	descuento = new ServicioDescuento();
        	lista = descuento.recuperarTodosDescuento();
        	request.setAttribute("descuento", lista);
        	
        	salida = "AddProducto.jsp";
			
		} catch (ServiceException | DomainException e) {
            if (e.getCause() == null) {//Error L�gico para usuario
                request.setAttribute("error", e.getMessage());
                salida = "/DevolverPaginaError.jsp";

            } else {

                request.setAttribute("error", "error interno");
                salida = "/DevolverPaginaError.jsp";
                e.printStackTrace();// para administrador

            }
        }
	}

}
