import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class CribaTest {
    int[] noPrimos = new int[0];
    int[] primos7 = {2, 3, 5, 7};
    int[] primos20 = {2, 3, 5, 7, 11, 13, 17, 19};

    @org.junit.jupiter.api.Test
    void generarPrimos() {
        assertEquals(Arrays.toString(Criba.generarPrimos(1)), Arrays.toString(noPrimos));
        assertEquals(Arrays.toString(Criba.generarPrimos(7)), Arrays.toString(primos7));
        assertEquals(Arrays.toString(Criba.generarPrimos(20)), Arrays.toString(primos20));
        assertNotEquals(Arrays.toString(Criba.generarPrimos(23)), Arrays.toString(primos20));
    }
}