package app.controllers;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */

import app.models.User;

public class UserController {
    
    private static User loggedUser = new User();
    
    public UserController() {}
    
    public static User getLoggedUser() {
        return UserController.loggedUser;
    }
    
    public static void setLoggedUser(User user) {
        UserController.loggedUser = user;
    }
    
}
