package seleniumadavanced.seleniumday1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestLoginDemoWebShop {

	@Test(dataProvider="dp1")
	public void testDemoWebShopLogin(String username,String password)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b4c.06.01\\soujanya\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertNotNull(driver.findElement(By.linkText("Log out")));
		driver.findElement(By.linkText("Log out")).click();
	}
	@DataProvider(name="dp1")
	public Object[][] getData()
	{
		return TestReadExcel.testreadExcel();
	}
}
