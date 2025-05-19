package com.mack.clinica.controller;

import java.io.IOException;
import java.util.List;
import com.mack.clinica.model.Usuario;
import com.mack.clinica.model.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/medicos")
public class MedicoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String realPathBase = request.getServletContext().getRealPath("/");
        UsuarioDAO dao = new UsuarioDAO();

        if (action == null) {
            List<Usuario> medicos = dao.listarMedicos(realPathBase);
            request.setAttribute("medicos", medicos);
            request.getRequestDispatcher("/lista_medicos.jsp").forward(request, response);
        } else switch (action) {
            case "edit" -> {
                int id = Integer.parseInt(request.getParameter("id"));
                Usuario medico = dao.buscarPorId(id, realPathBase);
                request.setAttribute("medico", medico);
                request.getRequestDispatcher("/medico_form.jsp").forward(request, response);
            }
            case "delete" -> {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.excluir(id, realPathBase);
                response.sendRedirect("medicos");
            }
            case "new" -> {
                request.getRequestDispatcher("/medico_form.jsp").forward(request, response);
            }
            default -> {
                List<Usuario> medicos = dao.listarMedicos(realPathBase);
                request.setAttribute("medicos", medicos);
                request.getRequestDispatcher("/lista_medicos.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String realPathBase = request.getServletContext().getRealPath("/");
        UsuarioDAO dao = new UsuarioDAO();

        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String cpf = request.getParameter("cpf");

        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setCelular(telefone);
        u.setCpf(cpf);
        u.setTipo("medico");

        if (idStr == null || idStr.isEmpty()) {
            dao.inserirMedico(u, realPathBase);
        } else {
            u.setId(Integer.parseInt(idStr));
            dao.atualizarMedico(u, realPathBase);
        }
        response.sendRedirect("medicos");
    }
}