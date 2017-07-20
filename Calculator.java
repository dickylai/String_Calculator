package com.calculator;

public class Calculator {
		
	public Double calculate(String evaluate) {
		evaluate = normalize(evaluate);
		if (evaluate.isEmpty()) return 0d;
		int indexOfSign;
		if ((indexOfSign = indexOfEndBracket(evaluate)) != -1) {
			String newEvaluateString = evaluate.replace(evaluate.substring(evaluate.indexOf("("), indexOfSign),"()").replace("()",calculate(evaluate.substring(evaluate.indexOf("(")+1, indexOfSign-1)).toString());
			return calculate(newEvaluateString);
		}		
		if ((indexOfSign = evaluate.lastIndexOf("+")) != -1) {
			return calculate(evaluate.substring(0,indexOfSign)) + calculate(evaluate.substring(indexOfSign+1));
		} else if ((indexOfSign = lastIndexOfMinusOperation(evaluate)) != -1) {
			return calculate(evaluate.substring(0,indexOfSign)) - calculate(evaluate.substring(indexOfSign+1));
		} else if ((indexOfSign = evaluate.lastIndexOf("*")) != -1) {
			return calculate(evaluate.substring(0,indexOfSign)) * calculate(evaluate.substring(indexOfSign+1));
		} else if ((indexOfSign = evaluate.lastIndexOf("/")) != -1) {
			return calculate(evaluate.substring(0,indexOfSign)) / calculate(evaluate.substring(indexOfSign+1));
		} else if ((indexOfSign = evaluate.indexOf("^")) != -1) {
			return power(evaluate.substring(0,indexOfSign), evaluate.substring(indexOfSign+1));
		}

		try {
			return Double.parseDouble(evaluate);
		} catch (NumberFormatException e) {
			throw e;
		}
	}
	
	private int indexOfEndBracket(String s) {
		return findEndBracket(s, 0, 0);
	}
	
	private int findEndBracket(String s, int count, int cutLength) {
		int indexOfOpenBracket = s.indexOf("(");
		int indexOfEndBracket = s.indexOf(")");
		if (indexOfOpenBracket < indexOfEndBracket && indexOfOpenBracket != -1) {
			return findEndBracket(s.substring(indexOfOpenBracket+1), ++count, cutLength+s.substring(0,indexOfOpenBracket).length()+1);
		} else if (indexOfOpenBracket == indexOfEndBracket) {
			return -1;
		} else {
			if (count == 1) return cutLength+indexOfEndBracket+1;
			else {
				return findEndBracket(s.substring(indexOfEndBracket+1), --count, cutLength+s.substring(0,indexOfEndBracket).length()+1);
			}
		}
	}
	
	private int lastIndexOfMinusOperation(String s) {
		if (s.lastIndexOf("-") <= 0) return -1;
		if (s.charAt(s.lastIndexOf("-") - 1) == '*' || s.charAt(s.lastIndexOf("-") - 1) == '/' || s.charAt(s.lastIndexOf("-") - 1) == '^')
			return lastIndexOfMinusOperation(s.substring(0,s.lastIndexOf("-") - 1));
		else
			return s.lastIndexOf("-");
	}
	
	private Double power(String base, String exp) {
		double baseVal = calculate(base);
		int expVal = (int) calculate(exp).doubleValue();
		
		return calculatePower(baseVal, expVal, 1d);
	}
	
	private Double calculatePower(double base, int exp, double acc) {
		if (exp == 0) {
			return acc;
		} else if (exp > 0) {
			return calculatePower(base, --exp, acc*base);
		} else {
			return calculatePower(base, ++exp, acc/base);
		}
	}
	
	private String normalize(String s) {
		return s.replace(" ","").replace("++","+").replace("+-","-").replace("-+","-").replace("--","+").replace("*+","*").replace("/+","/").replace("^+","^").replace("()","");
	}
}
