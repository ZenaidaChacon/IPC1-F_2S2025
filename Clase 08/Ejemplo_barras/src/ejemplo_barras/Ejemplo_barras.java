/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo_barras;

/**
 *
 * @author zenai
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo_barras extends JFrame {
    // Componentes de la GUI
    private JProgressBar progressBar1; // Barra de progreso 1
    private JProgressBar progressBar2; // Barra de progreso 2
    private JButton btnIniciar;         // Botón para iniciar las barras
    private JButton btnPausar;          // Botón para pausar/reanudar
    private JButton btnDetener;         // Botón para detener las barras

    // Hilos que controlan cada barra
    private Thread hilo1;
    private Thread hilo2;

    // Flags de control de los hilos
    private volatile boolean detener = false; // True para detener los hilos
    private volatile boolean pausar = false;  // True para pausar los hilos


    public Ejemplo_barras() {
        
        // Configuración básica de la ventana
        setTitle("Barras de Progreso Simultáneas");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10)); // 3 filas, 2 columnas, espacio de 10px


        // Crear barras de progreso y mostrar el porcentaje
        progressBar1 = new JProgressBar(0, 100);
        progressBar1.setStringPainted(true);

        progressBar2 = new JProgressBar(0, 100);
        progressBar2.setStringPainted(true);

        // Crear los botones
        btnIniciar = new JButton("Iniciar");
        btnPausar = new JButton("Pausar");
        btnDetener = new JButton("Detener");

        // Agregar los componentes a la ventana
        add(progressBar1);
        add(progressBar2);
        add(btnIniciar);
        add(btnPausar);
        add(btnDetener);

        // ------------------ BOTÓN INICIAR ------------------
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIniciar.setEnabled(false); // Desactivar botón mientras los hilos corren
                detener = false; // Resetear flag de detener
                pausar = false;  // Resetear flag de pausar

                // Crear hilo para barra 1 usando clase anónima Runnable
                hilo1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runProgressBar(progressBar1, 100, 100); // Ejecuta la barra con intervalo de 100ms
                    }
                });

                // Crear hilo para barra 2
                hilo2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runProgressBar(progressBar2, 100, 150); // Barra 2 con intervalo de 150ms
                    }
                });

                // Iniciar ambos hilos
                hilo1.start();
                hilo2.start();
            }
        });

        // ------------------ BOTÓN PAUSAR / REANUDAR ------------------
        btnPausar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!pausar) { // Si no está pausado, pausamos
                    pausar = true;
                    btnPausar.setText("Reanudar"); // Cambiar texto del botón
                } else { // Si ya estaba pausado, reanudamos
                    pausar = false;
                    btnPausar.setText("Pausar"); // Restaurar texto
                    synchronized (Ejemplo_barras.this) {
                        Ejemplo_barras.this.notifyAll(); // Despertar hilos pausados
                    }
                }
            }
        });

        // ------------------ BOTÓN DETENER ------------------
        btnDetener.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detener = true;    // Señalar a los hilos que deben detenerse
                pausar = false;    // Asegurar que no estén en pausa
                progressBar1.setValue(0); // Reiniciar barra 1
                progressBar2.setValue(0); // Reiniciar barra 2
                btnIniciar.setEnabled(true); // Reactivar botón de iniciar
                btnPausar.setText("Pausar"); // Restaurar texto del botón pausa
            }
        });
    }

    // ------------------ MÉTODO PARA EJECUTAR BARRA DE PROGRESO ------------------
    private void runProgressBar(JProgressBar progressBar, int max, int sleepTime) {
        for (int i = progressBar.getValue(); i <= max && !detener; i++) {

            // Manejar pausa
            synchronized (this) {
                while (pausar) { // Mientras esté pausado
                    try {
                        wait(); // Espera hasta que se reanude
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            final int valor = i; // Valor actual del progreso

            // Actualizar la barra de progreso en el hilo de Swing
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    progressBar.setValue(valor);
                }
            });

            try {
                Thread.sleep(sleepTime); // Pausa para simular ejecución
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        // Al finalizar, mostrar mensaje si no fue detenido
        if (!detener) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null,
                            progressBar == progressBar1 ? "¡Tarea 1 completada!" : "¡Tarea 2 completada!");
                }
            });
        }

        // Reactivar botón iniciar al terminar
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                btnIniciar.setEnabled(true);
            }
        });
    }

    // ------------------ MÉTODO MAIN ------------------
    public static void main(String[] args) {
        // Ejecutar la GUI en el hilo de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ejemplo_barras ventana = new Ejemplo_barras();
                ventana.setVisible(true);
            }
        });
    }
}
