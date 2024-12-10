package com.api.test1;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class UpdateAPIHashMap {
	@Test
	public void UpdateAPIUsingHashMap() {
		HashMap<String, String> resquestBody = new HashMap<String , String>();
		resquestBody.put("name","sandeep1");
		resquestBody.put("email","yarra@hasma1p.com");
		resquestBody.put("status","active");
		
		given().
		header("Accept", "application/json").
		header("Content-Type", "application/json").
		header("Authorization", "Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba").
		
		when().
		body(resquestBody).
		patch("https://gorest.co.in/public/v2/users/7563739").
		
		then().
		statusCode(200).
		header("Content-Type","application/json; charset=utf-8").
		log().all();
		
	}

}
