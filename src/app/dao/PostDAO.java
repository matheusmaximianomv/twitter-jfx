package app.dao;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.models.Post;
import app.models.User;
import config.database.ConnectionFactory;

public class PostDAO {
    
    private Connection connection;
    private List<Post> posts = new ArrayList<Post>();
    
    public PostDAO() { }
    
    public boolean store(Post post) {
        try {
            this.connection = new ConnectionFactory().getConnection();
            
            String query = "INSERT INTO posts (content, likes, id_user) VALUES (?, ?, ?)";
            
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, post.getContent());
            stmt.setLong(2, post.getLikes());
            stmt.setInt(3, post.getUser().getId());
            
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
    
    public boolean storeLike(Post post) {
        try {
            this.connection = new ConnectionFactory().getConnection();
            
            String query = "UPDATE posts SET likes=? WHERE id=?";
            
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, post.getLikes());
            stmt.setInt(2, post.getId());
            
            try {
               stmt.execute();
               stmt.close();
               connection.close();
               return true;
            } catch(SQLException ex) {
                System.err.println(ex);
                stmt.close();
                connection.close();
                return false;
            }
        } catch(SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }
    
    public List<Post> getAllPosts() {
        try {
            this.connection = new ConnectionFactory().getConnection();
            
            String query = "SELECT posts.id, posts.content, posts.likes, users.id as id_user, users.username, users.email "
                    + "FROM posts "
                    + "JOIN users ON posts.id_user = users.id "
                    + "ORDER BY posts.id DESC";
            
            PreparedStatement stmt = connection.prepareStatement(query);
            
            try {   
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()) {
                        
                        int idUser = rs.getInt(4);
                        String username = rs.getString(5);
                        String email = rs.getString(6);
                        User owner = new User(idUser,email, username);
                        
                        int idPost = rs.getInt(1);
                        String content = rs.getString(2);
                        long likes = rs.getLong(3);
                        
                        posts.add(new Post(idPost, content, likes, owner));
                }
                
                stmt.close();
                connection.close();
                return posts;
                
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
    
}
