/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.controlador to edit this template
 */
package controller;

/**
 *
 * @author zenai
 */

    

import model.Dispositivo;
import view.Vista;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador {

    private Dispositivo[] inventario = new Dispositivo[8];
    private int contador = 0;
    private Vista vista;

    public controlador(Vista vista) {
        this.vista = vista;
        iniciarEventos();
    }

    private void iniciarEventos() {
        
        vista.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarComputadora();
            }
        });
    }

    private void agregarComputadora() {
        if (contador >= inventario.length) {
            JOptionPane.showMessageDialog(vista, "Inventario lleno");
            return;
        }

        String marca = vista.getTxtMarca().getText().trim();
        
        String proc = vista.getTxtProcesador().getText().trim();
        String ramStr = vista.getTxtRam().getText().trim();

        if (marca.isEmpty() || proc.isEmpty() || ramStr.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Complete todos los campos");
            return;
        }

        try {
            int ram = Integer.parseInt(ramStr);
            inventario[contador] = new Dispositivo(marca, proc, ram);
            contador++;
            actualizarListado();
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "RAM debe ser un número entero");
        }
    }

    private void actualizarListado() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            sb.append(i + 1).append(". ").append(inventario[i].toString()).append("\n");
        }
        vista.getTxtListado().setText(sb.toString());
    }

    private void limpiarCampos() {
        vista.getTxtMarca().setText("");
        vista.getTxtProcesador().setText("");
        vista.getTxtRam().setText("");
    }
}
