
package gerenciador.servlets;

import gerenciador.beans.Post;
import gerenciador.beans.Usuario;
import gerenciador.dao.PostDAO;
import gerenciador.dao.UsuarioDAO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amanda e Gabriel
 */
public class Login implements Tarefa {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp){
        String pagina;
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        
        Usuario usuario = new UsuarioDAO().busca(email, senha);
 
        if(usuario == null) {
            // USUARIO NAO TEM CADASTRO 
            pagina = "index.jsp";
            return pagina;
        }else {
            HttpSession session = req.getSession();            
            session.setAttribute("usuarioLogado", usuario);
            
            Collection<Post> posts = new PostDAO().busca();   
            req.setAttribute("posts", posts);
            
            Boolean n= new Filtro().getNivel(req);

            if(n){ //ususario nao logado
                pagina = "/WEB-INF/TelaPrincipal.jsp";
            }else{
                pagina = "/WEB-INF/TelaPrincipalSP.jsp";
            }
            return pagina;
        }
    }
}
