package org.onurakca.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.onurakca.tests.BaseTest;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    public final String moreNaviBar = "//*[text()='More']";
    public final String careers = "//*[text()='Careers']";
    public final String acceptCookies= "wt-cli-accept-all-btn";
    public final String mainPageId = "main-head";
    public static Logger log = LogManager.getLogger(MainPage.class.getName());
    public MainPage(WebDriver driver) {
        super(driver);
    }


}
