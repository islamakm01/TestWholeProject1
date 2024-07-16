package Excersises;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MAPS1 {

	WebDriver driver;
	Properties prop;

	@BeforeClass
	public void initialization() throws InterruptedException, IOException {
		driver = new ChromeDriver();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Properties\\Config.properties");
		
		prop = new Properties();
		
		prop.load(fis);

		driver.get(prop.getProperty("MAPS_Dvalid"));
		driver.manage().window().maximize();

		Thread.sleep(3000);

		WebElement username = driver.findElement(By.id(prop.getProperty("UserName_URL")));
		username.sendKeys(prop.getProperty("username"));
		WebElement password = driver.findElement(By.xpath(prop.getProperty("Password_URL")));
		password.sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath(prop.getProperty("submit"))).click();
		System.out.println(driver.getTitle());

		Thread.sleep(15000);

		// Select Business Group
		WebElement openAccountPanel = driver.findElement(By.id(prop.getProperty("openAccountPanel")));
		openAccountPanel.isEnabled();
		openAccountPanel.click();
		WebElement businessGroup = driver.findElement(By.xpath(prop.getProperty("businessGroup")));

		Select select = new Select(businessGroup);
		select.selectByIndex(0);

		openAccountPanel.click();
	}

	@Test
	public void test2087() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("searchpanel"))).click();

		WebElement searchType = driver.findElement(By.xpath(prop.getProperty("searchType")));
		Select searchTypeSelect = new Select(searchType);
		Thread.sleep(5000);
		searchTypeSelect.selectByIndex(2);

		// add Filters
		Thread.sleep(5000);
		driver.findElement(By.id(prop.getProperty("add_filter"))).click();

		// Add Color Option and Operating Unit Filter
		WebElement colorOption = driver.findElement(By.xpath(prop.getProperty("colorOption")));
		colorOption.click();

		Thread.sleep(5000);
		WebElement operatingUnit = driver.findElement(By.xpath(prop.getProperty("operatingUnit")));
		operatingUnit.click();

		driver.findElement(By.xpath(prop.getProperty("add"))).click();

		//
		WebElement colorFilter = driver.findElement(By.xpath(prop.getProperty("colorFilter")));

		Thread.sleep(3000);
		Select sel1 = new Select(colorFilter);
		sel1.selectByValue("2");

		WebElement operatingUnitFilter = driver
				.findElement(By.xpath(prop.getProperty("operatingUnitFilter")));

		Select sel2 = new Select(operatingUnitFilter);
		Thread.sleep(5000);
		sel2.selectByValue("19");

		// Click search
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("click_search"))).click();

		Thread.sleep(7000);

		// Click Select Columns
		driver.findElement(By.xpath(prop.getProperty("column_select"))).click();

		// Click Select all Columns
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("select_all_columns"))).click();

		// Click Select all Columns
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("select_all_columns"))).click();

		// Select Color option column
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("color_option_column"))).click();

		// Select Operating Unit column
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("operating_unit_column"))).click();

		// Click ok
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("click_ok"))).click();

		// changed to wait 2000----------------------------------------------testing

		// ========================test 1 =======================================
		// Sort on Color option column
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("sort_color_option"))).click();

		// Click on the first row
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("click_first_row"))).click();

		// Click on the color meta data
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("color_metadata"))).click();

		// Sort on Color option column
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("sort_color_option"))).click();

		// Click on the first row
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("click_first_row"))).click();

		// Click on the color meta data
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("color_metadata"))).click();

		// ========================test 2 =======================================
		// Sort on Operating Unit column
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("sort_operating_unit"))).click();

		// Click on the first row
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("click_first_row_CAS"))).click();

		// Click on the CAS meta data
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("CAS_metadata"))).click();

		// Sort on Operating Unit column
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("sort_operating_unit"))).click();

		// Click on the first row
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("click_first_row_CAS"))).click();

		// Click on the CAS meta data
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("CAS_metadata"))).click();

	}

	@AfterClass
	public void cleanup() {
		// driver.quit();
	}

}
