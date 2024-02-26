import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class CribaTest {

    Criba criba = new Criba();
    int[] noPrimos = new int[0];
    int[] primos7 = {2, 3, 5, 7};
    int[] primos20 = {2, 3, 5, 7, 11, 13, 17, 19};

    @org.junit.jupiter.api.Test
    void generarPrimos() {
        assertEquals(Arrays.toString(criba.generarPrimos(1)), Arrays.toString(noPrimos));
        assertEquals(Arrays.toString(criba.generarPrimos(7)), Arrays.toString(primos7));
        assertEquals(Arrays.toString(criba.generarPrimos(20)), Arrays.toString(primos20));
        assertNotEquals(Arrays.toString(criba.generarPrimos(23)), Arrays.toString(primos20));
    }
}