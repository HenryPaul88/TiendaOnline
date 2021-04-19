package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Imagen;
import domain.Producto;
import exceptions.DAOException;
import recursos.DbQuery;
import recursos.Recursos;

public class ImagenDao {

	static final String DB_ERR = "Error de la base de datos";
	static final int ORACLE_DUPLICATE_PK = 1;
	static final int ORACLE_DELETE_FK = 2292;
	static final int ORACLE_FALLO_FK = 2291;

	private Connection con;

	public ImagenDao(Connection con) {
		this.con = con;
	}

	public void insertarImagen(Imagen imagen) throws DAOException {

		PreparedStatement st = null;
		PreparedStatement sti = null;
		ResultSet rs = null;

		try {
			st = con.prepareStatement(DbQuery.getInsertarimagenes());
			st.setInt(1, imagen.getCod_img());
			st.setString(2, imagen.getRuta());
			st.setString(3, imagen.getRuta_abs());

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

	public int idImagen() throws DAOException {

		Statement st = null;
		ResultSet rs = null;
		int id = 0;

		try {
			st = con.createStatement();
			rs = st.executeQuery(DbQuery.getIdimagenes());
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
	public List<Imagen> recuperarImagen() throws DAOException{
		PreparedStatement st = null;
        ResultSet rs = null;
        List<Imagen> list = new ArrayList<Imagen>();
        
        try {
            
            st = con.prepareStatement(DbQuery.getRecuperarimagenes());
            rs = st.executeQuery();
            while (rs.next()) {
                
                list.add(new Imagen(rs.getInt(1),rs.getString(2),rs.getString(3)));
                
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
