
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
        String pagina = "/WEB-INF/TelaPrincipal.jsp";
        
        return pagina;
    }
}
