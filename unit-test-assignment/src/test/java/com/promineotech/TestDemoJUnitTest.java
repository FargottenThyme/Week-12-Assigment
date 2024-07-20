package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	private TestDemo testDemo;
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive") 
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(arguments(2, 4, 6, false), arguments(10, 30, 40, false), arguments(8, 0, 8, true), arguments(-3, -4, -7, true), arguments(80, 224, 304, false));
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(100, 20)).isEqualTo(120);
		assertThat(testDemo.addPositive(1, 99)).isEqualTo(100);
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForCanAffordTotal")
	// Creates the test parameters for the "canAffordTotal" method and inputs the arguments set up in advance.
	void assertThatItemCostsAndFundsArePositive(double itemCost1, double itemCost2, double itemCost3, double funds, double expectedTotal, boolean expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.canAffordTotal(itemCost1, itemCost2, itemCost3, funds)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.canAffordTotal(itemCost1, itemCost2, itemCost3, funds)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	// Creates a stream of arguments for the previous method to input and test.
	static Stream<Arguments> argumentsForCanAffordTotal() {
		return Stream.of(arguments(1.00, 3.50, 2.75, 12.00, 7.25, true, false), arguments(0.00, 18.00, 0.01, 5.00, 18.01, false, false),
				arguments(-0.05, 0.00, -18.00, 0.00, -18.05, true, true), arguments(238.49, 186.99, 438.89, 500.00, 864.37, false, false),
				arguments(100.00, 100.00, 100.00, -200.00, 300.00, false, true));
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
}
