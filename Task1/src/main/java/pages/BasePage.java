package pages;
import driver_manager.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage {

    protected String mainPage = "https://store.steampowered.com/";

    protected WebDriver driver;

    public BasePage(){

        this.driver = DriverManager.getDriver();

    }

    public WebElement findByXpath(String xpath, Duration duration){
        return driver.findElement(waitForElementVisible(By.xpath(xpath), duration.getSeconds()));
    }

    public WebElement findById(String id, Duration duration){
        return driver.findElement(waitForElementVisible(By.id(id), duration.getSeconds()));
    }

//    public WebElement findByCss(String css, Duration duration){
//        return driver.findElement(waitForElementVisible(By.cssSelector(css), duration.getSeconds()));
//    }

    public List<WebElement> findElementsByXpath(String xpath, Duration duration){
        return driver.findElements(waitForElementVisible(By.xpath(xpath),duration.getSeconds()));

    }

    public boolean isOpen(String xpath){

        List<WebElement> elements = findElementsByXpath(xpath, Duration.ofSeconds(10));

        return elements.size() > 0;
    }

    public WebDriverWait getWaiter(long timeOutInSeconds){
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds);
        webDriverWait.ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        return webDriverWait;
    }

    public By waitForElementVisible(By findStrategy, long timeOutInSeconds){
        getWaiter(timeOutInSeconds).until(visibilityOfElementLocated(findStrategy));
        return findStrategy;
    }

//    public void clickCheckBox(String xpath){
//
//    }

//    public MainPage goToMainPage (){
//        DriverManager.getDriver().get(mainPage);
//        return new MainPage();
//    }

}
