package com.ontariotechu.sofe3980U;

import java.util.Arrays;
import java.util.Stack;

import org.joda.time.LocalTime;

/**
 * Hello world!
 */
public class App {
	static String[] operators = new String[] { "+", "*", "|", "&" };

	public static String evalRPN(String expr) {
		Stack<Binary> stack = new Stack<>();
		for (String s : expr.split("\\b")) {
			s = s.trim();
			if (s.isEmpty()) {
				continue;
			}

			Binary v = new Binary(s);
			if (Arrays.asList(operators).contains(s)) {
				Binary l = stack.pop();
				Binary r = stack.pop();
				switch (s) {
					case "+":
						v = Binary.add(l, r);
						break;
					case "*":
						v = Binary.mul(l, r);
						break;
					case "|":
						v = Binary.or(l, r);
						break;
					case "&":
						v = Binary.and(l, r);
						break;
				}
				System.out.println(String.format("%s %s %s = %s", l.getValue(), s, r.getValue(), v.getValue()));
			}
			stack.push(v);
		}
		return stack.pop().getValue();
	}

	public static void main(String[] args) {
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);
		Binary binary1 = new Binary("00010001000");
		System.out.println("First binary number is " + binary1.getValue());
		Binary binary2 = new Binary("111000");
		System.out.println("Second binary number is " + binary2.getValue());
		Binary sum = Binary.add(binary1, binary2);
		System.out.println("Their summation is " + sum.getValue());

		System.out.print("Enter an expression in RPN (supported ops: + * | &): ");
		System.out.println("Result: " + evalRPN(System.console().readLine()));
	}
}
