package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class MainPage extends BasePage {

    protected String isOpenElement = "//div[contains(@class,'responsive_page_frame')]";

    public boolean isOpen = isOpen(isOpenElement);


    public void clickOnAboutButton(){

        findByXpath("//div[@class='supernav_container']//child::a[contains(@href,'about')]",
                Duration.ofSeconds(10)).click();

    }

    public void holdNewsAndNoteworthy()  {
        Actions actions = new Actions(driver);
        actions.moveToElement(findById("noteworthy_tab", Duration.ofSeconds(10)));
        actions.perform();

    }

    public void clickTopSeller(){
        findById("noteworthy_flyout", Duration.ofSeconds(10)).click();
    }


}
