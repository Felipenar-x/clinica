<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.mack.clinica.model.ConsultaDAO.Consulta" %>
<%
    Consulta consulta = (Consulta) request.getAttribute("consulta");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Ficha Clínica</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
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
        <h1>Ficha Clínica</h1>
        <% if (consulta != null) { %>
        <ul style="list-style:none; padding:0;">
            <li><strong>ID da Consulta:</strong> <%= consulta.getId() %></li>
            <li><strong>Paciente:</strong> <%= consulta.getPacienteNome() %></li>
            <li><strong>Médico:</strong> <%= consulta.getMedicoNome() %></li>
            <li><strong>Data/Hora:</strong> <%= consulta.getDataHora() %></li>
            <li><strong>Status:</strong> <%= consulta.getStatus() %></li>
            <li><strong>Anotações Médicas:</strong> <span style="color:#888;">Em breve...</span></li>
            <li><strong>Prescrições:</strong> <span style="color:#888;">Em breve...</span></li>
        </ul>
        <div style="display: flex; flex-direction: column; align-items: center; gap: 12px; margin-top: 20px;">
            <form action="formulario_gerado.jsp" method="get" style="width:100%; display:flex; justify-content:center;">
                <input type="hidden" name="id" value="<%= consulta.getId() %>">
                <button type="submit" class="btn-azul" style="min-width:220px;">Gerar Formulário</button>
            </form>
            <form action="ficha_clinica" method="get" style="width:100%; display:flex; justify-content:center;">
                <button type="submit" class="novo-btn btn-pequeno" style="background:#888; color:#fff; min-width:220px;">Voltar para Ficha Clínica</button>
            </form>
        </div>
        <% } else { %>
            <p>Consulta não encontrada.</p>
            <button type="button" class="btn btn-secondary" onclick="window.location.href='ficha_clinica'">Voltar para Ficha Clínica</button>
        <% } %>
    </div>
</body>
</html>