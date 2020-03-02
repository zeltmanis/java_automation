package org.shl.selenium.va.pages.candidate;

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

public class CandidateEmailExercise {
    WebDriver driver;
    WebDriverWait wait;

    private boolean isElementPresent(By xpath) {
        return false;
    }

    public CandidateEmailExercise(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 30);
    }

    // Top corner icons and buttons
    private static final String SHL_LOGO = "//*[@data-testid='logo']";
    private static final String PAGE_BUTTON = "//*[@data-testid='icon-instructions']";
    private static final String TIMER_ICON = "//*[@id='root']/div/div[1]/div[2]/div[2]";
    private static final String EXIT_BUTTON = "(//*[@data-testid='clickable-icon'])[1]";

    // Side E-mail buttons
    private static final String COMPOSE = "//*[@data-testid='button-compose']";
    private static final String INBOX = "//*[@data-testid='button-sidebartab-inbox']";
    private static final String SENT = "//*[@data-testid='button-sidebartab-sent']";
    private static final String MARKED = "//*[@data-testid='button-sidebartab-marked']";
    private static final String DRAFTS = "//*[@data-testid='button-sidebartab-drafts']";
    private static final String MARK_ALL = "(//*[@data-testid='checkbox'])[1]";
    private static final String REFRESH = "(//*[@data-testid='clickable-icon'])[2]";

    // Bottom Document and Email button
    private static final String MENU = "//*[@data-testid='menu']";
    private static final String MENU_MAXIMIZED = "//*[@data-testid='menu-maximized']";
    private static final String DOCUMENTS = "//*[@data-testid='navigation-documents']";
    private static final String EMAIL = "//*[@data-testid='navigation-emails']";
    // private static final String EMAIL = "//*[@data-testid='button'][2]";
    private static final String BADGE = "//*[@data-testid='badge']";

    // Compose e-mail elements
    private static final String EMAIL_POPUP = "//*[@data-testid='panel-email-window-message-box']";
    private static final String EMAIL_TITLE = "//div[contains(@class,'') and text()='New Message']";
    private static final String MINIMAZE = "//*[@data-testid='icon-minimize']";
    private static final String EXPAND = "//*[@data-testid='icon-expand']";
    private static final String CLOSE = "//*[@data-testid='icon-close']";
    private static final String RECEIVER = "//*[@id='root']/div/div[2]/div/div[3]/div[2]/form/div[1]/div";
    private static final String SUBJECT = "//*[@data-testid='input-message-box']";
    private static final String EMAIL_BOX = "//*[@aria-label='Rich Text Editor, main']";
    private static final String BOLD = "//*[@id='root']/div/div[2]/div/div[3]/div[2]/form/div[3]/div[2]/div[1]/div/div[2]/div/button[1]";
    private static final String ITALIC = "//*[@id='root']/div/div[2]/div/div[3]/div[2]/form/div[3]/div[2]/div[1]/div/div[2]/div/button[2]";
    private static final String BULLET_POINTS = "//*[@id='root']/div/div[2]/div/div[3]/div[2]/form/div[3]/div[2]/div[1]/div/div[2]/div/button[3]";
    private static final String NUMBER_LIST = "//*[@id='root']/div/div[2]/div/div[3]/div[2]/form/div[3]/div[2]/div[1]/div/div[2]/div/button[4]";
    private static final String UNDO = "//*[@id='root']/div/div[2]/div/div[3]/div[2]/form/div[3]/div[2]/div[1]/div/div[2]/div/button[5]";
    private static final String REDO = "//*[@id='root']/div/div[2]/div/div[3]/div[2]/form/div[3]/div[2]/div[1]/div/div[2]/div/button[6]";
    private static final String SEND = "//*[@data-testid='button-send']";

    // Open received email
    private static final String RECEIVED_EMAIL = "//*[@data-testid='email-list-item-0']";
    private static final String EMAIL_WITH_PDF = "//*[text()='Regional sales figures and targets - (Item 13)']";
    private static final String BACK_BUTTON = "//*[@data-testid='button-back']";
    private static final String TITLE = "//*[@data-testid='subject']";
    private static final String SENDER = "//*[@data-testid='from']";
    private static final String EMAIL_TEXT = "//*[@data-testid='content']";
    private static final String EMAIL_ITEM = "//*[@data-testid='email-details-attachment-0']";
    private static final String DATE_TIME = "//*[@data-testid='date']";
    private static final String MARK_EMAIL = "(//*[@data-testid='clickable-icon'])[2]";
    private static final String REPLAY = "(//*[@data-testid='clickable-icon'])[3]";
    private static final String SENT_EMAIL = "//*[@data-testid='email-list-item-0']";
    private static final String SECOND_EMAIL = "//*[@id='root']/div/div[2]/div/div[2]/div[2]/div[2]/div[3]/div";
    private static final String UNMARK_EMAIL = "//*[@data-testid='button-mark']";

    // Received e-mail attachment
    private static final String ATTACHMENT = "//div[contains(@class,'react-pdf')]";
    private static final String PREVIEW_PAGE = "//*[@data-testid='pdf-preview']";
    private static final String CLOSE_ATTACHMENT = "/html/body/div[3]/div/div/div[2]";
    private static final String ATTACHED_FILE = "(//*[@data-testid='button-email-attachment-0'])[1]";

    // Top corner icons and buttons
    @FindBy(xpath = SHL_LOGO)
    WebElement shl_logo;

    @FindBy(xpath = PAGE_BUTTON)
    WebElement page_button;

    @FindBy(xpath = TIMER_ICON)
    WebElement timer_icon;

    @FindBy(xpath = EXIT_BUTTON)
    WebElement exit_button;

    // Side E-mail buttons
    @FindBy(xpath = COMPOSE)
    WebElement compose;

    @FindBy(xpath = INBOX)
    WebElement inbox;

    @FindBy(xpath = SENT)
    WebElement sent;

    @FindBy(xpath = MARKED)
    WebElement marked;

    @FindBy(xpath = DRAFTS)
    WebElement drafts;

    @FindBy(xpath = MARK_ALL)
    WebElement mark_all;

    @FindBy(xpath = REFRESH)
    WebElement refresh;

    // Bottom Document and Email button
    @FindBy(xpath = DOCUMENTS)
    WebElement documents;

    @FindBy(xpath = EMAIL)
    WebElement email;

    @FindBy(xpath = BADGE)
    WebElement badge;

    // Compose e-mail elementu

    @FindBy(xpath = EMAIL_POPUP)
    WebElement email_popup;

    @FindBy(xpath = EMAIL_TITLE)
    WebElement email_title;

    @FindBy(xpath = MINIMAZE)
    WebElement minimize;

    @FindBy(xpath = EXPAND)
    WebElement expand;

    @FindBy(xpath = CLOSE)
    WebElement close;

    @FindBy(xpath = RECEIVER)
    WebElement receiver;

    @FindBy(xpath = SUBJECT)
    WebElement subject;

    @FindBy(xpath = BOLD)
    WebElement bold;

    @FindBy(xpath = ITALIC)
    WebElement italic;

    @FindBy(xpath = BULLET_POINTS)
    WebElement bullet_points;

    @FindBy(xpath = NUMBER_LIST)
    WebElement number_list;

    @FindBy(xpath = UNDO)
    WebElement undo;

    @FindBy(xpath = REDO)
    WebElement redo;

    @FindBy(xpath = EMAIL_BOX)
    WebElement email_box;

    @FindBy(xpath = SEND)
    WebElement send;

    // Open received email
    @FindBy(xpath = RECEIVED_EMAIL)
    WebElement received_email;

    @FindBy(xpath = EMAIL_WITH_PDF)
    WebElement email_with_pdf;

    @FindBy(xpath = BACK_BUTTON)
    WebElement back_button;

    @FindBy(xpath = TITLE)
    WebElement title;

    @FindBy(xpath = SENDER)
    WebElement sender;

    @FindBy(xpath = EMAIL_TEXT)
    WebElement email_text;

    @FindBy(xpath = EMAIL_ITEM)
    WebElement email_item;

    @FindBy(xpath = DATE_TIME)
    WebElement date_time;

    @FindBy(xpath = MARK_EMAIL)
    WebElement mark_email;

    @FindBy(xpath = REPLAY)
    WebElement replay;

    @FindBy(xpath = SENT_EMAIL)
    WebElement sent_email;

    @FindBy(xpath = SECOND_EMAIL)
    WebElement second_email;

    @FindBy(xpath = MENU)
    WebElement menu;

    @FindBy(xpath = UNMARK_EMAIL)
    WebElement unmark_email;

    // Received e-mail attachment;

    @FindBy(xpath = ATTACHMENT)
    WebElement attachment;

    @FindBy(xpath = PREVIEW_PAGE)
    WebElement preview_page;

    @FindBy(xpath = CLOSE_ATTACHMENT)
    WebElement close_attachment;

    @FindBy(xpath = ATTACHED_FILE)
    WebElement attached_file;

    public void checkEmailElements() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(COMPOSE)));
        List<WebElement> emailElements = getCandidateEmailElements();
        for (WebElement e : emailElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void checkComposeEmailElements() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL_TITLE)));
        List<WebElement> emailElements = getComposeEmailElements();
        for (WebElement e : emailElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void moveBack() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(COMPOSE)));
        page_button.click();
    }

    public void clickExitButton() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EXIT_BUTTON)));
        exit_button.click();

    }

    public void switchDocuments() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DOCUMENTS)));
        documents.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(COMPOSE)));
    }

    public void switchEmail() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EMAIL)));
        email.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(COMPOSE)));
        List<WebElement> emailElements = getCandidateEmailElements();
        for (WebElement e : emailElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void composeEmail() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(COMPOSE)));
        compose.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL_TITLE)));
    }

    public void enterSubject(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUBJECT)));
        subject.click();
        subject.sendKeys(text);
    }

    public void openEmail() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RECEIVED_EMAIL)));
        received_email.click();
    }

    public void markOpenedEmail() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MARK_EMAIL)));
        mark_email.click();
    }

    public void unmarkOpenEmail() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RECEIVED_EMAIL)));
        unmark_email.click();
        assertTrue(!isElementPresent(By.xpath(RECEIVED_EMAIL)));
    }

    public void openMarked() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MARKED)));
        marked.click();
    }

    public void closeEmail() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BACK_BUTTON)));
        back_button.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MENU)));
        List<WebElement> emailElements = getCandidateEmailElements();
        for (WebElement e : emailElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void clickReplay() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(REPLAY)));
        replay.click();
        List<WebElement> emailElements = getComposeEmailElements();
        for (WebElement e : emailElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void enterTextEmail(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL_BOX)));
        email_box.click();
        email_box.sendKeys(text);
    }

    public void closeEmailBox() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CLOSE)));
        close.click();
        assertTrue(!isElementPresent(By.xpath(EMAIL_POPUP)));
    }

    public void clickSend() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEND)));
        send.click();
        assertTrue(!isElementPresent(By.xpath(EMAIL_POPUP)));
    }

    public void openSent() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SENT)));
        sent.click();
    }

    public void markedEmailCheck() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RECEIVED_EMAIL)));
    }

    public void openDrafts() {
        assertTrue(!isElementPresent(By.xpath(EMAIL_POPUP)));
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DRAFTS)));
        drafts.click();
    }

    public void getSentEmail() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SENT_EMAIL)));
        assertTrue(checkSentEmail().isDisplayed());
    }

    public WebElement checkSentEmail() {
        return sent_email;
    }

    public void clickLogo() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SHL_LOGO)));
        shl_logo.click();
    }

    public String unreadedEmailCount() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BADGE)));
        WebElement emailCount = driver.findElement(By.xpath(BADGE));
        String actual = emailCount.getText();

        return actual;
    }

    public void checkReceivedEmailElements() {
        List<WebElement> emailElements = getEmailElements();
        for (WebElement e : emailElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void openEmailWithPDF() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EMAIL_WITH_PDF)));
        email_with_pdf.click();
    }

    public void openAttachment() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EMAIL_ITEM)));
        email_item.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ATTACHMENT)));
        assertTrue(getEmailFile().isDisplayed());
    }

    public void closeAttachment() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CLOSE_ATTACHMENT)));
        close_attachment.click();
        List<WebElement> emailElements = getEmailElements();
        for (WebElement e : emailElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void openEmailFile() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ATTACHED_FILE)));
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ATTACHED_FILE)));
        attached_file.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ATTACHMENT)));
        assertTrue(getEmailFile().isDisplayed());
    }

    public WebElement getEmailFile() {
        return attachment;
    }

    public void hoverMenu() {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(MENU));
        builder.moveToElement(element).build().perform();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MENU_MAXIMIZED)));

    }

    public List<WebElement> getEmailElements() {
        List<WebElement> emailElements = new ArrayList();
        emailElements.add(back_button);
        emailElements.add(title);
        emailElements.add(sender);
        emailElements.add(email_text);
        emailElements.add(email_item);
        emailElements.add(date_time);
        emailElements.add(mark_email);
        emailElements.add(replay);

        return emailElements;
    }

    public List<WebElement> getComposeEmailElements() {
        List<WebElement> composeEmailElements = new ArrayList();
        composeEmailElements.add(email_title);
        composeEmailElements.add(minimize);
        composeEmailElements.add(expand);
        composeEmailElements.add(close);
        composeEmailElements.add(receiver);
        composeEmailElements.add(subject);
        // composeEmailElements.add(bold);
        // composeEmailElements.add(italic);
        // composeEmailElements.add(bullet_points);
        // composeEmailElements.add(number_list);
        // composeEmailElements.add(undo);
        // composeEmailElements.add(redo);
        composeEmailElements.add(email_box);
        composeEmailElements.add(send);

        return composeEmailElements;
    }

    public List<WebElement> getCandidateEmailElements() {
        List<WebElement> candidateEmailElements = new ArrayList();
        candidateEmailElements.add(page_button);
        candidateEmailElements.add(timer_icon);
        candidateEmailElements.add(exit_button);
        candidateEmailElements.add(compose);
        candidateEmailElements.add(inbox);
        candidateEmailElements.add(sent);
        candidateEmailElements.add(marked);
        candidateEmailElements.add(drafts);
        candidateEmailElements.add(mark_all);
        candidateEmailElements.add(refresh);

        return candidateEmailElements;
    }
}