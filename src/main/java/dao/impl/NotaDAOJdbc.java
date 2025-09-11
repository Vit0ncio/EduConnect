package main.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import main.java.dao.DAOException;
import main.java.dao.INotaDAO;

import main.java.data.Nota;

import main.java.util.ConexaoManager;

public class NotaDAOJdbc implements INotaDAO {
    public void salvar(Nota nota) throws DAOException {
        String sql = "INSERT INTO notas (materia, semestre, valor, aluno_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nota.getMateria());
            ps.setInt(2, nota.getSemestre());
            ps.setDouble(3, nota.getValor());
            ps.setInt(4, nota.getAluno().getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Erro ao salvar nota", e);
        }
    }

    public List<Nota> listarPorAluno(int alunoId) throws DAOException {
        String sql = "SELECT id, materia, semestre, valor FROM notas WHERE aluno_id = ?";
        List<Nota> notas = new ArrayList<>();

        try (Connection conn = ConexaoManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, alunoId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Nota nota = new Nota(
                    rs.getInt("id"),
                    rs.getString("materia"),
                    rs.getInt("semestre"),
                    rs.getDouble("valor"),
                    null
                );
                notas.add(nota);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro ao buscar notas do aluno", e);
        }
        return notas;
    }
}
