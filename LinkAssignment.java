package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkAssignment {
	
public static void main(String[] args) throws InterruptedException {
	
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leafground.com/pages/Link.html");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.findElement(By.partialLinkText("Go to Home Page")).click();
	String home = driver.getCurrentUrl();
	System.out.println("Home URL is :" + home);
	driver.navigate().back();
	
	// Find where I am supposed to go without clicking me
	
	WebElement link = driver.findElement(By.partialLinkText("Find where am supposed to go without clicking me?"));
	System.out.println(link.getAttribute("href"));
	
	// verify am I broken.
	
	driver.findElement(By.partialLinkText("Verify am I broken?")).click();
	String text = driver.getCurrentUrl();
	
	if(text == "HTTP Status 404 – Not Found")
	{
		System.out.println("URL is Broken");
	}
	driver.navigate().back();
	
	// Interact with same link name
			driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]"));
			String home1 = driver.getCurrentUrl();

			if (home.equals(home1)) {
				System.out.println("Both links are same");
			}
			driver.navigate().back();

			// How many links are available in thispage
			int size = driver.findElements(By.tagName("a")).size();
			System.out.println("The number of links are: " + size);
}
}
