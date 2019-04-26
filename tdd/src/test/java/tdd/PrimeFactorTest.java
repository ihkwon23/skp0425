package tdd;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PrimeFactorTest {

    @Test
    public void primeFactorsOf2() {
        assertEquals(Arrays.asList(2), PrimeFactor.of(2));
    }

    @Test
    public void primeFactorsOf3() {
        assertEquals(Arrays.asList(3), PrimeFactor.of(3));
    }

    @Test
    public void primeFactorsOf4() {
        assertEquals(Arrays.asList(2,2), PrimeFactor.of(4));
    }

    @Test
    public void primeFactorsOf6() {
        assertEquals(Arrays.asList(2,3), PrimeFactor.of(6));
    }

    @Test
    public void primeFactorsOf30() {
        assertEquals(Arrays.asList(2,3,5), PrimeFactor.of(30));
    }

    @Test
    public void primeFactorsOfBigInt() {
        assertEquals(Arrays.asList(2,2,2,3,3,5,7,11), PrimeFactor.of(2*2*2*3*3*5*7*11));
    }
}
