package org.onurakca.pages;

import com.google.common.io.Files;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.onurakca.tests.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public static Logger log = LogManager.getLogger(BasePage.class.getName());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        PageFactory.initElements(driver, this);
    }

    public String getPageUrl() {

        return driver.getCurrentUrl();

    }

    public void checkPageUrl(String expectedUrl) {

        try {
            Assertions.assertEquals(expectedUrl, getPageUrl());
            log.info("expectedUrl=" + expectedUrl);
            log.info("currentUrl=" + driver.getCurrentUrl());
        } catch (AssertionError e) {
            screenShot("SayfaUrl");
            log.error(e.toString());
            Assertions.fail();
        }


    }

    public void isDisplayedById(String id) {

        try {
            WebElement webElement = driver.findElement(By.id(id));
            log.info("id' si " + id + " olan obje bulundu.");
            try {
                Assertions.assertTrue(webElement.isDisplayed());
                log.info("id' si " + id + " olan obje görünürdür.");
            } catch (AssertionError e) {
                screenShot("Görünür değil ");
                log.info("id' si " + id + " olan obje görünür değil.");
                log.error(e.toString());
            }

        } catch (NoSuchElementException e) {
            screenShot("Bulunamayan obje");
            log.info("id' si " + id + " olan obje bulunamadı.");
            log.error(e.toString());

        }

    }public void isDisplayedByXpath(String xPath) {

        try {
            WebElement webElement = driver.findElement(By.xpath(xPath));
            log.info("xPath' i " + xPath + " olan obje bulundu.");
            try {
                Assertions.assertTrue(webElement.isDisplayed());
                log.info("xPath' i " + xPath + " olan obje görünürdür.");
            } catch (AssertionError e) {
                screenShot("Görünür değil");
                log.info("xPath' i " + xPath + " olan obje görünür değil.");
                log.error(e.toString());
            }

        } catch (NoSuchElementException e) {
            screenShot("Bulunamayan obje");
            log.info("xPath' i " + xPath + " olan obje bulunamadı.");
            log.error(e.toString());

        }

    }


    public void clickByXpath(String xpath) {

        try {
            driver.findElement(By.xpath(xpath)).click();
            log.info(xpath+" xpathi olan elemente tıklandı");
        }catch (NoSuchElementException e){
            screenShot("clickByXpath");
            log.error(e.toString());

        }

    }
    public void clickById(String id){
        try {
            driver.findElement(By.id(id)).click();
            log.info(id+" xpathi olan elemente tıklandı");
        }catch (NoSuchElementException e){
            screenShot("clickById");
            log.error(e.toString());

        }
    }
    public void screenShot(String ssName){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File image = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(image,new File("src/test/resources/ScreenShots/"+ssName+".png"));
            log.info(ssName+" ScreenShotı başarılı bir şekilde kaydedildi");
        } catch (IOException e) {
            log.error(e.toString());
        }


    }

    public void scrollDowntoWebElement(String xpath) {
        WebElement webElement = xPathToWebElement(xpath);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public WebElement xPathToWebElement(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
    public void forceClick(String s) {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", xPathToWebElement(s));
    }
    public void waitElementLoad(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }



}
