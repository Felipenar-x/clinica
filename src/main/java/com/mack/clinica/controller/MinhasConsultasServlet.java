package com.mack.clinica.controller;

import java.io.IOException;
import java.util.List;

import com.mack.clinica.model.ConsultaDAO;
import com.mack.clinica.model.ConsultaDAO.Consulta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/minha_agenda")
public class MinhasConsultasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer pacienteId = (Integer) request.getSession().getAttribute("id");
        if (pacienteId == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        String realPathBase = request.getServletContext().getRealPath("/");
        ConsultaDAO dao = new ConsultaDAO(realPathBase);
        List<Consulta> consultas = dao.listarConsultasPorPaciente(pacienteId);
        request.setAttribute("consultas", consultas);
        request.getRequestDispatcher("/minha_agenda.jsp").forward(request, response);
    }
}