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
public class Home implements Tarefa {
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp){
        Collection<Post> posts = new PostDAO().busca();   
        req.setAttribute("posts", posts);
        String pagina;
        
        Boolean n= new Filtro().getNivel(req);
        if(n){
            pagina = "/WEB-INF/TelaPrincipal.jsp";
        }else{
            pagina = "/WEB-INF/TelaPrincipalSP.jsp";
        }
        return pagina;
    }
}
