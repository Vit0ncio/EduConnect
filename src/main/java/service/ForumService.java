package main.java.service;

import java.util.List;
import main.java.dao.IForumDAO;
import main.java.data.Forum;

public class ForumService {
     private final IForumDAO forumDAO;

    public ForumService(IForumDAO forumDAO) {
        this.forumDAO = forumDAO;
    }

    public Forum criarForum(Forum forum) throws ServiceException {
        if (forum.getTopico() == null || forum.getTopico().isBlank()) {
            throw new ServiceException("Título do fórum não pode ser vazio");
        }
        try {
            forumDAO.salvar(forum);
            return forum;
        } catch (ServiceException se) {
            throw new ServiceException("Erro ao criar fórum", se);
        }
    }

    public List<Forum> listarTodos() throws ServiceException {
        try {
            return forumDAO.listarTodosForuns();
        } catch (ServiceException se) {
            throw new ServiceException("Erro ao listar fóruns", se);
        }
    }
}
