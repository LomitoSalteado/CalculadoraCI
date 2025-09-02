package com.joaquin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class OperacionesTest {

    @Test
    void testSumar() {
        assertEquals(7, Operaciones.sumar(3, 4), "La suma de 3 + 4 debe ser 7");
    }

    @Test
    void testRestar() {
        assertEquals(2, Operaciones.restar(5, 3), "La resta de 5 - 3 debe ser 2");
    }

    @Test
    void testMultiplicar() {
        assertEquals(15, Operaciones.multiplicar(3, 5), "La multiplicación de 3 * 5 debe ser 15");
    }

    @Test
    void testDividir() {
        assertEquals(4, Operaciones.dividir(8, 2), "La división de 8 / 2 debe ser 4");
    }

    @Test
    void testDivisionPorCero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Operaciones.dividir(10, 0);
        });
        assertEquals("Error: No se puede dividir por cero.", exception.getMessage());
    }
}
