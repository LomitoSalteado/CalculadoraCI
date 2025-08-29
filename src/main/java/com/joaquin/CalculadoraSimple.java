package com.joaquin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CalculadoraSimple extends JFrame {
    private final JTextField campo1 = new JTextField();
    private final JTextField campo2 = new JTextField();
    private final JTextField resultado = new JTextField();
    private char operacion = ' ';

    public CalculadoraSimple() {
        setTitle("Calculadora");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de botones
        JPanel botones = new JPanel(new GridLayout(1, 4, 10, 10));
        for (String op : new String[]{"+", "-", "*", "/"}) {
            JButton btn = new JButton(op);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(e -> operacion = op.charAt(0));
            botones.add(btn);
        }
        add(botones, BorderLayout.NORTH);

        // Panel de campos
        JPanel campos = new JPanel(new GridLayout(3, 2, 10, 10));
        campos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        campos.add(new JLabel("Número 1:")); campos.add(campo1);
        campos.add(new JLabel("Número 2:")); campos.add(campo2);
        campos.add(new JLabel("Resultado:")); resultado.setEditable(false); campos.add(resultado);
        add(campos, BorderLayout.CENTER);

        // Panel inferior con botón igual
        JButton igual = new JButton("=");
        igual.setFont(new Font("Arial", Font.BOLD, 18));
        igual.addActionListener(e -> calcular());

        JPanel panelInferior = new JPanel();
        panelInferior.add(igual);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void calcular() {
        try {
            int a = Integer.parseInt(campo1.getText().trim());
            int b = Integer.parseInt(campo2.getText().trim());

            int res = switch (operacion) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                case '/' -> {
                    if (b == 0) throw new ArithmeticException("División por cero");
                    yield a / b;
                }
                default -> throw new IllegalStateException("Selecciona una operación");
            };

            resultado.setText(String.valueOf(res));
        } catch (NumberFormatException | IllegalStateException | ArithmeticException ex) {
            resultado.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculadoraSimple::new);
    }
}
