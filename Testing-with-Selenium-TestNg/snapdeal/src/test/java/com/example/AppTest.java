package com.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Unit test for simple App.
 */
public class AppTest 
   
{
    ChromeDriver driver;
	String url = "http://www.snapdeal.com";
	@BeforeClass
	public void invokeBrowser(){
		
		
		ChromeOptions option = new ChromeOptions();
	      option.addArguments("--remote-allow-origins=*");

	      WebDriverManager.chromedriver().setup();
	      
		 driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		driver.get(url);
		 //Cell Phones & Accessoriesn
	}
	
	@Test(priority=1)
    public void moveAndHold() {
    	 WebElement clickable = driver.findElement(By.xpath("//span[text()='Sign In']"));
         new Actions(driver)
                 .clickAndHold(clickable)
                 .perform();
    }
	@Test(priority=2)
    public void login() {
    	
		 WebElement clickable =driver.findElement(By.xpath("//span[text()='Sign In']"));
		new Actions(driver)
        .clickAndHold(clickable)
        .perform();
    	driver.findElement(By.xpath("//a[text()='login']")).click();
    	WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='loginIframe']"));
    	driver.switchTo().frame(iframeElement);
    	driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("aakashmourya987321@gmail.com");
    	driver.findElement(By.xpath("//button[@id='checkUser']")).click();
    	
    }
    @AfterClass
	public void closeBrowser(){
		
		driver.quit();
		
	}

}
