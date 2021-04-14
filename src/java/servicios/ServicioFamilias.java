package servicios;

import java.util.ArrayList;
import java.util.List;

import daos.FamiliasDao;
import daos.TransaccionesManager;
import domain.Familias;
import exceptions.DAOException;
import exceptions.ServiceException;

public class ServicioFamilias {

	public ServicioFamilias() {
	}

	public void insertarFamilias(Familias familias) throws ServiceException {
		TransaccionesManager trans = null;
		try {

			trans = new TransaccionesManager();
			FamiliasDao familiasDAO = trans.getFamiliasDao();
			familiasDAO.insertarFamilias(familias);

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

	public int idFamilias() throws ServiceException {

		TransaccionesManager trans = null;
		int id = 0;

		try {
			trans = new TransaccionesManager();
			FamiliasDao familiasdao = trans.getFamiliasDao();
			id = familiasdao.idFamilias();

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

	public List<Familias> recuperarTodosFamilias() throws ServiceException {

		TransaccionesManager trans = null;
		List<Familias> list = new ArrayList<Familias>();

		try {
                        
			trans = new TransaccionesManager();                      
			FamiliasDao familiasDao = trans.getFamiliasDao();                        
			list = familiasDao.recuperarFamilias();
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
