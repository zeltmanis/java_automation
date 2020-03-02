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

public class Interview {
    WebDriver driver;
    WebDriverWait wait;

    private StartTask objStartTask;
    private CandidateVideo objCandidateVideo;

    public Interview(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 30);
    }

    // Starting page interview task elements
    private static final String ICON = "(//*[@data-testid='icon-task'])[3]";
    private static final String TASK_NAME = "(//*[@data-testid='name-task'])[3]";
    private static final String START_BUTTON = "(//*[@data-testid='button-task-start'])[3]";

    // Opened interview task elements
    private static final String VIDEO_STATUS = "//*[@data-testid='meeting-status']";
    private static final String VIDEO_START = "//*[@data-testid='button']";

    // Starting page interview task elements
    @FindBy(xpath = ICON)
    WebElement icon;

    @FindBy(xpath = TASK_NAME)
    WebElement task_name;

    @FindBy(xpath = START_BUTTON)
    WebElement start_button;

    // Opened interview task elements
    @FindBy(xpath = VIDEO_STATUS)
    WebElement video_status;

    @FindBy(xpath = VIDEO_START)
    WebElement video_start;

    public String getVideoStatus() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_STATUS)));
        WebElement videoStatus = driver.findElement(By.xpath(VIDEO_STATUS));
        String actual = videoStatus.getText();
        return actual;
    }

    public void startVideo() {
        objCandidateVideo = new CandidateVideo(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(VIDEO_START)));
        video_start.click();
        objCandidateVideo.getVideo();
    }

    public void clickStart() {
        objStartTask = new StartTask(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(START_BUTTON)));
        start_button.click();
        List<WebElement> taskElements = objStartTask.getStartTaskElements();
        for (WebElement e : taskElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public List<WebElement> getCandidateInterviewElements() {
        List<WebElement> candidateInterviewElements = new ArrayList();
        candidateInterviewElements.add(icon);
        candidateInterviewElements.add(task_name);
        candidateInterviewElements.add(start_button);

        return candidateInterviewElements;
    }
}