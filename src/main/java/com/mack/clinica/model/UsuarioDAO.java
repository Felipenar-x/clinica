package com.mack.clinica.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mack.clinica.util.DatabaseConnection;

public class UsuarioDAO {

    /**
     * Consulta o usuário pelo email e senha no banco.
     * @param email Email do usuário.
     * @param senha Senha do usuário.
     * @param realPathBase Caminho real da aplicação para localizar o banco.
     * @return Objeto Usuario encontrado ou null se não encontrado.
     */
    public static Usuario buscarUsuario(String email, String senha, String realPathBase) {
        try (Connection conn = DatabaseConnection.getConnection(realPathBase)) {
            String sql = "SELECT id, nome, email, cpf, celular, tipo FROM usuarios WHERE email = ? AND senha = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setTipo(rs.getString("tipo"));
                return usuario;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário no banco de dados.", e);
        }
        return null;
    }

    public List<Usuario> listarPacientes(String realPathBase) {
        List<Usuario> pacientes = new ArrayList<>();
        String sql = "SELECT id, nome, email, cpf, celular, tipo FROM usuarios WHERE tipo = 'paciente'";
        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setCpf(rs.getString("cpf"));
                u.setCelular(rs.getString("celular"));
                u.setTipo(rs.getString("tipo"));
                pacientes.add(u);
            }
        } catch (SQLException e) {
        }
        return pacientes;
    }

    public List<Usuario> listarMedicos(String realPathBase) {
        List<Usuario> medicos = new ArrayList<>();
        String sql = "SELECT id, nome, email, cpf, celular, tipo FROM usuarios WHERE tipo = 'medico'";
        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setCpf(rs.getString("cpf"));
                u.setCelular(rs.getString("celular"));
                u.setTipo(rs.getString("tipo"));
                medicos.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar médicos no banco de dados.", e);
        }
        return medicos;
    }

    public Usuario buscarPorId(int id, String realPathBase) {
        String sql = "SELECT id, nome, email, cpf, celular, tipo FROM usuarios WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setCpf(rs.getString("cpf"));
                u.setCelular(rs.getString("celular"));
                u.setTipo(rs.getString("tipo"));
                return u;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void inserirPaciente(Usuario u, String realPathBase) {
        String sql = "INSERT INTO usuarios (nome, email, cpf, celular, tipo, senha) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getCpf());
            stmt.setString(4, u.getCelular());
            stmt.setString(5, "paciente");
            stmt.setString(6, "123"); // senha padrão, altere se quiser
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserirMedico(Usuario u, String realPathBase) {
        String sql = "INSERT INTO usuarios (nome, email, cpf, celular, tipo, senha) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getCpf());
            stmt.setString(4, u.getCelular());
            stmt.setString(5, "medico");
            stmt.setString(6, "123"); // senha padrão
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPaciente(Usuario u, String realPathBase) {
        String sql = "UPDATE usuarios SET nome=?, email=?, cpf=?, celular=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getCpf());
            stmt.setString(4, u.getCelular());
            stmt.setInt(5, u.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarMedico(Usuario u, String realPathBase) {
        String sql = "UPDATE usuarios SET nome=?, email=?, cpf=?, celular=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getCpf());
            stmt.setString(4, u.getCelular());
            stmt.setInt(5, u.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id, String realPathBase) {
        String sql = "DELETE FROM usuarios WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection(realPathBase);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

