/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.beans;

import java.util.Date;

/**
 *
 * @author Amanda
 */
public class Post {
    private String titulo;
    private String autor;
    private String data;
    private String texto;

    public Post(String titulo, String autor, String data, String texto) {
        this.titulo = titulo;
        this.autor = autor;
        this.data = data;
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    
}
