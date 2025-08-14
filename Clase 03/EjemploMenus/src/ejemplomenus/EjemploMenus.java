/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplomenus;

/**
 *
 * @author zenai
 */
import java.util.Scanner;
public class EjemploMenus {

    /**
     * @param args the command line arguments
     */
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        // TODO code application logic here
        //Para probar cualquiera de los dos menus quita los primeros // y al otro colocale al inicio //
        //mostrarMenuSwitch(); // Iniciar el menú recursivo optimizado con un Switch
        mostrarMenuWhile();
        scanner.close(); // Cerrar el scanner al final
    }
     public static void mostrarMenuSwitch() {
        System.out.println("\n===== MENU PRINCIPAL SWITCH =====");
        System.out.println("1. Saludar");
        System.out.println("2. Mostrar fecha actual");
        System.out.println("3. Calcular suma");
        System.out.println("4. Mostrar un mensaje motivador");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: ");

        int opcion;

        // Validar que el usuario ingrese un número
        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt();
        } else {
            System.out.println(" Entrada invalida. Ingrese un numero.");
            scanner.nextLine(); // Limpiar buffer
            mostrarMenuSwitch();
            return;
        }

        switch (opcion) {
            case 1:
                System.out.println("Hola! Espero que tengas un gran dia.");
                mostrarMenuSwitch();
                break;

            case 2:
                System.out.println(" La fecha actual es: " + java.time.LocalDate.now());
                mostrarMenuSwitch();
                break;

            case 3:
                System.out.print("Ingrese el primer numero: ");
                int a = scanner.nextInt();
                System.out.print("Ingrese el segundo numero: ");
                int b = scanner.nextInt();
                System.out.println("La suma es: " + (a + b));
                mostrarMenuSwitch();
                break;

            case 4:
                System.out.println("Nunca dejes de aprender!");
                mostrarMenuSwitch();
                break;

            case 5:
                System.out.println("Saliendo... Hasta luego!");
                break;

            default:
                System.out.println(" Opción invalida, intente de nuevo.");
                mostrarMenuSwitch();
        }
    }
     
     public static void mostrarMenuWhile(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n===== MENU PRINCIPAL WHILE =====");
            System.out.println("1. Saludar");
            System.out.println("2. Mostrar fecha actual");
            System.out.println("3. Calcular suma");
            System.out.println("4. Mostrar un mensaje motivador");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            // Validar que el usuario ingrese un número
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                System.out.println("Entrada invalida. Ingrese un numero.");
                scanner.nextLine(); // Limpiar buffer
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Hola! Espero que tengas un gran dia.");
                    break;

                case 2:
                    System.out.println("La fecha actual es: " + java.time.LocalDate.now());
                    break;

                case 3:
                    System.out.print("Ingrese el primer numero: ");
                    int a = scanner.nextInt();
                    System.out.print("Ingrese el segundo numero: ");
                    int b = scanner.nextInt();
                    System.out.println("La suma es: " + (a + b));
                    break;

                case 4:
                    System.out.println("Nunca dejes de aprender!");
                    break;

                case 5:
                    System.out.println("Saliendo... Hasta luego!");
                    break;

                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        }

        scanner.close();
    
     }
}

