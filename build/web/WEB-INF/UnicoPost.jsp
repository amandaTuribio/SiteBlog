<%-- 
    Document   : TelaPrincipal
    Created on : 08/04/2017, 18:28:50
    Author     : Amanda
--%>

<%@page import="gerenciador.servlets.Filtro"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="gerenciador.beans.Usuario"%>
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
            <%
                Usuario u = new Filtro().getU(request);
                int perfil = session.getAttribute("usuarioLogado") == null ? 0 : 1;
                if(perfil == 1){ 
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
                }else{                   
                    out.println("<li class='sl'><a href='Controller?tarefa=Home'>Home</a></li>");
                    out.println("<li class='sl'><a href='Controller?tarefa=Logout'>Fazer Login</a></li>");
                }
            %>
        </ul>
        <img class="im" src="Estilo/blog.png">
        <br>

        <%
            Post posts = (Post)request.getAttribute("post");
                out.println("<div class='posts'>");
                out.println("<form action='Controller' method='post'><input type='submit' class='botao01' value='" + posts.getTitulo() + "' />");
                out.println("<input type='hidden' name ='postid' value='" + posts.getCodigo() + "'/>");
                out.println("<input type='hidden' name='tarefa' value='UnicoPost'></form>");
                out.println("<p class='tx'>" + posts.getTexto() + "</p>");
                out.println("<p class='a'> Postado por " + posts.getAutor() + " em " + posts.getData() + ". </p>");
                out.println("</div><br>");
                     
            ArrayList<Comentario> c = (ArrayList<Comentario>)request.getAttribute("c");
                for(Comentario cs : c){
                    out.println("<div class='comen'>");
                    out.println("<p>" + cs.getDescricao() + "</p>");
                    out.println("<p class='a'> Postado por " + cs.getAutor() + " em " + cs.getData() + ". ");
                    if(perfil == 1){
                        if( u.getEmail().equals(cs.getAutor()) || u.getEmail().equals(posts.getAutor())){
                            out.println("<form action='Controller' method='post'>");
                            out.println("<input type='hidden' name ='postid' value='" + posts.getCodigo()  + "'/></p>");
                            out.println("<input type='hidden' name ='postc' value='" + cs.getCodigo() + "'/></p>");
                            out.println("<input type='hidden' name='tarefa' value='ExcluirComentario'/>");
                            out.println("<input class='ex' type=image src='Estilo/ex.png'></form> ");
                        }
                    }
                    out.println("<hr>");
                    out.println("</div>");                    
                }
                if(perfil == 1){
                    out.println("<form action='Controller' method='post'>");
                    out.println("<input type='hidden' name ='postid' value='" + posts.getCodigo() + "'/>");
                    out.println("<input type='hidden' name='tarefa' value='NovoComentario'/>");
                    out.println("<input class='esquerdo-inferior' type=image src='Estilo/co.png'></form> ");
                } 
            %>   
    </body>
</html>