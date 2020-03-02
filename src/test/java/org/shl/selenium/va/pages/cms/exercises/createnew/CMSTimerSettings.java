package org.shl.selenium.va.pages.cms.exercises.createnew;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CMSTimerSettings {

    private WebDriver driver;
    WebDriverWait wait;

    public CMSTimerSettings(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    // Page elements
    private static final String TIMER = "(//*[@data-testid='label'])[1]";
    private static final String TIMER_BOX = "(//*[@data-testid='input'])[1]";
    private static final String ALERT_AT = "(//*[@data-testid='label'])[2]";
    private static final String ALERT_AT_BOX = "(//*[@data-testid='input'])[2]";

    @FindBy(xpath = TIMER)
    WebElement timer;

    @FindBy(xpath = TIMER_BOX)
    WebElement timer_box;

    @FindBy(xpath = ALERT_AT)
    WebElement alert_at;

    @FindBy(xpath = ALERT_AT_BOX)
    WebElement alert_at_box;

    public void enterTimer(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TIMER_BOX)));
        timer_box.click();
        timer_box.clear();
        timer_box.sendKeys(text);
    }

    public void enterAlertAt(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ALERT_AT_BOX)));
        alert_at_box.click();
        alert_at_box.clear();
        alert_at_box.sendKeys(text);

    }

    public List<WebElement> getTimerElements() {
        List<WebElement> timerElements = new ArrayList();
        timerElements.add(timer);
        timerElements.add(timer_box);
        timerElements.add(alert_at);
        timerElements.add(alert_at_box);

        return timerElements;
    }
}