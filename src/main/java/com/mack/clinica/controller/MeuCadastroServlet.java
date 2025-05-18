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

@WebServlet("/meuCadastro")
public class MeuCadastroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        if (usuarioLogado == null || !"paciente".equals(usuarioLogado.getTipo())) {
            response.sendRedirect("login.jsp");
            return;
        }

        UsuarioDAO dao = new UsuarioDAO();
        Usuario pacienteAtualizado = dao.buscarPorId(usuarioLogado.getId(), usuarioLogado.getTipo());

        request.setAttribute("paciente", pacienteAtualizado);
        request.getRequestDispatcher("meu_cadastro.jsp").forward(request, response);
        request.setAttribute("usuario", paciente);

        
    }
}
