<%-- 
    Document   : TelaPrincipal
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
        <title>JSP Page</title>
    </head>
    <body>
        <div class="blog">
            <img class="im" src="Estilo/blog.png">
            <br>
            <p class="bv">
                Bem-vindo, ${usuarioLogado.nome}!
            </p>
            <br>
        </div>
           <%
                ArrayList<Post> posts = (ArrayList<Post>)request.getAttribute("posts");
                for(Post post : posts){
                    out.println("<div class='posts'>");
                    out.println("<p class='ti'>" + post.getTitulo() + "</p>");
                    out.println("<p class='tx'>" + post.getTexto() + "</p>");
                    out.println("<p class='a'> Postado por " + post.getAutor() + " em " + post.getData() + ". </p>");
                    out.println("</div>");
                }
            %> 
    </body>
</html>