package pages;

import org.openqa.selenium.By;
import utils.ParsingString;
import java.util.ArrayList;
import java.util.List;

public class FirstItemPage extends BasePage{
    private final By isOpenLocator = By.xpath("//div[@id='appHubAppName']");
    public boolean isOpen = isOpen(isOpenLocator);

    private final By itemNameLocator = By.xpath( "//div[@id='appHubAppName']");
    private final By itemReleaseDateLocator = By.xpath("//div[contains(@class,'release_date')]//child::div[@class='date']");
    private final By itemPriceLocator = By.xpath("//div[contains(@class,'game_purchase_discount')]");



    public List<String> getItemInformation() {
            List<String> itemInformation = new ArrayList<>();
            itemInformation.add(ParsingString.parseWhiteSpacesAndToLowerCase(driver.findElement(itemNameLocator).getText()));
            itemInformation.add(ParsingString.parseWhiteSpacesAndToLowerCase(driver.findElement(itemReleaseDateLocator).getText()));
            itemInformation.add(ParsingString.parseWhiteSpacesAndToLowerCase(driver.findElement(itemPriceLocator).getAttribute("data-price-final")));
            return itemInformation;

    }


}
