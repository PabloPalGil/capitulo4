import java.util.Arrays;

/**
 * Clase Criba que identifica los números primos hasta el número que se le pasa como parámetro.
 */
public class Criba
{
    final static int PRIMER_PRIMO = 2;//El primer número primo siempre es el 2

    /**
     * Método que devuelve los números primos del 0 a max.
     * @param max valor entero hasta el que se identificarán los números primos, desde el 0
     * @return devuelve un vector de enteros con los números primos en orden desde 0 a max
     */
    public static int[] generarPrimos (int max)
    {
        if (max >= PRIMER_PRIMO) {
            //El tamaño del array es 1 más que el número introducido para incluir al 0
            boolean[] esPrimo = new boolean[max + 1];

            inicializaVector(esPrimo);

            cribarNoPrimos(esPrimo);

            // ¿Cuántos primos hay?
            int cuenta = cuentaPrimos(esPrimo);

            // Rellenar el vector de números primos
            return rellenarPrimos(cuenta, esPrimo);

        } else { // max < 2
            // Vector vacío
            return new int[0];
        }
    }

    /**
     * Método que inicializa un vector de tamaño max+1 a true.
     * @param esPrimo vector de valores booleanos de 0 a max que representa si son o no primos
     */
    public static void inicializaVector(boolean[] esPrimo) {
        //Inicializamos el vector con todos los elementos en true
        Arrays.fill(esPrimo, true);
    }

    /**
     * Método que pone en false a todos los números que no son primos de 0 a max
     * @param esPrimo vector de valores booleanos de 0 a max que representa si son o no primos
     */
    public static void cribarNoPrimos(boolean[] esPrimo) {

        // Eliminar el 0 y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = false;

        for (int i = PRIMER_PRIMO; i < Math.sqrt(esPrimo.length) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (int j = 2 * i; j < esPrimo.length; j += i){
                    esPrimo[j] = false;
                }
            }
        }
    }

    /**
     * Método que contabiliza los números primos (los que han quedado en true tras la criba).
     * @param esPrimo vector de valores booleanos de 0 a max que representa si son o no primos
     * @return devuelve un valor entero con la cantidad de elementos true que representa el total de primos
     */
    public static int cuentaPrimos(boolean[] esPrimo) {
        int cuenta = 0;

        for (boolean b : esPrimo) {
            if (b) {
                cuenta++;
            }
        }

        return cuenta;
    }

    /**
     * Método que crea y devuelve el vector final con sólo los números primos según las
     * posiciones correlativas de los elementos en true.
     * @param cuenta valor entero que indica la cantidad de números primos identificados
     * @param esPrimo vector de valores booleanos de 0 a max que representa si son o no primos
     * @return devuelve un vector de valores enteros que son los números primos de 0 al valor de entrada de la clase
     */
    public static int[] rellenarPrimos(int cuenta, boolean[] esPrimo) {
        int j;
        int i;
        int[] primos = new int[cuenta];

        for (i = 0, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]){
                primos[j++] = i;
            }
        }

        return primos;
    }

}