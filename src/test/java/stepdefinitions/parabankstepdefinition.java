package stepdefinitions;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverManager;

public class parabankstepdefinition {
	
	//public WebDriver driver;
	
	
	@Given("user navigating to login page")
	public void user_navigating_to_login_page() {
		
		DriverManager.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		DriverManager.getDriver().manage().window().maximize();
	   System.out.println("Launched");
	}

	@When("user should enter username and password")
	public void user_should_enter_username_and_password() {
		DriverManager.getDriver() .findElement(By.xpath("//input[@name='username']")).sendKeys("Token");
		DriverManager.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("Token@1223");
	}

	@When("click on login button")
	public void click_on_login_button() {
		DriverManager.getDriver().findElement(By.xpath("//input[@type='submit']")).submit();
		System.out.println("Clikced Login button");
	}

	@Then("User should login successfully and navigate to home page")
	public void user_should_login_successfully_and_navigate_to_home_page() {
		
		String ActTitle;
		ActTitle = DriverManager.getDriver().getTitle();
		System.out.println(ActTitle);
		String ExpTile="ParaBank | Accounts Overviews";
		if((ExpTile.equals(ActTitle))) {
			System.out.println("Logged in successfully");
		}else
			System.out.println("Failed");
		System.out.println("Execution completed");
	
	}
	@When("Click on Account Overview button")
	public void click_on_account_overview_button() {
		DriverManager.getDriver().findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a")).click();
	}

	@Then("user able to see accounts overview")
	public void user_able_to_see_accounts_overview() {
	   String ExpTitle;
	   ExpTitle=DriverManager.getDriver().getTitle();
	   System.out.println(ExpTitle);
	  
	}
	
	@When("CLick on Open new Account")
	public void c_lick_on_open_new_account() {
		DriverManager.getDriver().findElement(By.xpath("//*[@id='leftPanel']/ul/li/a")).click();
	}

	@When("Select Savings account from dropdown")
	public void select_savings_account_from_dropdown() {
	   WebElement SavingsAccntDrpdwn= DriverManager.getDriver().findElement(By.id("type"));
	   Select sel = new Select(SavingsAccntDrpdwn);
	   sel.selectByContainsVisibleText("SAVINGS");
	}

	@When("Select exiating account from dropdown")
	public void select_exiating_account_from_dropdown() {
	    WebElement selectexistingaccount = DriverManager.getDriver().findElement(By.xpath("//*[@id='fromAccountId']"));
	    Select sel = new Select(selectexistingaccount);
	    
	    sel.getFirstSelectedOption();
	}

	@When("Click on create new account button")
	public void click_on_create_new_account_button() {
		DriverManager.getDriver().findElement(By.xpath("//*[@id=\"openAccountForm\"]/form/div/input")).click();
	}

	@Then("Account should be created and Account no should be displayed")
	public void account_should_be_created_and_account_no_should_be_displayed() {
	   String expectedString ="Congratulations, your account is now open.";
	   WebElement successmsg = DriverManager.getDriver().findElement(By.xpath("//*[@id='openAccountResult']/p"));
	   if(expectedString.equals(successmsg)) {
		   System.out.println("Account Created Successfully");
	   }else
		   System.out.println("Error");
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
	    DriverManager.getDriver().close();
	}

	
}
