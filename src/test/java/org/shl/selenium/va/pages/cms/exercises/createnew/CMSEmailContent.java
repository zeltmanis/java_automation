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
import org.shl.selenium.va.utils.Utils;

public class CMSEmailContent {

    private WebDriver driver;
    WebDriverWait wait;

    public CMSEmailContent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    private boolean isElementPresent(By xpath) {
        return false;
    }

    String[] tag = Utils.generateRandomWords(1);

    // Page elements
    private static final String ADD_EMAIL = "//*[@data-testid='button-add-email']";
    private static final String EMAIL = "//*[@data-testid='panel-email-list-item']";
    private static final String EMAIL_SENDER = "//*[@data-testid='sender']";
    private static final String EMAIL_SUBJECT = "//*[@data-testid='subject']";
    private static final String EMAIL_DOCUMENT = "//*[@data-testid='document-0']";
    private static final String EMAIL_OPTIONS = "//*[@data-testid='controls']";
    private static final String EDIT = "(//*[@data-testid='option'])[1]";
    private static final String REMOVE = "(//*[@data-testid='option'])[2]";

    // Add email pop-up
    private static final String TIME = "(//*[@data-testid='label'])[1]";
    private static final String TIME_BOX = "(//*[@data-testid='label'])[1]";
    private static final String DATE = "(//*[@data-testid='label'])[2]";
    private static final String DATE_BOX = "(//*[@data-testid='input'])[2]";
    private static final String FROM = "(//*[@data-testid='label'])[3]";
    private static final String FROM_BOX = "(//*[@data-testid='input'])[3]";
    private static final String FROM_WARNING = "(//*[@data-testid='input-error'])[3]";
    private static final String SUBJECT = "(//*[@data-testid='label'])[4]";
    private static final String SUBJECT_BOX = "(//*[@data-testid='input'])[4]";
    private static final String SUBJECT_WARNING = "(//*[@data-testid='input-error'])[4]";
    private static final String BODY_BOX = "//*[@role='textbox']";
    private static final String ADD_ATTACHMENTS = "//*[@data-testid='button-add-attachments']";
    private static final String DISCARD_CHANGES = "//*[@data-testid='button-close']";
    private static final String SAVE_CHANGES = "//*[@data-testid='button-next']";
    private static final String ADDED_ATTACHMENT = "//*[@data-testid='document-0']";
    private static final String REMOVE_ATTACHMENT = "//*[@data-testid='icon-document-remove']";

    // Add attachment to email through add email pop-up
    private static final String NAME = "//*[@data-testid='title-name']";
    private static final String FILE_CHECK_BOX = "(//*[@data-testid='checkbox'])[2]";
    private static final String CLOSE = "(//*[@data-testid='button-close'])[2]";
    private static final String ADD_FILES = "(//*[@data-testid='button-next'])[2]";

    // Page elements
    @FindBy(xpath = ADD_EMAIL)
    WebElement add_email;

    @FindBy(xpath = EMAIL)
    WebElement email;

    @FindBy(xpath = EMAIL_SENDER)
    WebElement email_sender;

    @FindBy(xpath = EMAIL_SUBJECT)
    WebElement email_subject;

    @FindBy(xpath = EMAIL_DOCUMENT)
    WebElement email_document;

    @FindBy(xpath = EMAIL_OPTIONS)
    WebElement email_options;

    @FindBy(xpath = EDIT)
    WebElement edit;

    @FindBy(xpath = REMOVE)
    WebElement remove;

    // Add email pop-up
    @FindBy(xpath = TIME)
    WebElement time;

    @FindBy(xpath = TIME_BOX)
    WebElement time_box;

    @FindBy(xpath = DATE)
    WebElement date;

    @FindBy(xpath = DATE_BOX)
    WebElement date_box;

    @FindBy(xpath = FROM)
    WebElement from;

    @FindBy(xpath = FROM_BOX)
    WebElement from_box;

    @FindBy(xpath = FROM_WARNING)
    WebElement from_warning;

    @FindBy(xpath = SUBJECT)
    WebElement subject;

    @FindBy(xpath = SUBJECT_BOX)
    WebElement subject_box;

    @FindBy(xpath = SUBJECT_WARNING)
    WebElement subject_warning;

    @FindBy(xpath = BODY_BOX)
    WebElement body_box;

    @FindBy(xpath = ADD_ATTACHMENTS)
    WebElement add_attachments;

    @FindBy(xpath = REMOVE_ATTACHMENT)
    WebElement remove_attachment;

    @FindBy(xpath = DISCARD_CHANGES)
    WebElement discard_changes;

    @FindBy(xpath = SAVE_CHANGES)
    WebElement save_changes;

    // Add attachment to email through add email pop-up
    @FindBy(xpath = NAME)
    WebElement name;

    @FindBy(xpath = FILE_CHECK_BOX)
    WebElement file_check_box;

    @FindBy(xpath = CLOSE)
    WebElement close;

    @FindBy(xpath = ADD_FILES)
    WebElement add_files;

    public void clickAddEmail() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_EMAIL)));
        add_email.click();
        List<WebElement> elements = getAddEmailElements();
        for (WebElement e : elements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void enterFrom(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FROM_BOX)));
        from_box.click();
        from_box.clear();
        from_box.sendKeys(text);
    }

    public void enterSubject(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUBJECT_BOX)));
        subject_box.click();
        subject_box.clear();
        subject_box.sendKeys(text);
    }

    public void enterEmailBody(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BODY_BOX)));
        body_box.click();
        body_box.clear();
        body_box.sendKeys(text);
    }

    public void clickAddAttachment() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_ATTACHMENTS)));
        add_attachments.click();
    }

    public void selectAttachment() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FILE_CHECK_BOX)));
        file_check_box.click();
    }

    public void clickAddFiles() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_FILES)));
        add_files.click();
    }

    public String getAttachment() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADDED_ATTACHMENT)));
        WebElement attachment = driver.findElement(By.xpath(ADDED_ATTACHMENT));
        String actual = attachment.getText();
        return actual;
    }

    public void removeAttachment() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(REMOVE_ATTACHMENT)));
        remove_attachment.click();
    }

    public void clickSave() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SAVE_CHANGES)));
        save_changes.click();
    }

    public String getEmailFrom() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL)));
        WebElement fromElement = driver.findElement(By.xpath(EMAIL_SENDER));
        String actual = fromElement.getText();
        return actual;
    }

    public String getEmailSubject() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL)));
        WebElement subjectElement = driver.findElement(By.xpath(EMAIL_SUBJECT));
        String actual = subjectElement.getText();
        return actual;
    }

    public void openEmailOptions() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EMAIL_OPTIONS)));
        email_options.click();
    }

    public void clickEdit() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT)));
        edit.click();
    }

    public void clickRemove() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(REMOVE)));
        remove.click();
    }

    public void checkEmailDeleted() {
        assertTrue(!isElementPresent(By.xpath(EMAIL)));
    }

    public void checkRemovedAttachment() {
        assertTrue(!isElementPresent(By.xpath(ADDED_ATTACHMENT)));
    }

    public List<WebElement> getAddEmailElements() {
        List<WebElement> addEmailElements = new ArrayList();
        addEmailElements.add(time);
        addEmailElements.add(time_box);
        addEmailElements.add(date);
        addEmailElements.add(date_box);
        addEmailElements.add(from);
        addEmailElements.add(from_box);
        addEmailElements.add(subject);
        addEmailElements.add(subject_box);
        addEmailElements.add(body_box);
        addEmailElements.add(add_attachments);
        addEmailElements.add(discard_changes);
        addEmailElements.add(save_changes);

        return addEmailElements;
    }
}
