import java.util.Arrays;

public class Criba
{
    final static int PRIMER_PRIMO = 2;//El primer número primo es el 2

    // Generar números primos de 1 a max
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

    private static void inicializaVector(boolean[] esPrimo) {
        //Inicializamos el vector con todos los elementos en true
        Arrays.fill(esPrimo, true);

        // Eliminar el 0 y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = false;
    }

    private static void cribarNoPrimos(boolean[] esPrimo) {

        for (int i = PRIMER_PRIMO; i < Math.sqrt(esPrimo.length) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (int j = 2 * i; j < esPrimo.length; j += i){
                    esPrimo[j] = false;
                }
            }
        }
    }

    private static int cuentaPrimos(boolean[] esPrimo) {
        int cuenta = 0;

        for (boolean b : esPrimo) {
            if (b) {
                cuenta++;
            }
        }

        return cuenta;
    }

    private static int[] rellenarPrimos(int cuenta, boolean[] esPrimo) {
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