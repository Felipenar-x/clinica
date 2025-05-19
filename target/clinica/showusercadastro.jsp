<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.mack.clinica.model.Usuario" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Agendar Consulta</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

    <!-- Menu de Navegação -->
    <div class="navbar">
        <div class="nav-links">
            <a href="paciente_dashboard">Home</a>
            <a href="agendarConsulta">Agendamento de Consultas</a>
            <a href="minha_agenda">Minha Agenda</a>
            <a href="meu_cadastro">Meu Cadastro</a>
            <a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a>
        </div>
    </div>

    <!-- Conteúdo principal -->
    <div class="content">
        <h1>Meus dados</h1>
        <p>Bem-vindo a seus dados, onde você poderá visualizar e editar seus dados.</p>
        
        <% if ("sucesso".equals(request.getParameter("msg"))) { %>
            <div class="alert alert-success">Dados atualizados com sucesso!</div>
        <% } %>
        
        <form method="post" action="updateUser" class="form-container">

            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="${usuario.nome}" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${usuario.email}" required>

            <label for="telefone">Telefone:</label>
            <input type="text" id="telefone" name="telefone" value="${usuario.celular}" required>

            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" value="${usuario.cpf}" required readonly>

            <button type="submit" class="button">Atualizar</button>
        </form>
    </div>

</body>
</html>
