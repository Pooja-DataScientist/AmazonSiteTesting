package ExtentReportPackage;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ExtentReportCreate {
	public WebDriver driver;
	
	public ExtentHtmlReporter extenthtmlreporter;
	public ExtentReports extentreport;
	public ExtentTest extenttest;
	
	@BeforeTest
	public void setExtent() {
		extenthtmlreporter = new ExtentHtmlReporter("TestReport.html");
		extenthtmlreporter.config().setDocumentTitle("UI Automation Test Report");
		extenthtmlreporter.config().setReportName("Automation Test Report");
		
		extentreport = new ExtentReports();
		
		extentreport.attachReporter(extenthtmlreporter);
		extentreport.setSystemInfo("Hostname","localhost");
		extentreport.setSystemInfo("Operating Syste","Windows");
		extentreport.setSystemInfo("Browser","Chrome");
	}
	
	@BeforeMethod
	public void driversetup() {
		System.setProperty("webdriver.chrome.driver","C:\\BrowserDriver\\NewDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nopcommerce.com/");
	}
	
    @Test
    public void gettitletest() {
    	extenttest = extentreport.createTest("GetSiteTitleTest");
    	String Actualtitle = driver.getTitle();
    	String Expectedtitle = "Free and open-source eCommerce platform. ASP.NET based shopping cart. - nopCommerce";
    	Assert.assertEquals(Actualtitle, Expectedtitle);
    	System.out.println("Title Matched Successfully");
    }
    
    @Test
    public void logoavailabletest() {
    	extenttest = extentreport.createTest("LogoAvailabilityTest");
    	Boolean status = driver.findElement(By.xpath("//*[@id=\"en-page\"]/body/div[7]/header/div/div[1]/a/img")).isDisplayed();
    	Assert.assertTrue(status);
    }
    
    @Test
    public void invalidtitletest() {
    	extenttest = extentreport.createTest("GetInvalidTitleTest");
    	String Actualtitle = driver.getTitle();
    	String Expectedtitle = "Free open-source eCommerce platform. ASP.NET based shopping cart. - nopCommerce";
    	Assert.assertEquals(Actualtitle, Expectedtitle);
    	System.out.println("Title does not match");
    	
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
    	if(result.getStatus() == ITestResult.FAILURE) {
			extenttest.log(Status.FAIL, "TEST CASE FAILED IS" + result.getName());
			extenttest.log(Status.FAIL,"TEST CASE FAILED  IS" + result.getThrowable());
			
			//String screenshotPath = ExtentReportCreate.getScreenshot(driver, result.getName());
			//extenttest.addScreenCaptureFromPath(screenshotPath); // adding screenshot
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			extenttest.log(Status.SKIP, "TEST CASE SKIPPED IS " + result.getName());		
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			extenttest.log(Status.PASS, "TEST CASE PASSED IS" + result.getName());
		}
		driver.quit();
    }
    
   // public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//TakesScreenshot ts = (TakesScreenshot) driver;
		//File source = ts.getScreenshotAs(OutputType.FILE);
		
		//String destination = System.getProperty(screenshotName + dateName + ".png");
		//File finalDestination = new File(destination);
		//FileUtils.copyFile(source, finalDestination);
		//return destination;
	//}
    
    @AfterTest
    public void endReport() {
    	extentreport.flush();
    }
}
