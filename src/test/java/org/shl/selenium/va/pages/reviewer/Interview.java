package org.shl.selenium.va.pages.reviewer;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Interview {
    WebDriver driver;
    WebDriverWait wait;

    public Interview(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    private boolean isElementPresent(By xpath) {
        return false;
    }

    // Video elements
    private static final String VIDEO = "//*[@id='root']/div/div[2]/div/div/div[1]/div[1]/div";
    private static final String FINISH_VIDEO = "//*[@id='root']/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div[4]";
    private static final String CAMERA = "//*[@id='root']/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div[2]";
    private static final String MICROPHONE = "//*[@id='root']/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div[1]";
    private static final String VIDEO_FEEDBACK = "//*[@id='root']/div/div[2]/div/div/div[1]//*[text()='Automation Feedback']";

    // Tagging elements
    private static final String TAGGING_TITLE = "//*[@data-testid='tab-title']";
    private static final String EXAMPLE_TAG_TITLE_1 = "(//*[@data-testid='competency-title'])[1]";
    private static final String EXAMPLE_TAG_TITLE_2 = "(//*[@data-testid='competency-title'])[2]";
    private static final String EXAMPLE_TAG_TITLE_3 = "(//*[@data-testid='competency-title'])[3]";
    private static final String EXAMPLE_TAG_TITLE_4 = "(//*[@data-testid='competency-title'])[4]";
    private static final String TAG_STRATEGY = "//*[@data-testid='tag']/../..//*[text()='Clear Strategy']";
    private static final String TAG_LIKE = "//*[@data-testid='tag']/../..//*[text()='Clear Strategy']//*[@data-testid='like-button']";
    private static final String VIDEO_TAG = "//div[contains(@data-testid,'highlights-row')]//span[contains(@class,'') and text()='Clear Strategy']";
    private static final String OPEN_DELETE = "//*[@data-testid='button-options']";
    private static final String DELETE_BUTTON = "//*[@data-testid='delete-option']";

    // Feeback elements
    private static final String FEEDBACK_TITLE = "//*[@data-testid='label-feedback']";
    private static final String FEEDBACK_BOX = "//*[@data-testid='feedback-input']";
    private static final String ADD_BUTTON = "//*[@data-testid='button-add']";

    // Video elements
    @FindBy(xpath = VIDEO)
    WebElement video;

    @FindBy(xpath = FINISH_VIDEO)
    WebElement finish_video;

    @FindBy(xpath = CAMERA)
    WebElement camera;

    @FindBy(xpath = MICROPHONE)
    WebElement microphone;

    @FindBy(xpath = VIDEO_FEEDBACK)
    WebElement video_feedback;

    // Tagging elements
    @FindBy(xpath = TAGGING_TITLE)
    WebElement tagging_title;

    @FindBy(xpath = EXAMPLE_TAG_TITLE_1)
    WebElement example_tag_title_1;

    @FindBy(xpath = EXAMPLE_TAG_TITLE_2)
    WebElement example_tag_title_2;

    @FindBy(xpath = EXAMPLE_TAG_TITLE_3)
    WebElement example_tag_title_3;

    @FindBy(xpath = EXAMPLE_TAG_TITLE_4)
    WebElement example_tag_title_4;

    // Feedback elements
    @FindBy(xpath = FEEDBACK_TITLE)
    WebElement feedback_title;

    @FindBy(xpath = FEEDBACK_BOX)
    WebElement feedback_box;

    @FindBy(xpath = ADD_BUTTON)
    WebElement add_box;

    @FindBy(xpath = TAG_LIKE)
    WebElement tag_like;

    @FindBy(xpath = TAG_STRATEGY)
    WebElement tag_strategy;

    @FindBy(xpath = VIDEO_TAG)
    WebElement video_tag;

    @FindBy(xpath = OPEN_DELETE)
    WebElement open_delete;

    @FindBy(xpath = DELETE_BUTTON)
    WebElement delete_button;

    public void clickFinishButton() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FINISH_VIDEO)));
        finish_video.click();

    }

    public void enterFeedback(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FEEDBACK_BOX)));
        feedback_box.sendKeys(text);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADD_BUTTON)));
        add_box.click();
    }

    public WebElement checkAddedFeedback() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_FEEDBACK)));
        return video_feedback;
    }

    public void getAddedFeedback() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_FEEDBACK)));
        assertTrue(checkAddedFeedback().isDisplayed());
    }

    public void addTag() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TAG_LIKE)));
        tag_like.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_TAG)));
    }

    public WebElement checkVideoTag() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_TAG)));
        return video_tag;
    }

    public void getVideoTag() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO_TAG)));
        assertTrue(checkVideoTag().isDisplayed());
    }

    public void hoverTag() {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(TAG_STRATEGY));
        builder.moveToElement(element).build().perform();
    }

    public void deleteTag() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OPEN_DELETE)));
        open_delete.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DELETE_BUTTON)));
        delete_button.click();
        assertTrue(!isElementPresent(By.xpath(VIDEO_TAG)));
    }

    public List<WebElement> getInterviewElements() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO)));
        List<WebElement> interviewElements = new ArrayList();
        interviewElements.add(video);
        interviewElements.add(finish_video);
        interviewElements.add(camera);
        interviewElements.add(microphone);
        interviewElements.add(tagging_title);
        interviewElements.add(example_tag_title_1);
        interviewElements.add(example_tag_title_2);
        interviewElements.add(example_tag_title_3);
        interviewElements.add(example_tag_title_4);
        interviewElements.add(feedback_title);
        interviewElements.add(feedback_box);

        return interviewElements;
    }
}