package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Cliente;
import domain.FormaPago;
import exceptions.DAOException;
import recursos.DbQuery;
import recursos.Recursos;

public class FormaPagoDao {

	static final String DB_ERR = "Error de la base de datos";
	static final int ORACLE_DUPLICATE_PK = 1;
	static final int ORACLE_DELETE_FK = 2292;
	static final int ORACLE_FALLO_FK = 2291;

	private Connection con;

	public FormaPagoDao(Connection con) {
		this.con = con;
	}

	public void insertarFormaPago(FormaPago formaPago) throws DAOException {

		PreparedStatement st = null;
		PreparedStatement sti = null;
		ResultSet rs = null;

		try {
			st = con.prepareStatement(DbQuery.getInsertarformapago());
			st.setInt(1, formaPago.getCodigo_fp());
			st.setString(2, formaPago.getNombre_fp());

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

	public int idFormaPago() throws DAOException {

		Statement st = null;
		ResultSet rs = null;
		int id = 0;

		try {
			st = con.createStatement();
			st = con.createStatement();
			rs = st.executeQuery(DbQuery.getIdformapago());
			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		} finally {
			Recursos.closeResultSet(rs);

		}
		return id;
	}
	
	public List<FormaPago> recuperarFormaPago() throws DAOException{
		PreparedStatement st = null;
        ResultSet rs = null;
        List<FormaPago> list = new ArrayList<FormaPago>();
        
        try {
            st = con.prepareStatement(DbQuery.getRecuperarformapago());
            rs = st.executeQuery();
            while (rs.next()) {

                list.add(new FormaPago(rs.getInt(1),rs.getString(2)));
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
