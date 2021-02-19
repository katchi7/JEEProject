package com.ensias.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DAOUserTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Transactional
    @Rollback(true)
	@Mock
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testFindUser() {
		fail("Not yet implemented");
	}

}
