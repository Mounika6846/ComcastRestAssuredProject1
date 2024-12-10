package com.api.test1;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class UpdateFakerAPI {
	@Test
	public void UpdateAPIUsingJson() {
		Faker faker = new Faker();
		JSONObject resquestBody = new JSONObject();
		resquestBody.put("name",faker.name().firstName());
		resquestBody.put("email",faker.internet().emailAddress());
		resquestBody.put("status","active");
		
	Response response	=given().
		header("Accept", "application/json").
		header("Content-Type", "application/json").
		header("Authorization", "Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba").
		
		when().
		body(resquestBody.toString()).
		patch("https://gorest.co.in/public/v2/users/7563749");
		
	Assert.assertEquals(response.getStatusCode(),201);
	Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 201 Created");
	Assert.assertEquals(response.getContentType(),"application/json; charset=utf-8");
	System.out.println("status code " +response.getStatusCode());
	System.out.println("StatusLine " +response.getStatusLine());
	System.out.println("Response Time " +response.getTime());
	System.out.println("Response Headers " +response.getHeaders());
	System.out.println("Response Body " +response.getBody());
		
		
		//then().
		//statusCode(200).
		//header("Content-Type","application/json; charset=utf-8").
		//log().all();
		
	}

}
