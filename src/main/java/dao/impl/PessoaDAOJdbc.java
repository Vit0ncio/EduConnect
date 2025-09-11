package main.java.dao.impl;

import main.java.dao.IPessoaDAO;
import main.java.util.ConexaoManager;
import main.java.data.Pessoa;
import java.sql.*;
import java.util.Optional;
import main.java.dao.DAOException;

public class PessoaDAOJdbc implements IPessoaDAO {
    public boolean salvar(Pessoa pessoa, String tipoUsuario) throws DAOException {
        String sql = "insert into usuarios (nome, email, idade, senha, tipo) values (?, ?, ?, ?, ?)";
        
        try (Connection c = ConexaoManager.getConnection();
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getEmail());
            ps.setInt(3, pessoa.getIdade());
            ps.setString(4, pessoa.getSenha());
            ps.setString(5, tipoUsuario);
            
            int afetado = ps.executeUpdate();
            
            if (afetado > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) pessoa.setId(rs.getInt(1));
                }
                return true;
            }
            return false;
        } catch (SQLException ex) {
            throw new DAOException("Erro ao salvar usuário", ex);
        }
    }
    
    public Optional<Pessoa> login(String email, String senha) throws DAOException {
        String sql = "select * from usuarios where email = ? and senha = ?";
        
        try (Connection c = ConexaoManager.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, senha);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                     return Optional.of(mapRowToPessoa(rs));
                }
                return Optional.empty();
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao efetuar login", ex);
        }
    }
    
    @Override
    public Optional<Pessoa> buscarPorEmail(String email) throws DAOException {
        String sql = "select * from usuarios where email = ?";

        try (Connection c = ConexaoManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRowToPessoa(rs));
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar usuário por email", ex);
        }
    }
    
    private Pessoa mapRowToPessoa(ResultSet rs) throws SQLException {
        return new Pessoa(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getInt("idade"),
            rs.getString("email"),
            rs.getString("senha")
        );
    }
}