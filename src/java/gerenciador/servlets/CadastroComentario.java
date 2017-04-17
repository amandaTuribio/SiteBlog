/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.servlets;

import gerenciador.beans.Comentario;
import gerenciador.beans.Post;
import gerenciador.dao.ComentarioDAO;
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
public class CadastroComentario implements Tarefa {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp){
        String pagina;
        
        String postid = req.getParameter("postid");
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
        
        ComentarioDAO comen = new ComentarioDAO();
        try {
            comen.cadastrar(texto, postid, email, data1);
        } catch (SQLException ex) {
            pagina = "/WEB-INF/NovoComentario.jsp";
        }
        
        Post post = new PostDAO().buscaId(postid);
        Collection<Comentario> c = new ComentarioDAO().buscaComentario(postid);

        req.setAttribute("c", c);
        req.setAttribute("post", post);
        
        pagina = "/WEB-INF/UnicoPost.jsp";
        return pagina;
    }
}
