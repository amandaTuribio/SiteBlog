<%-- 
    Document   : TelaPrincipal
    Created on : 08/04/2017, 18:28:50
    Author     : Amanda
--%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@page import="java.util.ArrayList"%>
<%@page import="gerenciador.dao.PostDAO"%>
<%@page import="gerenciador.beans.Post"%>

<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
         <meta charset=UTF-8>
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
                ArrayList<Post> posts = (ArrayList<Post>)request.getAttribute("posts");
                for(Post post : posts){
                    out.println("<div class='posts'>");
                    out.println("<form action='Controller' method='post'><input type='submit' value='" + post.getTitulo() + "' />");
                    out.println("<input type='hidden' name ='postid' value='" + post.getCodigo() + "'/>");
                    out.println("<input type='hidden' name='tarefa' value='UnicoPost'></form>");
                    out.println("<p class='tx'>" + post.getTexto() + "</p>");
                    out.println("<p class='a'> Postado por " + post.getAutor() + " em " + post.getData() + ". </p>");
                    out.println("</div><br>");
                }
            %>
            
            <a href="Controller?tarefa=NovoPost"><img class="esquerdo-inferior"  src="Estilo/np.png"></a> 
    </body>
</html>
