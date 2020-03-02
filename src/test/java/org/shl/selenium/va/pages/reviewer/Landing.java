package org.shl.selenium.va.pages.reviewer;

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
import org.shl.selenium.va.pages.startpage.CognitoAuthDialog;

public class Landing {

    // Test Credentials
    private static final String SITE_TEST_USER = "reviewer1";
    private static final String SITE_TEST_PASSWORD = "Password@1";

    private WebDriver driver;
    WebDriverWait wait;

    // Page Objects
    private CognitoAuthDialog objCognitoAuthDialog;

    // Navigation
    private static final String LANDING_SHL_LOGO = "//*[@id='root']/div/div[1]/div/img";
    public static final String FIND_TITLE = "//*[@data-testid='title']";
    public static final String USER_ID_TITLE = "//*[@data-testid='subtitle']";
    public static final String USER_ID_BOX = "//*[@data-testid='field-search']";
    private static final String SEARCH_BUTTON = "//*[@data-testid='button-search']";
    public static final String USER_NOT_FOUND = "//*[@data-testid='title-error']";
    private static final String USER_NAME = "//*[@data-testid='interviewee-name']";

    // Navigation
    @FindBy(xpath = LANDING_SHL_LOGO)
    WebElement page_logo;

    @FindBy(xpath = FIND_TITLE)
    WebElement find_title;

    @FindBy(xpath = USER_ID_TITLE)
    WebElement user_id_title;

    @FindBy(xpath = USER_ID_BOX)
    WebElement user_id_box;

    @FindBy(xpath = SEARCH_BUTTON)
    WebElement search_button;

    @FindBy(xpath = USER_NOT_FOUND)
    WebElement user_not_found;

    @FindBy(xpath = USER_NAME)
    WebElement user_name;

    public Landing(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public WebElement getPageLogo() {
        return page_logo;
    }

    public void clickSearchButton() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH_BUTTON)));
        search_button.click();
    }

    public void enterUserId(String text) {

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(USER_ID_BOX)));
        user_id_box.sendKeys(text);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH_BUTTON)));
    }

    public String getUserName() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(USER_ID_BOX)));
        WebElement userName = driver.findElement(By.xpath(USER_NAME));
        String actual = userName.getText();
        return actual;
    }

    public String getUserNameNotFound() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(USER_NOT_FOUND)));
        WebElement falseUserName = driver.findElement(By.xpath(USER_NOT_FOUND));
        String notFoundActual = falseUserName.getText();
        return notFoundActual;
    }

    public void loginUser() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);

        // Verify Cognito Form before login
        assertTrue("VA Cognito Login page logo should be visible", objCognitoAuthDialog.getCognitoLogo().isDisplayed());

        assertTrue("The page title should be chagned as expected",
                objCognitoAuthDialog.getLoginTitle().equals("Signin"));

        // Login to the VA Tool
        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);

        // Verify that we are on Landing page
        await().atMost(5, SECONDS).until(() -> {
            return "SHL reviewer".equals(getTitle());
        });
        Assertions.assertThat(getTitle()).isEqualTo("SHL reviewer");
        assertTrue("VA Landing page logo should be visible", getPageLogo().isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(USER_ID_BOX)));

        List<WebElement> landingElements = getLandingPageElements();
        for (WebElement e : landingElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public List<WebElement> getLandingPageElements() {
        List<WebElement> landingElements = new ArrayList();
        landingElements.add(page_logo);
        landingElements.add(find_title);
        landingElements.add(user_id_title);
        landingElements.add(user_id_box);
        landingElements.add(search_button);

        return landingElements;
    }

}
