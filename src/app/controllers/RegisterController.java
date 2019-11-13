package app.controllers;

import app.models.User;

import database.Database;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */

public class RegisterController {
    
    /* Atributos */
    private final String username, email, password;
    
    /* Construtor */
    public RegisterController(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    /* Funções Auxiliares */
    private boolean isValidFields() {
        if(username.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty()) {
            return false;
        }
        return true;
    }
    
    private boolean checkUserValid() {
        for(User u : Database.getListUsers().getUsers()) {
            if(u.getEmail().equals(email)) {
                return false;
            }
        }
        
        return true;
    }
    
    private User createUser() {
        return new User(Database.getListUsers().getRecords(),email, password, username);
    }
    
     /* Métodos da Aplicação */
    public int registerUser() {
        if(!isValidFields()) return 0;
        else if(!checkUserValid()) return 1;
        else {
            Database.getListUsers().addUser(createUser());
            return 2; 
        }
    }
}
