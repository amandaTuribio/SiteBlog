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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amanda
 */
public class Alterar implements Tarefa {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp){
        String pagina= null;
        
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
        if(n == null){
            nivel =  false;
        }else{
            nivel = true;
        } 
        
        // Verificar email e senha 
        Boolean emailValido = null;        
        
        Usuario usuario = new Filtro().getU(req);

        if(email.isEmpty()){
            email = usuario.getEmail();
            emailValido = true;
        }else if(email.equals(usuario.getEmail())){ 
            emailValido = true;
        }else{
            emailValido = new UsuarioDAO().validarEmail(email);
        }   

        Boolean senhaValida = new Usuario().validarSenha(senha1, senha2);

        // OUTROS DADOS 
        
        if(nome.isEmpty()){
            nome = usuario.getNome();
        }
        if(endereco.isEmpty()){
            endereco = usuario.getEndereco();
        }
        if(cidade.isEmpty()){
            cidade = usuario.getC();
        }
        if(uf.isEmpty()){
            uf = usuario.getUf();
        }
        if(dataEmTexto.isEmpty()){
            dataEmTexto = usuario.getNascimento();
        }
        
        if(emailValido == true && senhaValida == true) {
            UsuarioDAO usu = new UsuarioDAO();
            try { 
                usu.alterar(email, senha1, dataEmTexto ,endereco, uf,  cidade, nivel, nome);

                Usuario usua = new UsuarioDAO().busca(email, senha1);
                HttpSession session = req.getSession();            
                session.setAttribute("usuarioLogado", usua);
                
            } catch (SQLException ex){
                pagina = "/WEB-INF/TelaAdmin.jsp";
                return pagina;
            }
        }else {    
            pagina = "/WEB-INF/TelaAdmin.jsp";
            return pagina;
        }
        
        Boolean niv = new Filtro().getNivel(req);
        if(niv){ 
            Collection<Post> posts = new PostDAO().busca();   
            req.setAttribute("posts", posts);
            pagina = "/WEB-INF/TelaPrincipal.jsp";
        }else{
            Collection<Post> posts = new PostDAO().busca();   
            req.setAttribute("posts", posts);
            pagina = "/WEB-INF/TelaPrincipalSP.jsp";
        }
        
        return pagina;
    }
}
