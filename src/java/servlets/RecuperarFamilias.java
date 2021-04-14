package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Familias;
import exceptions.DomainException;
import exceptions.ServiceException;
import servicios.ServicioFamilias;

/**
 * Servlet implementation class RecuperarFamilias
 */
@WebServlet("/RecuperarFamilias")
public class RecuperarFamilias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServicioFamilias familias;
		List<Familias> lista = new ArrayList<Familias>();
                String salida = null;
        
        try {
                
        	familias = new ServicioFamilias();
        	lista = familias.recuperarTodosFamilias();               
        	request.setAttribute("familias", lista);
        	
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
