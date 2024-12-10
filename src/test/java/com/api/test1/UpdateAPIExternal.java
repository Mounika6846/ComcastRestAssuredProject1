package com.api.test1;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UpdateAPIExternal {
	@Test
	public void UpdateJSONAPIExternalfile() throws FileNotFoundException {
		File file = new File(".\\payload.json");
		FileReader fr = new FileReader(file);
		JSONTokener jt= new JSONTokener(fr);
		JSONObject requestBody = new JSONObject(jt);
	
				
		
		given().
		
		header("Accept", "application/json").
		header("Content-Type", "application/json").
		header("Authorization", "Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba").
		
		when().
		
		body(requestBody.toString()).
		patch("https://gorest.co.in/public/v2/users/7563742").
		
		then().
		
		statusCode(201).
		header("Content-Type","application/json; charset=utf-8").
		log().all();
		
		
		
	}

}
