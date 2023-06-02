package org.onurakca.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends BasePage {
    public final String careersPageUrl = "https://useinsider.com/careers/";
    @FindBy(id = "career-find-our-calling")
    public  WebElement seeAllTeams;
    @FindBy(id = "career-our-location")
    public  WebElement ourLocation;
    @FindBy(xpath = "//*[@data-id='a8e7b90']")
    public WebElement lifeAtInsider;
    @FindBy(xpath = "//*[text()='See all teams']")
    public  WebElement seeAllTeamsButton;
    @FindBy(xpath = "//*[text()='Quality Assurance']")
    public  WebElement selectQualityAssurance;
    @FindBy(xpath = "(//*[@class='job-item col-12 col-lg-4 mt-5'])[4]")
    public  WebElement waitLoadAllTeams;

    public CareersPage(WebDriver driver) {
        super(driver);
    }


}
