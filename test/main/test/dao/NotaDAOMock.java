package main.test.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import main.java.dao.INotaDAO;
import main.java.dao.INotaDAO;
import main.java.data.Nota;
import main.java.data.Pessoa;

public class NotaDAOMock implements INotaDAO {
    private final List<Nota> notasMock = Arrays.asList(
        new Nota(1, "Matemática", 1, 8.0, new Pessoa(1, "Aluno1", 20, "aluno1@email.com", "senha")),
        new Nota(2, "Português", 1, 7.0, new Pessoa(1, "Aluno1", 20, "aluno1@email.com", "senha")),
        new Nota(3, "História", 1, 9.0, new Pessoa(1, "Aluno1", 20, "aluno1@email.com", "senha")),
        new Nota(4, "Geografia", 2, 6.0, new Pessoa(2, "Aluno2", 21, "aluno2@email.com", "senha")),
        new Nota(5, "Física", 2, 8.5, new Pessoa(2, "Aluno2", 21, "aluno2@email.com", "senha"))
    );

    @Override
    public void salvar(Nota nota) {
        System.out.println("Mock: Simulando salvamento da nota - " + nota.getMateria());
    }

    @Override
    public List<Nota> listarPorAluno(int alunoId) {
        List<Nota> notasDoAluno = new ArrayList<>();
        
        for (Nota nota : notasMock) {
            if (nota.getAluno() != null && nota.getAluno().getId() == alunoId) {
                notasDoAluno.add(nota);
            }
        }
        
        return switch (alunoId) {
            case 1 -> Arrays.asList(
                    new Nota(1, "Matemática", 1, 8.0, new Pessoa(1, "Aluno1", 20, "aluno1@email.com", "senha")),
                    new Nota(2, "Português", 1, 7.0, new Pessoa(1, "Aluno1", 20, "aluno1@email.com", "senha"))
            );
            case 2 -> new ArrayList<>();
            case 3 -> Arrays.asList(
                    new Nota(3, "História", 1, 0.0, new Pessoa(3, "Aluno3", 22, "aluno3@email.com", "senha")),
                    new Nota(4, "Geografia", 1, 0.0, new Pessoa(3, "Aluno3", 22, "aluno3@email.com", "senha"))
            );
            case 4 -> Arrays.asList(
                    new Nota(5, "Física", 1, 9.5, new Pessoa(4, "Aluno4", 23, "aluno4@email.com", "senha"))
            );
            default -> notasDoAluno;
        };
    }
}