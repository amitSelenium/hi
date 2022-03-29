package org.testngPrac;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest 
{
	@Test
	public void testGoogle()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("youtube",Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='yuRUbf']/a")).click();
		String originalTitle = driver.getTitle();
		String expectedTitle = "YouTube";
		Assert.assertEquals(originalTitle, expectedTitle);
		driver.quit();
	}
}
