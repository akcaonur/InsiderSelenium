package org.onurakca.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplyForJobPage extends BasePage {

    @FindBy(xpath = "//*[@class='postings-btn template-btn-submit shamrock']")
    public WebElement applyForThisJobBtn;
    public String applyJobDetails = "https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc";

    public ApplyForJobPage(WebDriver driver) {
        super(driver);
    }
}
