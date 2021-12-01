package APITest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class E_commerce {
	public String accessToken;
	public String id;
	
	public static String baseurl = "https://ecommerceservice.herokuapp.com";
	//if you use enabled = false it will not execute the method
	@Test(priority = 0,enabled = false)
	public void sign_up()
	{
		RestAssured.baseURI = baseurl;
		
		String Requestbody = "{\r\n"
				+ "	\"email\": \"amolmis176@gmail.com\",\r\n"
				+ "	\"password\": \"amolm@123\"\r\n"
				+ "}\r\n"
				+ "";




		
		// this tie i want to know what my response is in my console
		Response response = given()
				.header("content-Type","application/json")
				.body(Requestbody)
				
				.when()
				.post("/user/signup")
				
				.then()
				.assertThat().statusCode(201).and().contentType(ContentType.JSON)
				.extract().response();
		//basically the i\output format by default it will be strings i cannot read
		//i hve to convert it to json
		String jsonresponse = response.asString();
		//if i want to convert from normal string to json format i use a variable 
		JsonPath responsebody = new JsonPath(jsonresponse);
		System.out.println(responsebody.get("message"));
	}
	@Test(priority = 1)
	public void login()
	{
		RestAssured.baseURI = baseurl;
		
		String Requestbody = "{\r\n"
				+ "	\"email\": \"amolm176@gmail.com\",\r\n"
				+ "	\"password\": \"amolm@123\"\r\n"
				+ "}\r\n"
				+ "";




		
		// this tie i want to know what my response is in my console
		Response response = given()
				.header("content-Type","application/json")
				.body(Requestbody)
				
				.when()
				.post("/user/login")
				
				.then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
		//basically the i\output format by default it will be strings i cannot read
		//i hve to convert it to json
		String jsonresponse = response.asString();
		//if i want to convert from normal string to json format i use a variable 
		JsonPath responsebody = new JsonPath(jsonresponse);
		System.out.println(responsebody.get("accessToken"));
		accessToken = responsebody.get("accessToken");
	}
	@Test(priority = 2)
	public void GetUsers()
	{
		RestAssured.baseURI = baseurl;
		
		




		
		// this tie i want to know what my response is in my console
		Response response = given()
				.header("content-Type","application/json")
				.header("Authorization","bearer "+accessToken)
				
				.when()
				.get("/user")
				
				.then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
		//basically the i\output format by default it will be strings i cannot read
		//i hve to convert it to json
		String jsonresponse = response.asString();
		//if i want to convert from normal string to json format i use a variable 
		JsonPath responsebody = new JsonPath(jsonresponse);
		System.out.println(responsebody.get("users[200]._id"));
		id = responsebody.get("users[200]._id");
		
		
	}
	@Test(priority = 3)
	public void DeleteUsers()
	{
		RestAssured.baseURI = baseurl;
		
		




		
		// this tie i want to know what my response is in my console
		Response response = given()
				.header("content-Type","application/json")
				.header("Authorization","bearer "+accessToken)
				
				.when()
				.delete("/user/"+id)
				
				.then()
				.assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
		//basically the i\output format by default it will be strings i cannot read
		//i hve to convert it to json
		String jsonresponse = response.asString();
		//if i want to convert from normal string to json format i use a variable 
		JsonPath responsebody = new JsonPath(jsonresponse);
		System.out.println(responsebody.get("message"));
		
	}
}
