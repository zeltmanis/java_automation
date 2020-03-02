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

public class ExerciseReview {
    WebDriver driver;
    WebDriverWait wait;

    public ExerciseReview(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    // Exercise review elements
    private static final String DOCUMENT_TAB = "(//*[@data-testid='tab-title'])[1]";
    private static final String EMAIL_TAB = "(//*[@data-testid='tab-title'])[2]";
    private static final String UPLOAD_DOC_BOX = "(//*[@data-testid='checkbox'])[1]";
    private static final String SHARED_DOC_BOX = "(//*[@data-testid='checkbox'])[2]";
    private static final String INBOX_EMAIL_BOX = "(//*[@data-testid='checkbox'])[3]";
    private static final String SENT_EMAIL_BOX = "(//*[@data-testid='checkbox'])[4]";
    private static final String BACK_BUTTON = "//*[@data-testid='button-back']";

    // Candidate created content
    private static final String UPLOADED_DOC = "//div[text()='Test_pdf.pdf']";
    private static final String SENT_EMAIL = "//*[@data-testid='email-0']";

    @FindBy(xpath = DOCUMENT_TAB)
    WebElement document_tab;

    @FindBy(xpath = EMAIL_TAB)
    WebElement email_tab;

    @FindBy(xpath = UPLOAD_DOC_BOX)
    WebElement upload_doc_box;

    @FindBy(xpath = SHARED_DOC_BOX)
    WebElement shared_doc_box;

    @FindBy(xpath = INBOX_EMAIL_BOX)
    WebElement inbox_email_box;

    @FindBy(xpath = SENT_EMAIL_BOX)
    WebElement sent_email_box;

    @FindBy(xpath = BACK_BUTTON)
    WebElement back_button;

    // Candidate created content
    @FindBy(xpath = UPLOADED_DOC)
    WebElement uploaded_doc;

    @FindBy(xpath = SENT_EMAIL)
    WebElement sent_email;

    public void goBack() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BACK_BUTTON)));
        back_button.click();
    }

    public void clickEmailTab() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL_TAB)));
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EMAIL_TAB)));
        email_tab.click();
        List<WebElement> emailElements = getEmailElements();
        for (WebElement e : emailElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void clickDocumentTab() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DOCUMENT_TAB)));
        document_tab.click();
        List<WebElement> documentElements = getDocumentElements();
        for (WebElement e : documentElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public List<WebElement> getDocumentElements() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DOCUMENT_TAB)));
        List<WebElement> documentElements = new ArrayList();
        documentElements.add(document_tab);
        documentElements.add(email_tab);
        documentElements.add(upload_doc_box);
        documentElements.add(shared_doc_box);
        documentElements.add(uploaded_doc);

        return documentElements;
    }

    public List<WebElement> getEmailElements() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DOCUMENT_TAB)));
        List<WebElement> emailElements = new ArrayList();
        emailElements.add(document_tab);
        emailElements.add(email_tab);
        emailElements.add(inbox_email_box);
        emailElements.add(sent_email_box);
        emailElements.add(sent_email);

        return emailElements;
    }
}