package daos;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import recursos.DbQuery;
import recursos.Recursos;
import domain.Cliente;
import exceptions.DAOException;

public class ClienteDao {

	static final String DB_ERR = "Error de la base de datos";
	static final int ORACLE_DUPLICATE_PK = 1;
	static final int ORACLE_DELETE_FK = 2292;
	static final int ORACLE_FALLO_FK = 2291;
	
	private Connection con;

	public ClienteDao(Connection con) {
		this.con = con;
	}

	public void insertarCliente(Cliente cliente) throws DAOException {

		PreparedStatement st = null;
		PreparedStatement sti = null;

		try {
			st = con.prepareStatement(DbQuery.getInsertarcliente());
			st.setInt(1, cliente.getCodigo_cli());
			st.setString(2, cliente.getNombre());
			st.setString(3, cliente.getApellidos());
			st.setInt(4, cliente.getTelefono());
			st.setString(5, cliente.getDireccion());
			st.setString(6, cliente.getEmail());
			st.setString(7, cliente.getContrasena());

			st.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == ORACLE_DUPLICATE_PK) {
				throw new DAOException(" cliente ya existe");
			} else if (e.getErrorCode() == ORACLE_FALLO_FK) {
				throw new DAOException("Operacion no disponible temporalmente,repita proceso");
			} else if (e.getErrorCode() >= 20000 && e.getErrorCode() <= 20999) {// para PL/SQL.triggers
				String cadena = e.toString().substring(e.toString().indexOf("ORA", 0) + 10);
				String cadena1 = cadena.substring(0, cadena.indexOf("ORA", 0));
				throw new DAOException(cadena1);
			} else {
				throw new DAOException(DB_ERR, e);
			}
		} finally {
			Recursos.closePreparedStatement(st);
			Recursos.closePreparedStatement(sti);
		}
	}
	
	public int idCliente() throws DAOException{
		
		Statement st=null;
		ResultSet rs =null ;
		int id=0;
		try {
			
			st= con.createStatement();
			rs=st.executeQuery(DbQuery.getIdcliente());
			if (rs.next()){
				id=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		} finally {
		Recursos.closeResultSet(rs);
		
	}
		return id;
	}
	
	public List<Cliente> recuperarClienteLogin() throws DAOException{
		PreparedStatement st = null;
        ResultSet rs = null;
        List<Cliente> list = new ArrayList<Cliente>();
        
        try {
            st = con.prepareStatement(DbQuery.getRecuperarclientes());
            rs = st.executeQuery();
            while (rs.next()) {

                list.add(new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
                		rs.getString(5),rs.getString(6),rs.getString(7)));
            }
        } catch (SQLException e) {
            throw new DAOException(DB_ERR, e);
        } finally {// cerramos cursores  y ResulSet
            Recursos.closeResultSet(rs);
            Recursos.closePreparedStatement(st);
        }
        return list;
	}
}
