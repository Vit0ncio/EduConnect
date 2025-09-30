package main.test.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidacaoUtilTest {
    
    @Test
    public void testValidarEmail() {
        assertTrue("Email válido deve retornar true", 
            ValidacaoUtil.validarEmail("usuario@email.com"));
        assertFalse("Email inválido deve retornar false", 
            ValidacaoUtil.validarEmail("usuario"));
    }
    
    @Test
    public void testValidarSenha() {
        assertTrue("Senha válida deve retornar true", 
            ValidacaoUtil.validarSenha("senha123"));
        assertFalse("Senha curta deve retornar false", 
            ValidacaoUtil.validarSenha("12345"));
    }
    
    @Test
    public void testValidarNome() {
        assertTrue("Nome válido deve retornar true", 
            ValidacaoUtil.validarNome("João"));
        assertFalse("Nome vazio deve retornar false", 
            ValidacaoUtil.validarNome(""));
    }
    
    @Test
    public void testCalcularMedia() {
        assertEquals("Média de 8 e 7 deve ser 7.5", 
            7.5, ValidacaoUtil.calcularMedia(8.0, 7.0), 0.001);
        assertEquals("Média sem notas deve ser 0", 
            0.0, ValidacaoUtil.calcularMedia(), 0.001);
    }
}