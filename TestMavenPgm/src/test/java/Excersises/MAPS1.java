package Excersises;

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

	@BeforeClass
	public void initialization() throws InterruptedException {
		driver = new ChromeDriver();

		driver.get("https://mapsdvalid.pace.medtronic.com/");
		driver.manage().window().maximize();

		Thread.sleep(3000);

		WebElement username = driver.findElement(By.id("gwt-uid-2"));
		username.sendKeys("ylvisc1");
		WebElement password = driver.findElement(By.xpath("//input[@class='gwt-PasswordTextBox']"));
		password.sendKeys("xrccd59");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		System.out.println(driver.getTitle());

		Thread.sleep(15000);

		// Select Business Group
		WebElement openAccountPanel = driver.findElement(By.id("Open account panel"));
		openAccountPanel.isEnabled();
		openAccountPanel.click();
		WebElement businessGroup = driver.findElement(By.xpath("(//select[@class='gwt-ListBox browser-default'])[1]"));

		Select select = new Select(businessGroup);
		select.selectByIndex(0);

		openAccountPanel.click();
	}

	@Test
	public void test2087() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='Open search panel']")).click();

		WebElement searchType = driver.findElement(By.xpath("(//select[@class='gwt-ListBox browser-default'])[1]"));
		Select searchTypeSelect = new Select(searchType);
		Thread.sleep(5000);
		searchTypeSelect.selectByIndex(2);

		// add Filters
		Thread.sleep(5000);
		driver.findElement(By.id("add_filter")).click();

		// Add Color Option and Operating Unit Filter
		WebElement colorOption = driver.findElement(By.xpath("//tr[td[div[div[text()='Color option']]]]//label"));
		colorOption.click();

		Thread.sleep(5000);
		WebElement operatingUnit = driver.findElement(By.xpath("//tr[td[div[div[text()='Operating unit']]]]//label"));
		operatingUnit.click();

		driver.findElement(By.xpath("//span[text()='Add']")).click();

		//
		WebElement colorFilter = driver.findElement(By.xpath("(//select[@class='gwt-ListBox browser-default'])[3]"));

		Thread.sleep(3000);
		Select sel1 = new Select(colorFilter);
		sel1.selectByValue("2");

		WebElement operatingUnitFilter = driver
				.findElement(By.xpath("(//select[@class='gwt-ListBox browser-default'])[5]"));

		Select sel2 = new Select(operatingUnitFilter);
		Thread.sleep(5000);
		sel2.selectByValue("19");

		// Click search
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Search']")).click();

		Thread.sleep(7000);

		// Click Select Columns
		driver.findElement(By.xpath("(//i[@id='Column Selector'])[1]")).click();

		// Click Select all Columns
		Thread.sleep(2000);
		driver.findElement(By.xpath("//th[@id='col0']//label")).click();

		// Click Select all Columns
		Thread.sleep(2000);
		driver.findElement(By.xpath("//th[@id='col0']//label")).click();

		// Select Color option column
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Color option']")).click();

		// Select Color option column
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Operating unit']")).click();

		// Click ok
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='OK']")).click();

		// changed to wait 2000----------------------------------------------testing

		// ========================test 1 =======================================
		// Click on Color option column
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[span[text()='Color option']])[1]")).click();

		// Click on the first row
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='color'])[1]")).click();

		// Click on the color meta data
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='color']")).click();

		// Click on Color option column
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[span[text()='Color option']])[1]")).click();

		// Click on the first row
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='color'])[1]")).click();

		// Click on the color meta data
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='color']")).click();

		// ========================test 2 =======================================
		// Click on Operating Unit column
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[span[text()='Operating unit']])[1]")).click();

		// Click on the first row
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='CAS'])[1]")).click();

		// Click on the CAS meta data
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='CAS']")).click();

		// Click on Operating Unit column
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[span[text()='Operating unit']])[1]")).click();

		// Click on the first row
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[text()='CAS'])[1]")).click();

		// Click on the CAS meta data
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='CAS']")).click();

	}

	@AfterClass
	public void cleanup() {
		// driver.quit();
	}

}
