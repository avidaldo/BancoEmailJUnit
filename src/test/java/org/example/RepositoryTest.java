package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Repository repository;

    @BeforeEach
    void setUp() {
        repository = new Repository();
    }


    @Test
    void test1() {
        assertNull(repository.findByEmail("pepe@pepe.com"));
        assertTrue(repository.add(new Cuenta("pepe@pepe.com", 500)));
        assertEquals(repository.findByEmail("pepe@pepe.com").getSaldo(), 500);
        assertFalse(repository.add(new Cuenta("pepe@pepe.com", 400)));
    }


}