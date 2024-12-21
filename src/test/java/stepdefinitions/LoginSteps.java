package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
	String expectedURL="http://localhost:4200/home";
	private LoginPage loginPageEl = new LoginPage();
	
	@Given("the user is on login page")
	public void navigateTopage() {
		loginPageEl.navigateTo();
	}
	@When("the user enters the login detais and click on the Login button")
	public void enterdetails() {
		loginPageEl.enterLoginDetails();
	}
	@Then("user should redirect to home page")
	public void loggedinsuccessfully() throws InterruptedException {
		assertTrue(loginPageEl.isUserLoggedIn());
		loginPageEl.closeBrowser();
	}
}
