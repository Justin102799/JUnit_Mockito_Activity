import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.reset;

@RunWith(MockitoJUnitRunner.class)
public class AdvancedMathTesterBDD {

    @InjectMocks
    AdvanceMath advanceMath = new AdvanceMath();

    @Mock
    BasicMath basicMath;

    @Test
    public void testMultiplyDifferenceBy5() {
        //Given
        given(basicMath.subtract(80.0, 20.0)).willReturn(60.0);
        //When
        double result = advanceMath.multiplyDifferenceBy5(80.0,20.0);
        //Then
        Assert.assertEquals(result, 300.0, 0);
    }

    @Test
    public void testMultiplySumBy5() {
        //Given
        given(basicMath.add(75.0,25.0)).willReturn(100.0);
        //When
        double result = advanceMath.multiplySumBy5(75.0,25.0);
        //Then
        Assert.assertEquals(result, 500.0, 0);


    }

    @Test
    public void testSquareOfSum() {
        //Given
        given(basicMath.add(20.0,20.0)).willReturn(40.0);
        //When
        advanceMath.squareOfSum(20.0,20.0);
        //Then
        verify(basicMath).add(20.0, 20.0);
        verify(basicMath, atLeastOnce()).add(20.0, 20.0);
        verify(basicMath, atMost(2)).add(20.0, 20.0);

    }
    @Test
    public void testGetPercentage() {
        //Given
        given(basicMath.add(50.0,100.0)).willReturn(0.5);
        //When
        double result = advanceMath.getPercentage(50.0, 100.0);
        //Then
        reset(basicMath);
        Assert.assertEquals(result, 0.00, 0);
    }
}
