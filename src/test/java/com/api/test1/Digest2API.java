package com.api.test1;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Digest2API {
	@Test
  public void DigestAPI2() {
		given()
		.header("accept","application/json")
		.auth().digest("user","passwd")
		
		
		.when()
		
		.get("https://httpbin.org/digest-auth/auth/user/passwd/MD5")
		
		.then()
		
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.header("content-type", "application/json")
		.log().all();
		
	}

	
	
	
}
