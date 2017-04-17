<%-- 
    Document   : TelaPrincipal
    Created on : 08/04/2017, 18:28:50
    Author     : Amanda
--%>

<%@page import="gerenciador.beans.Comentario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gerenciador.dao.PostDAO"%>
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
                <li class="home"><a href="Controller?tarefa=Home">Home</a></li> 
                <li class="home"><a href="Controller?tarefa=Conta">Editar Conta</a></li>                
                <li class="home"><a href="Controller?tarefa=MPost">Meus Posts</a></li>
                <li class="home"><a href="Controller?tarefa=Logout">Logout</a></li>              
            </ul>
            <img class="im" src="Estilo/blog.png">
            <br>

           <%
                Post posts = (Post)request.getAttribute("post");
                     out.println("<div class='posts'>"); 
                     out.println("<p class='tx'>" + posts.getTitulo() + "</p>");
                     out.println("<p class='tx'>" + posts.getTexto() + "</p>");
                     out.println("<p class='a'> Postado por " + posts.getAutor() + " em " + posts.getData() + ". </p>");
                     out.println("</div>");
                     out.println("</br>");
                     
                ArrayList<Comentario> c = (ArrayList<Comentario>)request.getAttribute("c");
                for(Comentario cs : c){
                    out.println("<div class='comen'>");
                    out.println("<p>" + cs.getDescricao() + "</p>");
                    out.println("<p class='a'> Postado por " + cs.getAutor() + " em " + cs.getData() + ". </p>");
                    out.println("</div>");
                }
                
                out.println("<form action='Controller' method='post'>");
                out.println("<input type='hidden' name ='postid' value='" + posts.getCodigo() + "'/>");
                out.println("<input type='hidden' name='tarefa' value='NovoComentario'/>");
                out.println("<input class='esquerdo-inferior' type=image src='Estilo/co.png'></form> ");
                     
            %>   
    </body>
</html>