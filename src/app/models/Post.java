package app.models;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */
public class Post {
    
    private final String id;
    private String content;
    private User author;
    private long likes = 0;
    
    public Post(String id) {
        this.id = id;
        likes = 0;
    }
    public Post(String id, String content, User author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.likes = 0;
    }
    
    public String getId() {
        return id;
    }
    
    public String getContent() {
        return content;
    }
    
    public User getUser() {
        return author;
    }
    
    public long getLikes() {
        return likes;
    }
    
    public void setLike() {
        this.likes++;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public void setAuthor(User author) {
        this.author = author;
    }
    
}
