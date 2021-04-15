package servicios;

import java.util.ArrayList;
import java.util.List;

import daos.ImagenDao;
import daos.TransaccionesManager;
import domain.Imagen;
import exceptions.DAOException;
import exceptions.ServiceException;

public class ServicioImagen {

	public ServicioImagen() {
	}

	public void insertarImagen(Imagen imagen) throws ServiceException {
		TransaccionesManager trans = null;
		try {

			trans = new TransaccionesManager();
			ImagenDao imagenDAO = trans.getImagenDao();
			imagenDAO.insertarImagen(imagen);

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

	public int idImagen() throws ServiceException {

		TransaccionesManager trans = null;
		int id = 0;

		try {
			trans = new TransaccionesManager();
			ImagenDao imagendao = trans.getImagenDao();
			id = imagendao.idImagen();

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

	public List<Imagen> recuperarImagen() throws ServiceException {

		TransaccionesManager trans = null;
		List<Imagen> list = new ArrayList<Imagen>();
                
		try {

			trans = new TransaccionesManager();
			ImagenDao imagenDao = trans.getImagenDao();
			list = imagenDao.recuperarImagen();
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
