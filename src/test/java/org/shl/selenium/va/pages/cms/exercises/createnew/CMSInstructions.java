package org.shl.selenium.va.pages.cms.exercises.createnew;

import static org.junit.Assert.assertEquals;
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

public class CMSInstructions {

    private WebDriver driver;
    WebDriverWait wait;

    public CMSInstructions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    private boolean isElementPresent(By xpath) {
        return false;
    }

    String[] tag = Utils.generateRandomWords(1);

    // Page elements
    private static final String HEADLINE = "//*[@data-testid='label']";
    private static final String HEADLINE_BOX = "//*[@data-testid='input']";
    private static final String OVERVIEW = "//div[text()='Overview']";
    private static final String OVERVIEW_BOX = "/html/body/div[2]/div/div/div/form/div[2]/div[5]/div/div[1]/div[2]/div[3]/div[2]/div";
    private static final String UNDO_BUTTON = "/html/body/div[2]/div/div/div/form/div[2]/div[5]/div/div[1]/div[2]/div[3]/div[1]/div/div[2]/div/div/button[1]";
    private static final String REDO_BUTTON = "/html/body/div[2]/div/div/div/form/div[2]/div[5]/div/div[1]/div[2]/div[3]/div[1]/div/div[2]/div/div/button[2]";
    private static final String BOLD_BUTTON = "/html/body/div[2]/div/div/div/form/div[2]/div[5]/div/div[1]/div[2]/div[3]/div[1]/div/div[2]/div/div/button[3]";
    private static final String ITALIC_BUTTON = "/html/body/div[2]/div/div/div/form/div[2]/div[5]/div/div[1]/div[2]/div[3]/div[1]/div/div[2]/div/div/button[4]";
    private static final String STEPS = "//div[text()='Steps']";
    private static final String ADD_STEPS_BUTTON = "//*[@data-testid='button-add-steps']";

    // Add steps pop-up
    private static final String ADD_STEPS_HEADLINE = "(//*[@data-testid='label'])[2]";
    private static final String ADD_STEPS_HEADLINE_BOX = "(//*[@data-testid='input'])[2]";
    private static final String ADD_STEPS_HEADLINE_WARNING = "(//*[@data-testid='input-error'])[2]";
    private static final String BODY = "//div[text()='Body']";
    private static final String BODY_BOX = "//*[@data-testid='body']//textarea";
    private static final String BODY_WARNING = "//div[text()='Body is mandatory']";
    private static final String DISCARD = "//*[@data-testid='button-close']";
    private static final String CREATE = "//*[@data-testid='button-next']";
    private static final String SAVE = "//button[text()='Save']";

    // Added step to Instructions
    private static final String STEP = "//*[contains(@class,'') and text()='Step ']";
    private static final String STEP_HEADLINE = "/html/body/div[2]/div/div/div/form/div[2]/div[5]/div/div[2]/div/div[2]/div[2]";
    private static final String STEP_BODY = "/html/body/div[2]/div/div/div/form/div[2]/div[5]/div/div[2]/div/div[2]/div[3]";
    private static final String OPTIONS = "/html/body/div[2]/div/div/div/form/div[2]/div[5]/div/div[2]/div/div[2]/div[4]";
    private static final String EDIT = "//div[text()='Edit']";
    private static final String REMOVE = "//div[text()='Remove']";

    // Delete step warning msg
    private static final String MSG = "//h2[text()='Are you sure that you want to delete step?']";
    private static final String YES = "//*[@data-testid='button-yes']";
    private static final String NO = "//*[@data-testid='button-no']";

    // Page elements
    @FindBy(xpath = HEADLINE)
    WebElement headline;

    @FindBy(xpath = HEADLINE_BOX)
    WebElement headline_box;

    @FindBy(xpath = OVERVIEW)
    WebElement overview;

    @FindBy(xpath = OVERVIEW_BOX)
    WebElement overview_box;

    @FindBy(xpath = UNDO_BUTTON)
    WebElement undo_button;

    @FindBy(xpath = REDO_BUTTON)
    WebElement redo_button;

    @FindBy(xpath = BOLD_BUTTON)
    WebElement bold_button;

    @FindBy(xpath = ITALIC_BUTTON)
    WebElement italic_button;

    @FindBy(xpath = STEPS)
    WebElement steps;

    @FindBy(xpath = ADD_STEPS_BUTTON)
    WebElement add_steps_button;

    // Add steps pop-up
    @FindBy(xpath = ADD_STEPS_HEADLINE)
    WebElement add_steps_headline;

    @FindBy(xpath = ADD_STEPS_HEADLINE_BOX)
    WebElement add_steps_headline_box;

    @FindBy(xpath = ADD_STEPS_HEADLINE_WARNING)
    WebElement add_steps_headline_warning;

    @FindBy(xpath = BODY)
    WebElement body;

    @FindBy(xpath = BODY_BOX)
    WebElement body_box;

    @FindBy(xpath = BODY_WARNING)
    WebElement body_warning;

    @FindBy(xpath = DISCARD)
    WebElement discard;

    @FindBy(xpath = CREATE)
    WebElement create;

    @FindBy(xpath = SAVE)
    WebElement save;

    // Added step to Instructions
    @FindBy(xpath = OPTIONS)
    WebElement options;

    @FindBy(xpath = EDIT)
    WebElement edit;

    @FindBy(xpath = REMOVE)
    WebElement remove;

    // Delete step warning msg
    @FindBy(xpath = MSG)
    WebElement msg;

    @FindBy(xpath = YES)
    WebElement yes;

    @FindBy(xpath = NO)
    WebElement no;

    public void textHeadline(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HEADLINE_BOX)));
        headline_box.sendKeys(text);
    }

    public void textOverview(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OVERVIEW_BOX)));
        overview_box.sendKeys(text);
    }

    public void enterHeadline() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HEADLINE_BOX)));
        textHeadline(tag[0]);
    }

    public void enterOverview() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OVERVIEW_BOX)));
        textOverview(tag[0]);
    }

    public void addSteps() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_STEPS_BUTTON)));
        add_steps_button.click();
        List<WebElement> addStepsElements = getAddStepElements();
        for (WebElement e : addStepsElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void textStepHeadline(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADD_STEPS_HEADLINE_BOX)));
        add_steps_headline_box.clear();
        add_steps_headline_box.sendKeys(text);
    }

    public void enterStepHeadline() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADD_STEPS_HEADLINE_BOX)));
        textStepHeadline(tag[0]);
    }

    public WebElement stepHeadlineWarning() {
        return add_steps_headline_warning;
    }

    public String getStepHeadlineWarning() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADD_STEPS_HEADLINE_BOX)));
        body_box.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADD_STEPS_HEADLINE_WARNING)));
        WebElement warningHeadline = driver.findElement(By.xpath(ADD_STEPS_HEADLINE_WARNING));
        String actual = warningHeadline.getText();
        return actual;
    }

    public void textBody(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BODY_BOX)));
        body_box.clear();
        body_box.sendKeys(text);
    }

    public void enterBody() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BODY_BOX)));
        textBody(tag[0]);
    }

    public WebElement stepBodyWarning() {
        return body_warning;
    }

    public String getStepBodyWarning() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BODY_BOX)));
        add_steps_headline_box.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BODY_WARNING)));
        WebElement warning = driver.findElement(By.xpath(BODY_WARNING));
        String actual = warning.getText();
        return actual;
    }

    public void clickDiscard() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DISCARD)));
        discard.click();
        List<WebElement> instructionElements = getIntructionElements();
        for (WebElement e : instructionElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void clickCreate() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE)));
        create.click();
        List<WebElement> instructionElements = getIntructionElements();
        for (WebElement e : instructionElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void clickSaveChanges() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SAVE)));
        save.click();
        List<WebElement> instructionElements = getIntructionElements();
        for (WebElement e : instructionElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void createButtonDisabled() {
        assertFalse(driver.findElement(By.xpath(CREATE)).isEnabled());
    }

    public String getStepElement() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(STEP)));
        WebElement warning = driver.findElement(By.xpath(STEP));
        String actual = warning.getText();
        return actual;
    }

    public String getStepHeadline() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(STEP_HEADLINE)));
        WebElement warning = driver.findElement(By.xpath(STEP_HEADLINE));
        String actual = warning.getText();
        return actual;
    }

    public String getStepBody() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(STEP_BODY)));
        WebElement warning = driver.findElement(By.xpath(STEP_HEADLINE));
        String actual = warning.getText();
        return actual;
    }

    public void checkStepElements() {
        assertEquals("Step " + "1", getStepElement());
        assertEquals(tag[0], getStepHeadline());
        assertEquals(tag[0], getStepBody());
    }

    public void cancelReoveStep() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OPTIONS)));
        options.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(REMOVE)));
        remove.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MSG)));
        no.click();
        assertEquals("Step " + "1", getStepElement());
    }

    public void removeStep() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OPTIONS)));
        options.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(REMOVE)));
        remove.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MSG)));
        yes.click();
        assertTrue(!isElementPresent(By.xpath(STEP)));
    }

    public void editStep() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OPTIONS)));
        options.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT)));
        edit.click();

    }

    public List<WebElement> getIntructionElements() {
        List<WebElement> instructionElements = new ArrayList();
        instructionElements.add(headline);
        instructionElements.add(headline_box);
        instructionElements.add(overview);
        instructionElements.add(overview_box);
        instructionElements.add(undo_button);
        instructionElements.add(redo_button);
        instructionElements.add(bold_button);
        instructionElements.add(italic_button);
        instructionElements.add(steps);
        instructionElements.add(add_steps_button);

        return instructionElements;
    }

    public List<WebElement> getAddStepElements() {
        List<WebElement> addStepElements = new ArrayList();
        addStepElements.add(add_steps_headline);
        addStepElements.add(add_steps_headline_box);
        addStepElements.add(body);
        addStepElements.add(body_box);
        addStepElements.add(discard);
        addStepElements.add(create);

        return addStepElements;
    }

}