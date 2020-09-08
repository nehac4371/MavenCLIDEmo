package com.example.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	Caluculator caluculator = new Caluculator();

	@Test
	public void isValidAddition() {
		assertEquals(5.0, caluculator.addition(2.0, 3.0), 0.0);
	}
	
}
