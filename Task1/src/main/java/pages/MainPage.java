package pages;

import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class MainPage extends BasePage {


    public  AboutPage clickOnAboutButton(){

        findByXpath("//div[@class='supernav_container']//child::a[contains(@href,'about')]", Duration.ofSeconds(10)).click();

        return new AboutPage();
    }

    public List<WebElement> findElement(){

      return findElementsByXpath("//div[contains(@class,'responsive_page_frame')]", Duration.ofSeconds(10));

    }


}
