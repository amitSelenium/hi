package org.testngPrac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrm
{
	WebDriver driver;
	
	@BeforeMethod
	public void initialseBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void launchBrowser()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void enteringLoginDetails()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123 ");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test
	public void verifyingLoginDetails()
	{
		driver.findElement(By.xpath("//div[@class='head']/h1")).isDisplayed();
	}

	@Test
	public void navigateToMyInfo()
	{
		driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
	}
	
	@Test
	public void varifyingMyInfo()
	{
		driver.findElement(By.xpath("//div[@class='box pimPane' and id='employee-details']")).isDisplayed();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
