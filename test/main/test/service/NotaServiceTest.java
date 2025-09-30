package main.test.service;

import org.junit.Test;
import static org.junit.Assert.*;
import main.java.data.Nota;
import main.java.data.Pessoa;

public class NotaServiceTest {
    
    @Test
    public void testCriacaoNota() {
        Pessoa aluno = new Pessoa(1, "Aluno", 20, "aluno@email.com", "senha");
        Nota nota = new Nota(1, "Matemática", 1, 8.5, aluno);
        
        assertNotNull("Nota não deve ser nula", nota);
        assertEquals("Matéria deve ser Matemática", "Matemática", nota.getMateria());
        assertEquals("Valor deve ser 8.5", 8.5, nota.getValor(), 0.001);
        assertNotNull("Aluno não deve ser nulo", nota.getAluno());
    }
    
    @Test
    public void testCalculoMediaSimples() {
        double media = calcularMedia(8.0, 7.0, 9.0);
        assertEquals("Média de 8,7,9 deve ser 8.0", 8.0, media, 0.001);
    }
    
    private double calcularMedia(double... notas) {
        if (notas.length == 0) return 0.0;
        double soma = 0.0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }
}