package com.thisguywritescode.dibsology.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.thisguywritescode.dibsology.model.Submission;
import com.thisguywritescode.dibsology.model.User;
import com.thisguywritescode.dibsology.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@InjectMocks
	UserService userService = new UserServiceImpl();

	@Mock
	UserRepository mockUserRepository;

	@Mock
	User mockUser;

	private final int VALID_SUBMISSION_ID = 1;
	private final int VALID_USER_ID = 1;
	private List<User> VALID_USER_LIST;
	private List<User> EMPTY_USER_LIST;
	private Submission VALID_SUBMISSION;

	@Before
	public void setUp() {
	    EMPTY_USER_LIST = new ArrayList<User>();

		VALID_USER_LIST = new ArrayList<User>();
		VALID_USER_LIST.add(mockUser);
		VALID_USER_LIST.add(mockUser);
		VALID_USER_LIST.add(mockUser);

		doReturn(Optional.of(mockUser)).when(mockUserRepository).findById(VALID_USER_ID);
		doReturn(VALID_USER_LIST).when(mockUserRepository).findAll();
		doReturn(VALID_USER_ID).when(mockUser).getId();
		
		VALID_SUBMISSION = new Submission();
		VALID_SUBMISSION.setUser(mockUser);
	}

	@Test
	public void getUserById_returnsValidSubmission_whenGivenValidId() {
		assertThat(userService.getUserById(VALID_USER_ID), is(mockUser));
	}

	@Test
	public void getUserById_returnsEmpty_whenGivenInvalidId() {
		assertThat(userService.getUserById(0), is(nullValue()));
	}

	@Test
	public void getAllUsers_returnsValidSubmissionList_byDefault() {
		assertThat(userService.getAllUsers(), is(VALID_USER_LIST));
	}

	@Test
	public void getSubmissionsByUserId_returnsValidSubmissionList_whenGivenValidUserId() {
		assertThat(userService.getUserBySubmission(VALID_SUBMISSION), is(mockUser));
	}

	@Test
	public void getSubmissionsByUserId_returnsEmptySubmissionList_whenGivenInvalidUserId() {
		assertThat(userService.getUserBySubmission(null), is(nullValue()));
	}

}
