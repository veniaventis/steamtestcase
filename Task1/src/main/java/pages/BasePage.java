package pages;
import driver_manager.DriverManager;
import org.openqa.selenium.*;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {

        this.driver = DriverManager.getDriver();

    }
    public boolean isOpen(By locator) {

        List<WebElement> elements = driver.findElements(locator);

        return elements.size() > 0;
    }


}