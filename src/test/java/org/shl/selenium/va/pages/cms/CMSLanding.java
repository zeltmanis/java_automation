package org.shl.selenium.va.pages.cms;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.shl.selenium.va.pages.cms.exercises.CMSExercisesLanding;
import org.shl.selenium.va.pages.startpage.CognitoAuthDialog;

public class CMSLanding {

    // Test Credentials
    private static final String SITE_TEST_USER = "contenteditor1";
    private static final String SITE_TEST_PASSWORD = "Password@1";

    private WebDriver driver;
    WebDriverWait wait;

    // Page Objects
    private CognitoAuthDialog objCognitoAuthDialog;
    private CMSExercisesLanding objCMSExercisesLanding;
    private CMSCompetencies objCMSCompetencies;

    private boolean isElementPresent(By xpath) {
        return false;
    }

    public CMSLanding(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public WebElement getPageLogo() {
        return logo;
    }

    // Log-in funciotn to get to CMS page
    public void loginCMS() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);

        // Verify Cognito Form before login
        assertTrue("VA Cognito Login page logo should be visible", objCognitoAuthDialog.getCognitoLogo().isDisplayed());

        assertTrue("The page title should be chagned as expected",
                objCognitoAuthDialog.getLoginTitle().equals("Signin"));

        // Login to the VA Tool
        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);

        // Verify that we are on Landing page
        await().atMost(5, SECONDS).until(() -> {
            return "SHL CMS".equals(getTitle());
        });
        Assertions.assertThat(getTitle()).isEqualTo("SHL CMS");
        assertTrue("VA Landing page logo should be visible", getPageLogo().isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGO)));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOADER)));

        List<WebElement> CMSElements = getCMSElements();
        for (WebElement e : CMSElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    // Page elements
    public static final String LOGO = "//*[@id='root']/div/div[1]/div";
    private static final String FILES = "(//*[@data-testid='button-select-tab'])[1]";
    private static final String EXERCISES = "(//*[@data-testid='button-select-tab'])[2]";
    private static final String COMPETENCIES = "(//*[@data-testid='button-select-tab'])[3]";

    // Created competencie
    public static final String TEST_COMPETENCIE = "//*[contains(@data-testid,'row')]//*[text()='Automation test']";
    private static final String DELETE_COMPETENCIE = "//*[contains(@data-testid,'row')]//*[text()='Delete Automation Test']";
    private static final String OPTION_COMPETENCIE = "//tbody//tr//td//div[contains(@class,'') and text()='Delete Automation Test']//div/div";
    private static final String DELETE_BUTTON = "//tbody//tr//td//div[contains(@class,'') and text()='Delete Automation Test']//div/div[contains(@class,'') and text()='Delete']";

    // Edit competencie
    private static final String EDIT_COMPETENCIE = "(//*[contains(@data-testid,'row')]/../..//*[text()='Edit Automation Test']//div)[1]";
    private static final String EDIT_BUTTON = "(//*[@data-testid='option'])[1]";
    private static final String OPTION_BUTTON = "(//*[contains(@data-testid,'row')]/../..//*[text()='Edit Automation Test']//div)[1]";
    private static final String EDIT_TITLE = "//*[@data-testid='table-body']/../..//*[text()='Changed Test Automation']";

    private static final String LOADER = "//div[@data-testid='loader']";

    // Page elements
    @FindBy(xpath = LOGO)
    WebElement logo;

    @FindBy(xpath = FILES)
    WebElement files;

    @FindBy(xpath = EXERCISES)
    WebElement exercises;

    @FindBy(xpath = COMPETENCIES)
    WebElement competencies;

    // Created competencie
    @FindBy(xpath = TEST_COMPETENCIE)
    WebElement test_competencie;

    @FindBy(xpath = DELETE_COMPETENCIE)
    WebElement delete_competencie;

    @FindBy(xpath = OPTION_COMPETENCIE)
    WebElement option_competencie;

    @FindBy(xpath = DELETE_BUTTON)
    WebElement delete_button;

    // Edit competencie
    @FindBy(xpath = EDIT_COMPETENCIE)
    WebElement edit_competencie;

    @FindBy(xpath = EDIT_BUTTON)
    WebElement edit_button;

    @FindBy(xpath = OPTION_BUTTON)
    WebElement option_button;

    @FindBy(xpath = EDIT_TITLE)
    WebElement edit_title;

    @FindBy(xpath = LOADER)
    WebElement loader;

    public void waitForLoader() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOADER)));
    }

    public void openExercises() {
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EXERCISES)));
        exercises.click();
        List<WebElement> exercisesNewElements = objCMSExercisesLanding.getCMSExercisesLandingElements();
        for (WebElement e : exercisesNewElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void openCompetencies() {
        objCMSCompetencies = new CMSCompetencies(driver);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(COMPETENCIES)));
        competencies.click();
        List<WebElement> competenciesElements = objCMSCompetencies.getCMSCompetenciesElements();
        for (WebElement e : competenciesElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void openFiles() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FILES)));
        files.click();
    }

    public WebElement checkEditedcompetencie() {
        return edit_title;
    }

    public void getEditedCompetencie() {
        assertTrue(checkEditedcompetencie().isDisplayed());
    }

    public void openOptions() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_COMPETENCIE)));
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OPTION_COMPETENCIE)));
        option_competencie.click();
    }

    public void clickDelete() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_BUTTON)));
        delete_button.click();
    }

    public void clickEdit() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDIT_COMPETENCIE)));
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OPTION_BUTTON)));
        option_button.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT_BUTTON)));
        edit_button.click();
    }

    public void checkDeletedCompetency() {
        assertTrue(!isElementPresent(By.xpath(DELETE_COMPETENCIE)));
    }

    public WebElement checkCreatedCompetencie() {
        return test_competencie;
    }

    public void getCreatedCompetencie() {
        assertTrue(checkCreatedCompetencie().isDisplayed());

    }

    public void checkLoader() {
        assertTrue(isElementPresent(By.xpath(LOADER)));
    }

    public List<WebElement> getCMSElements() {
        List<WebElement> CMSElements = new ArrayList();
        CMSElements.add(logo);
        CMSElements.add(files);
        CMSElements.add(exercises);
        CMSElements.add(competencies);

        return CMSElements;
    }
}