package UI_tests;

import driver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected WebDriver driver = DriverManager.getDriver();

    protected String url  = "https://store.steampowered.com/";
    @BeforeTest
    public void start(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterTest
    public void kill(){DriverManager.closeDriver();}
}
