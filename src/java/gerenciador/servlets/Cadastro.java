/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        String n = req.getParameter("cc");
        Boolean nivel = n.equals("1")?true:false;       

        Boolean emailValido = new UsuarioDAO().validarEmail(email);
        Boolean senhaValida = new Usuario().validarSenha(senha1, senha2);

        if(emailValido == true && senhaValida == true) {
            UsuarioDAO usu = new UsuarioDAO();
            try {
                usu.cadastrar(email, senha1, dataEmTexto ,endereco, uf,  cidade, nivel, nome);
            } catch (SQLException ex) { //ERRO AO CADASTRAR
                pagina ="cadastro.html";
                return pagina;
            }
        }else {    
            pagina ="cadastro.html";
            return pagina;
        }
        pagina = "login.html";
        return pagina;
    }
}
