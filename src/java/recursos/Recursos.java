package recursos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import exceptions.DAOException;

public class Recursos {

	public static void closeResultSet(ResultSet rs) throws DAOException {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new DAOException("Error de la base de datos", e);
		}
	}

	public static void closePreparedStatement(PreparedStatement st) throws DAOException {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			throw new DAOException("Error de la base de datos", e);
		}
	}

	public static void closeCallableStatement(CallableStatement st) throws DAOException {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			throw new DAOException("Error de la base de datos", e);
		}
	}

}
