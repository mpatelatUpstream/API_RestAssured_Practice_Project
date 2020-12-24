package local_APIs;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenAPIExamples extends DataForTesting{

	
	@Test(dataProvider = "DataForPost")
	public void test_post(String firstName, String lastName, int subjectID ) {
		JSONObject request = new JSONObject();
		
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectID", subjectID);
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
		statusCode(201).log().all();
	}
	

//@Test(dataProvider = "DataForDelete")
public void test_delete(int userID) {
	baseURI = "http://localhost:3000/";
	
	when().
		delete("/users/"+userID).
	then().
	statusCode(200);
}

//@Parameters(userID)
//@Test
//public void test_delete2(int userID) {
//	baseURI = "http://localhost:3000/";
//	
//	when().
//		delete("/users/"+userID).
//	then().
//	statusCode(200);
//}
}
