package gerenciador.servlets;

import gerenciador.beans.Post;
import gerenciador.dao.PostDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amanda e Gabriel
 */

public class CadastroPost implements Tarefa {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp){
        String pagina;
        String titulo = req.getParameter("titulo");
        String texto = req.getParameter("tex");
        
        String data = "dd/MM/yyyy";
	String data1;
	java.util.Date agora = new java.util.Date();;
	SimpleDateFormat formata = new SimpleDateFormat(data);
	data1 = formata.format(agora);
	
        String email= new Filtro().getUsuario(req);
        
        if(email.equals(null)){ 
            pagina = "index.jsp";
            return pagina;
        }

        PostDAO post = new PostDAO();
        try {
            post.cadastrar(titulo, texto, data1, email);
        } catch (SQLException ex) {
            pagina = "/WEB-INF/NovoPost.jsp";
        }
        
        Collection<Post> posts = new PostDAO().buscaAutor(email);   
        req.setAttribute("posts", posts);
        pagina = "/WEB-INF/TelaAutor.jsp";

        return pagina;
    }
}
