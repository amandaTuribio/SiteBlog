
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
 * @author Amanda e Gabriel
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
                Post p = new Post(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5));
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
                Post p = new Post(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5));
                posts.add(p);
            }
        } catch (SQLException ex) {
            return null;
        }
        return posts;
    }

    public void cadastrar(String titulo, String texto, String data1, String email) throws SQLException {
        PreparedStatement stmt;
            stmt = connection.prepareStatement("INSERT INTO `post`(`post_tt`, `post_at`, `post_dt`, `post_tx`) "
                    + "VALUES (?,?,?,?)");
        stmt.setString(1, titulo); 
        stmt.setString(2, email);
        stmt.setString(3,data1);
        stmt.setString(4, texto);
      
        stmt.execute();
        stmt.close();
    }
    
    public Post buscaId(String id) {
	PreparedStatement st;
        try {
            st = connection.prepareStatement("SELECT * FROM post WHERE post_cd=\""+ id +"\"");
            st.executeQuery();
            ResultSet rs = st.getResultSet();
            
           while(rs.next()){
                Post p = new Post(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5));
                return p;
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public void exclui(String id) throws SQLException {
        PreparedStatement stmt;
        stmt = connection.prepareStatement("DELETE FROM post WHERE post_cd = ? ");

        stmt.setString(1, id);
        
        stmt.execute();
        stmt.close();   
    }
}
