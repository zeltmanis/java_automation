package org.shl.selenium.va.pages.cms;

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

public class CMSCompetencies {

    private WebDriver driver;
    WebDriverWait wait;

    private boolean isElementPresent(By xpath) {
        return false;
    }

    public CMSCompetencies(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    // Competencies elements
    private static final String CREATE_NEW = "//*[@data-testid='button-create']";
    private static final String COMPETENCIES_TITLE = "//*[@data-testid='header-row-0']";

    // Elements under Create New
    private static final String NAME = "//div[text()='Name']";
    private static final String NAME_BOX = "(//*[@data-testid='input'])[1]";
    private static final String LANGUAGE = "//div[text()='Language']";
    private static final String LANGUAGE_BOX = "/html/body/div[2]/div/div/div/form/div[1]/div[2]/div[2]/div";
    private static final String BEHAVIOURS = "//div[text()='Behaviours']";
    private static final String BEHAVIOURS_BOX = "(//*[@data-testid='input'])[2]";
    private static final String BEHAVIOURS_ADD_BUTTON = "html/body/div[2]/div/div/div/form/div[2]/div[2]/div//span";
    private static final String BEHAVIOURS_WARNING = "//*[@data-testid='input-behaviours']//span";
    private static final String CREATE_TAG = "//div[text()='Create tags']";
    private static final String CREATE_TAG_BOX = "(//*[@data-testid='input'])[3]";
    private static final String CREATE_TAG_ADD_BUTTON = "/html/body/div[2]/div/div/div/form/div[3]/div[2]/div/div//span";
    private static final String TAG_WARNING = "//*[@data-testid='input-tags']//span";
    private static final String DISCARD_BUTTON = "//*[@data-testid='button-cancel']";
    private static final String CREATE = "//*[@data-testid='button-submit']";
    private static final String SAVE_BUTTON = "//button[text()='Save']";

    // Create Tag error icon
    private static final String ERROR_ICON = "//*[@data-testid='icon-error']";
    private static final String BEHAVIOUR_ERROR_ICON = "//*[@data-testid='icon-error']";

    // Competencies elements
    @FindBy(xpath = CREATE_NEW)
    WebElement create_new;

    @FindBy(xpath = COMPETENCIES_TITLE)
    WebElement competencies_title;

    // Elements under Create New
    @FindBy(xpath = NAME)
    WebElement name;

    @FindBy(xpath = NAME_BOX)
    WebElement name_box;

    @FindBy(xpath = LANGUAGE)
    WebElement language;

    @FindBy(xpath = LANGUAGE_BOX)
    WebElement language_box;

    @FindBy(xpath = BEHAVIOURS)
    WebElement behaviours;

    @FindBy(xpath = BEHAVIOURS_BOX)
    WebElement behaviours_box;

    @FindBy(xpath = BEHAVIOURS_ADD_BUTTON)
    WebElement behaviours_add_button;

    @FindBy(xpath = BEHAVIOURS_WARNING)
    WebElement behaviours_warning;

    @FindBy(xpath = CREATE_TAG)
    WebElement create_tag;

    @FindBy(xpath = CREATE_TAG_BOX)
    WebElement create_tag_box;

    @FindBy(xpath = CREATE_TAG_ADD_BUTTON)
    WebElement create_tag_add_button;

    @FindBy(xpath = TAG_WARNING)
    WebElement tag_warning;

    @FindBy(xpath = DISCARD_BUTTON)
    WebElement discard_button;

    @FindBy(xpath = CREATE)
    WebElement create;

    @FindBy(xpath = SAVE_BUTTON)
    WebElement save_button;

    // Create Tag error icon
    @FindBy(xpath = ERROR_ICON)
    WebElement error_icon;

    public void clickCreateNew() {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CREATE_NEW)));
        create_new.click();
        // List<WebElement> newCompetenciesElements = getCMSNewCompetenciesElements();
        // for (WebElement e : newCompetenciesElements) {
        // assertTrue("Element " + e + " is not visible", e.isDisplayed());
        // }
    }

    public void enterName(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_BOX)));
        name_box.click();
        name_box.clear();
        name_box.sendKeys(text);
    }

    public void enterBehaviours() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BEHAVIOURS_BOX)));
        assertTrue(!isElementPresent(By.xpath(BEHAVIOURS_ADD_BUTTON)));
        String[] tag = Utils.generateRandomWords(1);
        behaviours_box.sendKeys(tag[0]);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BEHAVIOURS_ADD_BUTTON)));
        behaviours_add_button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[2]/div/div/div/form/div[2]/div[2]/div[2]//div[text()='" + tag[0] + "']")));
    }

    public void enterTags() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_TAG_BOX)));
        assertTrue(!isElementPresent(By.xpath(CREATE_TAG_ADD_BUTTON)));
        String[] tag = Utils.generateRandomWords(1);
        create_tag_box.sendKeys(tag[0]);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE_TAG_ADD_BUTTON)));
        create_tag_add_button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[2]/div/div/div/form/div[3]/div[2]/div[2]//div[text()='" + tag[0] + "']")));
    }

    public void deleteBehaviours() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BEHAVIOURS_BOX)));
        assertTrue(!isElementPresent(By.xpath(BEHAVIOURS_ADD_BUTTON)));
        String[] tag = Utils.generateRandomWords(1);
        behaviours_box.sendKeys(tag[0]);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BEHAVIOURS_ADD_BUTTON)));
        behaviours_add_button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[2]/div/div/div/form/div[2]/div[2]/div[2]//div[text()='" + tag[0] + "']")));
        this.driver
                .findElement(By.xpath(
                        "/html/body/div[2]/div/div/div/form/div[2]/div[2]/div[2]//div[text()='" + tag[0] + "']//img"))
                .click();
        assertTrue(!isElementPresent(
                By.xpath("/html/body/div[2]/div/div/div/form/div[2]/div[2]/div[2]//div[text()='" + tag[0] + "']")));
    }

    public void deleteCompetenciesTag() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_TAG_BOX)));
        assertTrue(!isElementPresent(By.xpath(CREATE_TAG_ADD_BUTTON)));
        String[] tag = Utils.generateRandomWords(1);
        create_tag_box.sendKeys(tag[0]);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE_TAG_ADD_BUTTON)));
        create_tag_add_button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[2]/div/div/div/form/div[3]/div[2]/div[2]//div[text()='" + tag[0] + "']")));
        this.driver
                .findElement(By.xpath(
                        "/html/body/div[2]/div/div/div/form/div[3]/div[2]/div[2]//div[text()='" + tag[0] + "']//img"))
                .click();
        assertTrue(!isElementPresent(
                By.xpath("/html/body/div[2]/div/div/div/form/div[3]/div[2]/div[2]//div[text()='" + tag[0] + "']")));

    }

    public void clickCreate() {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CREATE)));
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE)));
        create.click();
    }

    public void clickSave() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SAVE_BUTTON)));
        save_button.click();
        List<WebElement> competenciesElements = getCMSCompetenciesElements();
        for (WebElement e : competenciesElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public String getWarningOnlyChar() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_TAG_BOX)));
        assertTrue(!isElementPresent(By.xpath(CREATE_TAG_ADD_BUTTON)));
        create_tag_box.sendKeys("123");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_ICON)));
        WebElement warining = driver.findElement(By.xpath(TAG_WARNING));
        String actual = warining.getText();
        return actual;
    }

    public String getWarningExistingTag() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_TAG_BOX)));
        assertTrue(!isElementPresent(By.xpath(CREATE_TAG_ADD_BUTTON)));
        create_tag_box.sendKeys("Test");
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE_TAG_ADD_BUTTON)));
        create_tag_add_button.click();
        create_tag_box.sendKeys("Test");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_ICON)));
        WebElement warining = driver.findElement(By.xpath(TAG_WARNING));
        String actual = warining.getText();
        return actual;
    }

    public String getWarningUppercaseTag() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_TAG_BOX)));
        assertTrue(!isElementPresent(By.xpath(CREATE_TAG_ADD_BUTTON)));
        create_tag_box.sendKeys("uppercase");
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE_TAG_ADD_BUTTON)));
        create_tag_add_button.click();
        create_tag_box.sendKeys("UPPERCASE");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_ICON)));
        WebElement warining = driver.findElement(By.xpath(TAG_WARNING));
        String actual = warining.getText();
        return actual;
    }

    public String get30CharMessage() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_TAG_BOX)));
        assertTrue(!isElementPresent(By.xpath(CREATE_TAG_ADD_BUTTON)));
        create_tag_box.sendKeys("abcdyabcdyabcdyabcdyabcdyabcdyz");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_ICON)));
        WebElement warining = driver.findElement(By.xpath(TAG_WARNING));
        String actual = warining.getText();
        return actual;
    }

    public String getWarningExistingBehaviours() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BEHAVIOURS_BOX)));
        assertTrue(!isElementPresent(By.xpath(BEHAVIOURS_ADD_BUTTON)));
        behaviours_box.sendKeys("Test");
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BEHAVIOURS_ADD_BUTTON)));
        behaviours_add_button.click();
        behaviours_box.sendKeys("Test");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BEHAVIOUR_ERROR_ICON)));
        WebElement warining = driver.findElement(By.xpath(BEHAVIOURS_WARNING));
        String actual = warining.getText();
        return actual;
    }

    public String getMsgBehaviourTagUpper() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BEHAVIOURS_BOX)));
        assertTrue(!isElementPresent(By.xpath(BEHAVIOURS_ADD_BUTTON)));
        behaviours_box.sendKeys("uppercase");
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BEHAVIOURS_ADD_BUTTON)));
        behaviours_add_button.click();
        behaviours_box.sendKeys("UPPERCASE");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BEHAVIOUR_ERROR_ICON)));
        WebElement warining = driver.findElement(By.xpath(BEHAVIOURS_WARNING));
        String actual = warining.getText();
        return actual;
    }

    public List<WebElement> getCMSCompetenciesElements() {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CREATE_NEW)));
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_NEW)));
        List<WebElement> CMSCompetenciesElements = new ArrayList();
        CMSCompetenciesElements.add(create_new);
        CMSCompetenciesElements.add(competencies_title);

        return CMSCompetenciesElements;
    }

    public List<WebElement> getCMSNewCompetenciesElements() {
        List<WebElement> CMSNewCompetenciesElements = new ArrayList();
        CMSNewCompetenciesElements.add(name);
        CMSNewCompetenciesElements.add(name_box);
        CMSNewCompetenciesElements.add(language);
        CMSNewCompetenciesElements.add(language_box);
        CMSNewCompetenciesElements.add(behaviours);
        CMSNewCompetenciesElements.add(behaviours_box);
        CMSNewCompetenciesElements.add(create_tag);
        CMSNewCompetenciesElements.add(create_tag_box);
        CMSNewCompetenciesElements.add(discard_button);
        CMSNewCompetenciesElements.add(create);

        return CMSNewCompetenciesElements;
    }

}