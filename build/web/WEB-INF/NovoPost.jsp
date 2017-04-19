<%-- 
    Document   : NovoPost
    Created on : 11/04/2017, 19:15:35
    Author     : Amanda
--%>

<%@page import="gerenciador.servlets.Controller"%>
<%@page import="gerenciador.beans.Usuario"%>
<%@page import="gerenciador.servlets.Filtro"%>
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
        <div class="login-page">
            <form class="f" action="Controller"  accept-charset="ISO-8859-1" method="POST">                
                <input placeholder="Titulo" type="text" name="titulo">               
                <textarea placeholder="Seu Post" rows="5" cols="38" name="tex"></textarea>
                <input class="s" type="submit" value="Postar!">
                <input type="hidden" name="tarefa" value="CadastroPost">
            </form>
        </div>
    </body>
</html>

