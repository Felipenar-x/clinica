package com.mack.clinica.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mack.clinica.util.DatabaseConnection;

public class ConsultaDAO {

    private final String realPathBase;

    public ConsultaDAO(String realPathBase) {
        this.realPathBase = realPathBase;
    }

    public List<Consulta> listarConsultasPorPaciente(int pacienteId) {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT c.id, c.data_hora, c.status, c.observacoes, u.nome AS medico_nome " +
                     "FROM consultas c " +
                     "JOIN usuarios u ON c.profissional_id = u.id " +
                     "WHERE c.paciente_id = ? ORDER BY c.data_hora DESC";
        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pacienteId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                consulta.setDataHora(rs.getString("data_hora"));
                consulta.setStatus(rs.getString("status"));
                consulta.setObservacoes(rs.getString("observacoes"));
                consulta.setMedicoNome(rs.getString("medico_nome"));
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar consultas por paciente", e);
        }
        return consultas;
    }

    // Lista todas as consultas com filtros opcionais
    public List<Consulta> listarConsultasFiltradas(String paciente, String medico, String data) {
        List<Consulta> consultas = new ArrayList<>();
        StringBuilder sql = new StringBuilder(
            "SELECT c.id, c.data_hora, c.status, c.observacoes, " +
            "u.nome AS medico_nome, p.nome AS paciente_nome " +
            "FROM consultas c " +
            "JOIN usuarios u ON c.profissional_id = u.id " +
            "JOIN usuarios p ON c.paciente_id = p.id WHERE 1=1 "
        );
        List<Object> params = new ArrayList<>();
        if (paciente != null && !paciente.isEmpty()) {
            sql.append(" AND p.nome LIKE ?");
            params.add("%" + paciente + "%");
        }
        if (medico != null && !medico.isEmpty()) {
            sql.append(" AND u.nome LIKE ?");
            params.add("%" + medico + "%");
        }
        if (data != null && !data.isEmpty()) {
            sql.append(" AND date(c.data_hora) = ?");
            params.add(data);
        }
        sql.append(" ORDER BY c.data_hora DESC");
        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                consulta.setDataHora(rs.getString("data_hora"));
                consulta.setStatus(rs.getString("status"));
                consulta.setObservacoes(rs.getString("observacoes"));
                consulta.setMedicoNome(rs.getString("medico_nome"));
                consulta.setPacienteNome(rs.getString("paciente_nome"));
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar consultas", e);
        }
        return consultas;
    }

    // Classe interna para consulta (ou crie em arquivo separado)
    public static class Consulta {
        private int id;
        private String dataHora;
        private String status;
        private String observacoes;
        private String medicoNome;
        private String pacienteNome;

        // Getters e setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getDataHora() { return dataHora; }
        public void setDataHora(String dataHora) { this.dataHora = dataHora; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        public String getObservacoes() { return observacoes; }
        public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
        public String getMedicoNome() { return medicoNome; }
        public void setMedicoNome(String medicoNome) { this.medicoNome = medicoNome; }
        public String getPacienteNome() { return pacienteNome; }
        public void setPacienteNome(String pacienteNome) { this.pacienteNome = pacienteNome; }
    }
}