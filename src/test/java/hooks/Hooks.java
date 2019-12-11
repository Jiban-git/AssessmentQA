package hooks;

import cucumber.api.java.After;
import supportLibraries.webdriverfactory;


public class Hooks {
	@After
	 public void teardown() {
		webdriverfactory.getwebdriverfactoyobj().driver.quit();
	 
	 }

}
