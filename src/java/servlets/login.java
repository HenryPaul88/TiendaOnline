package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Cliente;
import exceptions.DomainException;
import exceptions.ServiceException;
import servicios.ServicioCliente;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		

		ServicioCliente servicoCliente;
		String salida = null;
		List<Cliente> list = new ArrayList<Cliente>();
		String nombre=request.getParameter("nombre");
		String clave=request.getParameter("contrasena");
		try {
			
			servicoCliente=new ServicioCliente();
			list=servicoCliente.recuperarTodosClientes();
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getNombre().equals(nombre) && list.get(i).getContrasena().equals(clave)) {
					salida = "/perfil.jsp";
				}
			}
			
		} catch (ServiceException|DomainException e) {
			if(e.getCause()==null){
				System.out.println(e.getMessage());//Error Logico para usuario
			}else{
				e.printStackTrace();// para administrador
				System.out.println("ertor interno");//Error interno para usuario
			}
		}
		getServletContext().getRequestDispatcher(salida).forward(request, response);
	}

}
