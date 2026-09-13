package com.ontariotechu.sofe3980U;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest {
	/**
	 * Test The constructor with a valid binary vallue
	 */
	@Test
	public void normalConstructor() {
		Binary binary = new Binary("1001001");
		assertTrue(binary.getValue().equals("1001001"));
	}

	/**
	 * Test The constructor with an invalid binary value of out-of-range digits
	 */
	@Test
	public void constructorWithInvalidDigits() {
		Binary binary = new Binary("1001001211");
		assertTrue(binary.getValue().equals("0"));
	}

	/**
	 * Test The constructor with an invalid binary value of alphabetic characters
	 */
	@Test
	public void constructorWithInvalidChars() {
		Binary binary = new Binary("1001001A");
		assertTrue(binary.getValue().equals("0"));
	}

	/**
	 * Test The constructor with an invalid binary value that has a sign
	 */
	@Test
	public void constructorWithNegativeSign() {
		Binary binary = new Binary("-1001001");
		assertTrue(binary.getValue().equals("0"));
	}

	/**
	 * T est The constructor with a zero tailing valid binary value
	 */
	@Test
	public void constructorWithZeroTailing() {
		Binary binary = new Binary("00001001");
		assertTrue(binary.getValue().equals("1001"));
	}

	/**
	 * Test The constructor with an empty string
	 */
	@Test
	public void constructorEmptyString() {
		Binary binary = new Binary("");
		assertTrue(binary.getValue().equals("0"));
	}

	static String[][] operands = new String[][] {
			{ "1000", "1111" },
			{ "1010", "11" },
			{ "11", "1010" },
			{ "0", "1010" },
			{ "0", "0" },
	};

	public interface Operator {
		Binary call(Binary l, Binary r);
	}

	static void testOperator(Operator op, int i, String expected) {
		Binary opResult = op.call(new Binary(operands[i][0]), new Binary(operands[i][1]));
		assertEquals(expected, opResult.getValue());
	}

	/**
	 * Test The add functions with two binary numbers of the same length
	 */
	@Test
	public void add() {
		testOperator((l, r) -> {
			return Binary.add(l, r);
		}, 0, "10111");
	}

	/**
	 * Test The add functions with two binary numbers, the length of the first
	 * argument is less than the second
	 */
	@Test
	public void add2() {
		testOperator((l, r) -> {
			return Binary.add(l, r);
		}, 1, "1101");
	}

	/**
	 * Test The add functions with two binary numbers, the length of the first
	 * argument is greater than the second
	 */
	@Test
	public void add3() {
		testOperator((l, r) -> {
			return Binary.add(l, r);
		}, 2, "1101");
	}

	/**
	 * Test The add functions with a binary numbers with zero
	 */
	@Test
	public void add4() {
		testOperator((l, r) -> {
			return Binary.add(l, r);
		}, 3, "1010");
	}

	/**
	 * Test The add functions with two zeros
	 */
	@Test
	public void add5() {
		testOperator((l, r) -> {
			return Binary.add(l, r);
		}, 4, "0");
	}

	@Test
	public void mul1() {
		testOperator((l, r) -> {
			return Binary.mul(l, r);
		}, 0, "1111000");
	}

	@Test
	public void mul2() {
		testOperator((l, r) -> {
			return Binary.mul(l, r);
		}, 1, "11110");
	}

	@Test
	public void mul3() {
		testOperator((l, r) -> {
			return Binary.mul(l, r);
		}, 2, "11110");
	}

	@Test
	public void mul4() {
		testOperator((l, r) -> {
			return Binary.mul(l, r);
		}, 3, "0");
	}

	@Test
	public void mul5() {
		testOperator((l, r) -> {
			return Binary.mul(l, r);
		}, 4, "0");
	}

	@Test
	public void or1() {
		testOperator((l, r) -> {
			return Binary.or(l, r);
		}, 0, "1111");
	}

	@Test
	public void or2() {
		testOperator((l, r) -> {
			return Binary.or(l, r);
		}, 1, "1011");
	}

	@Test
	public void or3() {
		testOperator((l, r) -> {
			return Binary.or(l, r);
		}, 2, "1011");
	}

	@Test
	public void or4() {
		testOperator((l, r) -> {
			return Binary.or(l, r);
		}, 3, "1010");
	}

	@Test
	public void or5() {
		testOperator((l, r) -> {
			return Binary.or(l, r);
		}, 4, "0");
	}

	@Test
	public void and1() {
		testOperator((l, r) -> {
			return Binary.and(l, r);
		}, 0, "1000");
	}

	@Test
	public void and2() {
		testOperator((l, r) -> {
			return Binary.and(l, r);
		}, 1, "10");
	}

	@Test
	public void and3() {
		testOperator((l, r) -> {
			return Binary.and(l, r);
		}, 2, "10");
	}

	@Test
	public void and4() {
		testOperator((l, r) -> {
			return Binary.and(l, r);
		}, 3, "0");
	}

	@Test
	public void and5() {
		testOperator((l, r) -> {
			return Binary.and(l, r);
		}, 4, "0");
	}
}
