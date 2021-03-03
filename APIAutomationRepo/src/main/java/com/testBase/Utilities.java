package com.testBase;

import org.json.simple.JSONObject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utilities {
	
	public static RequestSpecification reqSpecBuild() {
		
		TestConfigProperties config=new TestConfigProperties();
		
		RequestSpecification request=new RequestSpecBuilder().setBaseUri(config.getBaseURI()).
		setContentType(ContentType.JSON).build();
		return request;
	}
	
	public static ResponseSpecification resSpecBuild() {
		ResponseSpecification response=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		return response;
	}
	
	public static JsonPath rawToJson(Response res) {
		String resp=res.asString();
		JsonPath js=new JsonPath(resp);
		return js;
	}
	public JSONObject payLoad(){
		JSONObject js=new JSONObject();
		js.put("key", "value");
		return js;
	}
}
