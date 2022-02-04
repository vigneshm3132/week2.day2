package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTitleAssignment {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		//driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//driver.findElement(By.partialLinkText("Login")).click();
		
		String title = driver.getTitle();
		System.out.println("Page Title is:" + title);
		
		driver.findElement(By.partialLinkText("Log Out")).click();
				
	}
}
