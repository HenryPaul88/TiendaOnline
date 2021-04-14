package servicios;

import java.util.ArrayList;
import java.util.List;

import daos.FormaPagoDao;
import daos.TransaccionesManager;
import domain.FormaPago;
import exceptions.DAOException;
import exceptions.ServiceException;

public class ServicioFormaPago {
	
	public ServicioFormaPago() {
	}

	public void insertarFormaPago(FormaPago formaPago) throws ServiceException {
		TransaccionesManager trans = null;
		try {

			trans = new TransaccionesManager();
			FormaPagoDao formaPagoDAO = trans.getFormaPagoDao();
			formaPagoDAO.insertarFormaPago(formaPago);

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

	public int idFormaPago() throws ServiceException {

		TransaccionesManager trans = null;
		int id = 0;

		try {
			trans = new TransaccionesManager();
			FormaPagoDao formaPagodao = trans.getFormaPagoDao();
			id = formaPagodao.idFormaPago();

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

	public List<FormaPago> recuperarTodosFormaPago() throws ServiceException {

		TransaccionesManager trans = null;
		List<FormaPago> list = new ArrayList<FormaPago>();

		try {

			trans = new TransaccionesManager();
			FormaPagoDao formaPagoDao = trans.getFormaPagoDao();
			list = formaPagoDao.recuperarFormaPago();
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
