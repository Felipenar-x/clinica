<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.mack.clinica.model.Usuario" %>
<%
    Usuario paciente = (Usuario) request.getAttribute("paciente");
    boolean editando = paciente != null;
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title><%= editando ? "Editar" : "Cadastrar" %> Paciente</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <!-- Menu de Navegação -->
    <div class="navbar">
        <div class="nav-links">
            <a href="admin_dashboard">Home</a>
            <a href="pacientes">Cadastro de Pacientes</a>
            <a href="medicos">Cadastro de Médicos</a>
            <a href="consultar_agenda">Consultar Agenda</a>
            <a href="ficha_clinica">Ficha Clínica</a>
            <a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a>
        </div>
    </div>

    <div class="content center-content">
        <h1><%= editando ? "Editar" : "Cadastrar" %> Paciente</h1>
        <form method="post" action="pacientes">
            <input type="hidden" name="id" value="<%= editando ? paciente.getId() : "" %>">
            <label>Nome:</label>
            <input type="text" name="nome" value="<%= editando ? paciente.getNome() : "" %>" required><br>
            <label>Email:</label>
            <input type="email" name="email" value="<%= editando ? paciente.getEmail() : "" %>" required><br>
            <label>CPF:</label>
            <input type="text" name="cpf" value="<%= editando ? paciente.getCpf() : "" %>" required><br>
            <label>Telefone:</label>
            <input type="text" name="telefone" value="<%= editando ? paciente.getCelular() : "" %>" required><br>
            <button type="submit" class="novo-btn" style="background:#0066cc;">Salvar</button>
            <button type="button" class="novo-btn" style="background:#888;" onclick="window.location.href='pacientes'">Cancelar</button>
        </form>
    </div>
</body>
</html>