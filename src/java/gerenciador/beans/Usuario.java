package gerenciador.beans;

import java.util.Date;

/**
 *
 * @author Amanda e Gabriel
 */
public class Usuario {
    private String email;
    private String senha;
    private Date nascimento;
    private String endereco;
    private Integer nivel;

    public Usuario(String email, String senha, Date nascimento, String endereco, Integer nivel) {
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.nivel = nivel;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    
    
}
