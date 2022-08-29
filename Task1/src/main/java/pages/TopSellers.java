package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ParsingString;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class TopSellers extends BasePage{
    private final By isOpenElement =By.xpath("//div[contains(@class,'range_display')]");
    private final By steamOsLocator = By.xpath("//div[contains(@data-loc,'SteamOS')]");
    private final By countPlayersCheckbox = By.xpath("//div[contains(@data-collapse-name,'category3')]");
    private final By tagLocator = By.xpath("//div[contains(@data-param,'tags') and @data-value='19']");
    private final By coapLan = By.xpath("//div[contains(@data-param,'category3') and contains(@data-value,'48')]");
    private final By countItemsLocator = By.xpath("//a[contains(@data-gpnav,'item') and contains(@href,'store')]");
    private final By itemsFoundCountLocator =By.xpath( "//div[@class='search_results_count']");
    private final By itemNameLocator = By.xpath("//div[@id='search_resultsRows']//child::a[1]//child::span[@class='title']");
    private final By releaseDateLocator =By.xpath("//div[@id='search_resultsRows']//child::a[1]//div[contains(@class,'search_released ')]");
    private final By priceLocator = By.xpath("//div[@id='search_resultsRows']//child::a[1]//div[contains(@class,'discount_combined ')]") ;
    public boolean isOpen = isOpen(isOpenElement);
    public boolean isSelected;


    public  void clickCheckBoxOs(){
        driver.findElement(steamOsLocator).click();
        checkSelected(steamOsLocator);
    }

    private boolean checkSelected(By locator){
         WebElement getAttributeClass = driver.findElement(locator);
         String attributeClass = getAttributeClass.getAttribute("class");
         isSelected = attributeClass.equals("tab_filter_control_row  checked");
         return isSelected;
    }

    public void clickLANCoap() throws InterruptedException {
        driver.findElement(countPlayersCheckbox).click();
        Thread.sleep(2000);
        driver.findElement(coapLan).click();
        checkSelected(coapLan);
    }

    public void clickTag(){
        driver.findElement(tagLocator).click();
        checkSelected(tagLocator);

    }

    public int checkCountItems(){
        return  driver.findElements(countItemsLocator).size();
    }

    public int getFoundCountItems(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//Вынести в отельный файл секунды ожидания
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemsFoundCountLocator));
        return ParsingString.parseString(driver.findElement(itemsFoundCountLocator).getText());
    }

    public List<String> getItemInformation() {
            List<String> itemInformation = new ArrayList<>();
                itemInformation.add(ParsingString.parseWhiteSpacesAndToLowerCase(driver.findElement(itemNameLocator).getText()));
                itemInformation.add(ParsingString.parseWhiteSpacesAndToLowerCase(driver.findElement(releaseDateLocator).getText()));
                itemInformation.add(ParsingString.parseWhiteSpacesAndToLowerCase(driver.findElement(priceLocator).getAttribute("data-price-final")));
            return itemInformation;
    }


    public void clickFirstItem(){
        driver.findElement(itemNameLocator).click();
    }




}
