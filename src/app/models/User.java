package app.models;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */
public class User {
    
    private int id;
    private String email, senha, nome;
    
    public User() {}
    
    public User(String nome, String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }
    
    public User(int id, String email, String nome) {
        this.id = id;
        this.email = email;
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getId() {
        return id;
    }
    
}
