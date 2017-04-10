package gerenciador.beans;

import java.util.Date;

/**
 *
 * @author Amanda e Gabriel
 */
public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private Date nascimento;
    private String endereco;
    private String cidade;
    private String uf;
    private Boolean nivel;

    public Usuario(String email, String senha, Date nascimento, String endereco, String uf, String cidade, Boolean nivel, String nome) {
        this.email = nome;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.uf = uf;
        this.cidade = cidade;
        this.nivel = nivel;
    }

    public Usuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Boolean getNivel() {
        return nivel;
    }

    public void setNivel(Boolean nivel) {
        this.nivel = nivel;
    }
    
    public Boolean validarSenha(String senha1, String senha2) {
        if(senha1.equals(senha2)){
            return true;
        }
        return false;
    }
    
}
