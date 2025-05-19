package com.mack.clinica.controller;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String cpf = request.getParameter("cpf");

        // Atualiza o objeto do usuário
        usuarioLogado.setNome(nome);
        usuarioLogado.setEmail(email);
        usuarioLogado.setCelular(telefone);
        usuarioLogado.setCpf(cpf);

        String realPathBase = request.getServletContext().getRealPath("/");
        UsuarioDAO dao = new UsuarioDAO();
        dao.atualizarPaciente(usuarioLogado, realPathBase);

        // Atualiza o objeto na sessão
        session.setAttribute("usuarioLogado", usuarioLogado);

        // Redireciona para a tela de cadastro com mensagem de sucesso
        response.sendRedirect("meu_cadastro?msg=sucesso");
    }
}