<%-- 
    Document   : index
    Created on : 15/04/2017, 13:21:41
    Author     : Amanda
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="StyleSheet" type="text/css" href="Estilo/estilo.css">
        <title>Sistema de Blog</title>
    </head>
    <body>
        <div class="login-page">
            <form class="f" action="Controller"  method="POST">
                <input placeholder="Email" type="text" name="email">
                <input placeholder="Senha" type="password" name="senha">
                <input class="s" type="submit" value="Fazer Login">
                <input type="hidden" name="tarefa" value="Login">
                <a class="log" href="cadastro.html"> Cadastre-se </a> ou <a class="log" href="Controller?tarefa=Home"> Entre sem fazer login </a>
            </form>
        </div>
    </body>
</html>
