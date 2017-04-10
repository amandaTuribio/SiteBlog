
package gerenciador.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Giovani
 */
public class Controller extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String tarefa = req.getParameter("tarefa");
            
        if(tarefa == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/SemTarefa.jsp");
            requestDispatcher.forward(req, resp);
        }
        
        tarefa = "gerenciador.servlets." + tarefa;
        
        try { 
            Class<?> classe = Class.forName(tarefa);
            Tarefa instancia = (Tarefa) classe.newInstance();
            
            String pagina = instancia.executa(req, resp);

        
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
            requestDispatcher.forward(req, resp);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
