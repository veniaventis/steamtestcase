package UI_tests;

import driver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver = DriverManager.getDriver();
    @AfterTest
    public void kill(){
        DriverManager.closeDriver();
    }
}
