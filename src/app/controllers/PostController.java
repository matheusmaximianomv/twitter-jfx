package app.controllers;

import java.util.List;

import app.models.Post;

import app.dao.PostDAO;

import utils.enums.Results;


/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */
public class PostController {
    
    private String message = "";
    private PostDAO postDAO = new PostDAO();
    
    public PostController() {}
    
    public PostController(String message) {
        this.message = message;
    }
    
    public Results postar() {
        if(message.trim().isEmpty()) return Results.INVALID_FIELDS;
        else if(postDAO.store(new Post(message, UserController.getLoggedUser()))) return Results.CONFIRMED;
        else return Results.INTERNAL_ERROR;
    }
    
    public List<Post> listarPostagens() {
        return postDAO.getAllPosts();
    }
    
    public boolean likePost(Post post) {
        if(postDAO.storeLike(post)) return true;
        return false;
    }
    
}
