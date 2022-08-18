package pages;

import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class StorePage extends BasePage{

    public List<WebElement> findElement(){
        return findElementsByXpath("//div[contains(@class,'home_cluster_ctn')]", Duration.ofSeconds(10));
    }

}
