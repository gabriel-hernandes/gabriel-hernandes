import db.DB

import java.sql.Connection

class Teste {
    public static void main(String[] args) {

        Connection conn = DB.getConnection()
        DB.closeConnection()
    }
}
