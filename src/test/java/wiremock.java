import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

public class wiremock {
	@Test
public void getallcourses() {
	given()
	.when()
	.get("http//localhost:8080/allCourses")
	.then()
	.statusCode(200)
	.header("Content-Type", "application/json")
	.log().all();
	}
}
