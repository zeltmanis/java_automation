package org.shl.selenium.va.pages.cms.exercises;

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
import org.shl.selenium.va.pages.cms.exercises.createnew.CMSGeneralSettings;

public class CMSExercisesLanding {

    private static CMSExercisesPopUp objCMSExercisesPopUp;
    private static CMSGeneralSettings objCMSGeneralSettings;

    private WebDriver driver;
    WebDriverWait wait;

    private boolean isElementPresent(By xpath) {
        return false;
    }

    public CMSExercisesLanding(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    // Page elements
    private static final String CREATE_NEW = "//*[@data-testid='button-create']";
    private static final String EXERCISE_NAME = "//*[@data-testid='header-cell-0']";
    private static final String LAST_MODIFIED = "//*[@data-testid='header-cell-1']";
    private static final String MODIFIED_BY = "//*[@data-testid='header-cell-2']";
    private static final String LAST_PUBLISH_TAG = "//*[@data-testid='header-cell-3']";
    private static final String TAG = "//*[@data-testid='header-cell-4']";
    private static final String STATUS = "//*[@data-testid='header-cell-5']";

    private static final String TABLE = "//*[@data-testid='body']";
    private static final String OPTION = "//*[@data-testid='cell-5']//div[@tabindex]";

    // options button
    private static final String REMOVE = "//*[@data-testid='cell-5']//div[text()='Remove']";
    private static final String EDIT = "//*[@data-testid='cell-5']//div[text()='Edit']";

    // Page elements
    @FindBy(xpath = CREATE_NEW)
    WebElement create_new;

    @FindBy(xpath = EXERCISE_NAME)
    WebElement exercise_name;

    @FindBy(xpath = LAST_MODIFIED)
    WebElement last_modified;

    @FindBy(xpath = MODIFIED_BY)
    WebElement modified_by;

    @FindBy(xpath = LAST_PUBLISH_TAG)
    WebElement last_publish_tag;

    @FindBy(xpath = TAG)
    WebElement tag;

    @FindBy(xpath = STATUS)
    WebElement status;

    @FindBy(xpath = TABLE)
    WebElement table;

    @FindBy(xpath = OPTION)
    WebElement option;

    @FindBy(xpath = REMOVE)
    WebElement remove;

    @FindBy(xpath = EDIT)
    WebElement edit;

    public void clickOptions(String tag) {
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        driver.navigate().refresh();
        this.wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//div[text()='" + tag + "']/../..//div[@tabindex]")))
                .click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(REMOVE)));
    }

    public void removeExercise(String tag) {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(REMOVE)));
        remove.click();
        assertTrue(!isElementPresent(By.xpath("//div[text()='" + tag + "']/../..//div[@tabindex]")));
    }

    public void editExercise() {
        objCMSGeneralSettings = new CMSGeneralSettings(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT)));
        edit.click();
        List<WebElement> exerciseElements = objCMSGeneralSettings.getExerciseElements();
        for (WebElement e : exerciseElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
        List<WebElement> jobElements = objCMSGeneralSettings.getJobElements();
        for (WebElement e : jobElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
        List<WebElement> dateElements = objCMSGeneralSettings.getDateElements();
        for (WebElement e : dateElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }

    }

    public void clickCreateNew() throws InterruptedException {
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        driver.navigate().refresh();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE_NEW)));
        create_new.click();
        Thread.sleep(4000);
        List<WebElement> exercisePopUpElements = objCMSExercisesPopUp.getCMSExercisesPopUpElements();
        for (WebElement e : exercisePopUpElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public List<WebElement> getCMSExercisesLandingElements() {
        List<WebElement> CMSExerciseLandingElements = new ArrayList();
        CMSExerciseLandingElements.add(create_new);
        CMSExerciseLandingElements.add(exercise_name);
        CMSExerciseLandingElements.add(last_modified);
        CMSExerciseLandingElements.add(modified_by);
        CMSExerciseLandingElements.add(last_publish_tag);
        CMSExerciseLandingElements.add(tag);
        CMSExerciseLandingElements.add(status);

        return CMSExerciseLandingElements;
    }

}