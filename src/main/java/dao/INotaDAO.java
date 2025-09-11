package main.java.dao;

import java.util.List;
import main.java.data.Nota;

public interface INotaDAO {
    void salvar(Nota nota) throws DAOException;
    List<Nota> listarPorAluno(int alunoId) throws DAOException;
}
