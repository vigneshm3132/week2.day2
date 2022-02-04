package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditBtnAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// Complete all the 5 activities in Edit Page:
		// http://leafground.com/pages/Edit.html
		
		//Enter your email address
		
		//driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("email");
		
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("abc1@example.com");
		
		//Append a text and press keyboard tab
		
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("Appended Text");
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys(Keys.TAB);
		
		//Thread.sleep(2000);
		
		//Get default text entered
		
		WebElement text = driver.findElement(By.xpath("//input[@value='TestLeaf']"));
		String enter = text.getAttribute("value");
		System.out.println("Default text is:" +enter);
		
		//clear the text
		
		WebElement clear = driver.findElement(By.xpath("//input[@value='Clear me!!']"));
		clear.clear();
		
		//Confirm that edit field is disabled
		WebElement disable = driver.findElement(By.xpath("//input[@disabled='true']"));
		boolean actualValue = disable.isEnabled();
		
		if (actualValue) {
			System.out.println("Button is enabled");
		} else {
			System.out.println("Button is not enabled");
		}
			
		
				
		
	}
}
