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
import org.shl.selenium.va.utils.Utils;

public class InterviewReview {
    WebDriver driver;
    WebDriverWait wait;

    private Landing objLanding;

    public InterviewReview(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    private boolean isElementPresent(By xpath) {
        return false;
    }

    // Page to buttons
    private static final String BACK_BUTTON = "//*[@data-testid='button-back']";
    private static final String TAGGING_TAB = "//*[@data-testid='tab-title']/../..//*[text()='Tagging']";
    private static final String RATING_TAB = "//*[@data-testid='tab-title']/../..//*[text()='Rating']";
    private static final String EXPAND_ALL = "//*[@data-testid='button-expand-all']";
    private static final String DOCUMENT_TAB = "//*[@data-testid='tab-title']/../..//*[text()='Documents']";
    private static final String EMAIL_TAB = "//*[@data-testid='tab-title']/../..//*[text()='Email']";

    // Skill titles for Tagging
    private static final String SKILL1_TAGGING = "(//*[@data-testid='competency-title'])[1]";
    private static final String SKILL2_TAGGING = "(//*[@data-testid='competency-title'])[2]";
    private static final String SKILL3_TAGGING = "(//*[@data-testid='competency-title'])[3]";
    private static final String SKILL4_TAGGING = "(//*[@data-testid='competency-title'])[4]";

    // Skill titles for Rating
    private static final String SKILL1 = "//div[contains(@class, '') and text()='Entrepreneurial and Commercial Thinking']";
    private static final String SKILL2 = "//div[contains(@class, '') and text()='Persuading and Influencing']";
    private static final String SKILL3 = "//div[contains(@class, '') and text()='Formulating Strategies and Concepts']";
    private static final String SKILL4 = "//div[contains(@class, '') and text()='Delivering Results and Meeting Customer Expectations']";

    // Rating tab elements for Entrepreneurial and Commercial Thinking
    private static final String SKILL1_ICON = "(//*[@data-testid='rated-count'])[1]";
    private static final String SKILL1_EXPAND = "(//*[@data-testid='expand-competency'])[1]";
    private static final String SKILL1_1 = "(//*[@data-testid='behaviour-name'])[1]";
    private static final String SKILL1_2 = "(//*[@data-testid='behaviour-name'])[2]";
    private static final String SKILL1_3 = "(//*[@data-testid='behaviour-name'])[3]";
    private static final String SKILL1_4 = "(//*[@data-testid='behaviour-name'])[4]";
    private static final String SKILL1_5 = "(//*[@data-testid='behaviour-name'])[5]";
    private static final String SKILL1_6 = "(//*[@data-testid='behaviour-name'])[6]";

    // Rating tab elements for Persuading and Influencing
    private static final String SKILL2_ICON = "(//*[@data-testid='rated-count'])[2]";
    private static final String SKILL2_EXPAND = "(//*[@data-testid='expand-competency'])[2]";
    private static final String SKILL2_1 = "(//*[@data-testid='behaviour-name'])[7]";
    private static final String SKILL2_2 = "(//*[@data-testid='behaviour-name'])[8]";
    private static final String SKILL2_3 = "(//*[@data-testid='behaviour-name'])[9]";
    private static final String SKILL2_4 = "(//*[@data-testid='behaviour-name'])[10]";
    private static final String SKILL2_5 = "(//*[@data-testid='behaviour-name'])[11]";
    private static final String SKILL2_6 = "(//*[@data-testid='behaviour-name'])[12]";
    private static final String RATING_NUMBER = "//*[@data-testid='rated-count']/../..//div[text()='3']";

    // Rating tab elements for Formulating Strategies and Concepts
    private static final String SKILL3_ICON = "(//*[@data-testid='rated-count'])[3]";
    private static final String SKILL3_EXPAND = "(//*[@data-testid='expand-competency'])[3]";
    private static final String SKILL3_1 = "(//*[@data-testid='behaviour-name'])[13]";
    private static final String SKILL3_2 = "(//*[@data-testid='behaviour-name'])[14]";
    private static final String SKILL3_3 = "(//*[@data-testid='behaviour-name'])[15]";
    private static final String SKILL3_4 = "(//*[@data-testid='behaviour-name'])[16]";
    private static final String SKILL3_5 = "(//*[@data-testid='behaviour-name'])[17]";
    private static final String SKILL3_6 = "(//*[@data-testid='behaviour-name'])[18]";

    // Rating tab elements for Delivering Results and Meeting Customer Expectations
    private static final String SKILL4_ICON = "(//*[@data-testid='rated-count'])[4]";
    private static final String SKILL4_EXPAND = "(//*[@data-testid='expand-competency'])[4]";
    private static final String SKILL4_1 = "(//*[@data-testid='behaviour-name'])[19]";
    private static final String SKILL4_2 = "(//*[@data-testid='behaviour-name'])[20]";
    private static final String SKILL4_3 = "(//*[@data-testid='behaviour-name'])[21]";
    private static final String SKILL4_4 = "(//*[@data-testid='behaviour-name'])[22]";
    private static final String SKILL4_5 = "(//*[@data-testid='behaviour-name'])[23]";
    private static final String SKILL4_6 = "(//*[@data-testid='behaviour-name'])[24]";
    private static final String SKILL4_7 = "(//*[@data-testid='behaviour-name'])[25]";

    // Elements for skill rating
    private static final String VPOOR_BUTTON = "(//*[@data-testid='radio-button'])[1]";
    private static final String VERY_POOR = "//*[@data-testid='score-label']/../..//*[text()='Very Poor']";
    private static final String POOR_BUTTON = "(//*[@data-testid='radio-button'])[2]";
    private static final String POOR = "//*[@data-testid='score-label']/../..//*[text()='Poor']";
    private static final String SAT_BUTTON = "(//*[@data-testid='radio-button'])[3]";
    private static final String SATISFACTORY = "//*[@data-testid='score-label']/../..//*[text()='Satisfactory']";
    private static final String GOOD_BUTTON = "(//*[@data-testid='radio-button'])[4]";
    private static final String GOOD = "//*[@data-testid='score-label']/../..//*[text()='Good']";
    private static final String EXCELLENT_BUTTON = "(//*[@data-testid='radio-button'])[5]";
    private static final String EXCELLENT = "//*[@data-testid='score-label']/../..//*[text()='Excellent']";

    // Elements for filling out skill rating
    private static final String FIRST_RATING = "(//*[@data-testid='radio-button'])[31]";
    private static final String SECOND_RATING = "(//*[@data-testid='radio-button'])[36]";
    private static final String THIRD_RATING = "(//*[@data-testid='radio-button'])[41]";

    // Feedback elements
    private static final String FEEDBACK_TITLE = "//*[@data-testid='label-feedback']";
    private static final String FEEDBACK_BOX = "//*[@data-testid='feedback-input']";
    private static final String FEEDBACK_ADD = "//*[@data-testid='button-add']";
    private static final String FEEDBACK_VIDEO = "//*[@data-testid='title-note']";

    // Video click
    private static final String VIDEO = "//*[@id='root']/div/div[2]/div/div/div[1]/div[1]/div[3]";
    private static final String VIDEO_CLICK = "//*[@id='root']/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div[1]";
    private static final String SEARCH_BOX = "//*[@data-testid='search-field']";

    // Email and Documents Tab elements
    private static final String UPLOAD_DOC_BOX = "(//*[@data-testid='checkbox'])[3]";
    private static final String SHARED_DOC_BOX = "(//*[@data-testid='checkbox'])[4]";
    private static final String INBOX_EMAIL_BOX = "(//*[@data-testid='checkbox'])[1]";
    private static final String SENT_EMAIL_BOX = "(//*[@data-testid='checkbox'])[2]";

    // Candidate created content
    private static final String UPLOADED_DOC = "//div[text()='Test_pdf.pdf']";
    private static final String SENT_EMAIL = "//*[@data-testid='email-0']";

    // Page to buttons
    @FindBy(xpath = BACK_BUTTON)
    WebElement back_button;

    @FindBy(xpath = TAGGING_TAB)
    WebElement tagging_tab;

    @FindBy(xpath = RATING_TAB)
    WebElement rating_tab;

    @FindBy(xpath = EMAIL_TAB)
    WebElement email_tab;

    @FindBy(xpath = DOCUMENT_TAB)
    WebElement document_tab;

    @FindBy(xpath = EXPAND_ALL)
    WebElement expand_all;

    // Skill titles for Tagging
    @FindBy(xpath = SKILL1_TAGGING)
    WebElement skill1_tagging;

    @FindBy(xpath = SKILL2_TAGGING)
    WebElement skill2_tagging;

    @FindBy(xpath = SKILL3_TAGGING)
    WebElement skill3_tagging;

    @FindBy(xpath = SKILL4_TAGGING)
    WebElement skill4_tagging;

    // Skill titles for Rating
    @FindBy(xpath = SKILL1)
    WebElement skill1;

    @FindBy(xpath = SKILL2)
    WebElement skill2;

    @FindBy(xpath = SKILL3)
    WebElement skill3;

    @FindBy(xpath = SKILL4)
    WebElement skill4;

    // Rating tab elements for Entrepreneurial and Commercial Thinking
    @FindBy(xpath = SKILL1_ICON)
    WebElement skill1_icon;

    @FindBy(xpath = SKILL1_EXPAND)
    WebElement skill1_expand;

    @FindBy(xpath = SKILL1_1)
    WebElement skill1_1;

    @FindBy(xpath = SKILL1_2)
    WebElement skill1_2;

    @FindBy(xpath = SKILL1_3)
    WebElement skill1_3;

    @FindBy(xpath = SKILL1_4)
    WebElement skill1_4;

    @FindBy(xpath = SKILL1_5)
    WebElement skill1_5;

    @FindBy(xpath = SKILL1_6)
    WebElement skill1_6;

    // Rating tab elements for Persuading and Influencing
    @FindBy(xpath = SKILL2_ICON)
    WebElement skill2_icon;

    @FindBy(xpath = SKILL2_EXPAND)
    WebElement skill2_expand;

    @FindBy(xpath = SKILL2_1)
    WebElement skill2_1;

    @FindBy(xpath = SKILL2_2)
    WebElement skill2_2;

    @FindBy(xpath = SKILL2_3)
    WebElement skill2_3;

    @FindBy(xpath = SKILL2_4)
    WebElement skill2_4;

    @FindBy(xpath = SKILL2_5)
    WebElement skill2_5;

    @FindBy(xpath = SKILL2_6)
    WebElement skill2_6;

    @FindBy(xpath = RATING_NUMBER)
    WebElement rating_number;

    // Rating tab elements for Formulating Strategies and Concepts
    @FindBy(xpath = SKILL3_ICON)
    WebElement skill3_icon;

    @FindBy(xpath = SKILL3_EXPAND)
    WebElement skill3_expand;

    @FindBy(xpath = SKILL3_1)
    WebElement skill3_1;

    @FindBy(xpath = SKILL3_2)
    WebElement skill3_2;

    @FindBy(xpath = SKILL3_3)
    WebElement skill3_3;

    @FindBy(xpath = SKILL3_4)
    WebElement skill3_4;

    @FindBy(xpath = SKILL3_5)
    WebElement skill3_5;

    @FindBy(xpath = SKILL3_6)
    WebElement skill3_6;

    // Rating tab elements for Delivering Results and Meeting Customer Expectations
    @FindBy(xpath = SKILL4_ICON)
    WebElement skill4_icon;

    @FindBy(xpath = SKILL4_EXPAND)
    WebElement skill4_expand;

    @FindBy(xpath = SKILL4_1)
    WebElement skill4_1;

    @FindBy(xpath = SKILL4_2)
    WebElement skill4_2;

    @FindBy(xpath = SKILL4_3)
    WebElement skill4_3;

    @FindBy(xpath = SKILL4_4)
    WebElement skill4_4;

    @FindBy(xpath = SKILL4_5)
    WebElement skill4_5;

    @FindBy(xpath = SKILL4_6)
    WebElement skill4_6;

    @FindBy(xpath = SKILL4_7)
    WebElement skill4_7;

    // Feedback elements
    @FindBy(xpath = FEEDBACK_TITLE)
    WebElement feedback_title;

    @FindBy(xpath = FEEDBACK_BOX)
    WebElement feedback_box;

    @FindBy(xpath = FEEDBACK_ADD)
    WebElement feedback_add;

    @FindBy(xpath = FEEDBACK_VIDEO)
    WebElement feedback_video;

    // Elements for skill rating
    @FindBy(xpath = VPOOR_BUTTON)
    WebElement vpoor_button;

    @FindBy(xpath = VERY_POOR)
    WebElement very_poor;

    @FindBy(xpath = POOR_BUTTON)
    WebElement poor_button;

    @FindBy(xpath = POOR)
    WebElement poor;

    @FindBy(xpath = SAT_BUTTON)
    WebElement sat_button;

    @FindBy(xpath = SATISFACTORY)
    WebElement satisfactory;

    @FindBy(xpath = GOOD_BUTTON)
    WebElement good_button;

    @FindBy(xpath = GOOD)
    WebElement good;

    @FindBy(xpath = EXCELLENT_BUTTON)
    WebElement excellent_button;

    @FindBy(xpath = EXCELLENT)
    WebElement excellent;

    @FindBy(xpath = VIDEO_CLICK)
    WebElement video_click;

    @FindBy(xpath = VIDEO)
    WebElement video;

    @FindBy(xpath = SEARCH_BOX)
    WebElement search_box;

    @FindBy(xpath = FIRST_RATING)
    WebElement first_rating;

    @FindBy(xpath = SECOND_RATING)
    WebElement second_rating;

    @FindBy(xpath = THIRD_RATING)
    WebElement third_rating;

    // Video review elements

    @FindBy(xpath = UPLOAD_DOC_BOX)
    WebElement upload_doc_box;

    @FindBy(xpath = SHARED_DOC_BOX)
    WebElement shared_doc_box;

    @FindBy(xpath = INBOX_EMAIL_BOX)
    WebElement inbox_email_box;

    @FindBy(xpath = SENT_EMAIL_BOX)
    WebElement sent_email_box;

    // Candidate created content
    @FindBy(xpath = UPLOADED_DOC)
    WebElement uploaded_doc;

    @FindBy(xpath = SENT_EMAIL)
    WebElement sent_email;

    public void clickBack() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BACK_BUTTON)));
        back_button.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Landing.FIND_TITLE)));
    }

    public List<WebElement> getTaggingElements() {
        List<WebElement> taggingElements = new ArrayList();
        taggingElements.add(tagging_tab);
        taggingElements.add(rating_tab);
        taggingElements.add(skill1_tagging);
        taggingElements.add(skill2_tagging);
        taggingElements.add(skill3_tagging);
        taggingElements.add(skill4_tagging);
        taggingElements.add(feedback_title);
        taggingElements.add(feedback_box);

        return taggingElements;
    }

    public void clickTagging() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TAGGING_TAB)));
        tagging_tab.click();
        List<WebElement> taggingElements = getTaggingElements();
        for (WebElement e : taggingElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }

    }

    public List<WebElement> getRatingElements() {
        List<WebElement> ratingElements = new ArrayList();
        ratingElements.add(tagging_tab);
        ratingElements.add(rating_tab);
        ratingElements.add(expand_all);
        ratingElements.add(skill1);
        ratingElements.add(skill1_icon);
        ratingElements.add(skill1_expand);
        ratingElements.add(skill2);
        ratingElements.add(skill2_icon);
        ratingElements.add(skill2_expand);
        ratingElements.add(skill3);
        ratingElements.add(skill3_icon);
        ratingElements.add(skill3_expand);
        ratingElements.add(skill4);
        ratingElements.add(skill4_icon);
        ratingElements.add(skill4_expand);

        return ratingElements;
    }

    public void clickRating() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RATING_TAB)));
        rating_tab.click();
        List<WebElement> ratingElements = getRatingElements();
        for (WebElement e : ratingElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }

    }

    public void clickEmail() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL_TAB)));
        email_tab.click();
    }

    public List<WebElement> getSkill1Elements() {
        List<WebElement> skill1Elements = new ArrayList();
        skill1Elements.add(skill1_1);
        skill1Elements.add(skill1_2);
        skill1Elements.add(skill1_3);
        skill1Elements.add(skill1_4);
        skill1Elements.add(skill1_5);
        skill1Elements.add(skill1_6);

        return skill1Elements;
    }

    public void expandSkill1() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SKILL1_EXPAND)));
        skill1_expand.click();
        List<WebElement> skill1Elements = getSkill1Elements();
        for (WebElement e : skill1Elements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }

    }

    public List<WebElement> getSkill2Elements() {
        List<WebElement> skill2Elements = new ArrayList();
        // skill2Elements.add(skill2_1);
        skill2Elements.add(skill2_2);
        skill2Elements.add(skill2_3);
        skill2Elements.add(skill2_4);
        // skill2Elements.add(skill2_5);
        skill2Elements.add(skill2_6);

        return skill2Elements;
    }

    public void expandSkill2() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SKILL2_EXPAND)));
        skill2_expand.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIRST_RATING)));
        List<WebElement> skill2Elements = getSkill2Elements();
        for (WebElement e : skill2Elements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void expandSkill2forIcon() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SKILL2_EXPAND)));
        skill2_expand.click();
    }

    public List<WebElement> getSkill3Elements() {
        List<WebElement> skill3Elements = new ArrayList();
        skill3Elements.add(skill3_1);
        skill3Elements.add(skill3_2);
        skill3Elements.add(skill3_3);
        skill3Elements.add(skill3_4);
        skill3Elements.add(skill3_5);
        skill3Elements.add(skill3_6);

        return skill3Elements;
    }

    public void expandSkill3() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SKILL3_EXPAND)));
        skill3_expand.click();
        List<WebElement> skill3Elements = getSkill3Elements();
        for (WebElement e : skill3Elements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }

    }

    public List<WebElement> getSkill4Elements() {
        List<WebElement> skill4Elements = new ArrayList();
        skill4Elements.add(skill4_1);
        skill4Elements.add(skill4_2);
        skill4Elements.add(skill4_3);
        skill4Elements.add(skill4_4);
        skill4Elements.add(skill4_5);
        skill4Elements.add(skill4_6);
        skill4Elements.add(skill4_7);

        return skill4Elements;
    }

    public void expandSkill4() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SKILL4_EXPAND)));
        skill4_expand.click();
        List<WebElement> skill4Elements = getSkill4Elements();
        for (WebElement e : skill4Elements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }

    }

    public void expandAll() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EXPAND_ALL)));
        expand_all.click();
        List<WebElement> skill1Elements = getSkill1Elements();
        for (WebElement e : skill1Elements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
        List<WebElement> skill2Elements = getSkill2Elements();
        for (WebElement e : skill2Elements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
        List<WebElement> skill3Elements = getSkill3Elements();
        for (WebElement e : skill3Elements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
        List<WebElement> skill4Elements = getSkill4Elements();
        for (WebElement e : skill4Elements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }

    }

    public String veryPoorRating() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VPOOR_BUTTON)));
        vpoor_button.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VERY_POOR)));
        WebElement veryPoor = driver.findElement(By.xpath(VERY_POOR));
        return veryPoor.getText();
    }

    public String poorRating() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POOR_BUTTON)));
        poor_button.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(POOR)));
        WebElement poor = driver.findElement(By.xpath(POOR));
        return poor.getText();
    }

    public String satisfactoryRating() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SAT_BUTTON)));
        sat_button.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SATISFACTORY)));
        WebElement satisfactory = driver.findElement(By.xpath(SATISFACTORY));
        return satisfactory.getText();
    }

    public String goodRating() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(GOOD_BUTTON)));
        good_button.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GOOD)));
        WebElement good = driver.findElement(By.xpath(GOOD));
        return good.getText();
    }

    public String excellentRating() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EXCELLENT_BUTTON)));
        excellent_button.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EXCELLENT)));
        WebElement excellent = driver.findElement(By.xpath(EXCELLENT));
        return excellent.getText();
    }

    public String checkRatingIcon() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIRST_RATING)));
        first_rating.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SECOND_RATING)));
        second_rating.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(THIRD_RATING)));
        third_rating.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RATING_NUMBER)));
        WebElement ratingNumber = driver.findElement(By.xpath(RATING_NUMBER));
        return ratingNumber.getText();
    }

    public void tagVideo() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO)));
        video_click.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIDEO)));

    }

    public void enterFeedback(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FEEDBACK_BOX)));
        feedback_box.sendKeys(text);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FEEDBACK_ADD)));
        feedback_add.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FEEDBACK_VIDEO)));
    }

    public WebElement checkVideoFeedback() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FEEDBACK_VIDEO)));
        return feedback_video;
    }

    public void getVideoFeedback() {
        assertTrue(checkVideoFeedback().isDisplayed());
    }

    public void searchVideoTag() {

        String[] tag = Utils.generateRandomWords(1);
        enterFeedback(tag[0]);
        this.wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[contains(@class,'') and text()='" + tag[0] + "']")));
        search_box.sendKeys(tag[0]);
        this.wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[contains(@class,'') and text()='" + tag[0] + "']")));
        search_box.sendKeys(tag[0] + "a");
        assertTrue(!isElementPresent(By.xpath("//span[contains(@class,'') and text()='" + tag[0] + "']")));
    }

    public void clickEmailTab() {
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