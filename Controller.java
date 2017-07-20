package com.calculator;

public class Controller {

	private final Calculator calculator;
	private final View view;
	private final Validator validator;
	
	public Controller(View view, Calculator calculator, Validator validator) {
		this.calculator = calculator;
		this.view = view;
		this.validator = validator;
	}
	
	public void execute() {
		String input = view.getInput();
		try {
			validator.validate(input);
			view.displayAnswer(calculator.calculate(input));
		} catch (InvalidCharacterException e) {
			view.displayException(e);
		} catch (CalculatorException e) {
			view.displayException(e);
		}
	}
}