package main.test.service;

import org.junit.Test;
import static org.junit.Assert.*;
import main.java.data.Pessoa;

public class PessoaServiceTest {
    
    @Test
    public void testCriacaoPessoa() {
        Pessoa pessoa = new Pessoa(1, "João Silva", 25, "joao@email.com", "senha123");
        
        assertNotNull("Pessoa não deve ser nula", pessoa);
        assertEquals("Nome deve ser João Silva", "João Silva", pessoa.getNome());
        assertEquals("Email deve ser joao@email.com", "joao@email.com", pessoa.getEmail());
    }
    
    @Test
    public void testSettersPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maria");
        pessoa.setEmail("maria@email.com");
        pessoa.setIdade(30);
        
        assertEquals("Nome deve ser Maria", "Maria", pessoa.getNome());
        assertEquals("Email deve ser maria@email.com", "maria@email.com", pessoa.getEmail());
        assertEquals("Idade deve ser 30", 30, pessoa.getIdade());
    }
}