/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.servlets;

import gerenciador.beans.Post;
import gerenciador.beans.Usuario;
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
public class Alterar implements Tarefa {
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
        
        String e = new Filtro().getUsuario(req);
        Boolean emailValido = null;
        
        if(e.equals(email)){ 
            emailValido = true;
        }else{
            emailValido = new UsuarioDAO().validarEmail(email);
        }
            
        Boolean senhaValida = new Usuario().validarSenha(senha1, senha2);

        if(emailValido == true && senhaValida == true && !email.isEmpty()) {
            UsuarioDAO usu = new UsuarioDAO();
            usu.alterar(email, senha1, dataEmTexto ,endereco, uf,  cidade, nivel, nome); 
        }else {    
            pagina ="cadastro.html";
            return pagina;
        }
        pagina = "index.html";
        return pagina;
    }
}
