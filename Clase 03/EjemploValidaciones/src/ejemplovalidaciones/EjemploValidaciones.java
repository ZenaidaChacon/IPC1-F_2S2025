/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplovalidaciones;

/**
 *
 * @author zenai
 */
import java.util.Scanner;
public class EjemploValidaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa un número entero: ");
        String entero = sc.nextLine();
        validarEntero(entero);

        System.out.print("Ingresa solo texto: ");
        String texto = sc.nextLine();
        validarTexto(texto);

        System.out.print("Ingresa un decimal: ");
        String decimal = sc.nextLine();
        validarDecimal(decimal);

        System.out.print("Ingresa un boolean (true/false): ");
        String bool = sc.nextLine();
        validarBoolean(bool);

        System.out.print("Ingresa un char: ");
        String c = sc.nextLine();
        validarChar(c);

        sc.close();
    }
    

    // 1. Validar número entero
    public static boolean validarEntero(String valor) {
        try {
            int num = Integer.parseInt(valor);
            System.out.println("Es un número entero válido: " + num);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("No es un número entero.");
            return false;
        }
    }

    // 2. Validar solo texto
    public static boolean validarTexto(String valor) {
        
        if (valor != null && valor.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) { //En este caso utilizo una expresion para que tambien me tome en cuenta los acentos
            System.out.println("Es texto valido: " + valor);
            return true;
        } else {
            System.out.println("No es texto valido.");
            return false;
        }
    }

    // 3. Validar decimal
    public static boolean validarDecimal(String valor) {
        try {
            double num = Double.parseDouble(valor);
            System.out.println("Es un decimal valido: " + num);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("No es un decimal valido.");
            return false;
        }
    }

    // 4. Validar boolean
    public static boolean validarBoolean(String valor) {
        if (valor.equalsIgnoreCase("true") || valor.equalsIgnoreCase("false")) {
            System.out.println("Es boolean valido: " + valor);
            return true;
        } else {
            System.out.println("No es boolean valido.");
            return false;
        }
    }

    // 5. Validar char
    public static boolean validarChar(String valor) {
        if (valor.length() == 1) {
            System.out.println("Es un char valido: " + valor);
            return true;
        } else {
            System.out.println("No es un char valido.");
            return false;
        }
    }

}
