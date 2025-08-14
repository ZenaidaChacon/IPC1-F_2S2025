/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplocasteos;

/**
 *
 * @author zenai
 */
public class EjemploCasteos {

    /**
     * @param args the command line arguments
     */
    public static int a;
    public static int b;
    public static String hola;
    public static char letra;
    public static void main(String[] args) {
        // TODO code application logic here
        EjemploCasteos.a = 40;
        EjemploCasteos.b = 10;
        EjemploCasteos.hola= "12";
        EjemploCasteos.letra = 'a';
        //Casteos de numeros a cadenas
        System.out.println(Integer.toString(EjemploCasteos.a)+": Se unieron :"+EjemploCasteos.hola);
        //Casteo implicito para decimales
        double v = EjemploCasteos.a;
        Integer numero = 50;
        int entero = numero;
        System.out.println(numero.doubleValue());
        //Ejemplo de numero a char
        char n = (char)EjemploCasteos.a;
        System.out.println(n);
        //De char a entero
        System.out.println((int)EjemploCasteos.letra);
        //De string a numero
        System.out.println(Integer.parseInt(hola));
        
    }
    
}
