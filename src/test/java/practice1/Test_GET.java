package practice1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_GET {

	@Test
	void getUserList() {

		// specify base url
		RestAssured.baseURI = "https://reqres.in/api/users";
		Response response = null;

		response = RestAssured
				.given()
				.when()
				.get("?page=2");


		System.out.println("Response is :\n"+response.getBody().asString());
		System.out.println("****Seperator****");
		System.out.println("response.getHeader.content-type: "+response.getHeader("content-type"));
	
		int statusCode = response.getStatusCode();
		System.out.println("response.getStatusCode: "+response.getStatusCode());
		Assert.assertEquals(statusCode, 200);
		// create request object
		////RequestSpecification request = RestAssured.given();

		// create response object
		//Response response = request.request(Method.GET, "");
		//Response response2 = get("");
	}

	@Test
	void testGet_1() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");

		System.out.println("==============================");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
	}
	
	@Test
	void testGet_2() {
		baseURI = "https://reqres.in/api/users";

		get("?page=2").then().body("data.id[0]", equalTo(7));	
		
		/*
		 		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(7)).log().all();
		 */
	}

	@Test
	void testGet_3() {
		baseURI = "https://reqres.in/api/users"; 

		RestAssured.given().param("","")
						   .header("","")
					.when()
					.get("")
					.then().statusCode(200);

		RestAssured.get("?page=2").then().body("data.id[0]", equalTo(7));	
	}
	
	@Test
	void testGet_4() {

		get("https://reqres.in/api/users?page=2")
		.body().asString();

		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200);

	}
	
	
	@Test
	public void test_1() {

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();

		//	given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[1]",equalTo(8)).log().all();

		given().get("https://reqres.in/api/users?page=2")
		.then().statusCode(200).body("data.id[1]",equalTo(8))
			.body("data.first_Name", hasItems("Michael","Lindsay"));

	}
	
	

	@Test
	void test_01() {
//Response response=	RestAssured.get("https://reqres.in/api/users?page=2");
		Response response=	get("https://reqres.in/api/users?page=2");
response.asString();
response.getBody();
response.getStatusCode();
System.out.println(response.asString());
System.out.println("******************");
System.out.println(response.getBody().asString());
System.out.println("******************");
System.out.println(response.getStatusCode());

int statusCode = response.getStatusCode();
Assert.assertEquals(statusCode, 200);
//Assert.assertEquals(statusCode, 201);  // should get failed as we have purposefully giving wrong expected value

System.out.println("******************");
System.out.println(response.getStatusLine());
System.out.println("******************");
System.out.println(response.getHeader("content-type"));
System.out.println("******************");
System.out.println(response.getTime());
System.out.println("******************");

	}
	
	@Test
	void test_02() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7));
	}
	
	@Test
	public void test_3() {
		
		given()
			.param("Key", "values")
			.header("key", "value")
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.log().all()
			.body("data.first_name", hasItems("Michael","Lindsay"));
	}
}
