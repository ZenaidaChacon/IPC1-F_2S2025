/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplointerfaz;

import view.Vista;
import controller.controlador;
/**
 *
 * @author zenai
 */
public class EjemploInterfaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                javax.swing.SwingUtilities.invokeLater(() -> {
            Vista v = new Vista();
            new controlador(v); // enlaza Vista y Controlador
            v.setVisible(true);
        });
        

    }
    
}
