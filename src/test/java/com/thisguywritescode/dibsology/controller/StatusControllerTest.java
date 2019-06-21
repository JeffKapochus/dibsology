package com.thisguywritescode.dibsology.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class StatusControllerTest {

	@InjectMocks
	StatusController statusController;

	@Before
	public void setUp() {
	}

	@Test
	public void getStatus_returnsHttpOk_Always() {
		assertThat(statusController.getStatus(), is(new ResponseEntity<String>("Dibsology Backend is Running", HttpStatus.OK)));
	}

}
