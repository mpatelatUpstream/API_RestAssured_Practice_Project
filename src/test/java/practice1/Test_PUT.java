package practice1;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_PUT {
	@Test
	public void test_PUT() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Raghav");
		map.put("job", "Teacher");

		System.out.println("not json format:  "+map);
		JSONObject request = new JSONObject(map);//new JSONObject(map)   To create proper json object

		//System.out.println(request);//some time we get serialization errors writing request jsonObject directly so instead we can use  then toJSONString
		System.out.println(request.toJSONString());

		given().
				header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
				body(request.toJSONString()).
		when().
		put("https://reqres.in/api/users/2").
		then().statusCode(200).log().all();

	}

}
