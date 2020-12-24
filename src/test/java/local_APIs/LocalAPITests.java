package local_APIs;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/**
 * Make sure to start the server before running any test on this APIs
 * Run following commands on the command line: C:\Users\manis>"json-server --watch db.json"
 * @author manis
 *
 */
public class LocalAPITests {

	@Test
	public void test_get() {
		baseURI = "http://localhost:3000/";
		RestAssured
		.given().contentType(ContentType.JSON).accept(ContentType.JSON).param("id", 1)
		.param("name","Automation")
		.when().get("/subjects")
		.then().statusCode(200).log().all();
		System.out.println("****Seperator****");
	}

	@Test
	public void test_post() {
		JSONObject request = new JSONObject();

		request.put("firstName", "Tom");
		request.put("lastName", "Cooper");
		request.put("subjectID", "1");

		baseURI = "http://localhost:3000/";

		RestAssured.given().
							contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type","application/json").//header of single attribute, headers for multiple attributes
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).log().all();
	}


	@Test
	public void test_patch() {
		JSONObject request = new JSONObject();
		request.put("lastName", "Shephard");

		baseURI = "http://localhost:3000/";

		RestAssured.given().
				contentType(ContentType.JSON).accept(ContentType.JSON).
				header("Content-Type","application/json").
				body(request.toJSONString()).
		when().
		patch("/users/4").
		then().
		statusCode(200).log().all();
	}

	@Test
	public void test_put() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Mary");
		request.put("lastName", "Kom");
		request.put("subjectID", "1");

		baseURI = "http://localhost:3000/";

		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("Content-Type","application/json").
		body(request.toJSONString()).
		when().
		put("/users/4").
		then().
		assertThat().statusCode(200).log().all();
	}

	@Test
	public void test_delete() {
		baseURI = "http://localhost:3000/";

		when().
		delete("/users/4").
		then().
		statusCode(200).log().all();
	}


}
