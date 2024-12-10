package com.api.test1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class DeleteUserAPI {
	@Test
	public void DeleteAPI() {
		given().
		header("Accept", "application/json").
		header("Content-Type", "application/json").
		header("Authorization", "Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba").
		
		when().
		
		delete("https://gorest.co.in/public/v2/users/6942847").
		
		then().
		statusCode(204);
		
		
		
	}

}
