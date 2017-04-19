<%-- 
    Document   : NovoComentario
    Created on : 16/04/2017, 16:20:53
    Author     : Amanda
--%>

<%@page import="gerenciador.beans.Usuario"%>
<%@page import="gerenciador.servlets.Filtro"%>
<%@page import="gerenciador.beans.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="StyleSheet" type="text/css" href="Estilo/estilo.css">
        <title>Blog</title>
    </head>
    <body>        
        <ul class="u">
            <%
                Usuario u = new Filtro().getU(request);
                    if(u.getNivel() == true){
                        out.println("<li class='home'><a href='Controller?tarefa=Home'>Home</a></li>");
                        out.println("<li class='home'><a href='Controller?tarefa=Conta'>Editar Conta</a></li>");
                        out.println("<li class='home'><a href='Controller?tarefa=MPost'>Meus Posts</a></li>");
                        out.println("<li class='home'><a href='Controller?tarefa=Logout'>Logout</a></li>");
                    }else{                    
                        out.println("<li class='h'><a href='Controller?tarefa=Home'>Home</a></li>");
                        out.println("<li class='h'><a href='Controller?tarefa=Conta'>Editar Conta</a></li>");
                        out.println("<li class='h'><a href='Controller?tarefa=Logout'>Logout</a></li>");                   
                    }                
            %>
        </ul> 
            
        <div class="login-page">
            <form class="f" action="Controller" accept-charset="ISO-8859-1" method="post">                              
                <%
                    out.println("<input type='hidden' name ='postid' value='" + request.getAttribute("postid") + "'/>");
                %>  
                <textarea placeholder="Escreva aqui seu comentario" rows="5" cols="38" name="tex"></textarea>
                <input type="hidden" name="tarefa" value="CadastroComentario">
                <input class="s" type="submit" value="Comentar">
            </form>     
        </div>
    </body>
</html>

