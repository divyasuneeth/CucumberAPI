package com.restapi.cucumber.steps;

import static org.hamcrest.CoreMatchers.containsString;

import org.hamcrest.Matchers;
import org.testng.Assert;

import com.restapi.helpers.ReusableMethod;
import com.restapi.helpers.UserServiceHelper;
import com.restapi.models.UserVO;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class UpdateUserStepDef extends UserServiceHelper {
	@When("user salary is set to {int}")
	public void user_data_is_changed(Integer int1) {
		user = getUser();
		user.setSalary(int1.toString());
		
		

	}

	@When("user is updated with working endpoint")
	public void updated_with_working_endpoint() {
		Response res = updateUser();
		res.then().statusCode(200);
		res.then().time(Matchers.lessThan(3000L));
		res.then().body(containsString("success"));
	}

	@Then("check salary is updated to {int}")
	public void check_salary_is_updated(Integer int1) {
		UserVO u = ReusableMethod.getUserFromResponse();
		Assert.assertEquals(u.getSalary(), int1.toString());
	}
}
