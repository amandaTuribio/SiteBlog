/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.servlets;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import gerenciador.beans.Usuario;
import gerenciador.dao.UsuarioDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amanda
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
        String uf = req.getParameter("uf");
        String n = req.getParameter("cc");
        Boolean nivel = Boolean.getBoolean(n);;
       
        String dataEmTexto = req.getParameter("datanasc");
        Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);

        Boolean emailValido = new UsuarioDAO().validarEmail(email);
        Boolean senhaValida = new Usuario().validarSenha(senha1, senha2);
        
        if(emailValido == true && senhaValida == true) {
            UsuarioDAO usu = new UsuarioDAO();
            try {
                usu.cadastrar(email, senha1, date ,endereco, uf,  cidade, nivel, nome);
            } catch (SQLException ex) {
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(cadastro == true){
                pagina = "/WEB-INF/TelaPrincipal.html";
                return pagina;
            }else{
                pagina = "cadastro.html";
                return pagina;  
            }  
        }else {    
            pagina = "cadastro.html";
            return pagina;
        }
    }
}
