package com.mack.clinica.controller;

import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/meu_cadastro")
public class MeuCadastroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        if (usuarioLogado == null || !"paciente".equals(usuarioLogado.getTipo())) {
            response.sendRedirect("index.jsp");
            return;
        }

        String realPathBase = request.getServletContext().getRealPath("/");
        UsuarioDAO dao = new UsuarioDAO();
        Usuario pacienteAtualizado = dao.buscarPorId(usuarioLogado.getId(), realPathBase);

        request.setAttribute("usuario", pacienteAtualizado);
        request.getRequestDispatcher("showusercadastro.jsp").forward(request, response);
    }
}
