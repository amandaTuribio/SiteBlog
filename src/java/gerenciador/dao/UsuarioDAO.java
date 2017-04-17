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
 * @author Amanda e Gabriel
 */
public class UsuarioDAO {
    private final Connection connection;
    
    public  UsuarioDAO(){
         this.connection = new ConnectionFactory().getConnection();
    }
    
    public Usuario busca(String email, String senha) {
        PreparedStatement st;
        try {
            st = connection.prepareStatement("SELECT * FROM usuario where usu_em =\""+ email +"\" and usu_sn=\""+ senha +"\" ");
            st.executeQuery();
            ResultSet rs = st.getResultSet();
            while(rs.next()){
                Usuario u = new Usuario(email, senha, rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getBoolean(8), rs.getString(9));                
                return u;
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }
    
    public Boolean validarEmail(String email) {
        PreparedStatement st;
        try {
            st = connection.prepareStatement("SELECT * FROM usuario where usu_em =\""+ email +"\"");
            st.executeQuery();
            ResultSet rs = st.getResultSet();
            if(rs.next()){               
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public void cadastrar(String email, String senha, String date, String endereco, String uf, String cidade, Boolean nivel, String nome) throws SQLException {
        PreparedStatement stmt;
            stmt = connection.prepareStatement("INSERT INTO `usuario`(`usu_cd`, `usu_em`, `usu_sn`, `usu_dt_ns`, `usu_ru`, `usu_uf`, `usu_ci`, `usu_cc`, `usu_nm`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)");
        stmt.setString(1, null); 
        stmt.setString(2, email);
        stmt.setString(3,senha);
        stmt.setString(4, date);
        stmt.setString(5,endereco);
        stmt.setString(6,uf);
        stmt.setString(7,cidade);
        stmt.setBoolean(8,nivel);
        stmt.setString(9,nome);
        
        stmt.execute();
        stmt.close();
    }
    
    public Usuario buscaEmail(String email) {
        PreparedStatement st;
        try {
            st = connection.prepareStatement("SELECT * FROM usuario where usu_em =\""+ email +"\" ");
            st.executeQuery();
            ResultSet rs = st.getResultSet();
            while(rs.next()){
                Usuario u = new Usuario(email, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getBoolean(8), rs.getString(9));                
                return u;
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public void alterar(String email, String senha1, String dataEmTexto, String endereco, String uf, String cidade, Boolean nivel, String nome) throws SQLException {   
 
        PreparedStatement stmt;
        stmt = connection.prepareStatement("UPDATE usuario SET usu_em=?, usu_sn=?, usu_dt_ns=?, usu_ru=?, usu_uf=?, usu_ci=?,usu_cc=?,usu_nm=?  WHERE usu_em=?");

        stmt.setString(1, email);
        stmt.setString(2,senha1);
        stmt.setString(3, dataEmTexto);
        stmt.setString(4,endereco);
        stmt.setString(5,uf);
        stmt.setString(6,cidade);
        stmt.setBoolean(7,nivel);
        stmt.setString(8,nome);
        stmt.setString(9, email);
        
        stmt.execute();
        stmt.close();
    }

    public void exclui(String email) throws SQLException {

         PreparedStatement stmt;
            stmt = connection.prepareStatement("DELETE FROM usuario WHERE usu_em = ? ");

        stmt.setString(1, email);
        
        stmt.execute();
        stmt.close();
    }
}
