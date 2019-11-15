package app.controllers;

import app.models.User;

import app.dao.UserDAO;


/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */

public class LoginController {
   
    private UserDAO userDAO = new UserDAO();
    
    /* Construtor */
    public LoginController() {}
    
    public void fecharAplicacao() {
        System.exit(0);
    }
    
    public boolean logarAplicacao(String email, String senha) {
        
        User userlogged = userDAO.authenticate(email, senha);
        if(userlogged != null) {
            UserController.setLoggedUser(userlogged);
            return true;
        }
        return false;
    }

}
