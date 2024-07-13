package com.test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElementList {
	
	WebDriver driver;

	@BeforeClass
	public void Initalization() throws InterruptedException {
		  driver = new ChromeDriver();
		driver.get("https://www.amazon.in");

		driver.manage().window().maximize(); // nested concept
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
	}

	@Test(priority=1)
	public void MouseHovering() throws InterruptedException {

		WebElement accountLists = driver.findElement(By.xpath("//span[text()='Account & Lists']"));

		Actions action = new Actions(driver);
		action.moveToElement(accountLists).perform();

		List<WebElement> lists = driver
				.findElements(By.xpath("//div[@class='nav-title']|//a[@class='nav-link nav-item']"));
		Thread.sleep(2000);
		for (WebElement list : lists) {
			System.out.println(list.getText());
		}

	}

	@Test(priority=2)
	public void DropDown() {

		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(dropdown);

		sel.selectByIndex(3);// Low priority

		sel.selectByValue("search-alias=mobile-apps"); // medium Priority

		sel.selectByVisibleText("Computers & Accessories"); // High Priority

		List<WebElement> li = sel.getOptions();

		System.out.println(li.size());

		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i).getText());

		}

	}

	@AfterClass
	public void cleanUp() {
		driver.quit();
	}
}
