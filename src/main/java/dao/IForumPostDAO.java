package main.java.dao;

import java.util.List;
import main.java.data.ForumPost;

public interface IForumPostDAO {
    void salvar(ForumPost post) throws DAOException;
    List<ForumPost> listarPorForum(int forumId) throws DAOException;
}
