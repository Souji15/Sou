package seleniumadavanced.seleniumday1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import junit.framework.Assert;

public class TestCity {

	@Test
	public void name() throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\soujanya\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com");
		
		WebElement from = driver.findElement(By.id("FromTag"));
		Actions act1 = new Actions(driver);
		Thread.sleep(5000); //to wait
		act1.sendKeys(from,"hyd").perform();
		Thread.sleep(5000);
		act1.sendKeys(Keys.ENTER).perform();
		
		String city = driver.findElement(By.id("From")).getAttribute("value");
		Assert.assertEquals(city, "HYD");
		
		WebElement to = driver.findElement(By.id("ToTag"));
		to.sendKeys("bangk");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-id-2")));
		WebElement ul = driver.findElement(By.id("ui-id-2")); //inspect the drop down
		
		
		
		
		
	}
}
