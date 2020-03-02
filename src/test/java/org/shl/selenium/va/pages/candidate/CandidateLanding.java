package org.shl.selenium.va.pages.candidate;

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

public class CandidateLanding {
    WebDriver driver;
    WebDriverWait wait;

    private CognitoAuthDialog objCognitoAuthDialog;

    // Navigation
    private static final String LANDING_SHL_LOGO = "//*[@data-testid='logo']";
    public static final String THE_INTERVEE = "//*[@data-testid='title-interviewee']";
    public static final String CANDIDATE_NAME = "//*[@data-testid='interviewee-name']";
    private static final String SITE_TEST_USER = "candidate1";
    private static final String SITE_TEST_PASSWORD = "Password@1";

    // Navigation
    @FindBy(xpath = LANDING_SHL_LOGO)
    WebElement page_logo;

    @FindBy(xpath = THE_INTERVEE)
    WebElement the_intervee;

    @FindBy(xpath = CANDIDATE_NAME)
    WebElement candidate_name;

    public CandidateLanding(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 30);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public WebElement getPageLogo() {
        return page_logo;
    }

    public void loginCandidate(WebDriver driver) throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);

        // Verify Cognito Form before login
        assertTrue("VA Cognito Login page logo should be visible", objCognitoAuthDialog.getCognitoLogo().isDisplayed());

        assertTrue("The page title should be changed as expected",
                objCognitoAuthDialog.getLoginTitle().equals("Signin"));

        // Login to the VA Tool
        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);

        // Verify that we are on Landing page
        await().atMost(5, SECONDS).until(() -> {
            return "SHL candidate".equals(getTitle());
        });
        Assertions.assertThat(getTitle()).isEqualTo("SHL candidate");
        assertTrue("VA Landing page logo should be visible", getPageLogo().isDisplayed());

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CANDIDATE_NAME)));

        List<WebElement> candidateLandingElements = getCandidateLandingPageElements();
        for (WebElement e : candidateLandingElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void checkCandidateName() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CANDIDATE_NAME)));
    }

    public List<WebElement> getCandidateLandingPageElements() {
        List<WebElement> candidateLandingElements = new ArrayList();
        candidateLandingElements.add(page_logo);
        candidateLandingElements.add(the_intervee);
        candidateLandingElements.add(candidate_name);

        return candidateLandingElements;
    }

}