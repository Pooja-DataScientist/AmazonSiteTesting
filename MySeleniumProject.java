package newprojectselenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MySeleniumProject {

	private static final WebElement TRUE = null;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		WebElement searchelement = driver.findElementById("twotabsearchtextbox");
		searchelement.sendKeys("IPhone");
		
		WebElement searchbutton = driver.findElementById("nav-search-submit-button");
		searchbutton.click();
		
		driver.get("https://www.amazon.com/Samsung-Unlocked-Smartphone-Pro-Grade-SM-G996UZVAXAA/dp/B08N3LQBS9/ref=sr_1_1_sspa?dchild=1&keywords=IPhone&qid=1633351782&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUE2Sko3R0hKNzI3NlEmZW5jcnlwdGVkSWQ9QTA3OTI4MTVQVlYyTUJPV1FXSEsmZW5jcnlwdGVkQWRJZD1BMTAwNjQ5MDJHM0EyUEdLMVVOOVAmd2lkZ2V0TmFtZT1zcF9hdGYmYWN0aW9uPWNsaWNrUmVkaXJlY3QmZG9Ob3RMb2dDbGljaz10cnVl");
		
		WebElement addtocart = driver.findElementById("add-to-cart-button");
		addtocart.click();
        
        WebElement clickbutton = driver.findElementById("nav-cart-count-container");
        clickbutton.click();
        
        WebElement dropdownselection = driver.findElementByClassName("a-dropdown-label");
        dropdownselection.click();
        
        WebElement selectquantity = driver.findElementById("quantity_1");
        selectquantity.click();
        
        WebElement proceedorder = driver.findElementByClassName("a-button-input");
        proceedorder.click();
        
        driver.quit();
    
        
       
	}

}
