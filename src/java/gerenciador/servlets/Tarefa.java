
package gerenciador.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amanda e Gabriel
 */
public interface Tarefa {  
    String executa(HttpServletRequest req, HttpServletResponse resp);
}
