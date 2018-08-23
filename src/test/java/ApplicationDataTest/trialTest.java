package ApplicationDataTest;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;

import DataVariable.DataVariableRequest;

public class trialTest {
	public static Response responseWhen;
	public Response responseThen;
	public static void main(String args []){
				  
	String BaseURL= "http//s:whatever " ; 
					  responseWhen = given().contentType(com.jayway.restassured.http.ContentType.JSON)
		             .headers("Authorization"," abvmypassword" )
		             .when()
		             .get(BaseURL)
		             .then()
					.statusCode(200)
					.extract()
					.response();
					
	}
	
}
