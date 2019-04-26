package xpworks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;

public class SampleTest {
    @Test
    public void name() {
        Sample sample = mock(Sample.class);

        given(sample.hello()).willReturn("");

        assertEquals("",sample.hello());

        verify(sample, times(1)).hello();
    }
}
