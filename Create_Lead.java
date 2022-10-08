package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Create_Lead extends LeafBase {

	@Test
	public void runCreate_Lead() {

		// Click on Create Lead
		driver.findElement(By.linkText("Create Lead")).click();

		// Enter CompanyName Field Using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");

		// Enter FirstName Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kirruba Lakshmi");

		// Enter LastName Field Using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S P");

		// Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Kirruba");

		// Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");

		// Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Selenium Automation");

		// Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abctesting@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9876543210");

		// Select State/Province as NewYork Using Visible Text
		WebElement source = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd = new Select(source);
		dd.selectByVisibleText("New York");

		// Click on Create Button
		driver.findElement(By.className("smallSubmit")).click();

		// Get the Title of Resulting Page. refer the video using driver.getTitle()
		System.out.println("The title for Creat Lead is " + driver.getTitle());

	}

}
