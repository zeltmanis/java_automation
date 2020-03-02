package org.shl.selenium.va.pages.candidate;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CandidateVideo {
    WebDriver driver;
    WebDriverWait wait;

    public CandidateVideo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 30);
    }

    private static final String VIDEO = "//*[@data-testid='video']";
    private static final String EMAIL_TAB = "(//*[@data-testid='tab-title'])[1]";
    private static final String DOCUMENT_TAB = "(//*[@data-testid='tab-title'])[2]";

    @FindBy(xpath = VIDEO)
    WebElement video;

    @FindBy(xpath = EMAIL_TAB)
    WebElement email_tab;

    @FindBy(xpath = DOCUMENT_TAB)
    WebElement document_tab;

    public WebElement checkVideo() {
        return video;
    }

    public void getVideo() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO)));
        assertTrue(checkVideo().isDisplayed());
    }

    public List<WebElement> getVideoPageElements() {
        List<WebElement> videoPageElements = new ArrayList();
        videoPageElements.add(video);
        videoPageElements.add(email_tab);
        videoPageElements.add(document_tab);

        return videoPageElements;
    }
}