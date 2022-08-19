package pages;


import org.openqa.selenium.interactions.Actions;
import parse_util.ParsingString;
import java.time.Duration;


public class AboutPage extends BasePage{
    protected String isOpenElement = "//div[contains(@class,'responsive_page_frame')]";
    public boolean isOpen = isOpen(isOpenElement);




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

    public void clickOnStoreButton(){

        findByXpath("//a[contains(@class,'supernav') and contains(@href,'global-header')]",
                Duration.ofSeconds(10)).click();

    }





}
