package servicios;

import java.util.ArrayList;

import java.util.List;

import daos.ClienteDao;
import daos.TransaccionesManager;
import domain.Cliente;
import exceptions.DAOException;
import exceptions.ServiceException;

public class ServicioCliente {

	public ServicioCliente() {
    }

    public void insertarCliente(Cliente cliente) throws ServiceException {
        TransaccionesManager trans = null;
        try {

            trans = new TransaccionesManager();
            ClienteDao clienteDAO = trans.getClienteDao();
            clienteDAO.insertarCliente(cliente);

            trans.closeCommit();
        } catch (DAOException e) {

            try {
                if (trans != null) {
                    trans.closeRollback();
                }
            } catch (DAOException e1) {
                throw new ServiceException(e.getMessage(), e1);//Error interno
            }

            if (e.getCause() == null) {
                throw new ServiceException(e.getMessage());//Error L0gico
            } else {

                throw new ServiceException(e.getMessage(), e);//Error interno
            }

        }
    }
    
    public int idCliente() throws ServiceException {
    	
    	TransaccionesManager trans = null;
        int id=0;
        
        try {
        	trans = new TransaccionesManager();
        	ClienteDao clientedao = trans.getClienteDao();
			id = clientedao.idCliente();
			
			trans.closeCommit();
		 	} catch (DAOException e) {
			try{
				if(trans!=null)
				trans.closeRollback();
			}catch (DAOException e1){
				throw new ServiceException(e.getMessage(),e1);//Error interno
			}

			if(e.getCause()==null){
				throw new ServiceException(e.getMessage());//Error L�gico
			}else{

				throw new ServiceException(e.getMessage(),e);//Error interno
			}

		}
		return id;
	}
    
    public List<Cliente> recuperarTodosClientes() throws ServiceException{
    	

        TransaccionesManager trans = null;
        List<Cliente> list = new ArrayList<Cliente>();
    	
        try {
        	
            trans = new TransaccionesManager();
            ClienteDao clienteDao = trans.getClienteDao();
            list=clienteDao.recuperarClienteLogin();
            trans.closeCommit();
		}catch (DAOException e) {
			try{
				if(trans!=null)
				trans.closeRollback();
			}catch (DAOException e1){
				throw new ServiceException(e.getMessage(),e1);//Error interno
			}

			if(e.getCause()==null){
				throw new ServiceException(e.getMessage());//Error L�gico
			}else{

				throw new ServiceException(e.getMessage(),e);//Error interno
			}

		}
        
        return list;
    }
    
}
