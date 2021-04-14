package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Cliente;
import domain.Familias;
import exceptions.DAOException;
import recursos.DbQuery;
import recursos.Recursos;

public class FamiliasDao {

    static final String DB_ERR = "Error de la base de datos";
    static final int ORACLE_DUPLICATE_PK = 1;
    static final int ORACLE_DELETE_FK = 2292;
    static final int ORACLE_FALLO_FK = 2291;

    private Connection con;

    public FamiliasDao(Connection con) {
        this.con = con;
    }

    public void insertarFamilias(Familias familias) throws DAOException {

        PreparedStatement st = null;
        PreparedStatement sti = null;
        ResultSet rs = null;

        try {
           
            st = con.prepareStatement(DbQuery.getInsertarfamilias());
            st.setInt(1, familias.getCod_fam());
            st.setString(2, familias.getNom_fam());
            st.setString(3, familias.getDesc_fam());

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

    public int idFamilias() throws DAOException {

        Statement st = null;
        ResultSet rs = null;
        int id = 0;

        try {
            st = con.createStatement();
            rs = st.executeQuery(DbQuery.getIdfamilias());
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

    public List<Familias> recuperarFamilias() throws DAOException {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Familias> list = new ArrayList<Familias>();

        try {
           
            st = con.prepareStatement(DbQuery.getRecuperarfamilias());
            System.out.println("llega dao familia 2");
            rs = st.executeQuery();
            System.out.println("llega dao familia 3");
            int i=0;
            while (rs.next()) {
                i++;
                list.add(new Familias(rs.getInt(1), rs.getString(2), rs.getString(3)));
                System.out.println("entro");
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
