
package gerenciador.servlets;

import gerenciador.beans.Usuario;
import gerenciador.dao.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giovani
 */
public class Login implements Tarefa {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp){
        String pagina;
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        
        Usuario usuario = new UsuarioDAO().busca(login, senha);
 
        if(usuario==null) {
            pagina = "index.html";
            return pagina;
        }else {

            HttpSession session = req.getSession();            
            session.setAttribute("usuarioLogado", usuario);
            
            pagina = "/WEB-INF/TelaPrincipal.html";
            return pagina;
        }
    }
}
