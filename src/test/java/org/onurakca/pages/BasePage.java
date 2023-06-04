package org.onurakca.pages;

import com.google.common.io.Files;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(90L));
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
            log.info("sayfanın urlsi kontrol edilirken hata alındı");
            log.error(e.toString());
            Assertions.fail();
        }
    }

    public void isDisplayed(WebElement webElement) {
        try {
            Assertions.assertTrue(webElement.isDisplayed());
            log.info("obje görünür");
        } catch (AssertionError e) {
            screenShot("Görünür değil ");
            log.info("obje görünür değil.");
            log.error(e.getMessage());
            Assertions.fail();
        }
    }

    public void clickToElement(WebElement webElement) {
        try {
            webElement.click();
            log.info(webElement + " xpathi olan elemente tıklandı");
        } catch (NoSuchElementException e) {
            screenShot("clickToWebElement");
            log.info("elemente tıklanırken hata alındı");
            log.error(e.toString());
            Assertions.fail();
        }
    }

    public void screenShot(String ssName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File image = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(image, new File("src/test/resources/ScreenShots/" + ssName + ".png"));
            log.info(ssName + " ScreenShotı başarılı bir şekilde kaydedildi");
        } catch (IOException e) {
            log.info("screenshot alınamadı");
            log.error(e.toString());
            Assertions.fail();
        }
    }


    public void forceClick(WebElement webElement) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", webElement);
        log.info("elemente zorla tıklanır");
    }

    public void waitElementLoad(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        log.info("elementin yüklenmesi beklenir");
    }





    public void switchToNewTab() {
        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        log.info("Yeni tab'a geçildi");
    }

    public void moveToElement(WebElement element) {

        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            wait.until(ExpectedConditions.visibilityOf(element));
            log.info("elementin üstüne gidildi");
        } catch (Exception e) {
            log.info("elementin üstüne gidilirken hata alındı");
            log.error(e.getMessage());
            screenShot("moveElement");
            Assertions.fail();
        }

    }

    public void findScrollElementCenter(WebElement webElement) {
        try {
            String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                    + "var elementTop = arguments[0].getBoundingClientRect().top;"
                    + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
            ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, webElement);
            TimeUnit.SECONDS.sleep(1);
            log.info("elemente scroll edildi");
        } catch (Exception e) {
            log.info("elemente scroll edilemedi");
            log.error(e.getMessage());
            screenShot("scrollElementCenter");
            Assertions.fail(webElement + " scroll edilirken problem oluştu.");


        }
    }
}