package org.onurakca.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class OpenPositionsPage extends BasePage {
    @FindBy(id = "filter-by-location")
    public WebElement filterByLocationDropdown;
    public String location = "Istanbul, Turkey";
    public String depertmant = "Quality Assurance";
    @FindBy(xpath = "(//*[@role='presentation'])[1]")
    public WebElement dropDownMenu;
    @FindBy(xpath = "//*[@class='select2-results']//li[2]")
    public WebElement selecLocation;
    @FindBy(xpath = "//*[@selected='selected']")
    public WebElement filterByDepartment;
    @FindBy(id = "jobs-list")
    public WebElement jobList;
    @FindBy(xpath = "//*[@href='https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc']")
    public WebElement applyNowButton;

    @FindBy(xpath = "//*[@href='https://useinsider.com/request-a-demo/']")
    public WebElement getADemoBtn;
    public static Logger log = LogManager.getLogger(OpenPositionsPage.class.getName());
    private long timeOutInSeconds = 90L;

    public OpenPositionsPage(WebDriver driver) {
        super(driver);
    }

    public void checkFilterByDepartmantSelectedQa() {
        String text = filterByDepartment.getText();
        waitElementLoad(filterByDepartment);
        waitElementLoad(getADemoBtn);
        Assertions.assertEquals(depertmant, text);
        log.info("departman filitresinde " + depertmant + " seçili");
    }


    public void checkJobDetails() {
        List<WebElement> childreen = jobList.findElements(By.xpath("./*"));

        try {
            for (WebElement child : childreen) {
                findScrollElementCenter(child);
                waitUntilElementClickable(child);
                moveToElement(child);
                Assertions.assertTrue(child.getText().contains("Quality Assurance"));
                Assertions.assertTrue(child.getText().contains("Istanbul, Turkey"));
                Assertions.assertTrue(child.getText().contains("Apply Now"));
                log.info("job detayları kontrol edildi");
            }
        } catch (Exception e) {
            log.error("job detayları hatalı");
            log.error(e.getMessage());
            screenShot("jobdetails");
        }
    }

    public void waitUntilElementClickable(WebElement elementFindBy) {
        try {
            FluentWait<WebDriver> wait = (new WebDriverWait(driver, Duration.ofSeconds(this.timeOutInSeconds))).pollingEvery(Duration.ofSeconds(5L)).withTimeout(Duration.ofSeconds(this.timeOutInSeconds)).ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.elementToBeClickable(elementFindBy));
        } catch (Throwable var3) {
            log.error(var3.getMessage());
            Assertions.fail("Element: " + elementFindBy + " WebElement click edilebilir durumda degil !!");
            screenShot("elementNotClick");
        }

    }

    public void selectLocationDropDownMenu(WebElement webElement1, WebElement webElement2) {

        //.//option[normalize-space(.) = "Istanbul, Turkey"
        try {
            //Select s = new Select(webElement);
            //s.selectByValue("Istanbul, Turkey");

            webElement1.click();
            waitElementLoad(webElement2);
            webElement2.click();

        } catch (Exception e) {
            log.info(e.getMessage());
            Assertions.fail();
        }

    }
}