package com.restapi.cucumber.steps;

import static org.hamcrest.CoreMatchers.containsString;

import org.testng.Assert;

import com.restapi.helpers.ReusableMethod;
import com.restapi.helpers.UserServiceHelper;
import com.restapi.models.UserVO;
import com.restapi.utility.GetValueObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class AddUserStepDef extends UserServiceHelper {
	@Given("user has to login with working endpoint")
	public void user_has_to_login_with_working_endpoint() {
		
		Response res = LoginToApplication();
		res.then().statusCode(201);
	}

	@When("user data is populated")
	public void data_is_populated() {
		user = GetValueObjects.getUser();
	}

	@When("user added with working endpoint")
	public void user_added_with_working_endpoint() {
		Response res = addUser();
		res.then().statusCode(201);
		res.then().body(containsString("success"));
	}

	@Then("check last added record is the user")
	public void check_last_added_record_is() {
		UserVO u= ReusableMethod.getUserFromResponse();
		Assert.assertEquals(u.getAccountno(), user.getAccountno());
	}
}
