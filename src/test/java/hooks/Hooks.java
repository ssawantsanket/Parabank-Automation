package hooks;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {
	@Before
    public void setup() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }
	@After
	 public void tearDown() {
	        DriverManager.getDriver().quit();
	        DriverManager.unload();
	    }
}
