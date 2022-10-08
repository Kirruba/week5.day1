package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MergeContact extends LeafBase {

	@Test
	public void runMergeContact() throws InterruptedException {

		// Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();

		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.linkText("Merge Contacts")).click();

		// Click on Widget of From Contact
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);

		// Click on First Resulting Contact
		driver.switchTo().window(windows.get(1));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='linktext']")).click();

		// Click on Widget of To Contact
		driver.switchTo().window(windows.get(0));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();

		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>(windowHandles1);

		// Click on Second Resulting Contact
		driver.switchTo().window(windows1.get(1));
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a[@class='linktext']"))
				.click();

		// Click on Merge button using Xpath Locator
		driver.switchTo().window(windows1.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		// Accept the Alert
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		alert.accept();

		// Verify the title of the page
		String title = driver.getTitle();
		System.out.println("The title is: " + title);
		if (title.contains("View Contact")) {
			System.out.println("Title for Merge Contact is verified");
		} else {
			System.out.println("Title for Merge Contact is not verified");
		}

	}

}
