package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnctionUtil {
    Connection conn =null;
    public static Connection conDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/Admin","root","9649726949");
        }catch(ClassNotFoundException | SQLException ex){
            return null;
        }
return null;
    }

}
