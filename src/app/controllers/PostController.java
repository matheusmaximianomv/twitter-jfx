package app.controllers;

import app.models.Post;

import database.Database;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */
public class PostController {
    
    private final String message;
    
    public PostController(String message) {
        this.message = message;
    }
    
    public Post createPost() {
        return new Post(message, Database.getLoggedUser());
    }
    
    public int postar() {
        
        if(message.trim().isEmpty()) return 0;
        else {
            Database.getListPosts().addPost(createPost());
            return 1;
        }
        
    }
    
}
