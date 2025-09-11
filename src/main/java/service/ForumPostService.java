package main.java.service;

import java.util.List;
import main.java.dao.IForumPostDAO;
import main.java.data.ForumPost;

public class ForumPostService {
     private final IForumPostDAO forumPostDAO;

    public ForumPostService(IForumPostDAO forumPostDAO) {
        this.forumPostDAO = forumPostDAO;
    }

    public ForumPost criarPost(ForumPost post) throws ServiceException {
        if (post.getDescricao() == null || post.getDescricao().isBlank()) {
            throw new ServiceException("Conteúdo do post não pode ser vazio");
        }
        try {
            forumPostDAO.salvar(post);
            return post;
        } catch (ServiceException se) {
            throw new ServiceException("Erro ao criar post", se);
        }
    }

    public List<ForumPost> listarPorForum(int forumId) throws ServiceException {
        try {
            return forumPostDAO.listarPorForum(forumId);
        } catch (ServiceException se) {
            throw new ServiceException("Erro ao listar posts do fórum", se);
        }
    }
}
