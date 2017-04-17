/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.dao;

import gerenciador.Factory.ConnectionFactory;
import gerenciador.beans.Comentario;
import gerenciador.beans.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Amanda
 */
public class ComentarioDAO {
    
    private final Connection connection;
    
    public  ComentarioDAO(){
         this.connection = new ConnectionFactory().getConnection();
    }

    public Collection<Comentario> buscaComentario(String id) {
        Collection<Comentario> coments = new ArrayList<>();
	PreparedStatement st;
        try {
            st = connection.prepareStatement("SELECT * FROM comentario WHERE com_post_id=\""+ id +"\"");
            st.executeQuery();
            ResultSet rs = st.getResultSet();
            
            while(rs.next()){
                Comentario c = new Comentario(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5));
                coments.add(c);
            }
        } catch (SQLException ex) {
            return null;
        }
        return coments;
    }
    
    public Collection<Post> buscaAutor(String email) {
        Collection<Post> posts = new ArrayList<>();
	PreparedStatement st;
        try {
            st = connection.prepareStatement("SELECT * FROM post WHERE post_at=\""+ email +"\"");
            st.executeQuery();
            ResultSet rs = st.getResultSet();
            
            while(rs.next()){
                Post p = new Post(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5));
                posts.add(p);
            }
        } catch (SQLException ex) {
            return null;
        }
        return posts;
    }

    public void cadastrar(String des, String idPost, String autor, String data) throws SQLException {
        PreparedStatement stmt;
            stmt = connection.prepareStatement("INSERT INTO `comentario`(`com_ds`, `com_post_id`, `com_au`, `com_dt`) "
                    + "VALUES (?,?,?,?)");
        stmt.setString(1, des); 
        stmt.setString(2, idPost);
        stmt.setString(3, autor);
        stmt.setString(4, data);
      
        stmt.execute();
        stmt.close();
    }
}
