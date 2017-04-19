
package gerenciador.servlets;

import gerenciador.beans.Usuario;
import gerenciador.dao.UsuarioDAO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amanda e Gabriel
 */
public class Cadastro implements Tarefa {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp){
        String pagina;
        
        String nome = req.getParameter("nome");
        String endereco = req.getParameter("end");
        String cidade = req.getParameter("cidade");
        String email = req.getParameter("email");
        String senha1 = req.getParameter("senha1");
        String senha2 = req.getParameter("senha2");
        String uf = req.getParameter("idEstado");
        String dataEmTexto = req.getParameter("datanasc");        
        Boolean nivel=null;
        
        String n = req.getParameter("cc");
        if(n== null){
            nivel =  false;
        }else{
            nivel = true;
        } 
             
        Boolean emailValido = new UsuarioDAO().validarEmail(email);
        Boolean senhaValida = new Usuario().validarSenha(senha1, senha2);

        if(emailValido == true && senhaValida == true && !email.isEmpty()) {
            UsuarioDAO usu = new UsuarioDAO();
            try {
                usu.cadastrar(email, senha1, dataEmTexto ,endereco, uf,  cidade, nivel, nome);
            } catch (SQLException ex) {
                pagina ="cadastro.html";
                return pagina;
            }
        }else {    
            pagina ="cadastro.html";
            return pagina;
        }
        pagina = "index.jsp";
        return pagina;
    }
}
