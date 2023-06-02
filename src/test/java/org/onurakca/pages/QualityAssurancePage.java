package org.onurakca.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QualityAssurancePage extends BasePage {
    @FindBy(xpath = "//*[text()='See all QA jobs']")
    public WebElement seeAllQaJobs;
    public QualityAssurancePage(WebDriver driver) {
        super(driver);
    }
}
