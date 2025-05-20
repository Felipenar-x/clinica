<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.mack.clinica.model.ConsultaDAO" %>
<%@ page import="com.mack.clinica.model.ConsultaDAO.Consulta" %>
<%
    // Aqui você buscaria a consulta pelo id recebido via GET
    String idParam = request.getParameter("id");
    Consulta consulta = null;
    if (idParam != null) {
        try {
            int id = Integer.parseInt(idParam);
            // Supondo que você tenha um método utilitário para buscar a consulta pelo id
            ConsultaDAO dao = new ConsultaDAO(application.getRealPath("/"));
            for (Consulta c : dao.listarConsultasFiltradas(null, null, null)) {
                if (c.getId() == id) {
                    consulta = c;
                    break;
                }
            }
        } catch (Exception e) {}
    }
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Formulário Gerado</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        .ficha-bloco {
            background: #222;
            color: #fff;
            border-radius: 6px;
            padding: 30px 40px;
            margin: 30px 0 20px 0;
            box-shadow: 0 2px 8px rgba(0,0,0,0.10);
            max-width: 600px;
            width: 100%;
            text-align: left;
        }
        .ficha-bloco hr {
            border: 0;
            border-top: 1px solid #fff;
            margin: 10px 0 18px 0;
        }
        .ficha-bloco .ficha-label {
            font-weight: bold;
            color: #b3d1ff;
            margin-right: 6px;
        }
        .ficha-bloco .ficha-item {
            margin-bottom: 8px;
        }
        .btn-cinza {
            background: #888;
            color: #fff;
            border: none;
            border-radius: 4px;
            padding: 8px 22px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 10px;
            transition: background 0.2s;
        }
        .btn-cinza:hover {
            background: #555;
        }
    </style>
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
        <h1>Formulário Gerado</h1>
        <% if (consulta != null) { %>
        <div class="ficha-bloco">
            <div class="ficha-item"><span class="ficha-label">ID da Consulta:</span> <%= consulta.getId() %></div>
            <div class="ficha-item"><span class="ficha-label">Paciente:</span> <%= consulta.getPacienteNome() %></div>
            <div class="ficha-item"><span class="ficha-label">Médico:</span> <%= consulta.getMedicoNome() %></div>
            <div class="ficha-item"><span class="ficha-label">Data/Hora:</span> <%= consulta.getDataHora() %></div>
            <div class="ficha-item"><span class="ficha-label">Status:</span> <%= consulta.getStatus() %></div>
            <hr>
            <div class="ficha-item"><span class="ficha-label">Anotações Médicas:</span> <span style="color:#bdbdbd;">Em breve...</span></div>
            <div class="ficha-item"><span class="ficha-label">Prescrições:</span> <span style="color:#bdbdbd;">Em breve...</span></div>
        </div>
        <form action="ficha_clinica_form" method="get" style="display:inline;">
            <input type="hidden" name="consultaId" value="<%= consulta != null ? consulta.getId() : "" %>">
            <button type="submit" class="novo-btn btn-pequeno" style="background:#888;">Voltar</button>
        </form>
        <% } else { %>
            <p>Consulta não encontrada.</p>
            <form action="ficha_clinica" method="get" style="display:inline;">
                <button type="submit" class="btn-cinza">Voltar</button>
            </form>
        <% } %>
    </div>
</body>
</html>