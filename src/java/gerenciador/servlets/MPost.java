/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.servlets;

import gerenciador.beans.Post;
import gerenciador.dao.PostDAO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amanda
 */
public class MPost implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String email= new Filtro().getUsuario(req);
        String pagina = null;
        
        if(email.equals(null)){ //ususario nao logado
            pagina = "index.html";
        }else{
            Collection<Post> posts = new PostDAO().buscaAutor(email);   
            req.setAttribute("posts", posts);
            pagina = "/WEB-INF/TelaAutor.jsp";
        }
        return pagina;
    }
    
}
