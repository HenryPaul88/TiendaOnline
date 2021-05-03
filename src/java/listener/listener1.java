package listener;

import java.util.List;
import domain.Producto;
import exceptions.ServiceException;
import java.util.ArrayList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import servicios.ServicioProducto;

@WebListener
public class listener1 implements ServletContextListener {

    public listener1() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
    }

}
