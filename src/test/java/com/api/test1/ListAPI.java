package com.api.test1;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class ListAPI {
	
int extractedID;
	
	@Test(priority=0)
	
	public void createJsonApi()
		{
			JSONObject requestBody= new JSONObject();
			requestBody.put("name","mou567ni45634123");
			requestBody.put("gender","female");
			requestBody.put("email","mou124543556we34@15781ce.com");
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
	
	@Test(priority=1,dependsOnMethods={"createJsonApi"})
	
	public void VerifyCreateuser1() {
		
		
		
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization","Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba");
		
		when().
		get("https://gorest.co.in/public/v2/users").
		then().
		statusCode(200).
		body("gender", hasItems("male", "female")).
		body("status", hasItems("active", "inactive")).
		
		//body("[0].name", equalTo("Nawal Bhattathiri")).
		//body("[1].id", equalTo(7561792)).
		//body("[2].email", equalTo("shwet_tandon@reichel-ledner.test")).log().all();
		log().all();
	}
	@Test(priority=2,dependsOnMethods={"createJsonApi"})
	
	public void UpdateAPIUsingJson() {
		JSONObject resquestBody = new JSONObject();
		resquestBody.put("name","sandw3thyr34weep123");
		resquestBody.put("email","yaffrrrfvdrra@hasma1p.com");
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
@Test(priority=3,dependsOnMethods={"createJsonApi"})
	
	public void Verifyupdateuser() {
		
		
		
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization","Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba");
		
		when().
		get("https://gorest.co.in/public/v2/users").
		then().
		statusCode(200).
		body("gender", hasItems("male", "female")).
		body("status", hasItems("active", "inactive")).
		
		//body("[0].name", equalTo("Nawal Bhattathiri")).
		//body("[1].id", equalTo(7561792)).
		//body("[2].email", equalTo("shwet_tandon@reichel-ledner.test")).log().all();
		log().all();
	}
	@Test(priority=4,dependsOnMethods={"createJsonApi"})
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
@Test(priority=5,dependsOnMethods={"createJsonApi"})
	
	public void VerifyDeleteuser() {
		
		
		
		given().
		header("Accept","application/json").
		header("Content-Type","application/json").
		header("Authorization","Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba");
		
		when().
		get("https://gorest.co.in/public/v2/users").
		then().
		statusCode(200).
		body("gender", hasItems("male", "female")).
		body("status", hasItems("active", "inactive")).
		
		//body("[0].name", equalTo("Nawal Bhattathiri")).
		//body("[1].id", equalTo(7561792)).
		//body("[2].email", equalTo("shwet_tandon@reichel-ledner.test")).log().all();
		log().all();
	}

}
