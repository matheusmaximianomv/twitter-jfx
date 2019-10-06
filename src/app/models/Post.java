package app.models;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */
public class Post {
    
    private String content;
    private User author;
    private long likes = 0;
    
    public Post(User author) {
        this.author = author;
        likes = 0;
    }
    public Post(String content, User author) {
        this.content = content;
        this.author = author;
        this.likes = 0;
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
