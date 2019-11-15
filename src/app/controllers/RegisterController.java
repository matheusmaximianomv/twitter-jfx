package app.controllers;

import app.models.User;

import app.dao.UserDAO;

import utils.enums.Results;
/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */

public class RegisterController {
    
    /* Atributos */
    private final String username, email, password;
    private UserDAO userDAO = new UserDAO();
    
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
    
    /* Métodos da Aplicação */
    public Results registerUser() { 
        if(!isValidFields()) return Results.INVALID_FIELDS;
        else if(userDAO.checkUserExists(email) != null) return Results.USER_EXISTS;
        else if(userDAO.store(new User(username, email, password))) return Results.CONFIRMED;
        return Results.INTERNAL_ERROR;
    }
}
