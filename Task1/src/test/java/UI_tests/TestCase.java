package UI_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.MainPage;
import pages.StorePage;

public class TestCase extends BaseTest{


    @Test
    public void testMainPage() {

        int countElementsMinePage = new MainPage().goToMainPage().findElement().size();
        Assert.assertTrue(countElementsMinePage > 0, "Main page is not open");

        MainPage aboutButton = new MainPage();
        aboutButton.clickOnAboutButton();

        int countElementsAboutPage = new AboutPage().findElements().size();
        Assert.assertTrue(countElementsAboutPage > 0,
                "Button About doesn't working");

        Assert.assertTrue(new AboutPage().getPlayersInGame() < new AboutPage().getPlayersOnline(),
                "Count in game more than online");

        AboutPage storeButton = new AboutPage();
        storeButton.clickOnStoreButton();

        int countElementsStorePage = new StorePage().findElement().size();
        Assert.assertTrue(countElementsStorePage > 0 , "Page store doesn't open");

    }






}
