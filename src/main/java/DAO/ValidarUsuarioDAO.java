package DAO;

import Constants.UIConstants;
import db.DB;
import db.DbException;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

class ValidarUsuarioDAO {

    Map<String, String> validarUsuario(String usuario){
        Map<String, String> resultado = new HashMap<>();
        Connection conn = null;
        PreparedStatement pst = null;
        Statement st = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        try{
            conn = DB.getConnection();

            sql.append("SELECT ");
            sql.append("USER_LOGIN AS USUARIO, ");
            sql.append("USER_PASSWORD AS PASSWORD ");
            sql.append("FROM ");
            sql.append("TBC_USUARIO_LOGIN ");
            sql.append("WHERE ");
            sql.append("USER_LOGIN = ?");
            String sqlStatment = sql.toString();

            pst = conn.prepareStatement(sqlStatment);
            pst.setString(1,usuario);

            rs = pst.executeQuery();
            while(rs.next()){
                resultado.put(UIConstants.USUARIO_MAP_KEY,rs.getString("USUARIO"));
                resultado.put(UIConstants.SENHA_MAP_KEY,rs.getString("PASSWORD"));
            }
            return resultado;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }


    }
}
