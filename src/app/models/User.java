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
    
    public User(int id) {
        this.id = id;
    }
    
    public User(int id, String email, String senha, String nome) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }
    
    public void setEmail(String email) {
       this.email = email;
    }
    
    public void setSenha(String senha) {
       this.senha = senha;
    }
    
    public void setNome(String nome) {
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
    
}
