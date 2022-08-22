package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ParsingString;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TopSellers extends BasePage{
    protected String isOpenElement = "//div[contains(@class,'range_display')]";
    protected String steamOsLocator = "//div[contains(@data-loc,'SteamOS')]";
    protected String countPlayersCheckbox =
            "//div[contains(@data-collapse-name,'category3')]";
    protected String tagLocator = "//div[contains(@data-param,'tags') and @data-value='19']";
    protected String coapLan = "//div[contains(@data-param,'category3') and contains(@data-value,'48')]";
    protected String countItemsLocator = "//a[contains(@data-gpnav,'item') and contains(@href,'store')]";
    protected String itemsFoundCountLocator = "//div[@class='search_results_count']";
    protected String itemNameLocator = "//div[@id='search_resultsRows']//child::a[1]//child::span[@class='title']";
    protected String releaseDateLocator = "//div[@id='search_resultsRows']//child::a[1]//div[contains(@class,'search_released ')]";
    protected String priceLocator = "//div[@id='search_resultsRows']//child::a[1]//div[contains(@class,'discount_combined ')]" ;
    public boolean isOpen = isOpen(isOpenElement);
    public boolean isSelected;


    public  void clickCheckBoxOs(){
        findByXpath(steamOsLocator, Duration.ofSeconds(10)).click();
        checkSelected(steamOsLocator);
    }

    private boolean checkSelected(String xpath){
         WebElement getAttributeClass = findByXpath(xpath,Duration.ofSeconds(10));
         String attributeClass = getAttributeClass.getAttribute("class");
         isSelected = attributeClass.equals("tab_filter_control_row  checked");
         return isSelected;
    }

    public void clickLANCoap() throws InterruptedException {
        findByXpath(countPlayersCheckbox,Duration.ofSeconds(10)).click();
        Thread.sleep(2000);
        findByXpath(coapLan,Duration.ofSeconds(20)).click();
        checkSelected(coapLan);
    }

    public void clickTag(){
        findByXpath(tagLocator,Duration.ofSeconds(10)).click();
        checkSelected(tagLocator);

    }

    public int checkCountItems(){
        return  findElementsByXpath(countItemsLocator,Duration.ofSeconds(10)).size();
    }

    public int getFoundCountItems(){
     return ParsingString.parseString(findByXpath(itemsFoundCountLocator, Duration.ofSeconds(10)).getText());
    }

    public List<String> getItemInformation() {
            List<String> itemInformation = new ArrayList<>();
                itemInformation.add(ParsingString.parseWhiteSpacesAndToLowerCase(findByXpath(itemNameLocator, Duration.ofSeconds(10)).getText()));
                itemInformation.add(ParsingString.parseWhiteSpacesAndToLowerCase(findByXpath(releaseDateLocator, Duration.ofSeconds(10)).getText()));
                itemInformation.add(ParsingString.parseWhiteSpacesAndToLowerCase(findByXpath(priceLocator, Duration.ofSeconds(10)).getAttribute("data-price-final")));
            return itemInformation;
    }


    public void clickFirstItem(){
        findByXpath(itemNameLocator,Duration.ofSeconds(10)).click();
    }




}
