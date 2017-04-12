<%-- 
    Document   : NovoPost
    Created on : 11/04/2017, 19:15:35
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="StyleSheet" type="text/css" href="Estilo/estilo.css">
        <title>Blog</title>
    </head>
    <body>
        <div class="blog" >
            <form action="Controller" method="POST">
                <input type="submit" name="menu" value="Administrar Blog" />
                <input type="submit" name="menu" value="Meus posts" />
                <input type="submit" name="menu" value="Logout" />
                <input type="hidden" name="tarefa" value="Menu">
            </form>
        </div>
        <div class="login-page">
            <form class="f" action="Controller" method="POST">                
                <input placeholder="Titulo" type="text" name="titulo">               
                <input placeholder="Seu Post" type="textarea" name="tex">
                <input class="s" type="submit" value="Postar!">
                <input type="hidden" name="tarefa" value="CadastroPost">
            </form>
        </div>
    </body>
</html>

