<%-- 
    Document   : TelaAutor
    Created on : 08/04/2017, 18:28:50
    Author     : Amanda
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="gerenciador.dao.PostDAO"%>
<%@page import="gerenciador.beans.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="StyleSheet" type="text/css" href="Estilo/estilo.css">
        <title>Blog - ${usuarioLogado.nome}</title>
    </head>
    <body>
        <!--
        <nav>
            <ul class="menu">
                  <li><a href="Controller?tarefa=MPost">Meus Posts</a></li>
                  <li><a href="Controller?tarefa=Conta">Minha Conta</a></li>
                  <li><a href="Controller?tarefa=Logout">Logout</a></li>              
            </ul>
        </nav>
        -->
        
        <div class="blog" >
            <form action="Controller" method="POST">
                <input type="submit" name="menu" value="Minha Conta" />
                <input type="submit" name="menu" value="Meus posts" />
                <input type="submit" name="menu" value="Logout" />
                <input type="hidden" name="tarefa" value="Menu">
            </form>
        </div>
        
            <img class="im" src="Estilo/blog.png">
            <p class="bv">Posts de ${usuarioLogado.nome}</p>            
            <br>
            <%
                ArrayList<Post> posts = (ArrayList<Post>)request.getAttribute("posts");
                for(Post post : posts){
                    out.println("<div class='posts'>");
                    out.println("<p class='ti'>" + post.getTitulo() + "</a></p>");
                    out.println("<p class='tx'>" + post.getTexto() + "</p>");
                    out.println("<p class='a'> Postado por " + post.getAutor() + " em " + post.getData() + ". </p>");
                    out.println("</div>");
                }
            %> 
         <a href="Controller?tarefa=NovoPost"><img class="esquerdo-inferior"  src="Estilo/np.png"></a> 
    </body>
</html>