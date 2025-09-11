package main.java.dao;

import java.util.List;
import main.java.data.Forum;

public interface IForumDAO {
    void salvar(Forum forum) throws DAOException;
    List<Forum> listarTodosForuns() throws DAOException;
}
