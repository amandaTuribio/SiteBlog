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
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
public class UnicoPost implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {

        String id = req.getParameter("postid");
        
        Post post = new PostDAO().buscaId(id);
        Collection<Comentario> c = new ComentarioDAO().buscaComentario(id);
        
        req.setAttribute("c", c);
        req.setAttribute("post", post);
        String pagina = "/WEB-INF/UnicoPost.jsp";
        return pagina;
   }
}
    
