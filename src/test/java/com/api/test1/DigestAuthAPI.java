package com.api.test1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DigestAuthAPI {
	@Test
	public void DigestAuth() {
		
		given()
		.header("accept","application/json")
		.auth().digest("user","passwd")
		
		
		.when()
		
		.get("https://httpbin.org/basic-auth/user/passwd")
		
		.then()
		
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.header("content-type", "application/json")
		.log().all();
		
	}

}
