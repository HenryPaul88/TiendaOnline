package servlets;

import java.io.IOException;
import exceptions.DomainException;
import exceptions.ServiceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Cliente;
import servicios.ServicioCliente;

/**
 * Servlet implementation class InsertarCliente
 */
@WebServlet("/InsertarCliente")
public class InsertarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServicioCliente servicoCliente;
		String salida = null;
		int id=0;
		
		try {
			servicoCliente=new ServicioCliente();
			id=servicoCliente.idCliente();
			id++;
			servicoCliente.insertarCliente(new Cliente(
					id,request.getParameter("nombre"),request.getParameter("apellidos"),
					Integer.parseInt(request.getParameter("telefono")),request.getParameter("email"),
					request.getParameter("direccion"),request.getParameter("contrasena")
					));
			
			
            salida = "/IniciarSesion.jsp";
            
		} catch (ServiceException|DomainException e) {
			if(e.getCause()==null){
				System.out.println(e.getMessage());
			}else{
				e.printStackTrace();// 
				System.out.println("ertor interno");
			}
		}
		
		getServletContext().getRequestDispatcher(salida).forward(request, response);
	}
}
