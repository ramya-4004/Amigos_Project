package sample.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        String url="jdbc:mysql:://localhost:3306/users";
        String username="root";
        String pass="mysql95";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,username,pass);
        return con;


    }
}
