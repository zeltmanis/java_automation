package org.shl.selenium.va.pages.reviewer.landing;

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
import org.shl.selenium.va.pages.reviewer.InterviewPrepPage;

public class InterviewTask {
    WebDriver driver;
    WebDriverWait wait;

    private InterviewPrepPage objInterviewPrepPage;

    public InterviewTask(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    private static final String ICON = "//*[@data-testid='icon-exercise']";
    private static final String TASK_NAME = "//*[@data-testid='title-exercise']/../..//*[text()='Interview']";
    private static final String START_BUTTON = "(//*[@data-testid='button'])[1]";

    private static final String VIDEO_HEADER = "(//*[@data-testid='title-meeting'])[1]";
    private static final String VIDEO_STATUS = "(//*[@data-testid='meeting-status'])[1]";

    // Interview QA to test video in Review status
    private static final String VIDEO_REVIEW_1 = "(//*[@data-testid='button'])[1]";
    private static final String VIDEO_REVIEW = "//*[@data-testid='button']/../..//*[text()='Review']";

    @FindBy(xpath = ICON)
    WebElement icon;

    @FindBy(xpath = TASK_NAME)
    WebElement task_name;

    @FindBy(xpath = START_BUTTON)
    WebElement start_button;

    @FindBy(xpath = VIDEO_HEADER)
    WebElement video_header;

    @FindBy(xpath = VIDEO_STATUS)
    WebElement video_status;

    @FindBy(xpath = VIDEO_REVIEW_1)
    WebElement video_review_1;

    @FindBy(xpath = VIDEO_REVIEW)
    WebElement video_review;

    public String getVideoStatus() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_HEADER)));
        WebElement exerciseStatus = driver.findElement(By.xpath(VIDEO_STATUS));
        String actual = exerciseStatus.getText();
        return actual;
    }

    public String getVideoButton() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(START_BUTTON)));
        WebElement exerciseStatus = driver.findElement(By.xpath(START_BUTTON));
        String actual = exerciseStatus.getText();
        return actual;
    }

    public void clickStart() {
        objInterviewPrepPage = new InterviewPrepPage(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(START_BUTTON)));
        start_button.click();
        List<WebElement> taskElements = objInterviewPrepPage.getPreperation1Elements();
        for (WebElement e : taskElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void clickReviw() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(VIDEO_REVIEW)));
        video_review.click();
    }

    public void clickReviw1() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_REVIEW_1)));
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(VIDEO_REVIEW_1)));
        video_review_1.click();
    }

    public List<WebElement> getReviewerInterviewElements() {
        List<WebElement> reviewerInterviewElements = new ArrayList();
        reviewerInterviewElements.add(icon);
        reviewerInterviewElements.add(task_name);
        reviewerInterviewElements.add(start_button);

        return reviewerInterviewElements;
    }

}