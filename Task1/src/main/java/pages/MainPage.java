package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;



public class MainPage extends BasePage {

    private final By isOpenElement = By.xpath("//div[contains(@class,'responsive_page_frame')]");
    private final By topSellersBtn = By.xpath("//div[contains(@class,'popup_bod')]//child::a[contains(@href,'filter=topsellers')]");
    private final By communityLocator = By.xpath("//div[contains(@class,'supernav_container')]//child::a[contains(@data-tooltip-content,'community')]");
    private final By communityMarketLocator = By.xpath("//div[contains(@class,'supernav_container')]//child::a[contains(@href,'market')]");
    private final By aboutBtnLocator = By.xpath("//div[@class='supernav_container']//child::a[contains(@href,'about')]");
    private final By newsAndNoteworthy = By.id("noteworthy_tab");
    public boolean isOpen = isOpen(isOpenElement);


    public void clickOnAboutButton(){driver.findElement(aboutBtnLocator).click();}

    public void holdNewsAndNoteworthy()  {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(newsAndNoteworthy)).perform();
    }

    public void clickTopSeller(){ driver.findElement(topSellersBtn).click();}

    public void holdCommunityAndClick(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(communityLocator)).perform();
        driver.findElement(communityMarketLocator).click();
    }


}
