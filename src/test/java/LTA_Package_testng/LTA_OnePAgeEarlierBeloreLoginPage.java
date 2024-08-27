package LTA_Package_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LTA_OnePAgeEarlierBeloreLoginPage {
	 	private WebDriver driver;
	    private WebDriverWait wait;

	    @BeforeClass
		public void setUp()
		{
				try {
					// TODO Auto-generated method stub
					WebDriverManager.chromedriver().setup();
			        driver = new ChromeDriver();
			        driver.get("https://ltadev.affleprojects.com/lta/");
			        driver.manage().window().maximize();   
			        }
					catch(SessionNotCreatedException e)
					{
						System.err.println("Failed to create a session. Check browser and WebDriver compatibility.");
			            e.printStackTrace();
					}
		}
	    @Test(priority = 1)
	    public void testPageLoad() {
	        // Verify that the web page loads successfully
	        assert driver.getTitle().contains("Land Transport Authority"); // Replace 'expected title' as necessary
	    }

	    @Test(priority = 2)
	    public void testLanguageOptions() {
	        // Test the language change functionality
	       WebElement lang = driver.findElement(By.xpath("//p[normalize-space()='Melayu']"));
//	        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("p"), "请在以下登录方式选择一项。"));
//	        assert driver.getPageSource().contains("请在以下登录方式选择一项。");
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lang);
	       lang.click();
//	        driver.findElement(By.linkText("Melayu")).click(); 
//	        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "expected Malay content"));
//	        assert driver.getPageSource().contains("expected Malay content");
//
//	        driver.findElement(By.linkText("தமிழ்")).click();
//	        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "expected Tamil content"));
//	        assert driver.getPageSource().contains("expected Tamil content");
//
//	        // Switch back to English at the end of the test
//	        driver.findElement(By.linkText("English")).click();
	    }

	    @Test(priority = 3,enabled=false)
	    public void testContinueWithMobileButton() {
	        // Verify 'Continue with Mobile' button functionality
	        WebElement continueWithMobileButton = driver.findElement(By.cssSelector("button selector"));
	        continueWithMobileButton.click();
	        // Add assertions or other checks to verify the correct response to clicking the button
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	

}
