package com.joaquin.steps;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.joaquin.Operaciones;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OperacionesSteps {

    private double resultado;
    private String mensajeError;

    @Given("a calculator")
    public void aCalculator() {
        // No se requiere inicialización
    }

    @When("the user enters {int} and {int} and presses {string}")
    public void the_user_enters_and_and_presses(int a, int b, String operador) {
        try {
            if (!operador.equals("/")) {
                throw new IllegalArgumentException("Solo se permite división.");
            }
            resultado = Operaciones.dividir((double) a, (double) b);
            mensajeError = null;
        } catch (ArithmeticException e) {
            mensajeError = e.getMessage();
        }
    }

    @Then("the displayed result is {string}")
    public void theDisplayedResultIs(String esperado) {
        if (mensajeError != null) {
            assertEquals(esperado, mensajeError);
        } else {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
            DecimalFormat df = new DecimalFormat("0.00", symbols);
            String formateado = df.format(resultado);
            assertEquals(esperado, formateado);
        }
    }
}
