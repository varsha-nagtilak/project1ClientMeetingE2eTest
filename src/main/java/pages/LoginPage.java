package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	String expectedURL="http://localhost:4200/home";
	String redirectURL="";
	WebElement webElement;
	private WebDriver wd;

	public LoginPage() {
		//register the vendor browser-webdriver
	    WebDriverManager.chromedriver().setup();
	    //create an object to the ref of the browser
	    wd =new ChromeDriver();
	    
	    //maximize the screen
	    wd.manage().window().maximize();
	}
	
	public void navigateTo() {
		wd.get("http://localhost:4200/login");
	}
	
	
	public void enterLoginDetails() {
		wd.findElement(By.xpath("//*[@id=\"email\"]"))
		.sendKeys("admin@gmail.com");
		wd.findElement(By.xpath("//*[@id=\"psw\"]"))
		.sendKeys("admin@123");
		wd.findElement(By.xpath("/html/body/app-root/main/div/app-login/div/form/button"))
		.click();
		redirectURL=wd.getCurrentUrl();
	}
	
	public boolean isUserLoggedIn() throws InterruptedException {
		Thread.sleep(500);
		webElement = wd.findElement(By.linkText("Home"));
		if(webElement != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void closeBrowser() {
		wd.quit();
	}
	
}
