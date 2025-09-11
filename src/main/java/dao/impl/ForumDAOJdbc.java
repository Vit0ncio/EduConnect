package main.java.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.java.dao.DAOException;
import main.java.dao.IForumDAO;
import main.java.data.Forum;
import main.java.util.ConexaoManager;

public class ForumDAOJdbc implements IForumDAO {
    @Override
    public void salvar(Forum forum) {
        try {
            Connection c = ConexaoManager.getConnection();
            String sql = "INSERT INTO topicos_forum (titulo, descricao) VALUES (?, ?)";
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, forum.getTopico());
            ps.setString(2, "");
            
            int affectedRows = ps.executeUpdate();
            
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        forum.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException sqle) {
            throw new DAOException("Erro ao adicionar fórum", sqle);
        }
    }
    
    @Override
    public List<Forum> listarTodosForuns() {
        List<Forum> forums = new ArrayList<>();
        
        try {
            Connection c = ConexaoManager.getConnection();
            String sql = "SELECT * FROM topicos_forum";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Forum forum = new Forum(rs.getString("titulo"));
                forum.setId(rs.getInt("id"));
                forums.add(forum);
            }
            
            // Carregar posts para cada fórum
            ForumPostDAOJdbc postDAO = new ForumPostDAOJdbc();
            for (Forum forum : forums) {
                forum.setPosts(postDAO.listarPorForum(forum.getId()));
            }
            
            return forums;
        } catch (SQLException sqle) {
            throw new DAOException("Erro ao listar fórums", sqle);
        }
    }
}
