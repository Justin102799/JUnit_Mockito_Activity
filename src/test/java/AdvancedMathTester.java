import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AdvancedMathTester {
    @InjectMocks
    AdvanceMath advanceMath = new AdvanceMath();

    @Mock
    BasicMath basicMath;

    @Test
    public void testMultiplyDifferenceBy5() {
        when(basicMath.subtract(80.0, 20.0)).thenReturn(60.0);

        Assert.assertEquals(advanceMath.multiplyDifferenceBy5(80.0, 20.0), 300.0, 0);
    }

    @Test
    public void testMultiplySumBy5() {
        when(basicMath.add(75.0, 25.0)).thenReturn(100.0);

        Assert.assertEquals(advanceMath.multiplySumBy5(75.0, 25.0), 500.0, 0);
    }

    @Test
    public void testSquareOfSum() {
        when(basicMath.add(20.0, 20.0)).thenReturn(40.0);

        Assert.assertEquals(advanceMath.squareOfSum(20.0, 20.0), 1600.0, 0);
        verify(basicMath).add(20.0, 20.0);
        verify(basicMath, atLeastOnce()).add(20.0, 20.0);
        verify(basicMath, atMost(2)).add(20.0, 20.0);

    }

    @Test
    public void testGetPercentage() {
        when(basicMath.divide(50.0, 100.0)).thenReturn(0.5);

        advanceMath.getPercentage(50.0, 100.0);

        reset(basicMath);
        Assert.assertEquals(advanceMath.getPercentage(50.0, 100.0), 00.0, 0);
    }



}
