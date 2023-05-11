package test;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    void whenAddTwoDoublesThenReturnsSumOfThem() {
        //given + when
        double result = Calculator.addTwoDoubles(2, 3);
        //then

        //Assertions.assertEquals(5, result);   <-- wykorzystanie junit.jupiter.api.Assertions
        assertThat(result).isEqualTo(5);
    }

    @Test
    void whenAddTwoIntegersThenReturnsSumOfThem() {
        //given + when
        int result = Calculator.addTwoIntegers(2, 3);
        //then
        assertThat(result).isNotEqualTo(1);
    }

    @Test
    void whenAnyComponentIsBiggerThan100ThenIllegalArgumentExceptionIsThrown() {
        //given + when + then
        assertThrows(IllegalArgumentException.class,
                () -> Calculator.addTwoIntegers(101,3));
        assertThrows(IllegalArgumentException.class,
                () -> Calculator.addTwoIntegers(3,101));
    }

    @Test
    void whenSubtractTwoIntegersThenReturnSubOfThem(){
        //given + when
        int result = Calculator.subtractTwoIntegers(100,55);
        //then
        assertThat(result).isEqualTo(45);
    }

    @Test
    void whenComponentBIsBiggerThanComponentAThenIllegalArgumentExceptionIsThrown() {
        //given + when + then
        assertThrows(IllegalArgumentException.class,
                () -> Calculator.subtractTwoIntegers(101,1500));

    }
}
