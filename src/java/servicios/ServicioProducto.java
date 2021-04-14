package servicios;

import java.util.ArrayList;
import java.util.List;

import daos.ProductoDao;
import daos.TransaccionesManager;
import domain.Producto;
import exceptions.DAOException;
import exceptions.ServiceException;

public class ServicioProducto {

	public ServicioProducto() {
	}

	public void insertarProducto(Producto producto) throws ServiceException {
		TransaccionesManager trans = null;
		try {

			trans = new TransaccionesManager();
			ProductoDao productoDAO = trans.getProductoDao();
			productoDAO.insertarProducto(producto);

			trans.closeCommit();
		} catch (DAOException e) {

			try {
				if (trans != null) {
					trans.closeRollback();
				}
			} catch (DAOException e1) {
				throw new ServiceException(e.getMessage(), e1);// Error interno
			}

			if (e.getCause() == null) {
				throw new ServiceException(e.getMessage());// Error L0gico
			} else {

				throw new ServiceException(e.getMessage(), e);// Error interno
			}

		}
	}

	public int idProducto() throws ServiceException {

		TransaccionesManager trans = null;
		int id = 0;

		try {
			trans = new TransaccionesManager();
			ProductoDao productodao = trans.getProductoDao();
			id = productodao.idProducto();

			trans.closeCommit();
		} catch (DAOException e) {
			try {
				if (trans != null)
					trans.closeRollback();
			} catch (DAOException e1) {
				throw new ServiceException(e.getMessage(), e1);// Error interno
			}

			if (e.getCause() == null) {
				throw new ServiceException(e.getMessage());// Error L�gico
			} else {

				throw new ServiceException(e.getMessage(), e);// Error interno
			}

		}
		return id;
	}

	public List<Producto> recuperarTodosProducto() throws ServiceException {

		TransaccionesManager trans = null;
		List<Producto> list = new ArrayList<Producto>();

		try {

			trans = new TransaccionesManager();
			ProductoDao productoDao = trans.getProductoDao();
			list = productoDao.recuperarProductos();
			trans.closeCommit();
		} catch (DAOException e) {
			try {
				if (trans != null)
					trans.closeRollback();
			} catch (DAOException e1) {
				throw new ServiceException(e.getMessage(), e1);// Error interno
			}

			if (e.getCause() == null) {
				throw new ServiceException(e.getMessage());// Error L�gico
			} else {

				throw new ServiceException(e.getMessage(), e);// Error interno
			}

		}

		return list;
	}

}
