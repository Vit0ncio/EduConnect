package main.java.service;

import java.util.List;
import main.java.dao.DAOException;
import main.java.dao.INotaDAO;
import main.java.data.Nota;

public class NotaService {
    private final INotaDAO notaDAO;

    public NotaService(INotaDAO notaDAO) {
        this.notaDAO = notaDAO;
    }

    public List<Nota> listarNotasDoAluno(int alunoId) throws ServiceException {
        try {
            return notaDAO.listarPorAluno(alunoId);
        } catch (DAOException daoe) {
            throw new ServiceException("Erro ao listar notas do aluno", daoe);
        }
    }
}
