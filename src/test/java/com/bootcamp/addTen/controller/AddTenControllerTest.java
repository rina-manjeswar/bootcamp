package com.bootcamp.addTen.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Invoke the Controller methods via HTTP.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class AddTenControllerTest {
	
	private static final String ADD_TEN_URL = "/addTen";
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
    public void successScenarioForValidPositiveIntegerInput()  {

        ResponseEntity<String> response =
                restTemplate.getForEntity(ADD_TEN_URL + "/" + 20, String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is("30"));
    }
	
	@Test
    public void successScenarioForZeroAsInput()  {

        ResponseEntity<String> response =
                restTemplate.getForEntity(ADD_TEN_URL + "/" + 0, String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is("10"));
    }
	
	@Test
    public void successScenarioForValidNegativeIntegerInput()  {

        ResponseEntity<String> response =
                restTemplate.getForEntity(ADD_TEN_URL + "/" + -20, String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is("-10"));
    }
	
	@Test
    public void failureScenarioForInvalidFloatInput()  {

        ResponseEntity<String> response =
                restTemplate.getForEntity(ADD_TEN_URL + "/" + 2.2, String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(AddTenController.INVALID_INPUT_MESSAGE));
    }
	
	@Test
    public void failureScenarioForInvalidLongAsInput()  {

        ResponseEntity<String> response =
                restTemplate.getForEntity(ADD_TEN_URL + "/" + 22845743434L, String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(AddTenController.INVALID_INPUT_MESSAGE));
    }
	
	@Test
    public void failureScenarioForInvalidStringInput()  {

        ResponseEntity<String> response =
                restTemplate.getForEntity(ADD_TEN_URL + "/" + "sd", String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(AddTenController.INVALID_INPUT_MESSAGE));
    }
	
	@Test
    public void failureScenarioForInvalidSpecialCharacterAsInput()  {

        ResponseEntity<String> response =
                restTemplate.getForEntity(ADD_TEN_URL + "/" + "*", String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(AddTenController.INVALID_INPUT_MESSAGE));
    }

}
