package org.onurakca.tests;


import org.junit.jupiter.api.Test;


public class TestCase extends BaseTest {

    @Test
    public void
    testSuit1() {
        mainPage.checkPageUrl(url);
        mainPage.isDisplayed(mainPage.mainPageId);
        mainPage.clickToElement(mainPage.acceptCookies);
        mainPage.clickToElement(mainPage.moreNaviBar);
        mainPage.waitElementLoad(mainPage.careers);
        mainPage.isDisplayed(mainPage.careers);
        mainPage.clickToElement(mainPage.careers);
        careersPage.checkPageUrl(careersPage.careersPageUrl);
        careersPage.isDisplayed(careersPage.seeAllTeams);
        careersPage.isDisplayed(careersPage.ourLocation);
        careersPage.isDisplayed(careersPage.lifeAtInsider);
        careersPage.findScrollElementCenter(careersPage.seeAllTeamsButton);
        careersPage.forceClick(careersPage.seeAllTeamsButton);
        careersPage.waitElementLoad(careersPage.waitLoadAllTeams);
        careersPage.findScrollElementCenter(careersPage.selectQualityAssurance);
        careersPage.forceClick(careersPage.selectQualityAssurance);
        qualityAssurancePage.waitElementLoad(qualityAssurancePage.seeAllQaJobs);
        qualityAssurancePage.clickToElement(qualityAssurancePage.seeAllQaJobs);
        openPositionsPage.waitElementLoad(openPositionsPage.filterByDepartment);
        openPositionsPage.selectLocationDropDownMenu(openPositionsPage.dropDownMenu, openPositionsPage.selecLocation);
        openPositionsPage.checkFilterByDepartmantSelectedQa();
        openPositionsPage.checkJobDetails();
        openPositionsPage.forceClick(openPositionsPage.applyNowButton);
        openPositionsPage.switchToNewTab();
        applyForJobPage.waitElementLoad(applyForJobPage.applyForThisJobBtn);
        applyForJobPage.checkPageUrl(applyForJobPage.applyJobDetails);


    }
}