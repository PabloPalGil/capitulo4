import java.util.Scanner;

/**
 * Clase principal para comprobar el funcionamiento de la clase Criba.
 * @author Pablo Palanques Gil - Ejercicios T4 - EEDD
 */
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);//Declaramos el atributo Scanner

        //Pedimos el número hasta el que calcularemos los números primos
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();

        //Creamos un vector inicial con los números consecutivos hasta el introducido
        int[] vector = new int[dato];
        System.out.println("\nVector inicial hasta:" + dato);

        mostrarVectorInicial(vector);

        vector = Criba.generarPrimos(dato);//Llamamos a la clase Criba para sacar los números primos
        System.out.println("\nVector de primos hasta:" + dato);

        mostrarVectorPrimos(vector);//Mostramos los números primos obtenidos.
    }

    /**
     * Método que muestra por consola los números primos hasta el número introducido por teclado.
     * @param vector vector de valores enteros con los números primos en orden desde 0 al valor introducido
     *               previamente por teclado.
     */
    public static void mostrarVectorPrimos(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }

    /**
     * Método que muestra un vector con todos los números consecutivos hasta el número introducido.
     * @param vector vector de valores enteros desde el 0 al número introducido previamente por teclado
     */
    public static void mostrarVectorInicial(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
    }
}