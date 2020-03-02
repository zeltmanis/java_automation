package org.shl.selenium.va.pages.cms.exercises.createnew;

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
import org.shl.selenium.va.pages.cms.exercises.CMSExercisesLanding;

public class CMSExercisesCreateNew {

    private WebDriver driver;
    WebDriverWait wait;

    // Page Objects
    private CMSExercisesLanding objCMSExercisesLanding;
    private CMSDocuments objCMSDocuments;
    private CMSInstructions objCMSInstructions;
    private CMSTimerSettings objCMSTimerSettings;

    private boolean isElementPresent(By xpath) {
        return false;
    }

    public CMSExercisesCreateNew(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    // Page elements
    private static final String CLOSE = "/html/body/div[2]/div/div/div/button";
    private static final String SAVE_AS_DRAFT = "//button[text()='Save as draft']";
    private static final String PUBLISH = "//button[text()='Publish']";
    private static final String GENERAL_SETTINGS = "//div[text()='General settings']";
    private static final String EMAIL_CONTENT = "//div[text()='Email content']";
    private static final String DOCUMENTS = "//div[text()='Documents']";
    private static final String INSTRUCTIONS = "//div[text()='Instructions']";
    private static final String TIMER_SETTINGS = "//div[text()='Timer settings']";
    private static final String RATING_FORMS = "//div[text()='Rating forms']";

    // Page elements
    @FindBy(xpath = CLOSE)
    WebElement close;

    @FindBy(xpath = SAVE_AS_DRAFT)
    WebElement save_as_draft;

    @FindBy(xpath = PUBLISH)
    WebElement publish;

    @FindBy(xpath = GENERAL_SETTINGS)
    WebElement general_setting;

    @FindBy(xpath = EMAIL_CONTENT)
    WebElement email_content;

    @FindBy(xpath = DOCUMENTS)
    WebElement documents;

    @FindBy(xpath = INSTRUCTIONS)
    WebElement instructions;

    @FindBy(xpath = TIMER_SETTINGS)
    WebElement timer_settings;

    @FindBy(xpath = RATING_FORMS)
    WebElement rating_forms;

    public void clickSaveAsDraft() throws InterruptedException {
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SAVE_AS_DRAFT)));
        save_as_draft.click();
        assertTrue(!isElementPresent(By.xpath(SAVE_AS_DRAFT)));
        Thread.sleep(4000);
        List<WebElement> landingElements = objCMSExercisesLanding.getCMSExercisesLandingElements();
        for (WebElement e : landingElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void clickClose() {
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CLOSE)));
        close.click();
        List<WebElement> landingElements = objCMSExercisesLanding.getCMSExercisesLandingElements();
        for (WebElement e : landingElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void clickEmailContent() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EMAIL_CONTENT)));
        email_content.click();
    }

    public void clickDocuments() {
        objCMSDocuments = new CMSDocuments(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DOCUMENTS)));
        documents.click();
        assertTrue(objCMSDocuments.checkChooseFiles().isDisplayed());
        assertTrue(objCMSDocuments.checkCreateFolder().isDisplayed());
    }

    public void clickIntructions() {
        objCMSInstructions = new CMSInstructions(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(INSTRUCTIONS)));
        instructions.click();
        List<WebElement> instructionElements = objCMSInstructions.getIntructionElements();
        for (WebElement e : instructionElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void clickTimerSettings() {
        objCMSTimerSettings = new CMSTimerSettings(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TIMER_SETTINGS)));
        timer_settings.click();
        List<WebElement> timerElements = objCMSTimerSettings.getTimerElements();
        for (WebElement e : timerElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }

    }

    public void clickRatingForms() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(RATING_FORMS)));
        rating_forms.click();
    }

    public List<WebElement> getCMSExercisesCreatesNewElements() {
        List<WebElement> CMSExerciseCreateNewElements = new ArrayList();
        CMSExerciseCreateNewElements.add(close);
        CMSExerciseCreateNewElements.add(save_as_draft);
        CMSExerciseCreateNewElements.add(publish);
        CMSExerciseCreateNewElements.add(general_setting);
        CMSExerciseCreateNewElements.add(email_content);
        CMSExerciseCreateNewElements.add(documents);
        CMSExerciseCreateNewElements.add(instructions);
        CMSExerciseCreateNewElements.add(timer_settings);
        CMSExerciseCreateNewElements.add(rating_forms);

        return CMSExerciseCreateNewElements;
    }

}