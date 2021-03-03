package SignInTest;

import org.testng.annotations.Test;

import com.Signin.service.ErrorLogin;
import com.Signin.service.SuccessLogin;
import com.testBase.Utilities;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class LoginValidation {

	@Test(priority = 1,description = "To verify Successfull User login with Valid credentials")
	public void VerifyLogin() {
		
		SuccessLogin s=new SuccessLogin();		
		Response suc_res=s.LoginwithValidData();
		
	   JsonPath js=Utilities.rawToJson(suc_res);
	   Assert.assertEquals(js.get("name"), "Bhargavi");
	   Assert.assertEquals(suc_res.getStatusCode(), 200);
	   
	}
	
	@Test(priority = 2,description = "To verify Error on User login with Invalid credentials")
	public void verifyErrorLogin() {
		
		ErrorLogin e=new ErrorLogin();
		Response err_res=e.LoginWithInvalidData();
		
		JsonPath js=Utilities.rawToJson(err_res);
		Assert.assertEquals(err_res.getStatusCode(), 400);
		Assert.assertEquals(js.get("message"), "Received non success response code");
		
	}
}
