
package gerenciador.servlets;

import gerenciador.beans.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Amanda e Gabriel
 */
public class Filtro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        String usuario = getUsuario(req);
        Boolean nivel = getNivel(req);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
    
    public String getUsuario(HttpServletRequest req){
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
        if(usuario == null) return null;
        return usuario.getEmail();
    }
    
    public Usuario getU(HttpServletRequest req){
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
        if(usuario == null) return null;
        return usuario;
    }
    
    public Boolean getNivel(HttpServletRequest req){
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
        if(usuario == null) return false;
        return usuario.getNivel();
    }
}
