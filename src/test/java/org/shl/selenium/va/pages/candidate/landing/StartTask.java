package org.shl.selenium.va.pages.candidate.landing;

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
import org.shl.selenium.va.pages.candidate.CandidateVideo;

public class StartTask {
    WebDriver driver;
    WebDriverWait wait;

    private CandidateVideo objCandidateVideo;

    private boolean isElementPresent(By xpath) {
        return false;
    }

    public StartTask(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 30);
    }

    private static final String WELCOME_TEXT = "//h3[text()='Welcome to this business simulation exercise. You need to complete the following task']";
    private static final String ICONS = "//*[@data-testid='icon-exercise']";
    private static final String TASK_HEADER = "//*[@data-testid='title-exercise']";
    // Exercise
    private static final String EXERCISE_HEADER = "//*[@data-testid='title-experience-task']";
    private static final String EXERCISE_STATUS = "//*[@data-testid='experience-task-status']";
    private static final String EXERCISE_START = "//*[@data-testid='button']";

    // Interview
    private static final String VIDEO_HEADER = "//*[@data-testid='title-meeting']";
    private static final String VIDEO_STATUS = "//*[@data-testid='meeting-status']";
    private static final String VIDEO_START = "//*[@data-testid='button']";

    @FindBy(xpath = WELCOME_TEXT)
    WebElement welcome_text;

    @FindBy(xpath = ICONS)
    WebElement icons;

    @FindBy(xpath = TASK_HEADER)
    WebElement task_header;

    // Exercise
    @FindBy(xpath = EXERCISE_HEADER)
    WebElement exercise_header;

    @FindBy(xpath = EXERCISE_STATUS)
    WebElement exercise_status;

    @FindBy(xpath = EXERCISE_START)
    WebElement exercise_start;

    // Interview
    @FindBy(xpath = VIDEO_HEADER)
    WebElement video_header;

    @FindBy(xpath = VIDEO_STATUS)
    WebElement video_status;

    @FindBy(xpath = VIDEO_START)
    WebElement video_start;

    public void startExercise() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EXERCISE_START)));
        assertTrue(!isElementPresent(By.xpath(VIDEO_START)));
        exercise_start.click();
    }

    public String getExerciseStatus() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EXERCISE_STATUS)));
        WebElement exerciseStatus = driver.findElement(By.xpath(EXERCISE_STATUS));
        String actual = exerciseStatus.getText();
        return actual;
    }

    public void startVideo() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(VIDEO_START)));
        assertTrue(!isElementPresent(By.xpath(EXERCISE_START)));
        video_start.click();
    }

    public void startMultiTaskVideo() {
        objCandidateVideo = new CandidateVideo(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(VIDEO_START)));
        video_start.click();
        List<WebElement> videoElements = objCandidateVideo.getVideoPageElements();
        for (WebElement e : videoElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public String getVideoStatus() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_STATUS)));
        WebElement videoStatus = driver.findElement(By.xpath(VIDEO_STATUS));
        String actual = videoStatus.getText();
        return actual;
    }

    public List<WebElement> getStartTaskElements() {
        List<WebElement> startAnalysisElements = new ArrayList();
        startAnalysisElements.add(welcome_text);
        startAnalysisElements.add(icons);
        startAnalysisElements.add(task_header);

        return startAnalysisElements;
    }
}