<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mack.clinica.model.Usuario" %>
<%
    List<Usuario> pacientes = (List<Usuario>) request.getAttribute("pacientes");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Pacientes</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        .center-content {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .novo-btn {
            display: inline-block;
            margin-bottom: 20px;
            padding: 8px 18px;
            background-color: #0066cc;
            color: #fff !important;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.2s;
        }
        .novo-btn:hover {
            background-color: #0066cc;
        }
        table {
            margin: 0 auto;
        }
        .action-btn {
            margin: 0 2px;
            padding: 4px 10px;
            border: none;
            border-radius: 4px;
            color: #fff;
            cursor: pointer;
        }
        .edit-btn { background: #1976d2; }
        .delete-btn { background: #d32f2f; }
    </style>
</head>
<body>
    <!-- Menu de Navegação -->
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

    <div class="content center-content">
        <h1>Pacientes</h1>
        <div style="margin-bottom: 20px;">
            <a href="pacientes?action=new" class="novo-btn">Novo Paciente</a>
            <a href="admin_dashboard" class="novo-btn" style="background:#888; margin-left:10px;">Cancelar</a>
        </div>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>CPF</th>
                <th>Telefone</th>
                <th>Tipo</th>
                <th>Ações</th>
            </tr>
            <% if (pacientes != null) {
                   for (Usuario p : pacientes) { %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getNome() %></td>
                <td><%= p.getEmail() %></td>
                <td><%= p.getCpf() %></td>
                <td><%= p.getCelular() %></td>
                <td><%= p.getTipo() %></td>
                <td>
                    <form action="pacientes" method="get" style="display:inline;">
                        <input type="hidden" name="action" value="edit">
                        <input type="hidden" name="id" value="<%= p.getId() %>">
                        <button type="submit" class="action-btn edit-btn">Editar</button>
                    </form>
                    <form action="pacientes" method="get" style="display:inline;" onsubmit="return confirm('Excluir paciente?');">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="<%= p.getId() %>">
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