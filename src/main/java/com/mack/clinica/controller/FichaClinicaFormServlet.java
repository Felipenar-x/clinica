package com.mack.clinica.controller;

import java.io.IOException;

import com.mack.clinica.model.ConsultaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ficha_clinica_form")
public class FichaClinicaFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String realPathBase = req.getServletContext().getRealPath("/");
        int consultaId = Integer.parseInt(req.getParameter("consultaId"));
        ConsultaDAO dao = new ConsultaDAO(realPathBase);
        ConsultaDAO.Consulta consulta = null;
        for (ConsultaDAO.Consulta c : dao.listarConsultasFiltradas(null, null, null)) {
            if (c.getId() == consultaId) {
                consulta = c;
                break;
            }
        }
        req.setAttribute("consulta", consulta);
        req.getRequestDispatcher("/ficha_clinica_form.jsp").forward(req, resp);
    }
}