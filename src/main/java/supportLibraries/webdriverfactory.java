package supportLibraries;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class webdriverfactory {
	
	public static WebDriver driver;
	public static NgWebDriver ngDriver;
	private static webdriverfactory webdriverfactoryobj=null;
	String chromedriverpath=System.getProperty("user.dir")+"\\chromedriver.exe";
	
	private webdriverfactory()
	{
		System.setProperty("webdriver.chrome.driver",chromedriverpath);
		driver= new ChromeDriver();
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		ngDriver = new NgWebDriver(jsDriver);
	}
	
	public static webdriverfactory getwebdriverfactoyobj()
	{
		
		if(webdriverfactoryobj==null) {
			webdriverfactoryobj=new webdriverfactory();
		}
		return webdriverfactoryobj;
		
	}

}
