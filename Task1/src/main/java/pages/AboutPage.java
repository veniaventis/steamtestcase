package pages;


import org.openqa.selenium.By;
import utils.ParsingString;



public class AboutPage extends BasePage{
    private final By isOpenElement = By.xpath("//div[contains(@class,'responsive_page_frame')]");
    private final By playersInGameLocator = By.xpath( "//div[contains(@class,'gamers_in_game')]//parent::div[@class='online_stat']");
    private final By playersOnlineLocator = By.xpath("//div[contains(@class,'gamers_online')]//parent::div[@class='online_stat']");
    private final By storeBtnLocator  = By.xpath("//div[contains(@class,'supernav_container')]//child::a[contains(@data-tooltip-content,'store')]");
    public boolean isOpen = isOpen(isOpenElement);



    public int getPlayersInGame(){
        String playersInGame = driver.findElement(playersInGameLocator).getText();
        return ParsingString.parseString(playersInGame);
    }

    public int getPlayersOnline(){
        String playersOnline =driver.findElement(playersOnlineLocator).getText();
        return ParsingString.parseString(playersOnline);
    }

    public void clickOnStoreButton(){
        driver.findElement(storeBtnLocator).click();

    }
}
