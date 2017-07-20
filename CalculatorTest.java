package com.calculator;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.*;

public class CalculatorTest {

	private Calculator calculator;
	
	@Before
	public void setUp() {
		calculator = new Calculator();
	}

	@Test
	public void when_calculating_empty_string_should_return_0() {
		// method you are testing
		Double result = calculator.calculate("");

		// result you expect
		assertEquals(new Double(0), result);
	}

	@Test
	public void when_calculating_string_1_should_return_1() {
		// method you are testing
		Double result = calculator.calculate("1");

		// result you expect
		assertEquals(new Double(1), result);
	}

	@Test
	public void when_calculating_2_minus_1_should_return_1() {
		// method you are testing
		Double result = calculator.calculate("2-1");

		// result you expect
		assertEquals(new Double(1), result);
	}

	@Test
	public void when_calculating_2_plus_1_should_return_3() {
		// method you are testing
		Double result = calculator.calculate("2+1");

		// result you expect
		assertEquals(new Double(3), result);
	}

	@Test
	public void when_calculating_2_times_3_should_return_6() {
		// method you are testing
		Double result = calculator.calculate("2*3");

		// result you expect
		assertEquals(new Double(6), result);
	}

	@Test
	public void when_calculating_3_divides_3_should_return_1() {
		// method you are testing
		Double result = calculator.calculate("3/3");

		// result you expect
		assertEquals(new Double(1), result);
	}

	@Test
	public void when_calculating_1_plus_2_plus_3_should_return_6() {
		// method you are testing
		Double result = calculator.calculate("1+2+3");

		// result you expect
		assertEquals(new Double(6), result);
	}
	
	@Test
	public void when_calculating_1_minus_2_minus_3_should_return_minus_4() {
		// method you are testing
		Double result = calculator.calculate("1-2-3");

		// result you expect
		assertEquals(new Double(-4), result);
	}
	
	@Test
	public void when_calculating_1_plus_2_minus_3_should_return_0() {
		// method you are testing
		Double result = calculator.calculate("1+2-3");

		// result you expect
		assertEquals(new Double(0), result);
	}
	
	@Test
	public void when_calculating_1_minus_2_plus_3_should_return_2() {
		// method you are testing
		Double result = calculator.calculate("1-2+3");

		// result you expect
		assertEquals(new Double(2), result);
	}

	@Test
	public void when_calculating_2_plus_5_minus_3_plus_4_minus_1_should_return_7() {
		// method you are testing
		Double result = calculator.calculate("2+5-3+4-1");

		// result you expect
		assertEquals(new Double(7), result);
	}
	
	@Test
	public void when_calculating_2_plus_5_minus_3_minus_4_plus_1_should_return_1() {
		// method you are testing
		Double result = calculator.calculate("2+5-3-4+1");

		// result you expect
		assertEquals(new Double(1), result);
	}
	
	@Test
	public void when_calculating_2_plus_3_times_4_should_return_14() {
		// method you are testing
		Double result = calculator.calculate("2+3*4");

		// result you expect
		assertEquals(new Double(14), result);
	}
	
	@Test
	public void when_calculating_2_times_3_plus_4_should_return_10() {
		// method you are testing
		Double result = calculator.calculate("2*3+4");

		// result you expect
		assertEquals(new Double(10), result);
	}
	
	@Test
	public void when_calculating_2_minus_3_times_4_should_return_minus_10() {
		// method you are testing
		Double result = calculator.calculate("2-3*4");

		// result you expect
		assertEquals(new Double(-10), result);
	}
	
	@Test
	public void when_calculating_2_times_3_minus_4_should_return_2() {
		// method you are testing
		Double result = calculator.calculate("2*3-4");

		// result you expect
		assertEquals(new Double(2), result);
	}
	
	@Test
	public void when_calculating_minus_4_should_return_minus_4() {
		// method you are testing
		Double result = calculator.calculate("-4");

		// result you expect
		assertEquals(new Double(-4), result);
	}
	
	@Test
	public void when_calculating_2_times_3_times_4_should_return_minus_24() {
		// method you are testing
		Double result = calculator.calculate("2*3*4");

		// result you expect
		assertEquals(new Double(24), result);
	}
	
	@Test
	public void when_calculating_4_divide_2_divide_2_should_return_minus_1() {
		// method you are testing
		Double result = calculator.calculate("4/2/2");

		// result you expect
		assertEquals(new Double(1), result);
	}
	
	@Test
	public void when_calculating_4_divide_2_times_2_should_return_4() {
		// method you are testing
		Double result = calculator.calculate("4/2*2");

		// result you expect
		assertEquals(new Double(4), result);
	}
	
	@Test
	public void when_calculating_8_divide_4_times_2_divide_4_should_return_1() {
		// method you are testing
		Double result = calculator.calculate("8/4*2/4");

		// result you expect
		assertEquals(new Double(1), result);
	}
	
	@Test
	public void when_calculating_1_plus_minus_3_should_return_minus_2() {
		// method you are testing
		Double result = calculator.calculate("1+-3");

		// result you expect
		assertEquals(new Double(-2), result);
	}
	
	@Test
	public void when_calculating_1_minus_plus_3_should_return_minus_2() {
		// method you are testing
		Double result = calculator.calculate("1-+3");

		// result you expect
		assertEquals(new Double(-2), result);
	}
	
	@Test
	public void when_calculating_1_minus_minus_3_should_return_4() {
		// method you are testing
		Double result = calculator.calculate("1--3");

		// result you expect
		assertEquals(new Double(4), result);
	}
	
	@Test
	public void when_calculating_1_plus_plus_3_should_return_4() {
		// method you are testing
		Double result = calculator.calculate("1++3");

		// result you expect
		assertEquals(new Double(4), result);
	}
	
	@Test
	public void when_calculating_1_times_minus_3_should_return_minus_3() {
		// method you are testing
		Double result = calculator.calculate("1*-3");

		// result you expect
		assertEquals(new Double(-3), result);
	}

	@Test
	public void when_calculating_1_plus_3_times_minus_6_minus_4_divide_2_should_return_minus_19() {
		// method you are testing
		Double result = calculator.calculate("1+3*-6-4/2");

		// result you expect
		assertEquals(new Double(-19), result);
	}
	
	@Test
	public void when_calculating_minus_2_times_3_333_should_return_minus_6_666() {
		// method you are testing
		Double result = calculator.calculate("-2*+3.333");

		// result you expect
		assertEquals(new Double(-6.666), result);
	}

	@Test
	public void when_calculating_complicated() {
		// method you are testing
		Double result = calculator.calculate("-2*+3.333/0.5+2.1+2.1-2.1-24.0/+3.0*-2.0-0");

		// result you expect
		assertEquals(new Double(4.768), result, 0.001);
	}

	@Test
	public void when_calculating_2_to_the_power_3_should_return_8() {
		// method you are testing
		Double result = calculator.calculate("2^3");

		// result you expect
		assertEquals(new Double(8), result);
	}
	
	@Test
	public void when_calculating_2_to_the_power_minus_2_should_return_0_25() {
		// method you are testing
		Double result = calculator.calculate("2^-2");

		// result you expect
		assertEquals(new Double(0.25), result);
	}
	
	@Test
	public void when_calculating_2_to_the_power_2_to_the_power_2_should_return_16() {
		// method you are testing
		Double result = calculator.calculate("2^2^2");

		// result you expect
		assertEquals(new Double(16), result);
	}
	
	@Test
	public void when_calculating_0_to_the_power_2_should_return_0() {
		// method you are testing
		Double result = calculator.calculate("0^2");

		// result you expect
		assertEquals(new Double(0), result);
	}
	
	@Test
	public void when_calculating_2_to_the_power_0_should_return_1() {
		// method you are testing
		Double result = calculator.calculate("2^0");

		// result you expect
		assertEquals(new Double(1), result);
	}
	
	@Test
	public void when_calculating_0_to_the_power_0_should_return_1() {
		// method you are testing
		Double result = calculator.calculate("0^0");

		// result you expect
		assertEquals(new Double(1), result);
	}
	
	
	@Test
	public void when_calculating_1_5_to_the_power_minus_2_to_the_power_3_should_return_0_039() {
		// method you are testing
		Double result = calculator.calculate("1.5^-2^3");

		// result you expect
		assertEquals(new Double(0.039), result, 0.001);
	}
	
	@Test
	public void when_calculating_complicated_with_power() {
		// method you are testing
		Double result = calculator.calculate("-2*+3.333/0.5+2.1+2.1-2.1-24.0/+3.0*-2.0^2*2-0");

		// result you expect
		assertEquals(new Double(-75.232), result, 0.001);
	}

	@Test
	public void when_calculating_bracket_2_plus_3_times_5_should_return_25() {
		// method you are testing
		Double result = calculator.calculate("(2+3)*5");

		// result you expect
		assertEquals(new Double(25), result);
	}
	
	@Test
	public void when_calculating_bracket() {
		// method you are testing
		Double result = calculator.calculate("(((2+5)*6)+2)+3");

		// result you expect
		assertEquals(new Double(47), result);
	}
	
	@Test
	public void when_calculating_bracket_2() {
		// method you are testing
		Double result = calculator.calculate("2^(2*4-5)/(-9+5)*2");

		// result you expect
		assertEquals(new Double(-4), result);
	}
}
