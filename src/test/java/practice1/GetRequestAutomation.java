package practice1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
/**
 * nishant_FunDooTest
 * @author manis
 *
 */
public class GetRequestAutomation {

	@Test
	public void get() {
		RestAssured.baseURI = "https://reqres.in/api/users";


		//1 way
		/*		RestAssured.given().param("page", "2")
			.when()
			.get()
			.then().assertThat().log().all().statusCode(200); //log().all() will print entire header as well as response body
		 */	


		//2nd way
		Response response = RestAssured	.given().param("page", "2")
										.when()
										.get();
		System.out.println(response.getBody().asString());
		System.out.println("getStatusCode : ==> "+response.getStatusCode());
		System.out.println("Content Type : ==> "+response.contentType());
		System.out.println("Time : ==> "+response.getTime());
		System.out.println("Cookies : ==> "+response.getCookies());
		System.out.println(response.prettyPrint());

	}	
}
