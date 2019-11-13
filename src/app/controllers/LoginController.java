package app.controllers;

import app.models.User;

import database.Database;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */

public class LoginController {
   
    /* Construtor */
    public LoginController() {
        Database.setUserAdmin();
    }
    
    /* Métodos Auxiliares */    
    private boolean checkUserRecords() {
        if(Database.getListUsers().getRecords() == 0) {
            return false;
        }
        return true;
    }
    
    private boolean checkRegisteredUser(String email, String senha) {
        
        for(User u : Database.getListUsers().getUsers()) {
            if(u.getEmail().equals(email)) {
                if(u.getSenha().equals(senha)) {
                    return true;
                }
                return false;
            }
        }
        
        return false;
        
    }
    
    /* Métodos de Controle */
    public void fecharAplicacao() {
        System.exit(0);
    }
    
    public int logarAplicacao(String email, String senha) {
        
        if(!checkUserRecords())return 0;
        else if(!checkRegisteredUser(email, senha)) return 1;
        else {
            Database.setLoggedUser(getUserFromList(email));
            return 2;
        }
    }
    
    public User getUserFromList(String email) {
        for(User u : Database.getListUsers().getUsers()) {
            if(u.getEmail().equals(email)) {
                return u;
            }
        }
        
        return null;
    }

}
