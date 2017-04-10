
package gerenciador.servlets;

import gerenciador.beans.Usuario;
import gerenciador.dao.UsuarioDAO;
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
            pagina = "cadastro.html";
            return pagina;
        }else {
            HttpSession session = req.getSession();            
            session.setAttribute("usuarioLogado", usuario);
            
            pagina = "/WEB-INF/TelaPrincipal.html";
            return pagina;
        }
    }
}
