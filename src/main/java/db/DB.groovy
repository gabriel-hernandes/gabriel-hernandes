package db

import javax.imageio.stream.FileImageInputStream
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class DB {

    static Connection conn = null

    static Connection getConnection(){
        if(conn == null) {
            try {
                Properties props = loadProperties()
                String url = props.getProperty("dburl")
                conn = DriverManager.getConnection(url, props)
            }catch(SQLException e){
                throw new DbException(e.getMessage())
            }
        }
            return conn
    }

    static void closeConnection(){
        if(conn != null){
            try{
                conn.close()
            }catch(SQLException e){
                throw new DbException(e.getMessage())
            }
        }
    }

    static Properties loadProperties(){
        try{
            FileInputStream fs = new FileInputStream("db.properties")
            Properties props = new Properties()
            props.load(fs)
            return props
        }catch(IOException e){
            throw new DbException(e.getMessage())
        }
    }
}
