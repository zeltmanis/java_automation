package org.shl.selenium.va.pages.cms.files;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CMSFilesUpload {

    private WebDriver driver;
    WebDriverWait wait;

    // Page Objects
    private CMSFilesLanding objCMSFilesLanding;

    public CMSFilesUpload(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    String path = System.getProperty("user.dir");

    private static final String CLOSE = "//*[@data-testid='close-upload']";
    private static final String DROP_BOX = "//*[@data-testid='upload-modal']";
    private static final String SAVE = "//*[@data-testid='button-save']";
    private static final String DELETE_FILE = "//*[@data-testid='icon-remove-file']";

    @FindBy(xpath = CLOSE)
    WebElement close;

    @FindBy(xpath = DROP_BOX)
    WebElement drop_box;

    public void clickClose() {
        objCMSFilesLanding = new CMSFilesLanding(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CLOSE)));
        close.click();
        assertTrue(objCMSFilesLanding.checkUploadButton().isDisplayed());
    }

    public WebElement checkDropBox() {
        return drop_box;
    }

}
