/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.beans;

/**
 *
 * @author Aluno
 */
public class Comentario {
    
    private String descricao, data, autor;
    private int codigo, codigo_post;
    
    public Comentario(int codigo, String descricao, String autor, String data) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.data = data;
        this.autor = autor;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo_post() {
        return codigo_post;
    }

    public void setCodigo_post(int codigo_post) {
        this.codigo_post = codigo_post;
    }
}
