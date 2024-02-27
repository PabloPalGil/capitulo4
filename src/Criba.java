public class Criba
{
    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max)
    {
        int i,j;

        if (max >= 2) {
            // Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];

            inicializaVector(dim, esPrimo);

            cribarNoPrimos(dim, esPrimo);

            // ¿Cuántos primos hay?
            int cuenta = cuentaPrimos(dim, esPrimo);

            // Rellenar el vector de números primos
            return rellenarPrimos(cuenta, dim, esPrimo);
        } else { // max < 2
            // Vector vacío
            return new int[0];
        }
    }

    private static int[] rellenarPrimos(int cuenta, int dim, boolean[] esPrimo) {
        int j;
        int i;
        int[] primos = new int[cuenta];

        for (i=0, j=0; i< dim; i++) {
            if (esPrimo[i]){
                primos[j++] = i;
            }
        }

        return primos;
    }

    private static int cuentaPrimos(int dim, boolean[] esPrimo) {
        int i;
        int cuenta = 0;

        for (i=0; i< dim; i++) {
            if (esPrimo[i]){
                cuenta++;
            }
        }

        return cuenta;
    }

    private static void cribarNoPrimos(int dim, boolean[] esPrimo) {
        int i;
        int j;

        for (i=2; i<Math.sqrt(dim)+1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (j=2*i; j< dim; j+=i){
                    esPrimo[j] = false;
                }
            }
        }
    }

    public static void inicializaVector(int dim, boolean[] esPrimo) {
        int i;

        for (i=0; i< dim; i++){
            esPrimo[i] = true;
        }
        
        // Eliminar el 0 y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = false;
    }
}