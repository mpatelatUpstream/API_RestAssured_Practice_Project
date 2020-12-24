package practice1;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class Test_Delete {
	@Test
	public void test_4_delete() {
		when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	}
}
