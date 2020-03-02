package org.shl.selenium.va.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WarningMessage {

    private WebDriver driver;
    WebDriverWait wait;

    public WarningMessage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    private static final String MESSAGE = "//h2";
    private static final String YES = "//*[@data-testid='button-yes']";
    private static final String NO = "//*[@data-testid='button-no']";

    @FindBy(xpath = MESSAGE)
    WebElement message;

    @FindBy(xpath = YES)
    WebElement yes;

    @FindBy(xpath = NO)
    WebElement no;

    public String getMessage() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE)));
        WebElement message = driver.findElement(By.xpath(MESSAGE));
        String actual = message.getText();
        return actual;
    }

    public void clickYes() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(YES)));
        yes.click();
    }

    public void clickNo() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NO)));
        no.click();
    }

}
