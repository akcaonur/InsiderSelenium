package org.onurakca.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TestCase extends BaseTest{

    @Test
    public void testSuit1() throws InterruptedException {


        mainPage.checkPageUrl(url);
        mainPage.isDisplayedById(mainPage.mainPageId);
        mainPage.clickById(mainPage.acceptCookies);
        mainPage.clickByXpath(mainPage.moreNaviBar);
        mainPage.isDisplayedByXpath(mainPage.careers);
        mainPage.clickByXpath(mainPage.careers);
        careersPage.checkPageUrl(careersPage.careersPageUrl);
        careersPage.isDisplayedById(careersPage.seeAllTeams);
        careersPage.isDisplayedById(careersPage.ourLocation);
        careersPage.isDisplayedByXpath(careersPage.lifeAtInsider);
        careersPage.scrollDowntoWebElement(careersPage.seeAllTeamsButton);
        //careersPage.isDisplayedById(careersPage.seeAllTeamsButton);

        careersPage.forceClick(careersPage.seeAllTeamsButton);
        careersPage.waitElementLoad(careersPage.waitLoadAllTeams);
        careersPage.scrollDowntoWebElement(careersPage.selectQualityAssurance);

        careersPage.forceClick(careersPage.selectQualityAssurance);


    }
}
