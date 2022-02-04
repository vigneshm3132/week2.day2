package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Go to Home Page
		driver.findElement(By.id("home")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='images/button.png']")).click();
		Thread.sleep(2000);
		
		//Button Colour
		WebElement colour = driver.findElement(By.xpath("//button[@id ='color']"));
		String find = colour.getCssValue("background-color");
		System.out.println("Button Colour is :"+ find);
		
		//Button Text
		WebElement txt = driver.findElement(By.id("color"));
		String gettxt = txt.getText();
		System.out.println("Colour Btn Text is:" + gettxt);
		
		//Button Size
		WebElement size = driver.findElement(By.id("size"));
		int height = size.getSize().getHeight();
		System.out.println("Btn Height is:" + height);
		
		int width = size.getSize().getWidth();
		System.out.println("Btn Width is:" + width);
		
		//Button Position
		WebElement position = driver.findElement(By.id("position"));
		Point point = position.getLocation();
		
		int x = point.getX();
		System.out.println("X axis:" + x);
		int y = point.getY();
		System.out.println("Y axis:" + y);
	}
}
