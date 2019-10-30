package DAO;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObterNomeUsuarioDAO {

    public String obterNomeUsuario(String usuario){
        String nomeCompleto;

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();

        try{

            conn = DB.getConnection();

            sql.append("SELECT TU.NM_USUARIO ");
            sql.append("FROM  TBC_USUARIO TU ");
            sql.append("INNER JOIN ");
            sql.append("TBC_USUARIO_LOGIN TUL ON ");
            sql.append("TUL.CD_USUARIO = TU.CD_USUARIO ");
            sql.append("WHERE TUL.USER_LOGIN = ?");
            String sqlStatement = sql.toString();

            pst = conn.prepareStatement(sqlStatement);
            pst.setString(1,usuario);

            rs = pst.executeQuery();
            rs.next();
            nomeCompleto = rs.getString("NM_USUARIO");
            return nomeCompleto;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }

    }
}
