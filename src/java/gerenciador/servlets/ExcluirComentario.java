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
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amanda
 */
public class ExcluirComentario implements Tarefa {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("postc");
        String idpost = req.getParameter("postid");
        String pagina = null;
        
        ComentarioDAO p = new ComentarioDAO();
        
        try {
            p.exclui(id);
        } catch (SQLException ex) {
            pagina = "index.jsp";
            return pagina;
        }
        
        Post post = new PostDAO().buscaId(idpost);
        Collection<Comentario> c = new ComentarioDAO().buscaComentario(idpost);
        
        req.setAttribute("c", c);
        req.setAttribute("post", post);
        
        pagina = "/WEB-INF/UnicoPost.jsp";

        return pagina;
    }
}
