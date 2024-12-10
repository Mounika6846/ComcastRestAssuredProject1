package com.api.test1;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicAuthentication {
	@Test
	public void BasicAuth() {
		
		given().
		header("accept","application/json")
		.auth().basic("lion", "tiger").
		when().
		get("https://httpbin.org/basic-auth/lion/tiger").
		then().
		statusCode(200)
		.body("authenticated", equalTo(true))
		.header("content-type", "application/json")
		.log().all();
		
	}

}
