import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AdvancedMathTester {
    @InjectMocks
    AdvanceMath advanceMath = new AdvanceMath();

    @Mock
    BasicMath basicMath;

    @Test
    public void testMultiplyDifferenceBy5() {
        when(basicMath.subtract(80.0, 20.0)).thenReturn(60.0);

        Assert.assertEquals(advanceMath.multiplyDifferenceBy5(80.0, 20.0), 300, 0);
    }

    @Test
    public void testMultiplySumBy5() {
        when(basicMath.add(75.0, 25.0)).thenReturn(100.0);
        when(basicMath.multiply(100.0, 5.0)).thenReturn(500.0);


        Assert.assertEquals(advanceMath.multiplySumBy5(75.0, 25.0), 500.0, 0);
    }

    @Test
    public void testSquareOfSum() {
        when(basicMath.add(20.0, 20.0)).thenReturn(40.0);

        Assert.assertEquals(advanceMath.squareOfSum(20.0, 20.0), 1600.0, 0);
//        verify(basicMath).add(20.0, 20.0);
        verify(basicMath, atLeast(2)).add(20.0, 20.0);
        verify(basicMath, times(2)).add(20.0, 20.0);

    }

    @Test
    public void testGetPercentage() {
        when(basicMath.divide(50.0, 100.0)).thenReturn(0.5);

        advanceMath.getPercentage(50.0, 100.0);

        reset(basicMath);
        Assert.assertEquals(advanceMath.getPercentage(50.0, 100.0), 00.0, 0);
    }

    @Test
    public void testMultiplyDifferenceBy5Bdd() {
        //Given
        given(basicMath.subtract(80.0, 20.0)).willReturn(60.0);
        //When
        double result = advanceMath.multiplyDifferenceBy5(80.0,20.0);
        //Then
        Assert.assertEquals(result, 300.0, 0);
    }

    @Test
    public void testMultiplySumBy5Bdd() {
        //Given
        given(basicMath.add(75.0,25.0)).willReturn(100.0);
        given(basicMath.multiply(100.0, 5.0)).willReturn(500.0);
        //When
        double result = advanceMath.multiplySumBy5(75.0,25.0);
        //Then
        Assert.assertEquals(result, 500.0, 0);


    }

    @Test
    public void testSquareOfSumBdd() {
        //Given
        given(basicMath.add(20.0,20.0)).willReturn(40.0);
        //When
        advanceMath.squareOfSum(20.0,20.0);
        //Then
//        verify(basicMath).add(20.0, 20.0);
        verify(basicMath, atLeast(2)).add(20.0, 20.0);
        verify(basicMath, times(2)).add(20.0, 20.0);

    }
    @Test
    public void testGetPercentageBdd() {
        //Given
        given(basicMath.add(50.0,100.0)).willReturn(0.5);
        //When
        double result = advanceMath.getPercentage(50.0, 100.0);
        //Then
        reset(basicMath);
        Assert.assertEquals(result, 0.00, 0);
    }



}
