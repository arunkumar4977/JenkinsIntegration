package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginStepDefinitions {
	
	 WebDriver driver = new ChromeDriver();

	@Given("User is on Login page {string}")
	public void user_is_on_login_page(String url) {
		System.out.println("URL: " + url);
	    driver.get(url);
	}

	@When("User enters username {string}")
	public void user_enters_username(String userName) {
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(userName);
	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	}

	@Then("Click on Login")
	public void click_on_login() {
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}

}
