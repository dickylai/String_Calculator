package com.calculator;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.*;

public class ControllerTest {

	private Calculator calculator;
	private View view;
	private Validator validator;
	private Controller controller;
	
	@Before
	public void setUp() {
		view = mock(View.class);
		calculator = mock(Calculator.class);
		validator = mock(Validator.class);
		controller = new Controller(view, calculator, validator);
	}
	
	@Test
	public void controller_should_get_equation_from_the_view() {
		controller.execute();
		
		verify(view).getInput();
	}
	
	@Test
	public void controller_should_get_equation_from_view_and_send_to_be_validated() throws CalculatorException {
		when(view.getInput()).thenReturn("4+3");
		
		controller.execute();
		
		verify(validator).validate("4+3");
	}
	
	@Test
	public void controller_should_pass_equation_to_calculator_when_equation_is_valid() throws CalculatorException {
		when(view.getInput()).thenReturn("4+3");
		
		controller.execute();
		
		verify(calculator).calculate("4+3");
	}
	
	@Test
	public void controller_should_pass_answer_of_the_evaluated_equation_to_view_when_equation_is_valid() throws CalculatorException {
		when(view.getInput()).thenReturn("4+3");
		when(calculator.calculate("4+3")).thenReturn(new Double(7));
		
		controller.execute();
		
		verify(view).displayAnswer(new Double(7));
	}
	
	@Test
	public void controller_should_pass_InvalidCharacterException_to_view_when_equation_is_not_valid() throws CalculatorException {
		when(view.getInput()).thenReturn("a4+3");
		InvalidCharacterException e = new InvalidCharacterException();
		doThrow(e).when(validator).validate("a4+3");
		
		controller.execute();
		
		verify(view).displayException(e);
	}
	
}