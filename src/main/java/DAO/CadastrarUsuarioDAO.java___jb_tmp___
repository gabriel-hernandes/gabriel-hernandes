package DAO;

import Constants.UIConstants;
import db.DB;
import db.DbException;

import java.sql.*;
import java.util.HashMap;

public class CadastrarUsuarioDAO {

    public boolean cadastrarUsuario(HashMap<String,String> informacoes){

        boolean resultado = false;
        Connection conn = null;
        PreparedStatement pst = null;
        StringBuilder sql;
        ResultSet rst = null;
        try{

            conn = DB.getConnection();
            conn.setAutoCommit(false);
            sql = new StringBuilder();

            sql.append("INSERT INTO ");
            sql.append("TBC_USUARIO ");
            sql.append("(NM_USUARIO, ");
            sql.append("NR_RG, ");
            sql.append("NR_CPF, ");
            sql.append("DT_NASCIMENTO, ");
            sql.append("NR_REGISTRO_EMPRESA) ");
            sql.append("VALUES ");
            sql.append("(?,?,?,?,?) ");
            String sqlStatment = sql.toString();
            String data = informacoes.get(UIConstants.MAPKEY_DIA) + "/" + informacoes.get(UIConstants.MAPKEY_MES) + "/" + informacoes.get(UIConstants.MAPKEY_ANO);

            pst = conn.prepareStatement(sqlStatment, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,informacoes.get(UIConstants.MAPKEY_NOME));
            pst.setString(2,informacoes.get(UIConstants.MAPKEY_RG));
            pst.setString(3,informacoes.get(UIConstants.MAPKEY_CPF));
            pst.setString(4,data);
            pst.setString(5,informacoes.get(UIConstants.MAPKEY_REGISTRO));

            pst.executeUpdate();
            rst = pst.getGeneratedKeys();
            rst.next();
            Integer idGerada = rst.getInt(1);
            DB.closeStatement(pst);

            StringBuilder sql2 = new StringBuilder();
            sql2.append("INSERT INTO ");
            sql2.append("TBC_USUARIO_LOGIN ");
            sql2.append("(CD_USUARIO, ");
            sql2.append("USER_LOGIN, ");
            sql2.append("USER_PASSWORD, ");
            sql2.append("CD_ACESSO) ");
            sql2.append("VALUES ");
            sql2.append("(?,?,?,?) ");
            String sqlStatment2 = sql2.toString();

            pst = conn.prepareStatement(sqlStatment2);
            pst.setInt(1,idGerada);
            pst.setString(2,informacoes.get(UIConstants.MAPKEY_USUARIO));
            pst.setString(3,informacoes.get(UIConstants.MAPKEY_SENHA));
            pst.setInt(4,2);

            pst.executeUpdate();

            conn.commit();

            resultado = true;
        }catch(Exception e){
            conn.rollback();
            resultado = false;
            e.printStackTrace();
            throw new DbException(UIConstants.AVIS_FALHA_CADASTRO_NO_BANCO_DE_DADOS + e.getMessage());
        }finally {
            DB.closeStatement(pst);
            return resultado;
        }
    }
}
