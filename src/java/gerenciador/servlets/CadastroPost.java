/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Amanda
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
        
        if(email.equals(null)){ //ususario nao logado
            pagina = "index.html";
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
