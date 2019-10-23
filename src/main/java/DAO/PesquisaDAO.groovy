package DAO

import db.DB
import db.DbException

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class PesquisaDAO {

    Map<Integer,String> pesquisarDados(){
        Map<String,String> result = new HashMap<>()
        Connection conn = null
        Statement st = null
        ResultSet rs = null
        try{
            conn = DB.getConnection()
            st = conn.createStatement()
            rs = st.executeQuery("Select * from TBC_COR")
            int i=0;
            while (rs.next()){
                String cdKey = ("CD" + i)
                String nmKey = ("NM" + i)
                result.put(cdKey , rs.getInt("CD_COR"))
                result.put(nmKey , rs.getString("NM_COR"))
                i++
            }
        }catch(SQLException e){
            throw new DbException(e.getMessage())
        }finally{
            DB.closeResultSet(rs)
            DB.closeStatement(st)
            DB.closeConnection()
        }

        return result
    }

    String inserirDados(String modelo ,String fabricante ,String ano){

        Connection conn = null
        PreparedStatement pst = null
        StringBuilder sql = new StringBuilder()
        String generatedkeys
        try{
            conn = DB.getConnection()

            sql.append("INSERT INTO ");
            sql.append("TBC_MODELO ")
            sql.append("(NM_MODELO, ")
            sql.append("NM_FABRICANTE, ")
            sql.append("NR_ANO) ")
            sql.append("VALUES ")
            sql.append("(?,?,?)")
            String sqlStatment = sql.toString()

            pst = conn.prepareStatement(sqlStatment,Statement.RETURN_GENERATED_KEYS)
            pst.setString(1, modelo)
            pst.setString(2, fabricante)
            pst.setString(3, ano)

            int rowsAffected = pst.executeUpdate()
            if(rowsAffected>0){
                println "Inserido " + rowsAffected + " linhas no banco de dados"
                ResultSet rs = pst.getGeneratedKeys()
                while (rs.next()){
                    generatedkeys = rs.getString(1)
                }
            }else{
                println "Não foram inseridos dados no Banco de dados"
            }
        return generatedkeys

        }catch(SQLException e){
            throw new DbException(e.getMessage())
        }finally{
            DB.closeStatement(pst)
            DB.closeConnection()
        }


    }
}
