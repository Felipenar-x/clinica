<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mack.clinica.model.ConsultaDAO" %>
<%
    List<ConsultaDAO.Consulta> consultas = (List<ConsultaDAO.Consulta>) request.getAttribute("consultas");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Consultar Agenda</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        .filtro-form { margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #f0f0f0; }
    </style>
</head>
<body>
    <div class="navbar">
        <div class="nav-links">
            <a href="admin_dashboard">Home</a>
            <a href="pacientes">Cadastro de Pacientes</a>
            <a href="medicos">Cadastro de Médicos</a>
            <a href="consultar_agenda">Consultar Agenda</a>
            <a href="#">Ficha Clínica</a>
            <a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a>
        </div>
    </div>
    <div class="content">
        <h1>Consultar Agenda</h1>
        <form method="get" class="filtro-form">
            <label>Paciente: <input type="text" name="paciente" value="<%= request.getParameter("paciente") != null ? request.getParameter("paciente") : "" %>" /></label>
            <label>Médico: <input type="text" name="medico" value="<%= request.getParameter("medico") != null ? request.getParameter("medico") : "" %>" /></label>
            <label>Data: <input type="date" name="data" value="<%= request.getParameter("data") != null ? request.getParameter("data") : "" %>" /></label>
            <button type="submit">Filtrar</button>
        </form>
        <table>
            <tr>
                <th>ID</th>
                <th>Paciente</th>
                <th>Médico</th>
                <th>Data/Hora</th>
                <th>Status</th>
                <th>Observações</th>
            </tr>
            <% if (consultas != null && !consultas.isEmpty()) {
                for (ConsultaDAO.Consulta c : consultas) { %>
            <tr>
                <td><%= c.getId() %></td>
                <td><%= c.getPacienteNome() %></td>
                <td><%= c.getMedicoNome() %></td>
                <td><%= c.getDataHora() %></td>
                <td><%= c.getStatus() %></td>
                <td><%= c.getObservacoes() %></td>
            </tr>
            <%   }
               } else { %>
            <tr><td colspan="6">Nenhuma consulta encontrada.</td></tr>
            <% } %>
        </table>
    </div>
</body>
</html>
