package com.creditapp;


import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditappApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
			throws ClientProtocolException, IOException {

		// Given
		String name = RandomStringUtils.randomAlphabetic( 8 );
		HttpUriRequest request = new HttpGet( "https://api.github.com/users/" + name );

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

		// Then
		assertEquals(httpResponse.getStatusLine().getStatusCode(), 404);

	}
}
