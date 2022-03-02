package com.restapi.cucumber.runner;

import org.testng.annotations.BeforeClass;

import com.restapi.helpers.UserServiceHelper;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.restassured.RestAssured;

@CucumberOptions(features = { "src/test/resources/AppFeatures" }, glue = { "com/restapi/cucumber/steps" }, plugin = { "pretty",
		"html:target/cucumber-reports/cucumber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = UserServiceHelper.getBaseURI();
	}

	
}
