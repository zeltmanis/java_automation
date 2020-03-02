package org.shl.selenium.va.pages.candidate;

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

public class CandidateEmailIntro {
    WebDriver driver;
    WebDriverWait wait;

    private CandidateEmailExercise objCandidateEmailExercise;

    public CandidateEmailIntro(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 30);
    }

    // Top corner icons and buttons
    private static final String PAGE_BUTTON = "//*[@data-testid='icon-instructions']";
    private static final String TIMER_ICON = "//*[@id='root']/div/div[1]/div[2]/div[2]";

    // Exercise instructions
    private static final String INSTRUCTIONS = "//*[@data-testid='text-instruction-0']";
    private static final String TASK_1 = "(//*[@data-testid='title'])[1]";
    private static final String TASK_1_EXPAND = "//div[text()='TASK 1 - ORGANISING']/../..//img";
    private static final String TASK_1_TEXT = "(//*[@data-testid='text'])[1]";
    private static final String TASK_2 = "(//*[@data-testid='title'])[2]";
    private static final String TASK_2_EXPAND = "//div[text()='TASK 2 - PROBLEM SOLVING']/../..//img";
    private static final String TASK_2_TEXT = "(//*[@data-testid='text'])[2]";
    private static final String START_BUTTON = "//*[@data-testid='button-process']";

    private static final String MENU = "//*[@data-testid='menu']";

    // Top corner icons and buttons
    @FindBy(xpath = PAGE_BUTTON)
    WebElement page_button;

    @FindBy(xpath = TIMER_ICON)
    WebElement timer_icon;

    // Exercise instructions
    @FindBy(xpath = INSTRUCTIONS)
    WebElement instructions;

    @FindBy(xpath = TASK_1)
    WebElement task_1;

    @FindBy(xpath = TASK_1_EXPAND)
    WebElement task_1_expand;

    @FindBy(xpath = TASK_1_TEXT)
    WebElement task_1_text;

    @FindBy(xpath = TASK_2)
    WebElement task_2;

    @FindBy(xpath = TASK_2_EXPAND)
    WebElement task_2_expand;

    @FindBy(xpath = TASK_2_TEXT)
    WebElement task_2_text;

    @FindBy(xpath = START_BUTTON)
    WebElement start_button;

    @FindBy(xpath = MENU)
    WebElement menu;

    public void checkPageElements() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TASK_1_EXPAND)));
        List<WebElement> candidateElements = getCandidateEmailPrepElements();
        for (WebElement e : candidateElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }

    }

    public void expandTask1() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TASK_1_EXPAND)));
        task_1_expand.click();
    }

    public WebElement checkTask1Text() {
        return task_1_text;
    }

    public void getTask1Text() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TASK_1_TEXT)));
        assertTrue(checkTask1Text().isDisplayed());
    }

    public void expandTask2() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TASK_2_EXPAND)));
        task_2_expand.click();
    }

    public WebElement checkTask2Text() {
        return task_2_text;
    }

    public void getTask2Text() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TASK_2_TEXT)));
        assertTrue(checkTask2Text().isDisplayed());
    }

    public void startExercise() {
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(START_BUTTON)));
        start_button.click();
        List<WebElement> emailElements = objCandidateEmailExercise.getCandidateEmailElements();
        for (WebElement e : emailElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void switchPage() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PAGE_BUTTON)));
        page_button.click();
    }

    public void checkStartButton() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(START_BUTTON)));
    }

    public void getContinueButton() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(START_BUTTON)));
        assertTrue(checkContinueButton().isDisplayed());
    }

    public WebElement checkContinueButton() {
        return start_button;
    }

    public List<WebElement> getCandidateEmailPrepElements() {
        List<WebElement> candidateEmailPrepElements = new ArrayList();
        candidateEmailPrepElements.add(page_button);
        candidateEmailPrepElements.add(timer_icon);
        candidateEmailPrepElements.add(instructions);
        candidateEmailPrepElements.add(task_1);
        candidateEmailPrepElements.add(task_1_expand);
        candidateEmailPrepElements.add(task_2);
        candidateEmailPrepElements.add(task_2_expand);
        candidateEmailPrepElements.add(start_button);

        return candidateEmailPrepElements;
    }

}