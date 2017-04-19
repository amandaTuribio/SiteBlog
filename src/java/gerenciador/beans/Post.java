
package gerenciador.beans;


/**
 *
 * @author Amanda e Gabriel
 */
public class Post {
    private String titulo;
    private String autor;
    private String data;
    private String texto;
    private int codigo;

    public Post(int cd, String titulo, String autor, String data, String texto) {
        this.titulo = titulo;
        this.autor = autor;
        this.data = data;
        this.texto = texto;
        this.codigo = cd;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
