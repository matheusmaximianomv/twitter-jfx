package app.dao;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import app.models.User;
import config.database.ConnectionFactory;


public class UserDAO {
    
    private Connection connection;
    
    public UserDAO() { }
    
    public User checkUserExists(String email) {
        try {
            this.connection = new ConnectionFactory().getConnection();
            
            String query = "SELECT id, username, email FROM users WHERE email=?";
            
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            
            try {   
                ResultSet rs = stmt.executeQuery();
                if(rs.next()) {
                    User user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("username"));

                    stmt.close();
                    connection.close();
                    
                    return user;
                }
                
                stmt.close();
                connection.close();
                return null;
                
            } catch (SQLException ex) {
                System.err.println(ex);
                stmt.close();
                connection.close();
                return null;
            }
        } catch(SQLException ex) {
            System.err.println(ex);
            return null;
        }
        
        
    }
    
    public boolean store(User user) {
        try {
            this.connection = new ConnectionFactory().getConnection();
            
            String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSenha());
            
            try {
                stmt.execute();
                stmt.close();
                connection.close();
                return true;
            } catch(SQLException ex) {
                System.err.println(ex);
                connection.close();
                return false;
            }
            
        } catch(SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }
    
    public User authenticate(String email, String password) {
        try {
            this.connection = new ConnectionFactory().getConnection();
            
            String query = "SELECT * FROM users WHERE email=?";
            
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            
            try {   
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()) {
                    if(rs.getString("password").equals(password)) {
                        
                        int id = rs.getInt("id");
                        String username = rs.getString("username");
                        
                        stmt.close();
                        connection.close();
                        return new User(id, email, username);
                    } else {
                        
                        stmt.close();
                        connection.close();
                        return null;
                    }
                }
                
            } catch (SQLException ex) {
                
                System.err.println(ex);
                stmt.close();
                connection.close();
                return null;
            }
            
        } catch(SQLException ex) {
            System.err.println(ex);
            return null;
        }
        return null;
    }
    
}
