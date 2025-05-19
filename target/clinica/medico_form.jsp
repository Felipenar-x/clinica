<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.mack.clinica.model.Usuario" %>
<%
    Usuario medico = (Usuario) request.getAttribute("medico");
    boolean editando = medico != null;
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title><%= editando ? "Editar" : "Cadastrar" %> Médico</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="navbar">
        <div class="nav-links">
            <a href="admin_dashboard">Home</a>
            <a href="pacientes">Cadastro de Pacientes</a>
            <a href="medicos">Cadastro de Médicos</a>
            <a href="#">Consultar Agenda</a>
            <a href="#">Ficha Clínica</a>
            <a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a>
        </div>
    </div>
    <div class="content center-content">
        <h1><%= editando ? "Editar" : "Cadastrar" %> Médico</h1>
        <form method="post" action="medicos">
            <input type="hidden" name="id" value="<%= editando ? medico.getId() : "" %>">
            <label>Nome:</label>
            <input type="text" name="nome" value="<%= editando ? medico.getNome() : "" %>" required><br>
            <label>Email:</label>
            <input type="email" name="email" value="<%= editando ? medico.getEmail() : "" %>" required><br>
            <label>CPF:</label>
            <input type="text" name="cpf" value="<%= editando ? medico.getCpf() : "" %>" required><br>
            <label>Telefone:</label>
            <input type="text" name="telefone" value="<%= editando ? medico.getCelular() : "" %>" required><br>
            <button type="submit" class="novo-btn" style="background:#0066cc;">Salvar</button>
            <button type="button" class="novo-btn" style="background:#888;" onclick="window.location.href='medicos'">Cancelar</button>
        </form>
    </div>
</body>
</html>