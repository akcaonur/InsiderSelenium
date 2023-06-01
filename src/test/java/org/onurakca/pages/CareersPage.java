package org.onurakca.pages;

import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage{

    public final String careersPageUrl="https://useinsider.com/careers/";
    public final String seeAllTeams="career-find-our-calling";
    public final String ourLocation="career-our-location";
    public final String lifeAtInsider="//*[@data-id='a8e7b90']";
    public final String seeAllTeamsButton="//*[text()='See all teams']";
    public final String selectQualityAssurance="//*[text()='Quality Assurance']";
    public final String waitLoadAllTeams="(//*[@class='job-item col-12 col-lg-4 mt-5'])[4]";
    public CareersPage(WebDriver driver) {
        super(driver);
    }


}
