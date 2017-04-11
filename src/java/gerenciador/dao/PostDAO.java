/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.dao;

import gerenciador.Factory.ConnectionFactory;
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
public class PostDAO {
    
    private final Connection connection;
    
    public  PostDAO(){
         this.connection = new ConnectionFactory().getConnection();
    }

    public Collection<Post> busca() {
        Collection<Post> posts = new ArrayList<>();
	PreparedStatement st;
        try {
            st = connection.prepareStatement("SELECT * FROM post");
            st.executeQuery();
            ResultSet rs = st.getResultSet();
            
            while(rs.next()){
                Post p = new Post(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4));
                posts.add(p);
            }
        } catch (SQLException ex) {
            return null;
        }
        return posts;
    }
    
    public Collection<Post> buscaAutor(String email) {
        Collection<Post> posts = new ArrayList<>();
	PreparedStatement st;
        try {
            st = connection.prepareStatement("SELECT * FROM post WHERE post_at=\""+ email +"\"");
            st.executeQuery();
            ResultSet rs = st.getResultSet();
            
            while(rs.next()){
                Post p = new Post(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4));
                posts.add(p);
            }
        } catch (SQLException ex) {
            return null;
        }
        return posts;
    }
}
