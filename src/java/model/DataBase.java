package model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class DataBase {
    Connection conn;
    public void conectar() throws Exception{
        String user = "root";
        String pass = "";
        String url = "jdb:mysql://localhost/blackwings2";
        Class.forName("com.mysql.jdbc.Driver");
        conn = (Connection) DriverManager.getConnection(url, user, pass);
    }
    public void desconectar() throws Exception{
        if(!conn.isClosed()){
            conn.close();
        }
    }
}
