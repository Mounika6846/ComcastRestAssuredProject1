package com.api.test1;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateFakerAPI {
	@Test
	
	public void createJsonApi() {
	Faker faker = new Faker();
		{
			JSONObject requestBody= new JSONObject();
			requestBody.put("name",faker.name().firstName());
			requestBody.put("gender",faker.demographic().sex());
			requestBody.put("email",faker.internet().emailAddress());
			requestBody.put("status","inactive");
			given().
			header("Accept", "application/json").
			header("Content-Type", "application/json").
			header("Authorization", "Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba").
			when().
			body(requestBody.toString()).
			post("https://gorest.co.in/public/v2/users").
			then().
			statusCode(201).
			header("Content-Type","application/json; charset=utf-8").
			log().all();

}
	}
}
