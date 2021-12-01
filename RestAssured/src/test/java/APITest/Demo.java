package APITest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
public class Demo {
	//i am teaching you the get method works
	//https://api.trello.com/1/boards/{id}
	
	public static String baseurl ="https://api.trello.com";
	public String id;
	public String response;
	
	@Test(priority=1)
	public void getboard()
	{
		
		//anytime you have to work with rest assured first you have to load the baseurl
		
		RestAssured.baseURI= baseurl;
		
		//pre-requiste//parameter//header//cookies
		Response response = given().param("key", "8fbfa9d2370227cbeab133b66d5aef77")
		.param("token", "74c94b4cabcf0445575b4ff8b1063e88b735712d3261d6bb7b13448f9041ab89")
		
		//condition//differetn HTTP methds
		.when()
		.get("/1/boards/"+id)
		//basically checking response //applying assertion //assertion and response
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).and()
		.extract().response();
		String jsonresponse = response.asString();
		System.out.println(jsonresponse);
		
	   
	}
	
	@Test(priority=0)
	public void createboard()
	{
		
		//anytime you have to work with rest assured first you have to load the baseurl
		
		RestAssured.baseURI= baseurl;
		
		//pre-requisite//parameter//header//cookies
	    Response response = given().queryParam("key", "8fbfa9d2370227cbeab133b66d5aef77")
		.queryParam("token", "74c94b4cabcf0445575b4ff8b1063e88b735712d3261d6bb7b13448f9041ab89")
		.queryParam("name", "amol-new").header("content-type","application/json")
		
		//condition//different HTTP methods
		.when()
		.post("/1/boards/")
		//basically checking response //applying assertion //assertion and response
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
	    .extract().response();
	    String jsonresponse = response.asString();
	    JsonPath responsebody = new JsonPath(jsonresponse);
	    id = responsebody.get("id");
	    
	}
	
	@Test(priority=2)
	public void deleteboard()
	{
		
		//anytime you have to work with rest assured first you have to load the baseurl
		
		RestAssured.baseURI= baseurl;
		
		//pre-requisite//parameter//header//cookies
		
		Response response = given().queryParam("key", "8fbfa9d2370227cbeab133b66d5aef77")
		.queryParam("token", "74c94b4cabcf0445575b4ff8b1063e88b735712d3261d6bb7b13448f9041ab89")
		
		
		//condition//differetn HTTP methds
		.when()
		.delete("1/boards/"+id)
		//basically checking response //applying assertion //assertion and response
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		String jsonresponse = response.asString();
		System.out.println(jsonresponse);
	}
}

