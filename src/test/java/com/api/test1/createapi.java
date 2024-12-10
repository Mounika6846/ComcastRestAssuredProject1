package com.api.test1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.util.HashMap;

public class createapi {
	@Test
	public void createuserapi() {
		HashMap<String, String> requestBody=new HashMap<String,String>();
		requestBody.put("name","Tenali");
		requestBody.put("gender","male");
		requestBody.put("email","mounika123.ramakrishna123@151ce.com");
		requestBody.put("status","active");
		
		given().
		header("Accept", "application/json").
		header("Content-Type", "application/json").
		header("Authorization", "Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba").
		
		
		when().
		body(requestBody).
		post("https://gorest.co.in/public/v2/users").
		
		then().
		statusCode(201).
		header("Content-Type","application/json; charset=utf-8").
		log().all();
		
		
	}

}
