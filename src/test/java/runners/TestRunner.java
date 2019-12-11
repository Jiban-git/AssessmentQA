package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue = {"stepDefinitions"},
		plugin = {"pretty","html:test-output", "com.cucumber.listener.ExtentCucumberFormatter:target\\cucumber-reports\\report.html"},
		monochrome = true
		
		)


public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("configs/extent-config.xml"));
	}

	
}
