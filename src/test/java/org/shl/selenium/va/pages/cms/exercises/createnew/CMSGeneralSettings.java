package org.shl.selenium.va.pages.cms.exercises.createnew;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertFalse;
import org.shl.selenium.va.utils.Utils;

public class CMSGeneralSettings {

    private WebDriver driver;
    WebDriverWait wait;

    String[] tag = Utils.generateRandomWords(1);

    public CMSGeneralSettings(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    // Elements under EXERCISE
    private static final String LANGUAGE = "//*[@data-testid='language']//div[text()='Language']";
    private static final String LANGUAGE_DROP_DOWN = "//*[@data-testid='language']//div[@class=' css-1vrloku']";
    private static final String CHECK_BOX_HEAD = "//div[contains(text(),'Please select')]";
    private static final String DESKTOP_CHECK_BOX = "(//*[@data-testid='checkbox'])[1]";
    private static final String MEETING_CHECK_BOX = "(//*[@data-testid='checkbox'])[2]";
    private static final String EMAIL_NAME = "//*[@data-testid='email-task-name']//div[text()='Name of the task for email']";
    private static final String EMAIL_NAME_BOX = "//*[@data-testid='email-task-name']//input";
    private static final String TASK_NAME = "//*[@data-testid='meeting-task-name']//div[text()='Name of the task for meeting']";
    private static final String TASK_NAME_BOX = "//*[@data-testid='meeting-task-name']//input";
    private static final String ENGLISH = "//*[@data-testid='language']//div[text()='English int']";

    // Elements under JOB
    private static final String NAME = "//*[@data-testid='domain']//div[text()='Domain name']";
    private static final String NAME_BOX = "//*[@data-testid='domain']//input";
    private static final String LEVEL = "//*[@data-testid='job-level']//div[text()='Level']";
    private static final String LEVEL_DROP_DOWN = "//*[@data-testid='job-level']//div[@class=' css-1vrloku']";
    private static final String INDUSTRY = "//*[@data-testid='job-industry']//div[text()='Industry']";
    private static final String INDUSTRY_DROP_DOWN = "//*[@data-testid='job-industry']//div[@class=' css-1vrloku']";
    private static final String TYPE = "//*[@data-testid='job-type']//div[text()='Type']";
    private static final String TYPE_DROP_DOWN = "//*[@data-testid='job-type']//div[@class=' css-1vrloku']";
    private static final String SENIOR = "//div[text()='Senior']";
    private static final String FINANCE = "//div[text()='Finance']";
    private static final String STANDART = "//div[text()='Standart/custom']";

    // Date and domain
    private static final String DATE = "//*[@data-testid='date']//div[contains(text(),'date as per simulation')]";
    private static final String DATE_BOX = "//*[@data-testid='date']//input";
    private static final String TIME = "//*[@data-testid='time']//div[text()='Time']";
    private static final String TIME_BOX = "//*[@data-testid='time']//input";

    // Elements under EXERCISE
    @FindBy(xpath = LANGUAGE)
    WebElement language;

    @FindBy(xpath = LANGUAGE_DROP_DOWN)
    WebElement language_drop_down;

    @FindBy(xpath = CHECK_BOX_HEAD)
    WebElement check_box_head;

    @FindBy(xpath = DESKTOP_CHECK_BOX)
    WebElement desktop_check_box;

    @FindBy(xpath = MEETING_CHECK_BOX)
    WebElement meeting_check_box;

    @FindBy(xpath = EMAIL_NAME)
    WebElement email_name;

    @FindBy(xpath = EMAIL_NAME_BOX)
    WebElement email_name_box;

    @FindBy(xpath = TASK_NAME)
    WebElement task_name;

    @FindBy(xpath = TASK_NAME_BOX)
    WebElement task_name_box;

    @FindBy(xpath = ENGLISH)
    WebElement english;

    // Elements under Job
    @FindBy(xpath = NAME)
    WebElement name;

    @FindBy(xpath = NAME_BOX)
    WebElement name_box;

    @FindBy(xpath = LEVEL)
    WebElement level;

    @FindBy(xpath = LEVEL_DROP_DOWN)
    WebElement level_drop_down;

    @FindBy(xpath = INDUSTRY)
    WebElement industry;

    @FindBy(xpath = INDUSTRY_DROP_DOWN)
    WebElement industry_drop_down;

    @FindBy(xpath = TYPE)
    WebElement type;

    @FindBy(xpath = TYPE_DROP_DOWN)
    WebElement type_drop_down;

    @FindBy(xpath = SENIOR)
    WebElement senior;

    @FindBy(xpath = FINANCE)
    WebElement finance;

    @FindBy(xpath = STANDART)
    WebElement standart;

    // Date and time
    @FindBy(xpath = DATE)
    WebElement date;

    @FindBy(xpath = DATE_BOX)
    WebElement date_box;

    @FindBy(xpath = TIME)
    WebElement time;

    @FindBy(xpath = TIME_BOX)
    WebElement time_box;

    public void onlyDesktopSimulation() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MEETING_CHECK_BOX)));
        meeting_check_box.click();
        assertFalse(driver.findElement(By.xpath(TASK_NAME_BOX)).isEnabled());
    }

    public void onlyMeeting() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DESKTOP_CHECK_BOX)));
        desktop_check_box.click();
        assertFalse(driver.findElement(By.xpath(EMAIL_NAME_BOX)).isEnabled());
        assertFalse(driver.findElement(By.xpath(DATE_BOX)).isEnabled());
        assertFalse(driver.findElement(By.xpath(TIME_BOX)).isEnabled());
    }

    public void selectLanguage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LANGUAGE_DROP_DOWN)));
        language_drop_down.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ENGLISH)));
        english.click();
    }

    public void selectLevel() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LEVEL_DROP_DOWN)));
        level_drop_down.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SENIOR)));
        senior.click();
    }

    public void selectIndustry() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(INDUSTRY_DROP_DOWN)));
        industry_drop_down.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FINANCE)));
        finance.click();
    }

    public void selectType() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TYPE_DROP_DOWN)));
        type_drop_down.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(STANDART)));
        standart.click();
    }

    public void textNameForEmail(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL_NAME_BOX)));
        email_name_box.sendKeys(text);
    }

    public void enterNameForEmail() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL_NAME_BOX)));
        textNameForEmail(tag[0]);
    }

    public void textNameForMeeting(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TASK_NAME_BOX)));
        task_name_box.sendKeys(text);
    }

    public void enterNameForMeeting() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TASK_NAME_BOX)));
        textNameForMeeting(tag[0]);
    }

    public void textName(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_BOX)));
        name_box.click();
        name_box.clear();
        name_box.sendKeys(text);
    }

    public String enterDomainName() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_BOX)));
        String domainName = tag[0];
        textName(domainName);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_BOX)));
        return domainName;
    }

    public void checkDomainName() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_BOX)));

    }

    public List<WebElement> getExerciseElements() {
        List<WebElement> exerciseElements = new ArrayList();
        exerciseElements.add(language);
        exerciseElements.add(language_drop_down);
        exerciseElements.add(check_box_head);
        exerciseElements.add(desktop_check_box);
        exerciseElements.add(meeting_check_box);
        exerciseElements.add(email_name);
        exerciseElements.add(email_name_box);
        exerciseElements.add(task_name);
        exerciseElements.add(task_name_box);

        return exerciseElements;
    }

    public List<WebElement> getJobElements() {
        List<WebElement> jobElements = new ArrayList();
        jobElements.add(name);
        jobElements.add(name_box);
        jobElements.add(level);
        jobElements.add(level_drop_down);
        jobElements.add(industry);
        jobElements.add(industry_drop_down);
        jobElements.add(type);
        jobElements.add(type_drop_down);

        return jobElements;
    }

    public List<WebElement> getDateElements() {
        List<WebElement> dateElements = new ArrayList();
        dateElements.add(date);
        dateElements.add(date_box);
        // dateElements.add(time);
        // dateElements.add(time_box);

        return dateElements;
    }

}