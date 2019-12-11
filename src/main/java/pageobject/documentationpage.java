package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class documentationpage {

	public documentationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);//take driver instance of the given class and class type
	}
	
	
	
	@FindBy(xpath="*//a[contains(@href,'/documentation')]")

	public List<WebElement> internalLinks;
	

}
