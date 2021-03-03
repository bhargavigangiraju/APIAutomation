package com.Signin.service;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import com.testBase.Endpoints;
import com.testBase.TestConfigProperties;
import com.testBase.Utilities;


public class SuccessLogin {

	@SuppressWarnings("unchecked")
	public Response LoginwithValidData() {
		//Request Payload 
		TestConfigProperties config=new TestConfigProperties();
	
		JSONObject JSONobj=new JSONObject();
		JSONobj.put("userName", config.getuserName());
		JSONobj.put("password", config.getpassWord());
		
		//Response 
		RequestSpecification res2=given().spec(Utilities.reqSpecBuild()).body(JSONobj.toString()).log().all();
		
		Response resp=res2.when().post(Endpoints.Login_User).then().log().all().spec(Utilities.resSpecBuild()).extract().response();
				
		 Headers header=resp.getHeaders();
		 System.out.println(header);
		 Header token=header.get("jwt_token");
		 return resp;
		 
		 
		 /*Code before optimization*/
		 
//            RestAssured.baseURI="http://34.98.107.19/bff/digeca/user";		
//		      Response res=given().contentType(ContentType.JSON)
//		      .body("{\r\n" + 
//		      		"    \"userName\": \"gangiraju.bhargavi@terralogic.com\",\r\n" + 
//		      		"    \"password\": \"TL@123\"\r\n" + 
//		      		"}").log().all().
//				when().post("/authenticateWithVertical").
//				then().assertThat().statusCode(200).extract().response();
//		      
//		      String res1=res.asString();
//		      System.out.println("Response is "+res1);
//		      
//		      Headers head=res.getHeaders();
//		      System.out.println("Hearders for the poSt call are "+head);
//		     System.out.println("JwtToken "+head.get("jwt_token"));
		     
	
		     
	}
}
