package app.models;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */
public class Post {
    
    private int id;
    private String content;
    private User author;
    private long likes;
    
    public Post(String content, User author) {
        this.content = content;
        this.author = author;
        this.likes = 0;
    }
    
    public Post(int id, String content, long likes, User author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.likes = likes;
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
    
    public int getId() {
        return id;
    }
    
    public void setLike() {
        this.likes++;
    }
    
}
