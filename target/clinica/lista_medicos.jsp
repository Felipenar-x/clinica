<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mack.clinica.model.Usuario" %>
<%
    List<Usuario> medicos = (List<Usuario>) request.getAttribute("medicos");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Médicos</title>
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
        <h1>Médicos</h1>
        <div class="botoes-topo">
            <form action="medicos" method="get">
                <input type="hidden" name="action" value="new">
                <button type="submit" class="novo-btn btn-pequeno">Novo Médico</button>
            </form>
            <form action="admin_dashboard" method="get">
                <button type="submit" class="novo-btn btn-pequeno" style="background:#888;">Voltar</button>
            </form>
        </div>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>CPF</th>
                <th>Telefone</th>
                <th>Ações</th>
            </tr>
            <% if (medicos != null) {
                   for (Usuario m : medicos) { %>
            <tr>
                <td><%= m.getId() %></td>
                <td><%= m.getNome() %></td>
                <td><%= m.getEmail() %></td>
                <td><%= m.getCpf() %></td>
                <td><%= m.getCelular() %></td>
                <td>
                    <form action="medicos" method="get" style="display:inline;">
                        <input type="hidden" name="action" value="edit">
                        <input type="hidden" name="id" value="<%= m.getId() %>">
                        <button type="submit" class="action-btn edit-btn">Editar</button>
                    </form>
                    <form action="medicos" method="get" style="display:inline;" onsubmit="return confirm('Excluir médico?');">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="<%= m.getId() %>">
                        <button type="submit" class="action-btn delete-btn">Excluir</button>
                    </form>
                </td>
            </tr>
            <%   }
               }
            %>
        </table>
    </div>
</body>
</html>