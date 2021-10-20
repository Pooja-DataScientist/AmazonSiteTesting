import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIAutomationUsingTestNgTest {
	WebDriver driver;
	
	@BeforeTest
	public void opensite() {
		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
	}
	
	@Test(priority=1)
	public void titletest() {
		String Expectedtitle = "Amazon.com. Spend less. Smile more.";
		String Actualtitle = driver.getTitle();
		Assert.assertEquals(Actualtitle, Expectedtitle);	
	}
	@Test(priority=2)
	public void findtest() {
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("phone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String Expectedtitle2 = "Amazon.com : phone";
		String Actualtitle2 = driver.getTitle();
		Assert.assertEquals(Actualtitle2, Expectedtitle2);
		driver.get("https://www.amazon.com/SafeLink-TCL-Prepaid-Smartphone-Locked/dp/B08XZQ7RPT/ref=sr_1_1_sspa?dchild=1&keywords=phone&qid=1634633907&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUExUE5IWUw4SERHVjdYJmVuY3J5cHRlZElkPUEwMDg1MjI0Mk5QNFo3UUE5N1BPJmVuY3J5cHRlZEFkSWQ9QTA4NjM2ODEyOUhFNkZKN045V1E3JndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==");
		//driver.findElement(By.name("Google Pixel 4a - Unlocked Android Smartphone - 128 GB of Storage - Up to 24 Hour Battery - Barely Blue")).click();
	}
	@Test(priority=3)
	public void quantityselection() {
		WebElement Quantity = driver.findElement(By.id("quantity"));
		Select quantity = new Select(Quantity);
		quantity.selectByValue("2");
		WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
		addtocart.click();
		WebElement clickcart = driver.findElement(By.id("nav-cart-count-container"));
        clickcart.click();	
	}
	
	@Test(priority=4)
	public void checkcartitems() {
		String Expectedtitle_3 = "Amazon.com Shopping Cart";
		String Actualtitle_3 = driver.getTitle();
		Assert.assertEquals(Actualtitle_3, Expectedtitle_3);
		System.out.println("Title Match Successfully");
		WebElement proceedorder = driver.findElement(By.className("a-button-input"));
        proceedorder.click();
     
	}
	
	

	@AfterTest
	public void closesite() {
	   driver.close();
	  }
}
