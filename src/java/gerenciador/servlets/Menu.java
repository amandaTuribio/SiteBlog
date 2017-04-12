/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.servlets;

import gerenciador.beans.Post;
import gerenciador.beans.Usuario;
import gerenciador.dao.PostDAO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amanda
 */
public class Menu implements Tarefa {
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String pagina = null;
        String menu = req.getParameter("menu");
        
        if(menu.equals("Logout")){
            req.getSession().removeAttribute("usuarioLogado");
            pagina = "index.html";
            
        }else if(menu.equals("Meus posts")){
            String email= new Filtro().getUsuario(req);
            if(email.equals(null)){ //ususario nao logado
                pagina = "index.html";
            }else{
                Collection<Post> posts = new PostDAO().buscaAutor(email);   
                req.setAttribute("posts", posts);
                pagina = "/WEB-INF/TelaAutor.jsp";
            }
        }else if(menu.equals("Minha Conta")){
                pagina = "/WEB-INF/TelaAdmin.jsp";
        }
        return pagina;    
    }
}
