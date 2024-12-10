package com.api.test1;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("API chaining Epic")
@Feature("Feature to achive api chaining using faker lib")

public class APIALLureTest {
	
int extractedID;
Faker faker = new Faker();
@Story("Create user story")
@Step("Post Testcase")
@Description("This api creates a random user")
@Severity(SeverityLevel.BLOCKER)
	@Test(priority=1)
	
	public void createJsonApi()
	
		{
		
			JSONObject requestBody= new JSONObject();
			requestBody.put("name",faker.name().firstName());
			requestBody.put("gender",faker.demographic().sex());
			requestBody.put("email",faker.internet().emailAddress());
			requestBody.put("status","inactive");
			extractedID=given().
			header("Accept", "application/json").
			header("Content-Type", "application/json").
			header("Authorization", "Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba").
			when().
			body(requestBody.toString()).
			post("https://gorest.co.in/public/v2/users").
			jsonPath().getInt("id");
			//then().
		//	statusCode(201).
			//header("Content-Type","application/json; charset=utf-8").
			//log().all();
		}
@Story("Update user story")
@Step("Patch Testcase")
@Description("This api updates the created user")
@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2,dependsOnMethods=("createJsonApi"))
	
	public void UpdateAPIUsingJson() {
		Faker faker = new Faker();
		JSONObject resquestBody = new JSONObject();
		resquestBody.put("name",faker.name().firstName());
		resquestBody.put("email",faker.internet().emailAddress());
		resquestBody.put("status","active");
		
		given().
		header("Accept", "application/json").
		header("Content-Type", "application/json").
		header("Authorization", "Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba").
		
		when().
		body(resquestBody.toString()).
		patch("https://gorest.co.in/public/v2/users/"+extractedID).
		
		then().
		statusCode(200).
		header("Content-Type","application/json; charset=utf-8").
		log().all();
		
	}
@Story("Delete user story")
@Step("Delete Testcase")
@Description("This api Deletes the created user")
@Severity(SeverityLevel.NORMAL)
	@Test(priority=3,dependsOnMethods=("createJsonApi"))
	public void DeleteAPI() {
		given().
		header("Accept", "application/json").
		header("Content-Type", "application/json").
		header("Authorization", "Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba").
		
		when().
		
		delete("https://gorest.co.in/public/v2/users/"+extractedID).
		
		then().
		statusCode(204);
		
		
		
	}

}
