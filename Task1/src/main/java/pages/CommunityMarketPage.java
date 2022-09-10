package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ParsingString;
import java.util.ArrayList;
import java.util.List;

public class CommunityMarketPage extends BasePage{

    private final By isOpenLocator = By.xpath("//div[@class='market_page_left']");//xpath
    public boolean isOpen = isOpen(isOpenLocator);
    private final By filtersLocator = By.xpath("//div[contains(@style,'inline-block')]//child::a[contains(@class,'market_searchedForTerm')]");
    private final By advancedOptionsBtnLocator = By.id("market_search_advanced_show");
    private final String itemsLocator = "resultlink_";
    public List<String> exceptionList = new ArrayList<>();

    public void advancedOptionsClick(){
        driver.findElement(advancedOptionsBtnLocator).click();
    }

    public List<String> getTextGameFilter(){
        List<String> filtersText = new ArrayList<>();
        List<WebElement> elements = driver.findElements(filtersLocator);
        for(WebElement element:elements){
            filtersText.add(ParsingString.parseWhiteSpacesAndToLowerCase(element.getText()));
        }
        addExceptionList();
        return filtersText;
    }
//Получение первых 5 айтомов
//    public List<String> getTextItems(){
//        List <String> itemsText = new ArrayList<>();//
//      for{
//          {
//              itemsText.add(driver.findElement(itemsLocator).getText());
//          }
//      }
//        return itemsText;
//    }  Завтра дописать сбор первых 5 элементов
    public void addExceptionList(){
        exceptionList.add("dota2");
        exceptionList.add("lifestealer");
        exceptionList.add("immortal");
        exceptionList.add("\"golden\"");
    }

}
