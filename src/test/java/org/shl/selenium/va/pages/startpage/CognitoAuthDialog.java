package org.shl.selenium.va.pages.startpage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class CognitoAuthDialog {
    WebDriver driver;
    WebDriverWait wait;

    public static final String COGNITO_AUTH_LOGO = "/html/body/div[1]/div/div[2]/div[1]/div/div/center/img";
    public static final String FORM_INPUT_USERNAME = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/div[1]/input";
    public static final String FORM_INPUT_PASSWORD = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/div[2]/input";
    public static final String FORM_INPUT_SIGN_IN = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/form/input[3]";

    @FindBy(xpath = FORM_INPUT_USERNAME)
    WebElement username;

    @FindBy(xpath = FORM_INPUT_PASSWORD)
    WebElement password;

    @FindBy(xpath = FORM_INPUT_SIGN_IN)
    WebElement button_sign_in;

    @FindBy(xpath = COGNITO_AUTH_LOGO)
    WebElement img_auth_logo;

    public CognitoAuthDialog(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    public void setUserName(String inputUsername) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FORM_INPUT_USERNAME)));
        username.sendKeys(inputUsername);
    }

    public void setPassword(String inputPassword) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FORM_INPUT_PASSWORD)));
        password.sendKeys(inputPassword);
    }

    public void clickSignIn() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FORM_INPUT_SIGN_IN)));
        button_sign_in.click();
    }

    public String getLoginTitle() {
        return driver.getTitle();
    }

    public WebElement getCognitoLogo() {
        return img_auth_logo;
    }

    public void loginToVA(String inputUsername, String inputPassword) {
        this.setUserName(inputUsername);
        this.setPassword(inputPassword);
        this.clickSignIn();
    }
}
