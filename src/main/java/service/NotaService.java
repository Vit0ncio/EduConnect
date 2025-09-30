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
    
    public double calcularMediaDoAluno(int alunoId) throws ServiceException {
        try {
            List<Nota> notas = notaDAO.listarPorAluno(alunoId);
            
            if (notas.isEmpty()) {
                return 0.0;
            }
            
            double soma = 0.0;
            
            for (Nota nota : notas) {
                soma += nota.getValor();
            }
            
            return soma / notas.size();
        } catch (DAOException daoe) {
            throw new ServiceException("Erro ao calcular média do aluno", daoe);
        }
    }
}
