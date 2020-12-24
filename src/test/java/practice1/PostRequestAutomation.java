package practice1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
/**
 * nishant_FunDooTest
 * @author manis
 *
 */
public class PostRequestAutomation {
//1st way
@Test
public void postRequest() {
	//first step is to set baseURI
	RestAssured.baseURI = "https://reqres.in/api/users";
	RestAssured.given().body("{\r\n" + 
			"    \"name\": \"Swati\",\r\n" + 
			"    \"job\": \"CSR\"\r\n" + 
			"}")
	.post()
	.then().log().all().assertThat().statusCode(201);
}


//another way where you can pass the json body as a string and save it in variable, however we can not have static body so we cant use this eihter
//@Test
public void postRequest_2() {
	//first step is to set baseURI
	RestAssured.baseURI = "https://reqres.in/api/users";
	String inputJson = "{\r\n" + 
			"    \"name\": \"morpheus_2\",\r\n" + 
			"    \"job\": \"leader\"\r\n" + 
			"}";
	RestAssured.given().body(inputJson).post().then().log().all().assertThat().statusCode(201);
}
}
