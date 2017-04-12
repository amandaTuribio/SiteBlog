<%-- 
    Document   : TelaAdmin
    Created on : 10/04/2017, 23:31:27
    Author     : Amanda
--%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Sistema de Blog</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="StyleSheet" type="text/css" href="Estilo/estilo.css">
    </head>
    <body>
        <div class="login-page">
            <form class="f" action="Controller" method="POST">                          
                <input placeholder="${usuarioLogado.nome}" type="text" name="nome">
                <input placeholder="${usuarioLogado.endereco}" type="text" name="end">
                <input placeholder="Cidade" type="text" name="cidade">
                <select name="idEstado">
                    <option value="">Estado</option>
                    <option value="AC">Acre</option>
                    <option value="AL">Alagoas</option>
                    <option value="AP">Amapá</option>
                    <option value="AM">Amazonas</option>
                    <option value="BA">Bahia</option>
                    <option value="CE">Ceará</option>
                    <option value="DF">Distrito Federal</option>
                    <option value="ES">Espirito Santo</option>
                    <option value="GO">Goiás</option>
                    <option value="MA">Maranhão</option>
                    <option value="MS">Mato Grosso do Sul</option>
                    <option value="MT">Mato Grosso</option>
                    <option value="MG">Minas Gerais</option>
                    <option value="PA">Pará</option>
                    <option value="PB">Paraíba</option>
                    <option value="PR">Paraná</option>
                    <option value="PE">Pernambuco</option>
                    <option value="PI">Piauí</option>
                    <option value="RJ">Rio de Janeiro</option>
                    <option value="RN">Rio Grande do Norte</option>
                    <option value="RS">Rio Grande do Sul</option>
                    <option value="RO">Rondônia</option>
                    <option value="RR">Roraima</option>
                    <option value="SC">Santa Catarina</option>
                    <option value="SP">São Paulo</option>
                    <option value="SE">Sergipe</option>
                    <option value="TO">Tocantins</option>
                </select>
                <input placeholder="Data de nascimento" type="date" name="datanasc">
                <input placeholder="${usuarioLogado.email}" type="email" name="email">
                <input placeholder="Senha" type="password" name="senha1">
                <input placeholder=" Confirme a senha" type="password" name="senha2">
                <input type="checkbox" name="cc" value="1">Criador de conteudo
                <br/>
                <br/>
                <input class="s" type="submit" value="Alterar">
                <input type="hidden" name="tarefa" value="Alterar">
            </form>
        </div>
    </body>
</html>
