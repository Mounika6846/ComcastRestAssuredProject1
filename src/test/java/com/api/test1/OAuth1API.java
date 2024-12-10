package com.api.test1;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


public class OAuth1API {
	public void OAthu1APITest() {
		given()
		.header("accept","application/json")
		.auth().oauth("consumerkey", "consumersecret", "accesstoken", "secrettoken")
		
		
		.when()
		
		.get("https://api.github.com/user/repos" )
		
		.then()
		
		.statusCode(200)
		
		.header("content-type", "application/json; charset=utf-8")
		.log().all();

}
