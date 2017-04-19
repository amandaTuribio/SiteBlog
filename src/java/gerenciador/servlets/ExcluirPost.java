/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.servlets;

import gerenciador.beans.Post;
import gerenciador.beans.Usuario;
import gerenciador.dao.PostDAO;
import java.sql.SQLException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amanda
 */
public class ExcluirPost implements Tarefa{
   

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("postid");
        String pagina = null;
        
        PostDAO p = new PostDAO();
        
        try {
            p.exclui(id);
        } catch (SQLException ex) {
            pagina = "index.jsp";
            return pagina;
        }
        
        Usuario usuario = new Filtro().getU(req);
        
        if(usuario == null){ //ususario nao logado
            pagina = "index.jsp";
        }else{
            Collection<Post> posts = new PostDAO().buscaAutor(usuario.getEmail());   
            req.setAttribute("posts", posts);
            pagina = "/WEB-INF/TelaAutor.jsp";
        }
        return pagina;
    }
}
