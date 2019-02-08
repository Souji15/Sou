package seleniumadavanced.seleniumday1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestAjax {
	
	@Test
	public void testDrag() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\soujanya\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		
		WebElement from = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadTreeView1\"]/ul/li/ul/li[3]/ul/li[2]/div/div/span"));
		
		WebElement to= driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
		
		Actions act1 = new Actions(driver); 
		act1.dragAndDrop(from, to).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"),"Drop a package here to check price"));
		
		String result = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
		System.out.println("Result" +result);
	
		Assert.assertTrue(result.contains("$4999"));
		
	}
	
	
	

	
}
