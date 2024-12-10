package com.api.test1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BearerAPI {
	@Test
	public void BearerAPI1() {
		
		given()
		.header("accept","application/json")
		.header("Authorization","Bearer 12345")
		
		
		.when()
		
		.get("https://httpbin.org/bearer" )
		
		.then()
		
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.header("content-type", "application/json")
		.log().all();
		
		
	}

}
