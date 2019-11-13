package database;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */

import app.models.Post;
import app.models.User;

import app.controllers.ListPosts;
import app.controllers.ListUsers;

public class Database {
    
    private static ListUsers listUsers = new ListUsers();
    private static User loggedUser = new User();
    private static ListPosts listPosts = new ListPosts();
    private static boolean userAdminSetted = false;
    
    public Database() {}
    
    public static ListUsers getListUsers() {
        return Database.listUsers;
    }
    
    public static ListPosts getListPosts() {
        return Database.listPosts;
    }
    
    public static User getLoggedUser() {
        return Database.loggedUser;
    }
    
    public static void setLoggedUser(User user) {
        Database.loggedUser = user;
    }
    
    public static void setUserAdmin() {
        if (!Database.userAdminSetted) {
            User userAdmin = new User(Database.listUsers.getRecords(), "admin@email.com", "javafx", "Matheus Max");
            Database.listUsers.addUser(userAdmin);
            Database.userAdminSetted = true;
        }
    }
    
}
