package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteLead extends LeafBase {

	@Test
	public void runDeleteLead() throws InterruptedException {

		// Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		// Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		// Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9876543210");

		// Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// Capture lead ID of First Resulting lead
		Thread.sleep(10000);
		String text = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();
		System.out.println("The Lead ID of First Resulting lead is:" + text);

		// Click First Resulting lead
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		// Click Delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Leads']")).click();

		// Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		// Enter captured lead ID
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input")).sendKeys(text);

		// Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// Verify message "No records to display" in the Lead List. This message
		// confirms the successful deletion
		Thread.sleep(10000);
		String text2 = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();

		if (text2.equalsIgnoreCase("No records to display")) {
			System.out.println("Deletion of a First Resulting lead is successful");
		} else {
			System.out.println("Deletion of a First Resulting lead is not successful");
		}
	}

}
