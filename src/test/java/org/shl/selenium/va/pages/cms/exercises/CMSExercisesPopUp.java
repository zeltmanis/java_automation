package org.shl.selenium.va.pages.cms.exercises;

import static org.junit.Assert.assertFalse;
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
import org.shl.selenium.va.pages.cms.exercises.createnew.CMSExercisesCreateNew;

public class CMSExercisesPopUp {

    private CMSExercisesLanding objCMSExercisesLanding;
    private CMSExercisesCreateNew objCMSExercisesCreateNew;

    private WebDriver driver;
    WebDriverWait wait;

    String[] tag = Utils.generateRandomWords(1);

    public CMSExercisesPopUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    private static final String HEADER = "//*[@data-testid='label']";
    private static final String NAME_BOX = "//*[@data-testid='input']";
    private static final String CLOSE = "//*[@data-testid='button-close']";
    private static final String NEXT = "//*[@data-testid='button-next']";
    private static final String WARNING = "//*[@data-testid='input-error']";

    @FindBy(xpath = HEADER)
    WebElement header;

    @FindBy(xpath = NAME_BOX)
    WebElement name_box;

    @FindBy(xpath = CLOSE)
    WebElement close;

    @FindBy(xpath = NEXT)
    WebElement next;

    @FindBy(xpath = WARNING)
    WebElement warning;

    public void closPopUp() {
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CLOSE)));
        close.click();
        List<WebElement> exerciseElements = objCMSExercisesLanding.getCMSExercisesLandingElements();
        for (WebElement e : exerciseElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void enterName(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_BOX)));
        name_box.sendKeys(text);
    }

    public String getNameExist() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WARNING)));
        WebElement name = driver.findElement(By.xpath(WARNING));
        String actual = name.getText();
        return actual;
    }

    public void nextButtonDisabled() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NEXT)));
        assertFalse(driver.findElement(By.xpath(NEXT)).isEnabled());
    }

    public String exerciseName() {
        assertFalse(driver.findElement(By.xpath(NEXT)).isEnabled());
        String name = tag[0];
        enterName(name);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_BOX)));
        return name;
    }

    public String getTag() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_BOX)));
        String actual = exerciseName();
        return actual;
    }

    public void clickNext() {
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NEXT)));
        next.click();
        List<WebElement> createNewElements = objCMSExercisesCreateNew.getCMSExercisesCreatesNewElements();
        for (WebElement e : createNewElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }

    }

    public List<WebElement> getCMSExercisesPopUpElements() {
        List<WebElement> CMSExercisesPopUpElements = new ArrayList();
        CMSExercisesPopUpElements.add(header);
        CMSExercisesPopUpElements.add(name_box);
        CMSExercisesPopUpElements.add(close);
        CMSExercisesPopUpElements.add(next);

        return CMSExercisesPopUpElements;
    }
}