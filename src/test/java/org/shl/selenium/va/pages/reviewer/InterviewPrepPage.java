package org.shl.selenium.va.pages.reviewer;

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

public class InterviewPrepPage {
    WebDriver driver;
    WebDriverWait wait;

    private boolean isElementPresent(By xpath) {
        return false;
    }

    public InterviewPrepPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    // Video side elements
    private static final String BACK_BUTTON = "//*[@data-testid='button-back']";
    private static final String VIDEO = "//*[@class='sc-gHboQg eLpzfs']";
    private static final String START_BUTTON = "//div[contains(button,'') and text()='Start']";
    private static final String SHL_LOGO = "//*[@id='root']/div/div[1]/div/img";

    // Tag side elements
    private static final String USER_NAME = "(//*[@data-testid='title'])[1]";
    private static final String STATUS_TITLE = "(//*[@data-testid='subtitle'])[1]";
    private static final String CANDIDATE_STATUS = "//*[@data-testid='status']";
    private static final String TAG_BOX_TITLE = "//*[@data-testid='label']";
    private static final String TAG_BOX = "//*[@data-testid='input-custom-tag']";
    private static final String TAGS = "(//*[@data-testid='title'])[2]";
    private static final String ADD_TAG = "//*[@data-testid='button-add']";
    private static final String WARNING_TAG = "//*[@data-testid='error-custom-tag']";
    private static final String ERROR_BUTTON = "//*[@data-testid='icon-error']";

    // Started Video elements
    private static final String END_VIDEO = "//*[@id='root']/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]/div[4]";
    private static final String MESSAGE_YES = "/html/body/div[2]/div/div/div/button[1]";
    private static final String START_VIDEO_RECORDING = "//*[@id='root']/div/div[2]/div/div/div[1]/div/div/div[2]/div/button/div";

    @FindBy(xpath = BACK_BUTTON)
    WebElement back_button;

    @FindBy(xpath = VIDEO)
    WebElement video;

    @FindBy(xpath = START_BUTTON)
    WebElement start_button;

    @FindBy(xpath = USER_NAME)
    WebElement user_name;

    @FindBy(xpath = STATUS_TITLE)
    WebElement status_title;

    @FindBy(xpath = CANDIDATE_STATUS)
    WebElement candidate_status;

    @FindBy(xpath = TAG_BOX_TITLE)
    WebElement tag_box_title;

    @FindBy(xpath = TAG_BOX)
    WebElement tag_box;

    @FindBy(xpath = TAGS)
    WebElement tags;

    @FindBy(xpath = ADD_TAG)
    WebElement add_tag;

    @FindBy(xpath = WARNING_TAG)
    WebElement warning_tag;

    @FindBy(xpath = ERROR_BUTTON)
    WebElement error_button;

    @FindBy(xpath = END_VIDEO)
    WebElement end_video;

    @FindBy(xpath = MESSAGE_YES)
    WebElement message_yes;

    @FindBy(xpath = SHL_LOGO)
    WebElement shl_logo;

    @FindBy(xpath = START_VIDEO_RECORDING)
    WebElement start_video_recording;

    public String getStatus() {

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CANDIDATE_STATUS)));
        WebElement candidateStatus = driver.findElement(By.xpath(CANDIDATE_STATUS));
        String actual = candidateStatus.getText();
        return actual;
    }

    public String getWarningTag() {

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WARNING_TAG)));
        WebElement warningTag = driver.findElement(By.xpath(WARNING_TAG));
        String actual = warningTag.getText();
        return actual;
    }

    public String getMax30CharMsg() {

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WARNING_TAG)));
        WebElement warningTag = driver.findElement(By.xpath(WARNING_TAG));
        String actual = warningTag.getText();
        return actual;
    }

    public String getExistTag() {

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WARNING_TAG)));
        WebElement existTag = driver.findElement(By.xpath(WARNING_TAG));
        String actual = existTag.getText();
        return actual;
    }

    public void enterTag(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TAG_BOX)));
        tag_box.sendKeys(text);
    }

    public void addTag() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADD_TAG)));
        add_tag.click();

    }

    public void startVideo() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(START_BUTTON)));
        start_button.click();
    }

    public void finishVideo() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(END_VIDEO)));
        end_video.click();
    }

    public void acceptFinish() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE_YES)));
        message_yes.click();
    }

    public void checkError() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_BUTTON)));
    }

    public void emptyTag(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TAG_BOX)));
        assertTrue(!isElementPresent(By.xpath(ADD_TAG)));
        tag_box.sendKeys(text);
        assertTrue(!isElementPresent(By.xpath(ADD_TAG)));
    }

    public void startInterview() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(START_BUTTON)));
        start_button.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(USER_NAME)));
        List<WebElement> preparation1Elements = getPreperation1Elements();
        for (WebElement e : preparation1Elements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void clickBack() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BACK_BUTTON)));
        back_button.click();
    }

    public void clickLogo() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SHL_LOGO)));
        shl_logo.click();
    }

    public void startVideoRecording() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(START_VIDEO_RECORDING)));
        start_video_recording.click();
    }

    public List<WebElement> getPreperation1Elements() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BACK_BUTTON)));
        List<WebElement> preparation1elements = new ArrayList();
        // preparation1elements.add(back_button);
        // preparation1elements.add(video);
        preparation1elements.add(start_button);
        preparation1elements.add(user_name);
        preparation1elements.add(status_title);
        preparation1elements.add(candidate_status);
        preparation1elements.add(tag_box_title);
        preparation1elements.add(tag_box);
        preparation1elements.add(tags);

        return preparation1elements;
    }

}