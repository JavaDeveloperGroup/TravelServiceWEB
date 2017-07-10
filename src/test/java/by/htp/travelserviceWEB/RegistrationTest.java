package by.htp.travelserviceWEB;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {
	
	protected WebDriver driver;
	
	@Test
	public void userCreateNewAccount() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\popo\\.m2\\repository\\org\\seleniumhq\\selenium\\SeleniumGecko\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/travelservice/");
		clickNameElement("sign_up");
		
		inputData("Sergeo", "Parkhanovich", "Dubina", "qwerty1Q@", "qwerty1Q@", "09101990", "AT1234567", "parkh@mail.ru", "+37529222222");
		
		clickIdElement("go");
		clickNameElement("log_out");
		
		//incorrect password
		inputData("Sergeo", "Parkhanovich", "Dubina", "qwertyQ@", "qwerty1Q@", "09101990", "AT1234567", "parkh@mail.ru", "+37529222222");
		
		clickIdElement("go");
		clickNameElement("log_out");
	
	}
	
	public void clickNameElement(String nameElement) {
		driver.findElement(By.name(nameElement)).click();
	}
	
	public void clickIdElement(String nameElement) {
		driver.findElement(By.id(nameElement)).click();
	}
	
	public void inputData(String name, String surname, String login, String password, String passwordRepeat, String birthday, String passport, String email, String phone) {
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("surname")).sendKeys(surname);
		driver.findElement(By.id("login")).sendKeys(login);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("password_repeat")).sendKeys(passwordRepeat);
		driver.findElement(By.id("birthday")).sendKeys(birthday);
		driver.findElement(By.id("passport")).sendKeys(passport);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("phone")).sendKeys(phone);	
	}

}
