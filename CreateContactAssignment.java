package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactAssignment {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoCSR");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/contactsMain']")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/createContactForm']")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Vignesh");
		driver.findElement(By.id("lastNameField")).sendKeys("Munusamy");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("localVignesh");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("localMunusamy");
		driver.findElement(By.name("departmentName")).sendKeys("QA");
		driver.findElement(By.name("description")).sendKeys("Quality Analysis Test Automation");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("vignesh@example.com");
		
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd1 = new Select(state);
		dd1.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(2000);
		
	
		driver.findElement(By.partialLinkText("Edit")).click();
		
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("NewUpdates");
		driver.findElement(By.xpath("//input[@name= 'submitButton']")).click();
		
		String title = driver.getTitle();
		System.out.println("Page Title is:" + title);
		
		
		
		
	}
}
