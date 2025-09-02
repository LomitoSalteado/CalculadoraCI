package com.joaquin;

public class Operaciones {

    private Operaciones() {}

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int restar(int a, int b) {
        return a - b;
    }

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: No se puede dividir por cero.");
        }
        return a / b;
    }
}
