
package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage {
    WebDriver driver;
    
    
    @FindBy(xpath="//span[@class='checkmark']")
    WebElement Pre_Login_checkbox;
    
    @FindBy(xpath="//button[normalize-space()='Continue']")
    WebElement button_continue;

    @FindBy(xpath="//*[@id=\"root\"]/div[3]/div[2]/div/div/div/button")
    WebElement continu_with_mobile_button;
    
    @FindBy(xpath ="//input[@id='mobNumber']")
    WebElement mobileNumber;

    @FindBy(xpath = "//button[normalize-space()='Send OTP']")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
  
    public void login(WebDriver driver, double username) {
    	
        Pre_Login_checkbox.click();
        button_continue.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(continu_with_mobile_button)).click();
        continu_with_mobile_button.click();
//        wait.until(ExpectedConditions.elementToBeClickable(continu_with_mobile_button)).click();
    	mobileNumber.sendKeys(String.valueOf(username));
    	loginBtn.click();
    }
}
