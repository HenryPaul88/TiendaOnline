package listener;

import java.util.List;
import domain.Familias;
import servicios.ServicioFamilias;
import exceptions.ServiceException;
import java.util.ArrayList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class listener1 implements ServletContextListener {

    public listener1() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServicioFamilias familias;
        List<Familias> lista = new ArrayList<Familias>();
        
        try {
            System.out.println("llega listener familias 1");
            familias = new ServicioFamilias();
            lista = familias.recuperarTodosFamilias();
            System.out.println("llega listener familias 2");
            sce.getServletContext().setAttribute("familias", lista);
            System.out.println("llega listener familias 3");

        } catch (ServiceException e) {
            sce.getServletContext().setAttribute("ErrorContexto", e.getMessage());
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
    }

 
}
