package config.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/twitter?useSSL=false&requireSSL=false&verifyServerCertificate=false";
        
        try {
            return DriverManager.getConnection(url, "desktop_twitter", "twitter_desktop123");
        } catch(SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
