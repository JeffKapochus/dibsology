package com.thisguywritescode.dibsology.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.thisguywritescode.dibsology.model.User;
import com.thisguywritescode.dibsology.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
	UserController userController;

	@Mock
	UserServiceImpl userService;

	@Mock
	User mockUser;

	private final int VALID_USER_ID = 1;

	@Before
	public void setUp() {
		doReturn(mockUser).when(userService).getUserById(VALID_USER_ID);
	}

	@Test
	public void getUserById_returnsUserAndOK_whenGivenValidId() {
		final ResponseEntity<User> expected = new ResponseEntity<User>(mockUser, HttpStatus.OK);
		final ResponseEntity<User> result = userController.getUserById(VALID_USER_ID);

		assertThat(result, is(expected));
	}

	@Test
	public void getUserById_returnsNullAndOK_whenGivenInvalidId() {
		doReturn(null).when(userService).getUserById(VALID_USER_ID);

		final ResponseEntity<User> expected = new ResponseEntity<User>((User) null, HttpStatus.OK);
		final ResponseEntity<User> result = userController.getUserById(VALID_USER_ID);

		assertThat(result, is(expected));
	}

	@Test
	public void getSubmissionById_returnsInternalServerError_whenAServiceErrorOccurs() {
		doThrow(new NullPointerException()).when(userService).getUserById(VALID_USER_ID);

		final ResponseEntity<User> expected = new ResponseEntity<User>((User) null,
				HttpStatus.INTERNAL_SERVER_ERROR);
		final ResponseEntity<User> result = userController.getUserById(VALID_USER_ID);

		assertThat(result, is(expected));
	}

}
