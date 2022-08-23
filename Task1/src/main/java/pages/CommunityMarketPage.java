package pages;

import org.openqa.selenium.Keys;


import java.time.Duration;

public class CommunityMarketPage extends BasePage{

    protected String isOpenLocator = "//div[@class='market_page_left']";//xpath
    protected String showAdvancedOptionsClickLocator = "//div[contains(@class,'search_advanced_button')]";//xpath
    protected String getShowAdvancedOptionsFormLocator = "//div[@id='market_advancedsearch_appselect_activeapp']";//xpath
    protected String choiceGameLocator = "market_advancedsearch_appselect_activeapp";//id
    protected String dota2Locator = "app_option_570";//id
    protected String choiceHeroLocator = "//select[@name='category_570_Hero[]']";//xpath
    protected String heroLocator = "//option[contains(@value,'life_stealer')]";//xpath
    protected String rarityCheckBoxLocator = "tag_570_Rarity_Rarity_Immortal";//id
    protected String inputSearchLocator = "advancedSearchBox";//id
    public boolean isOpen;



    @Override
    public boolean isOpen(String xpath) {
        return super.isOpen(xpath);
    }
    public boolean isOpenPage(){
        return isOpen(isOpenLocator);
    }

    public boolean setShowAdvancedOptionsClick(){
        findByXpath(showAdvancedOptionsClickLocator, Duration.ofSeconds(10)).click();
        return isOpen = isOpen(getShowAdvancedOptionsFormLocator);
    }
    public void clickChoiceGame(){
        findById(choiceGameLocator,Duration.ofSeconds(10)).click();
    }
    public void clickDota2(){
        findById(dota2Locator,Duration.ofSeconds(10)).click();
    }
    public void choiceHeroClick(){
        findByXpath(choiceHeroLocator,Duration.ofSeconds(10)).click();
        findByXpath(heroLocator,Duration.ofSeconds(10)).click();
    }
    public void clickCheckBoxRarity(){
        findById(rarityCheckBoxLocator,Duration.ofSeconds(10)).click();
    }
    public void inputSearch(){
        findById(inputSearchLocator,Duration.ofSeconds(10)).click();
        findById(inputSearchLocator, Duration.ofSeconds(10)).sendKeys("golden");
        findById(inputSearchLocator,Duration.ofSeconds(10)).sendKeys(Keys.ENTER);
    }
}
