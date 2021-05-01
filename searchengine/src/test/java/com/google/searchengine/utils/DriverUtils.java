package com.google.searchengine.utils;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class DriverUtils {
	
	public static WebDriver driver;
	
	public static void startDriverConfiguration() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	public static WebElement waitElementToLoad(final By by, int waitTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(waitTime))
				.pollingEvery(Duration.ofMillis(100))
				.ignoring(NoSuchElementException.class);
		
		WebElement pageElement = wait.until(new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
			
		});
		
		return pageElement;
		
	}
	
	
}
