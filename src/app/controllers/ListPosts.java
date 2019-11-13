package app.controllers;

import app.models.Post;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus Max
 */
public class ListPosts {
    
    private static List<Post> posts = new ArrayList<Post>();
    
    public void addPost(Post post) {
        posts.add(post);
    }
    
    public List<Post> getPosts() {
        return posts;
    }
    
}
