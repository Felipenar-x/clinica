<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mack.clinica.model.ConsultaDAO.Consulta" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Minha Agenda</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="navbar">
        <div class="nav-links">
            <a href="paciente_dashboard">Home</a>
            <a href="agendarConsulta">Agendamento de Consultas</a>
            <a href="minha_agenda">Minha Agenda</a>
            <a href="meu_cadastro">Meu Cadastro</a>
            <a href="${pageContext.request.contextPath}/logout" class="logout-link">Logout</a>
        </div>
    </div>
    <div class="content">
        <h1>Minha Agenda de Consultas</h1>
        <%
            List<Consulta> consultas = (List<Consulta>) request.getAttribute("consultas");
            if (consultas == null || consultas.isEmpty()) {
        %>
            <p>Você não possui consultas agendadas.</p>
        <%
            } else {
        %>
        <table class="agenda-table">
            <tr>
                <th>Data e Hora</th>
                <th>Médico</th>
                <th>Status</th>
                <th>Observações</th>
            </tr>
            <%
                for (Consulta c : consultas) {
            %>
            <tr>
                <td><%= c.getDataHora() %></td>
                <td><%= c.getMedicoNome() %></td>
                <td>
                    <%
                        String status = c.getStatus();
                        String statusClass = status == null ? "" : status.toLowerCase().replace("á", "a").replace("ã", "a").replace("â", "a").replace("é", "e").replace("ê", "e").replace("í", "i").replace("ó", "o").replace("ô", "o").replace("õ", "o").replace("ú", "u").replace("ç", "c").replaceAll("[^a-z]", "");
                    %>
                    <span class="status-badge status-<%= statusClass %>"><%= status %></span>
                </td>
                <td><%= c.getObservacoes() != null ? c.getObservacoes() : "" %></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            }
        %>
    </div>
</body>
</html>