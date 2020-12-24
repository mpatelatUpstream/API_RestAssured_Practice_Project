package practice1;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_POST {
	@Test
	public void test_1_POST() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Raghav");
		map.put("job", "Teacher");

		System.out.println("print the map object, it is not in json format:  \n" + map);
		System.out.println("####seperator#############");
		// To create proper json object with the help of simple.JSONObject library:-->

		JSONObject request = new JSONObject();// new JSONObject(map)
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		System.out.println(request);
		// if you get some serialization errors then
		System.out.println("****seperator******");
		System.out.println(request.toJSONString());

		// given().
		// body(request.toJSONString()).
		// when().
		// post("https://reqres.in/api/users").
		// then().
		// statusCode(201);

		RestAssured.given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
			.statusCode(201);
	}
}
