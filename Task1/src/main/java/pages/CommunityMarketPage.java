package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ParsingString;
import java.util.ArrayList;
import java.util.List;

public class CommunityMarketPage extends BasePage{

    private final By isOpenLocator = By.xpath("//div[@class='market_page_left']");//xpath
    public boolean isOpen = isOpen(isOpenLocator);
    private final By filtersLocator = By.xpath("//div[contains(@style,'inline-block')]//child::a");
    private final By advancedOptionsBtnLocator = By.id("market_search_advanced_show");
    public List<String> exceptionList = new ArrayList<>();

    public void advancedOptionsClick(){
        driver.findElement(advancedOptionsBtnLocator).click();
    }

    public List<String> getTextGameFilter(){
        List<String> filtersText = new ArrayList<>();
        List<WebElement> elements = driver.findElements(filtersLocator);
        for(int a = 1; a < 5 ;a++){
            for(WebElement element:elements){
                filtersText.add(ParsingString.parseWhiteSpacesAndToLowerCase(element.getText()));
            }
        }
        addExceptionList();
        return filtersText;

    }
    public void addExceptionList(){
        exceptionList.add("dota2");
        exceptionList.add("lifestealer");
        exceptionList.add("immortal");
        exceptionList.add("\"golden\"");
    }

}
