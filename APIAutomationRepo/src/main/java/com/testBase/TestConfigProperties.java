package com.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.util.Properties;

import com.Signin.service.SuccessLogin;

import io.restassured.http.Header;

public class TestConfigProperties {
	
	private Properties prop;
	private final String PROPERTIES_FILE_PATH = "/src/main/java/resources/config.properties";
	
	SuccessLogin s= new SuccessLogin();
	public TestConfigProperties() {

		File file = new File(System.getProperty("user.dir")+PROPERTIES_FILE_PATH);
		FileInputStream fis = null;
		try {
			prop = new Properties();
			fis = new FileInputStream(file);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public String getBaseURI() {
		String baseURI = prop.getProperty("baseURI");
		return baseURI;
	}
	
	public String getuserName() {
		String username=prop.getProperty("userName");
        return username;
	}
	
	public String getpassWord() {
		String password=prop.getProperty("password");
        return password;
	}
	public String getInvalidpassWord() {
		String password=prop.getProperty("Invalidpassword");
        return password;
	}
}

