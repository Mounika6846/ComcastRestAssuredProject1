package com.api.test1;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class UpdateAPIJSONObject {
	@Test
		public void UpdateAPIUsingJson() {
			JSONObject resquestBody = new JSONObject();
			resquestBody.put("name","sandeep123");
			resquestBody.put("email","yarraaa@hasma1p.com");
			resquestBody.put("status","active");
			
			given().
			header("Accept", "application/json").
			header("Content-Type", "application/json").
			header("Authorization", "Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba").
			
			when().
			body(resquestBody.toString()).
			patch("https://gorest.co.in/public/v2/users/7563749").
			
			then().
			statusCode(200).
			header("Content-Type","application/json; charset=utf-8").
			log().all();
			
		}


}
