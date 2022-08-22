package pages;

import utils.ParsingString;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FirstItemPage extends BasePage{
    protected String isOpenLocator = "//div[@id='appHubAppName']";
    public boolean isOpen = isOpen(isOpenLocator);

    protected String itemNameLocator = "//div[@id='appHubAppName']" ;
    protected String itemReleaseDateLocator = "//div[contains(@class,'release_date')]//child::div[@class='date']";
    protected String itemPriceLocator = "//div[contains(@class,'game_purchase_discount')]";



    public List<String> getItemInformation() {
            List<String> itemInformation = new ArrayList<>();
            itemInformation.add(ParsingString.parseWhiteSpacesAndToLowerCase(findByXpath(itemNameLocator, Duration.ofSeconds(10)).getText()));
            itemInformation.add(ParsingString.parseWhiteSpacesAndToLowerCase(findByXpath(itemReleaseDateLocator, Duration.ofSeconds(10)).getText()));
            itemInformation.add(ParsingString.parseWhiteSpacesAndToLowerCase(findByXpath(itemPriceLocator, Duration.ofSeconds(10)).getAttribute("data-price-final")));
            return itemInformation;

    }


}
