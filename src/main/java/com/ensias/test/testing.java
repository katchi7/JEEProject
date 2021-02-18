package com.ensias.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class testing {

	@Test
	void test() {
		JunitTesting t = new JunitTesting();
		int expected =2;
		int actual = t.add(3,1);
		assertEquals(expected, actual);
		
}
}

