package practice1;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_PATCH {

	@Test
	public void test_Patch() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Raghav");
		map.put("job", "Teacher");

		//To create proper json object:-->
		JSONObject request = new JSONObject(map);//new JSONObject(map)
		//System.out.println(request);
		//if you get some serialization errors then
		System.out.println(request.toJSONString());

		given().header("Content-Type","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).
		when().patch("https://reqres.in/api/users/2").
		then().statusCode(200).log().all();

	}
	}

