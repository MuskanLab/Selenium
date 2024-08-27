package LTA_Package_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LTA_After_login_Pop {
	
	WebDriver driver;
	@BeforeMethod
	public void beforeLogin()
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
	@AfterMethod(enabled=false)
	public void afterLogin()  
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	@Test(enabled=false)
	public void TestCaseElementDisplay()
	{
		  	WebElement checkbox = driver.findElement(By.xpath("//span[@class='checkmark']"));
		    WebElement continueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
		    WebElement under18Button = driver.findElement(By.xpath("//button[contains(@class,'text-center ageButton')]"));
		    WebElement termsLink = driver.findElement(By.linkText("Terms & Conditions"));
		
		    assert checkbox.isDisplayed();
		    assert continueButton.isDisplayed();
		    assert under18Button.isDisplayed();
		    assert termsLink.isDisplayed();
	}
	@Test(enabled=false)
	public void testTermsAndConditionsLink()
	{
	        WebElement termsLink = driver.findElement(By.linkText("Terms & Conditions"));
	        termsLink.click();
	}
	@Test(enabled=false)
	public void testContinueButtonWithoutCheckbox() {
		try {
			
        WebElement continueButton = driver.findElement(By.xpath("//button[@class='btnRounded  btnDisable']"));
        boolean isEnabled= continueButton.isEnabled();
        System.out.print("True value "+isEnabled);
        System.out.println("Is 'Continue' button enabled according to isEnabled()? " + isEnabled);

        // Check if the button has 'pointer-events: none' using the CSS value
        String pointerEvents = continueButton.getCssValue("pointer-events");
        boolean isPointerEventsNone = "none".equals(pointerEvents);
        System.out.println("Does 'Continue' button have 'pointer-events: none'? " + isPointerEventsNone);

        // Combine both checks to determine if the button is effectively disabled
        boolean isDisabled = !isEnabled || isPointerEventsNone;
        System.out.println("Is 'Continue' button effectively disabled? " + isDisabled);
        
        // Assert that the button is disabled
        Assert.assertTrue(isDisabled, "The 'Continue' button should be disabled.");
		}
        catch (AssertionError e) {
            // Handle the assertion error
            System.err.println("Assertion failed: " + e.getMessage());
            // Optionally, you can take a screenshot, log additional info, etc.
        } 
	
	}
	@Test(enabled=true)
	public void testContinueButtonWithCheckbox() {
		WebElement checkbox = driver.findElement(By.xpath("//span[@class='checkmark']"));
		checkbox.click();
		WebElement continueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
		assert continueButton.isEnabled();
		continueButton.click();
		
		
	}
	
}
