package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exceptions.DAOException;

public class ConexionMySql {

    private Connection objconexion;

    public Connection getConexion() {
        return objconexion;
    }

    public ConexionMySql() throws DAOException {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            objconexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/tienda_oline", "root", "");
           
        } catch (ClassNotFoundException e) {
            throw new DAOException("no se ha cargado los controladores jdbc", e);

        } catch (SQLException e) {
            throw new DAOException("no se ha establecido la conexion a la bbdd", e);
        }

    }

    public ConexionMySql(String urlbd, String usuario, String password) throws DAOException {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            objconexion = DriverManager.getConnection(urlbd, usuario, password);

        } catch (ClassNotFoundException e) {
            throw new DAOException("no se ha cargado los controladores jdbc", e);
        } catch (SQLException e) {
            throw new DAOException("no se ha establecido la conexion a la bbdd", e);
        }

    }

}
