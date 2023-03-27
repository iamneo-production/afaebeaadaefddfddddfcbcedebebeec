package com.example;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ChromeDriver driver;
        String url = "http://www.snapdeal.com";
        ChromeOptions option = new ChromeOptions();
	      option.addArguments("--remote-allow-origins=*");

	      WebDriverManager.chromedriver().setup();
	      
		 driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		driver.get(url);
        WebElement clickable = driver.findElement(By.xpath("//span[text()='Sign In']"));
         new Actions(driver)
                 .clickAndHold(clickable)
                 .perform();
                 driver.findElement(By.xpath("//a[text()='login']")).click();
                 WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='loginIframe']"));
                 driver.switchTo().frame(iframeElement);
                 driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("aakashmourya987321@gmail.com");
                 driver.findElement(By.xpath("//button[@id='checkUser']")).click();
    }
}
