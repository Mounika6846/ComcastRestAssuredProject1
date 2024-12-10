package com.api.test1;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerApi {
	@Test
	public void FakerClass() {
		Faker faker = new Faker();
		System.out.println(faker.country().name());
		System.out.println(faker.name().fullName());
		System.out.println(faker.name().firstName());
		System.out.println(faker.internet().emailAddress());
		System.out.println(faker.demographic().sex());
		
	}

}
