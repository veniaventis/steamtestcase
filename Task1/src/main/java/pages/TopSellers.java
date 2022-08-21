package pages;

import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TopSellers extends BasePage{
    protected String isOpenElement = "//div[contains(@class,'range_display')]";
    protected String steamOsLocator = "//div[contains(@data-loc,'SteamOS')]";
    public boolean isOpen = isOpen(isOpenElement);
    public boolean isSelected;

    protected String countPlayersCheckbox =
            "//div[contains(@data-collapse-name,'category3')]";

    protected String tagLocator = "//div[contains(@data-param,'tags') and @data-value='19']";

    protected String coapLan = "//div[contains(@data-param,'category3') and contains(@data-value,'48')]";

    public  void clickCheckBoxOs(){
        findByXpath(steamOsLocator, Duration.ofSeconds(10)).click();
        checkSelected(steamOsLocator);
    }

    private boolean checkSelected(String xpath){
         WebElement getAttributeClass = findByXpath(xpath,Duration.ofSeconds(10));
         String attributeClass = getAttributeClass.getAttribute("class");
         isSelected = attributeClass.equals("tab_filter_control_row  checked");
         return isSelected;
    }

    public void clickLANCoap() throws InterruptedException {
        findByXpath(countPlayersCheckbox,Duration.ofSeconds(10)).click();
        Thread.sleep(2000);
        findByXpath(coapLan,Duration.ofSeconds(20)).click();
        checkSelected(coapLan);
    }

    public void clickTag(){
        findByXpath(tagLocator,Duration.ofSeconds(10)).click();
        checkSelected(tagLocator);

    }


}
