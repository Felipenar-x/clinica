package com.mack.clinica.controller;

import com.mack.clinica.model.ConsultaDAO;
import com.mack.clinica.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/consultar_agenda")
public class ConsultarAgendaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String realPathBase = request.getServletContext().getRealPath("/");
        ConsultaDAO consultaDAO = new ConsultaDAO(realPathBase);

        String paciente = request.getParameter("paciente");
        String medico = request.getParameter("medico");
        String data = request.getParameter("data");

        List<ConsultaDAO.Consulta> consultas = consultaDAO.listarConsultasFiltradas(paciente, medico, data);
        request.setAttribute("consultas", consultas);
        request.getRequestDispatcher("/consultar_agenda.jsp").forward(request, response);
    }
}
