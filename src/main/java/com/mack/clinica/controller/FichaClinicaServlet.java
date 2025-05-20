package com.mack.clinica.controller;

import java.io.IOException;
import java.util.List;

import com.mack.clinica.model.ConsultaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ficha_clinica")
public class FichaClinicaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String realPathBase = req.getServletContext().getRealPath("/");
        ConsultaDAO dao = new ConsultaDAO(realPathBase);
        List<ConsultaDAO.Consulta> consultas = dao.listarConsultasFiltradas(null, null, null);
        req.setAttribute("consultas", consultas);
        req.getRequestDispatcher("/ficha_clinica.jsp").forward(req, resp);
    }
}