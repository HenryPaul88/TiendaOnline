package servicios;

import java.util.ArrayList;
import java.util.List;

import daos.DescuentoDao;
import daos.TransaccionesManager;
import domain.Descuento;
import exceptions.DAOException;
import exceptions.ServiceException;

public class ServicioDescuento {

	public ServicioDescuento() {
	}

	public void insertarDescuento(Descuento descuento) throws ServiceException {
		TransaccionesManager trans = null;
		try {

			trans = new TransaccionesManager();
			DescuentoDao descuentoDAO = trans.getDescuentoDao();
			descuentoDAO.insertarDescuento(descuento);

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

	public int idDescuento() throws ServiceException {

		TransaccionesManager trans = null;
		int id = 0;

		try {
			trans = new TransaccionesManager();
			DescuentoDao descuentodao = trans.getDescuentoDao();
			id = descuentodao.idDescuento();

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

	public List<Descuento> recuperarTodosDescuento() throws ServiceException {

		TransaccionesManager trans = null;
		List<Descuento> list = new ArrayList<Descuento>();

		try {

			trans = new TransaccionesManager();
			DescuentoDao descuentoDao = trans.getDescuentoDao();
			list = descuentoDao.recuperarDescuento();
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
