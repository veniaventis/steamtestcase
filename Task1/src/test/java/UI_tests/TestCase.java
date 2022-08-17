package UI_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends BaseTest{


    @Test
    public void checkSteam(){
        driver.get("https://store.steampowered.com/");

        driver.findElement(By
                .xpath("//div[@class='supernav_container']//child::a[contains(@href,'about')]"))
                .click();


        String playersOnline = driver.findElement(By
                .xpath("//div[contains(@class,'gamers_online')]//parent::div[@class='online_stat']"))
                .getText()
                .replaceAll(",","");

        String playersInGame = driver.findElement(By
                .xpath("//div[contains(@class,'gamers_in_game')]//parent::div[@class='online_stat']"))
                .getText()
                .replaceAll(",","");
//      Parsing to integer
        int parsePlayersOnLine = (Integer.parseInt(playersOnline.replaceAll("[^0-9]", "")));
        int parsePlayersInGame = (Integer.parseInt(playersInGame.replaceAll("[^0-9]", "")));
        Assert.assertTrue(parsePlayersInGame < parsePlayersOnLine, "Number of in-game players is not less than number of players online");

        driver.findElement(By
                .xpath("//a[contains(@class,'supernav') and contains(@href,'global-header')]"))
                .click();


    }
}
