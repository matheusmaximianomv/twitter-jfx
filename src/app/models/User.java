package app.models;


/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */
public class User {
    
    private String email = null, senha = null, nome = null;
    
    public User() {}
    public User(String email, String senha, String nome) {
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
