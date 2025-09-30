package main.test.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class TesteBasico {
    
    @Test
    public void testeMuitoSimples() {
        System.out.println("Executando teste básico...");
        assertTrue("2+2 deve ser 4", 2 + 2 == 4);
        assertEquals("Strings devem ser iguais", "teste", "teste");
    }
    
    @Test
    public void testeValidacaoEmailSimples() {
        assertTrue(ValidacaoUtil.validarEmail("teste@email.com"));
        assertFalse(ValidacaoUtil.validarEmail("email-invalido"));
    }
}