package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import domain.Descuento;
import domain.Familias;
import domain.Imagen;
import domain.Producto;
import exceptions.DAOException;
import recursos.DbQuery;
import recursos.Recursos;

public class ProductoDao {

	static final String DB_ERR = "Error de la base de datos";
	static final int ORACLE_DUPLICATE_PK = 1;
	static final int ORACLE_DELETE_FK = 2292;
	static final int ORACLE_FALLO_FK = 2291;

	private Connection con;

	public ProductoDao(Connection con) {
		this.con = con;
	}

	public void insertarProducto(Producto producto) throws DAOException {

		PreparedStatement st = null;
		PreparedStatement sti = null;
		

		try {
			st = con.prepareStatement(DbQuery.getInsertarproductos());
			st.setInt(1, producto.getCod_pro());                       
			st.setString(2, producto.getNom_pro());
                        st.setDouble(3, producto.getPrecio());
			st.setInt(4, producto.getCod_fam().getCod_fam());
			st.setInt(5, producto.getCod_des().getCod_des());
			st.setInt(6, producto.getCod_img().getCod_img());
                        st.setDate(7, producto.getFecha_pro());			
                        st.setString(8, producto.getDesc_pro());
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

	public int idProducto() throws DAOException {

		Statement st = null;
		ResultSet rs = null;
		int id = 0;

		try {
			st = con.createStatement();
			rs = st.executeQuery(DbQuery.getIdproductos());
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
	
	public List<Producto> recuperarProductos() throws DAOException{
		PreparedStatement st = null;
        ResultSet rs = null;
        List<Producto> list = new ArrayList<Producto>();
        
        try {
            st = con.prepareStatement(DbQuery.getRecuperarproductos());
            rs = st.executeQuery();
            while (rs.next()) {

                list.add(new Producto(rs.getInt(1),rs.getString(2),rs.getDouble(3), new Familias(rs.getInt(4)),new Descuento(rs.getInt(5))
                		, new Imagen(rs.getInt(6)), rs.getDate(7),rs.getString(8)));
            }
        } catch (SQLException e) {
            throw new DAOException(DB_ERR, e);
        } finally {// cerramos cursores  y ResulSet
            Recursos.closeResultSet(rs);
            Recursos.closePreparedStatement(st);
        }
        return list;
	}
        
        public List<Producto> recuperarProductosPrincipal() throws DAOException{
		PreparedStatement st = null;
        ResultSet rs = null;
        List<Producto> list = new ArrayList<Producto>();
        
        try {
            st = con.prepareStatement(DbQuery.getRecuperarProductosPrincipal());
            rs = st.executeQuery();
            while (rs.next()) {

                list.add(new Producto(rs.getInt(1),rs.getString(2),rs.getDouble(3), new Familias(rs.getInt(4)),new Descuento(rs.getInt(5))
                		, new Imagen(rs.getInt(6)), rs.getDate(7),rs.getString(8)));
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
