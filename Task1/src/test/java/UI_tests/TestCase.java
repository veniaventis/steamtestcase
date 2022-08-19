package UI_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.MainPage;

public class TestCase extends BaseTest{


    @Test
    public void testCase1() {

        MainPage mainPage = new MainPage();
        AboutPage aboutPage = new AboutPage();

        Assert.assertTrue(mainPage.isOpen, "Main page is not open");

        mainPage.clickOnAboutButton();

        Assert.assertTrue(aboutPage.isOpen,"Button About doesn't working");

        Assert.assertTrue(aboutPage.getPlayersInGame() < aboutPage.getPlayersOnline(),
                "Count in game more than online");

        aboutPage.clickOnStoreButton();
        Assert.assertTrue(mainPage.isOpen, "Page store doesn't open");
    }

    @Test
    public void testCase2(){
        MainPage mainPage = new MainPage();

        mainPage.holdNewsAndNoteworthy();
        mainPage.clickTopSeller();


    }
}
