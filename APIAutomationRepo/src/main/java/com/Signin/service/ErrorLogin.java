package com.Signin.service;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import com.testBase.Endpoints;
import com.testBase.TestConfigProperties;
import com.testBase.Utilities;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ErrorLogin {
	
        @SuppressWarnings("unchecked")
		public Response LoginWithInvalidData() {
		
        	JSONObject js=new JSONObject();
        	TestConfigProperties config=new TestConfigProperties();
        	js.put("userName", config.getuserName());
    		js.put("password", config.getInvalidpassWord());
        			
		    RequestSpecification res3=given().spec(Utilities.reqSpecBuild()).
		    		body(js.toString()).log().all();
		    Response res=res3.when().post(Endpoints.Login_User).then().log().all()
		    		.spec(Utilities.resSpecBuild()).extract().response();
			return res;
		     
	}
}
