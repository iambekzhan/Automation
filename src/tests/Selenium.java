package tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Telling to system to use chrome driver at the given path when trying to launch a browser
		System.setProperty("webdriver.chrome.driver", "/Users/iambekzhan/Documents/Selenium/Drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		String url = "http://cybertek-bnb.herokuapp.com/";
		driver.get(url);
		
		String title = driver.getTitle();
		if(title.equals("Intro | cybertek-bnb")) {
			System.out.println("Title verification is pass");
			System.out.println("Title: " + title);
		}else {
			System.out.println("Title verification is failed");
		}
		
		Random r = new Random();
		int a = r.nextInt(1000000);
		
		String firstName = "John";
		String lastName = "Wick";
		String email = "jw" + a +"@gmail.com";
		String password = "johnw234";
		
		String url1 = driver.getCurrentUrl();
		if(url.concat("intro").equals(url1)) {
			System.out.println("URL verification is pass");
			System.out.println("URL: " + url1);
		}else {
			System.out.println("URL verification is failed");
		}
		
		driver.findElement(By.linkText("sign up")).click();
		Thread.sleep(1000);
		
		WebElement fName = driver.findElement(By.name("first-name"));
		WebElement lName = driver.findElement(By.name("last-name"));
		WebElement emailElement = driver.findElement(By.name("email"));
		WebElement passElement = driver.findElement(By.name("password"));
		WebElement signup = driver.findElement(By.xpath("//button[.='sign up']"));
		
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		emailElement.sendKeys(email);
		passElement.sendKeys(password);
		signup.click();
		
		if(driver.getTitle().equals("Sing in | cybertek-bnb")) {
			System.out.println("Sign up successfully");
			System.out.println("Email: " + email);
		}else {
			System.out.println("Sign up failed");
		}
		
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[.='sign in']")).click();
		
		String loggedInTitle = driver.getTitle();
		if(loggedInTitle.equals("Map | cybertek-bnb")) {
			System.out.println("User signed in succesfully");
		}else {
			System.out.println("User sign in failed");
		}
		
		Thread.sleep(10000);
		driver.quit();
		
		
	}
}
