package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AdvancedOptionsPage extends BasePage {
    private final By isOpenLocator = By.xpath("//div[@class='newmodal_header_border'] ");
    public boolean isOpen = isOpen(isOpenLocator);
    private final By choiceGameLocator = By.id("market_advancedsearch_appselect_activeapp");
    private final By dota2Locator = By.id("app_option_570");
    private final By choiceHeroLocator = By.xpath("//select[@name='category_570_Hero[]']");//xpath
    private final By heroLocator = By.xpath("//option[contains(@value,'life_stealer')]");//xpath
    private final By rarityCheckBoxLocator = By.id("tag_570_Rarity_Rarity_Immortal");//id
    private final By inputSearchLocator = By.id("advancedSearchBox");



    public void clickChoiceGame(){
        driver.findElement(choiceGameLocator).click();
    }

    public void clickDota2(){
        driver.findElement(dota2Locator).click();
    }

    public void choiceHeroClick(){
        driver.findElement(choiceHeroLocator).click();
        driver.findElement(heroLocator).click();
    }

    public void clickCheckBoxRarity(){
        driver.findElement(rarityCheckBoxLocator).click();
    }

    public void inputSearch(){
        driver.findElement(inputSearchLocator).click();
        driver.findElement(inputSearchLocator).sendKeys("golden");
        driver.findElement(inputSearchLocator).sendKeys(Keys.ENTER);
    }


}
