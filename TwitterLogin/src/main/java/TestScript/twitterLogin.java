package TestScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class twitterLogin {
	WebDriver driver;

	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void loginTest() {
		driver.get("https://twitter.com/login");

		// Waiting for login page to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("text")));

		// Send email or phone number in Phone,email or username field
		WebElement userName = driver.findElement(By.name("text"));

		userName.clear();
		userName.click();
		userName.sendKeys("shoboh7@gmail.com");// enter your email, phone or username

		// click on Next button
		WebElement nextButton = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton.click();

		// Waiting for password field
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));

		// Send password in Password field
		WebElement passwordField = driver.findElement(By.name("password"));

		passwordField.clear();
		passwordField.click();
		passwordField.sendKeys("12345678"); //enter your password
		
		
		//Click on login button
		WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
		loginButton.click();

		//Validate home page url
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1//a[contains(@href,'/home')]")));
		String title = driver.getCurrentUrl();
		
		System.out.print(title);
		Assert.assertEquals(title,"https://twitter.com/home","Home page not found");
		

	}

	public static void main(String[] args) {
		twitterLogin twitterLogin = new twitterLogin();
		twitterLogin.setup();
		twitterLogin.loginTest();
		// If you want to close the browser, uncomment the line below.
		//twitterLogin.driver.quit();

	}

}
