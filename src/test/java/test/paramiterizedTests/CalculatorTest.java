package test.paramiterizedTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import test.Calculator;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    // CSV -> Comma separated value
    @ParameterizedTest
    @CsvFileSource(resources = "data-addition.csv")
    void whenAddTwoIntegersThenReturnsSumOfThem(int a, int b, int expected) {
        //given + when
        int result = Calculator.addTwoIntegers(a, b);
        //then
        assertThat(result).isEqualTo(expected);
    }
}
