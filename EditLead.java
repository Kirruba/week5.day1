package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EditLead extends LeafBase {

	@Test(dependsOnMethods = "week5.day1.Create_Lead.runCreate_Lead")
	public void runEditLead() throws InterruptedException {

		// Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		// Enter first name
		driver.findElement(By.xpath("//div[@class='x-tab-panel-body x-tab-panel-body-top']//input[@name='firstName']"))
				.sendKeys("Kirruba");

		// Click Find leads button
		driver.findElement(By.xpath("//div[@class='x-panel-footer x-panel-footer-noborder']//button")).click();

		// Click on first resulting lead
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		// Verify title of the page
		String oldtitle = driver.getTitle();
		String newtitle = "View Lead | opentaps CRM";

		if (oldtitle.equalsIgnoreCase(newtitle)) {
			System.out.println("The title for Edit Lead is verified successfully");
		} else {
			System.out.println("The title for Edit Lead is not verified successfully");
		}

		// Click Edit
		driver.findElement(By.linkText("Edit")).click();

		// Change the company name
		WebElement findElement = driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']"));
		findElement.clear();
		findElement.sendKeys("TestLeaf");

		// Click Update
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

		// Confirm the changed name appears
		String changeName = driver.findElement(By.xpath("//span[contains(text(),'TestLeaf')]")).getText();

		if (changeName.contains("TestLeaf"))

		{
			System.out.println("Company Name is verified successfully");
		} else {
			System.out.println("Company Name is not updated successfully");
		}

	}

}
