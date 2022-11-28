package com.apress.demo.services;

import com.apress.demo.exceptions.UserImportServiceCommunicationFailure;
import com.apress.demo.model.UsersImportResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * @author Siva
 *
 */
@SpringBootTest
public class UsersImportServiceMockitoTest {

	@MockBean
	private UsersImporter usersImporter;

	@Autowired
	private UsersImportService usersImportService;

	@Test
	public void should_import_users() {
		UsersImportResponse response = usersImportService.importUsers();
		assertThat(response.getRetryCount()).isEqualTo(0);
		assertThat(response.getStatus()).isEqualTo("SUCCESS");
	}

	@Test
	public void should_retry_3times_when_UserImportServiceCommunicationFailure_occured() {
		given(usersImporter.importUsers()).willThrow(new UserImportServiceCommunicationFailure());
		
		UsersImportResponse response = usersImportService.importUsers();
		
		assertThat(response.getRetryCount()).isEqualTo(3);
		assertThat(response.getStatus()).isEqualTo("FAILURE");
	}

}
