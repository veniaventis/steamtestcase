package pages;

import org.openqa.selenium.WebElement;
import parse_util.ParsingString;

import java.time.Duration;
import java.util.List;

public class AboutPage extends BasePage{

    public List<WebElement> findElements(){
        return findElementsByXpath("//div[contains(@class,'responsive_page_frame')]", Duration.ofSeconds(10));
    }

    public int getPlayersInGame(){
        String playersInGame = findByXpath("//div[contains(@class,'gamers_in_game')]//parent::div[@class='online_stat']",Duration.ofSeconds(10))
                .getText()
                .replaceAll(",","");
        return ParsingString.parseString(playersInGame);
    }

    public int getPlayersOnline(){
        String playersOnline = findByXpath("//div[contains(@class,'gamers_online')]//parent::div[@class='online_stat']", Duration.ofSeconds(10))
                .getText()
                .replaceAll(",","");
        return ParsingString.parseString(playersOnline);
    }

    public StorePage clickOnStoreButton(){

        findByXpath("//a[contains(@class,'supernav') and contains(@href,'global-header')]",
                Duration.ofSeconds(10)).click();

        return new StorePage();

    }





}
