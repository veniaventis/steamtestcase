package UI_tests;

import driver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    protected WebDriver driver = DriverManager.getDriver();
    protected String url  = "https://store.steampowered.com/";
    @BeforeTest
    public void start(){
        DriverManager.getDriver().get(url);
    }
    @AfterTest
    public void kill(){
        DriverManager.closeDriver();
    }
}
