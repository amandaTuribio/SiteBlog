/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.servlets;

import gerenciador.beans.Post;
import gerenciador.dao.PostDAO;
import gerenciador.dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amanda
 */
public class ExcluirConta implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        String pagina;
        
        String email= new Filtro().getUsuario(req);
        
        if(email.equals(null)){ 
            pagina = "index.jsp";
            return pagina;
        }

        UsuarioDAO usu = new UsuarioDAO();
        
        try {
            usu.exclui(email);
        } catch (SQLException ex) {
            pagina = "/WEB-INF/index.jsp";
        }
        
        pagina = "cadastro.html";

        return pagina;    }
    
}
