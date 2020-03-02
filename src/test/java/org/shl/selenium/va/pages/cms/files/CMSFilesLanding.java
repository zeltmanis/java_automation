package org.shl.selenium.va.pages.cms.files;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CMSFilesLanding {

    private WebDriver driver;
    WebDriverWait wait;

    // Page Objects
    private CMSFilesUpload objCMSFilesUpload;

    public CMSFilesLanding(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    private static final String UPLOAD = "//*[@data-testid='button-upload']";
    private static final String FILE = "(//*[@data-testid='panel-cms-files']/../..//a)[2]";

    @FindBy(xpath = UPLOAD)
    WebElement upload;

    @FindBy(xpath = FILE)
    WebElement file;

    public void openUpload() {
        objCMSFilesUpload = new CMSFilesUpload(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(UPLOAD)));
        upload.click();
        assertTrue(objCMSFilesUpload.checkDropBox().isDisplayed());
    }

    public WebElement checkUploadButton() {
        return upload;
    }

    public void downloadFile() throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILE)));
        file.click();
    }

}