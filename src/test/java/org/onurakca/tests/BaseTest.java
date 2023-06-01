package org.onurakca.tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.onurakca.config.PropertiesFile;
import org.onurakca.pages.CareersPage;
import org.onurakca.pages.MainPage;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public static Logger log = LogManager.getLogger(BaseTest.class.getName());

    Properties prop = PropertiesFile.readPropertiesFile();
    String url = prop.getProperty("url");
    String browserType = prop.getProperty("browser");


    MainPage mainPage;
    CareersPage careersPage;

    @BeforeEach
    void setup() {

        if (browserType.contains("Chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            log.info("chrome driverda url=" + url + " açıldı");
        } else if (browserType.contains("Firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            driver.get(url);
            log.info("Firefox driverda url=" + url + " açıldı");
        } else {
            log.error("config.properties dosyasına geçerli browser girin.Firefox veya Chrome");
        }
        mainPage = new MainPage(driver);
        careersPage = new CareersPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }
}
