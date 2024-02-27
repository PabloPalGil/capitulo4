import java.util.Scanner;

/**
 * Clase principal para comprobar el funcionamiento de la clase Criba.
 */
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");

        int dato = teclado.nextInt();
        int[] vector = new int[dato];
        System.out.println("\nVector inicial hasta:" + dato);

        mostrarVectorInicial(vector);

        vector = Criba.generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);

        mostrarVectorPrimos(vector);
    }

    /**
     * Método que muestra por consola los números primos hasta el número introducido por teclado.
     * @param vector
     */
    public static void mostrarVectorPrimos(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }

    /**
     * Método que muestra un vector con todos los números consecutivos hasta el número introducido.
     * @param vector
     */
    public static void mostrarVectorInicial(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
    }
}