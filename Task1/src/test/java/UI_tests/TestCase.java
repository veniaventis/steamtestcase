package UI_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

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
    public void testCase2() throws InterruptedException {


        MainPage mainPage = new MainPage();

        mainPage.holdNewsAndNoteworthy();
        mainPage.clickTopSeller();

        TopSellers topSellers = new TopSellers();
        Assert.assertTrue(topSellers.isOpen,"Top Sellers page doesn't open");

        topSellers.clickCheckBoxOs();
        Assert.assertTrue(topSellers.isSelected,"OS doesn't selected");

        topSellers.clickLANCoap();
        Assert.assertTrue(topSellers.isSelected);

        topSellers.clickTag();
        Assert.assertTrue(topSellers.isSelected);
        Assert.assertEquals(topSellers.getFoundCountItems(),topSellers.checkCountItems(),
                "The amount written does not match the actual amount." );
        List<String> forEquals = topSellers.getItemInformation();

        topSellers.clickFirstItem();

        FirstItemPage firstItemPage = new FirstItemPage();
        Assert.assertTrue(firstItemPage.isOpen, "First item page doesn't open");
        Assert.assertEquals(forEquals, firstItemPage.getItemInformation(),"Data doesn't match" );
    }
    @Test
    public void testCase3() throws InterruptedException {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isOpen);

        mainPage.holdCommunityAndClick();

        CommunityMarketPage communityMarketPage = new CommunityMarketPage();
        Assert.assertTrue(communityMarketPage.isOpenPage());

        communityMarketPage.setShowAdvancedOptionsClick();
        Assert.assertTrue(communityMarketPage.isOpen);

        communityMarketPage.clickChoiceGame();
        communityMarketPage.clickDota2();
        communityMarketPage.choiceHeroClick();
        communityMarketPage.clickCheckBoxRarity();
        communityMarketPage.inputSearch();
        List<String> filterText = communityMarketPage.getTextGameFilter();
        Assert.assertEquals(filterText,communityMarketPage.exceptionList,"Filter selected incorrectly");



    }
}
