package main.test.service;

import org.junit.Test;
import static org.junit.Assert.*;
import main.java.data.Forum;

public class ForumServiceTest {
    
    @Test
    public void testCriacaoForum() {
        Forum forum = new Forum("Novo Fórum");
        
        assertNotNull("Forum não deve ser nulo", forum);
        assertEquals("Tópico deve ser 'Novo Fórum'", "Novo Fórum", forum.getTopico());
        assertNotNull("Lista de posts não deve ser nula", forum.getPosts());
        assertTrue("Lista de posts deve estar vazia inicialmente", forum.getPosts().isEmpty());
    }
    
    @Test
    public void testSettersForum() {
        Forum forum = new Forum("Teste");
        forum.setId(1);
        
        assertEquals("ID deve ser 1", 1, forum.getId());
    }
}