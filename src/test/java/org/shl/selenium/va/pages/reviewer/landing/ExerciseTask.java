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
import org.shl.selenium.va.pages.reviewer.ExerciseReview;

public class ExerciseTask {
    WebDriver driver;
    WebDriverWait wait;

    private ExerciseReview objExerciseReview;

    public ExerciseTask(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    private static final String ICONS = "//*[@data-testid='icon-exercise']";
    private static final String TASK_HEADER = "//*[@data-testid='title-exercise']";
    private static final String EXERCISE_HEADER = "//*[@data-testid='title-experience-task']";
    private static final String EXERCISE_STATUS = "(//*[@data-testid='experience-task-status'])[1]";
    private static final String EXERCISE_BUTTON = "(//*[@data-testid='button'])[1]";
    private static final String VIDEO_HEADER = "//*[@data-testid='title-meeting']";
    private static final String VIDEO_STATUS = "(//*[@data-testid='meeting-status'])[1]";
    private static final String VIDEO_BUTTON = "(//*[@data-testid='button'])[2]";

    @FindBy(xpath = ICONS)
    WebElement icons;

    @FindBy(xpath = TASK_HEADER)
    WebElement task_header;

    @FindBy(xpath = EXERCISE_HEADER)
    WebElement exercise_header;

    @FindBy(xpath = EXERCISE_STATUS)
    WebElement exercise_status;

    @FindBy(xpath = EXERCISE_BUTTON)
    WebElement exercise_button;

    @FindBy(xpath = VIDEO_HEADER)
    WebElement video_header;

    @FindBy(xpath = VIDEO_STATUS)
    WebElement video_status;

    @FindBy(xpath = VIDEO_BUTTON)
    WebElement video_button;

    public void reviewExercise() {
        objExerciseReview = new ExerciseReview(driver);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EXERCISE_BUTTON)));
        exercise_button.click();
        List<WebElement> exerciseElements = objExerciseReview.getDocumentElements();
        for (WebElement e : exerciseElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void startVideo() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(VIDEO_BUTTON)));
        video_button.click();
    }

    public List<WebElement> getReviewerExerciseElements() {
        List<WebElement> reviewerExerciseElements = new ArrayList();
        reviewerExerciseElements.add(icons);
        reviewerExerciseElements.add(task_header);
        reviewerExerciseElements.add(exercise_header);
        reviewerExerciseElements.add(exercise_status);
        reviewerExerciseElements.add(video_header);
        reviewerExerciseElements.add(video_status);

        return reviewerExerciseElements;
    }
}