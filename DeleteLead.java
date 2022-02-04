package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoCSR");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
	
	driver.findElement(By.xpath("//a[@href= '/crmsfa/control/findLeads']")).click();
	driver.findElement(By.linkText("Phone")).click();
	driver.findElement(By.name("phoneNumber")).sendKeys("9962141715");
	driver.findElement(By.xpath("//button[text() ='Find Leads']")).click();
	Thread.sleep(2000);
	
	//Capture lead ID of First Resulting lead
	//Click First Resulting lead
	
	WebElement id = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]"));
	String text = id.getText();
	id.click();
	
	Thread.sleep(2000);
	
	//Click Delete
	driver.findElement(By.className("subMenuButtonDangerous")).click();	
	
	//Click Find leads
	
	driver.findElement(By.xpath("//a[@href= '/crmsfa/control/findLeads']")).click();
	//Enter captured lead ID
	driver.findElement(By.linkText("Phone")).click();
	driver.findElement(By.name("phoneNumber")).sendKeys("9962141715");
	driver.findElement(By.xpath("//button[text() ='Find Leads']")).click();
			//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
	WebElement display = driver.findElement(By.xpath("//div[text()='No records to display']"));
			
			if (display.isDisplayed() == true) {
				System.out.println("No Records to display");
			}
			//Close the browser
			driver.close();
}
}
