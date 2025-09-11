package main.java;

import main.java.dao.IForumDAO;
import main.java.dao.IForumPostDAO;
import main.java.dao.INotaDAO;
import main.java.dao.impl.PessoaDAOJdbc;
import main.java.dao.impl.ForumDAOJdbc;
import main.java.dao.impl.ForumPostDAOJdbc;
import main.java.dao.impl.NotaDAOJdbc;
import main.java.data.Pessoa;
import main.java.service.PessoaService;
import main.java.service.ForumService;
import main.java.service.ForumPostService;
import main.java.service.NotaService;
import main.java.view.TelaLogin;

public class MainApp {
    public static void main(String[] args) {
        Pessoa usuario = new Pessoa();
        PessoaService pessoaService = new PessoaService(new PessoaDAOJdbc());
        ForumService forumService = new ForumService((IForumDAO) new ForumDAOJdbc());
        ForumPostService forumPostService = new ForumPostService((IForumPostDAO) new ForumPostDAOJdbc());
        NotaService notaService = new NotaService((INotaDAO) new NotaDAOJdbc());

        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin(usuario, pessoaService, forumService, forumPostService, notaService).setVisible(true);
        });
    }
}