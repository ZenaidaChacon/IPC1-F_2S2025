/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo_hilos;

/**
 *
 * @author zenai
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo_hilos extends JFrame {
    private JLabel labelHilo1;
    private JLabel labelHilo2;
    private JButton botonHilo1;
    private JButton botonHilo2;

    public Ejemplo_hilos() {
        setTitle("Ejemplo de Hilos con GUI");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Crear componentes
        labelHilo1 = new JLabel("Hilo 1: 0");
        labelHilo2 = new JLabel("Hilo 2: 0");

        botonHilo1 = new JButton("Iniciar Hilo 1");
        botonHilo2 = new JButton("Iniciar Hilo 2");

        // Agregar al frame
        add(labelHilo1);
        add(labelHilo2);
        add(botonHilo1);
        add(botonHilo2);

        // Acción botón Hilo 1
        botonHilo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread hilo1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= 10; i++) {
                            final int contador = i;
                            // Actualizar label en el hilo de Swing
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    labelHilo1.setText("Hilo 1: " + contador);
                                }
                            });
                            try {
                                Thread.sleep(500); // 0.5 segundos
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                hilo1.start();
            }
        });

        // Acción botón Hilo 2
        botonHilo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread hilo2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= 10; i++) {
                            final int contador = i;
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    labelHilo2.setText("Hilo 2: " + contador);
                                }
                            });
                            try {
                                Thread.sleep(700); // 0.7 segundos
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                hilo2.start();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ejemplo_hilos ventana = new Ejemplo_hilos();
                ventana.setVisible(true);
            }
        });
    }
}
