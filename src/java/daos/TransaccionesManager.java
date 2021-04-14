package daos;

import java.sql.Connection;
import bbdd.ConexionMySql;
import java.sql.SQLException;
import exceptions.DAOException;
import java.sql.Savepoint;

public class TransaccionesManager {

	private static final String DB_ERR = "Error de la base de datos";
	private static final String DB_CON_ERR = "Error al conectar con la base de datos";

	private Connection con;

	public TransaccionesManager() throws DAOException {
		try {
			con = new ConexionMySql().getConexion();
                        System.out.println("llega transaccion tienda");
			con.setAutoCommit(false);
		} catch (SQLException e) {
			throw new DAOException("Error en la  bbdd", e);
		}
	}

	public void closeCommit() throws DAOException {
		try {
			if (con != null) {
				con.commit();
				con.close();
			}

		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		}
	}

	public void commit() throws DAOException {
		try {
			if (con != null) {
				con.commit();

			}

		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		}
	}

	public void closeRollback() throws DAOException {
		try {
			if (con != null) {
				con.rollback();
				con.close();
			}

		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		}
	}

	public void rollback() throws DAOException {
		try {
			if (con != null) {
				con.rollback();

			}

		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		}
	}

	public void close() throws DAOException {
		try {
			if (con != null) {
				con.close();

			}

		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		}

	}

	public Savepoint savepoint() throws DAOException {
		Savepoint s = null;
		try {
			if (con != null) {
				s = con.setSavepoint();
			}
		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		}
		return s;
	}

	public void deshacerHastaSavepoint(Savepoint s) throws DAOException {
		try {
			if (con != null) {
				con.rollback(s);
			}
		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		}
	}

	public Connection getConexion() {

		return con;
	}
	
	public ClienteDao getClienteDao() {
		return new ClienteDao(con);
	}
	
	public ProductoDao getProductoDao() {
		return new ProductoDao(con);
	}
	
	public DescuentoDao getDescuentoDao() {
		return new DescuentoDao(con);
	}
	
	public FamiliasDao getFamiliasDao() {
		return new FamiliasDao(con);
	}
	
	public FormaPagoDao getFormaPagoDao() {
		return new FormaPagoDao(con);
	}
	
	public ImagenDao getImagenDao() {
		return new ImagenDao(con);
	}
	
	
	
}
