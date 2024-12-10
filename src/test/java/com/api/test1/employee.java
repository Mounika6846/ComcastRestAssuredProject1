package com.api.test1;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;
public class employee {
	@Test 
	
	public void list1()
	{
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
