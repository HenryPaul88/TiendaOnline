package servlets;

import domain.Descuento;
import domain.Familias;
import domain.Producto;
import exceptions.DomainException;
import exceptions.ServiceException;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import util.Fecha;
import servicios.ServicioProducto;

/**
 * Servlet implementation class InsertarProducto
 */
@MultipartConfig
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
        java.sql.Date fecha;
        Part fotoPart = request.getPart("foto");
        InputStream inputStream=fotoPart.getInputStream();
        File file = new File("/home/henry/NetBeansProjects/Regalos/web/imagen/"+fotoPart.getSubmittedFileName());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int dato= inputStream.read();
        while(dato!=-1){
            fileOutputStream.write(dato);
            dato = inputStream.read();
        }
        fileOutputStream.close();
        inputStream.close();
        
        
        
        try {
            
            productoServicio = new ServicioProducto();
            idProducto = productoServicio.idProducto()+1;
            fecha =Fecha.fechaActualDate();
  
            productoServicio.insertarProducto(new Producto(idProducto, request.getParameter("nombre"),Double.parseDouble(request.getParameter("precio")),
                    new Familias(Integer.parseInt(request.getParameter("familias"))),new Descuento(Integer.parseInt(request.getParameter("Descuento"))), 
                     fotoPart.getInputStream(),fecha ,request.getParameter("descripcion")));

            salida = "/FormularioProducto";
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
