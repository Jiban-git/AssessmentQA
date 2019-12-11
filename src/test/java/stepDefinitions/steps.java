package stepDefinitions;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.NgWebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import junit.framework.Assert;
import pageobject.documentationpage;

import supportLibraries.webdriverfactory;

public class steps  {
	WebDriver driver=webdriverfactory.getwebdriverfactoyobj().driver;
	NgWebDriver ngDriver=webdriverfactory.getwebdriverfactoyobj().ngDriver;
	List<WebElement> allinternalLinks=new ArrayList<WebElement>();
	List<String>  urls=new ArrayList<String>();
		
//	WebDriver driver=getwebdriver("chrome");
	
	documentationpage documentationpageobj=new documentationpage(driver);
	
	
	
	

@Given("^I have landed  on developer documentaion$")
public void i_have_logged_in_to_google() throws Throwable {
	
	
    driver.get("https://developer.here.com/documentation");
    ngDriver.waitForAngularRequestsToFinish();
    
    jsWaitForPageToLoad(10);
    
   
    
}


@Given("^I have all the internal links available from the page$")
public void i_have_all_the_internal_links_available_from_the_page() throws Throwable {
    
	allinternalLinks=documentationpageobj.internalLinks;
	for(WebElement link:allinternalLinks )
	{   
		urls.add(link.getAttribute("href"));
		
	}
  
    
}

@Then("^I should get response code of each link as TwoHundred$")
public void i_should_get_response_code_of_each_link_as() throws Throwable {
	SoftAssertions softassert=new SoftAssertions();
	int response=0;
    for(String url:urls)
    {
    	
        if(url == null || url.isEmpty()){
        System.out.println("URL is either not configured for anchor tag or it is empty");
            continue;
        }
        
        response=RestAssured.given().when().get(url).getStatusCode();
        if(response==200)
        {
        	
        	System.out.println("url got 200 response >>>>"+url);
        }
        
        else
        {
        	System.out.println("url got "+response+"response code  >>>>"+url);
        	softassert.fail("url got "+response+"response code  >>>>"+url);
        }
        
    }
    softassert.assertAll();
    
}

@Then("^For each link page should be loaded and angular should be initialized$")
public void for_each_link_page_should_be_loaded() throws Throwable {
    
	for(String url:urls)
	{
		driver.get(url);
		ngDriver.waitForAngularRequestsToFinish();
		jsWaitForPageToLoad(10);
	}
    
}

//@Then("^For each page angular is initialized$")
//public void for_each_page_angular_is_initialized() throws Throwable {
//	ngDriver.waitForAngularRequestsToFinish();
//    
//}

public void jsWaitForPageToLoad(int timeOutInSeconds) throws Exception {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String jsCommand = "return document.readyState";

    // Validate readyState before doing any waits
    if (js.executeScript(jsCommand).toString().equals("complete")) {
        return;
    }

    for (int i = 0; i < timeOutInSeconds; i++) {
        Thread.sleep(1000);
        if (js.executeScript(jsCommand).toString().equals("complete")) {
            break;
        }
        else {
        	throw new TimeoutException();
        }
    }
}

}
