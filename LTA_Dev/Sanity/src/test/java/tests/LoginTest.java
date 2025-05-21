package tests;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.LoginPage;
import utils.ConfigReader;
import utils.ExcelUtils;
import org.testng.annotations.Listeners;

@Listeners(Listener.TestListener.class)
public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        driver.get(ConfigReader.get("app.url"));
        ExcelUtils.setExcelFile("testdata/LoginData.xlsx", "Sheet1");
        double username = ExcelUtils.getCellData(1, 0);
       
        LoginPage lg=new LoginPage(driver);
        lg.login(driver, username);
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}
