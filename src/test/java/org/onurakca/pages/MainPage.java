package org.onurakca.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "//*[text()='More']")
    public WebElement moreNaviBar;
    @FindBy(xpath = "//*[text()='Careers']")
    public WebElement careers;
    @FindBy(id = "wt-cli-accept-all-btn")
    public WebElement acceptCookies;
    @FindBy(id = "main-head")
    public WebElement mainPageId;
    public static Logger log = LogManager.getLogger(MainPage.class.getName());

    public MainPage(WebDriver driver) {
        super(driver);
    }


}
