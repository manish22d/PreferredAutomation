package com.travel.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/com/travel/features"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = {"com.travel.stepdef"},
        tags = "@HomePageContact")
public class TestRunner extends AbstractTestNGCucumberTests {


}
