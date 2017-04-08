/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.dao;

import gerenciador.Factory.ConnectionFactory;
import gerenciador.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class UsuarioDAO {
    private final Connection connection;
    public  UsuarioDAO(){
         this.connection = new ConnectionFactory().getConnection();
    }
    
    public Usuario busca(String login, String senha) {
        PreparedStatement st;
        try {
            st = connection.prepareStatement("SELECT * FROM usu where usu_lg =\""+ login +"\" and usu_sn=\""+ senha +"\" ");
            st.executeQuery();
            ResultSet rs = st.getResultSet();
            while(rs.next()){
                Usuario u = new Usuario(login,senha, rs.getDate(3), rs.getString(4), rs.getInt(5)); 
                //String email, String senha, Date nascimento, String endereco, Integer nivel
                return u;
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }
}
