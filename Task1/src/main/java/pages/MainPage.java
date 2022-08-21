package pages;

import com.beust.ah.A;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class MainPage extends BasePage {

    protected String isOpenElement = "//div[contains(@class,'responsive_page_frame')]";
    protected String topSellersBtn = "//div[contains(@class,'popup_bod')]//child::a[contains(@href,'filter=topsellers')]";

    public boolean isOpen = isOpen(isOpenElement);


    public AboutPage clickOnAboutButton(){

        findByXpath("//div[@class='supernav_container']//child::a[contains(@href,'about')]",
                Duration.ofSeconds(10)).click();
        return new AboutPage();
    }

    public void holdNewsAndNoteworthy()  {
        Actions actions = new Actions(driver);
        actions.moveToElement(findById("noteworthy_tab", Duration.ofSeconds(10))).perform();
    }



    public TopSellers clickTopSeller(){
        findByXpath(topSellersBtn, Duration.ofSeconds(20)).click();
        return new TopSellers();
    }


}
