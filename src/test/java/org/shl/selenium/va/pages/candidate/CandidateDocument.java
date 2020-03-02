package org.shl.selenium.va.pages.candidate;

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

public class CandidateDocument {
    static WebDriver driver;
    WebDriverWait wait;

    String path = System.getProperty("user.dir");

    public CandidateDocument(WebDriver driver) {
        CandidateDocument.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(CandidateDocument.driver, 30);
    }

    // Top elements
    private static final String PAGE_BUTTON = "//*[@data-testid='icon-instructions']";
    private static final String TIMER = "//*[@id='root']/div/div[1]/div[2]/div[2]";
    private static final String EXIT_BUTTON = "(//*[@data-testid='clickable-icon'])[1]";

    // Side buttons
    private static final String UPLOAD_BUTTON = "//*[@data-testid='button-compose']";
    private static final String MY_FILES = "//*[@data-testid='button-sidebartab-my']";
    private static final String SHARED_FILES = "//*[@data-testid='button-sidebartab-shared']";
    private static final String MARKED_FILES = "//*[@data-testid='button-sidebartab-marked']";

    // Menu
    private static final String MENU = "//*[@data-testid='menu']";
    private static final String DOCUMENTS = "//*[@data-testid='navigation-documents']";
    private static final String EMAIL = "//*[@data-testid='navigation-email']";

    // Upload file elements
    private static final String DROP_BOX = "//*[@data-testid='drop-area']";
    private static final String SAVE_BUTTON = "//*[@data-testid='button-save']";
    private static final String FILE_UPLOAD = "//*/input";
    private static final String FILE_EXCEL = "//*[@data-testid='file-name']/../..//*[text()='Test_excel.xlsx']";
    private static final String FILE_DOC = "//*[@data-testid='file-name']/../..//*[text()='Test_doc.docx']";
    private static final String FILE_PDF = "//*[@data-testid='file-name']/../..//*[text()='Test_pdf.pdf']";
    private static final String FILE_PP = "//*[@data-testid='file-name']/../..//*[text()='Test_pp.pptx']";
    private static final String EXISTING_FILE = "//*[@data-testid='file-name']/../..//*[text()='Test_exist.docx']";

    // Warnings
    private static final String FILE_EXIST = "//*[@data-testid='error-message']";
    private static final String TRY_AGAIN = "//*[@data-testid='button-close']";

    // Elements under Shared files
    private static final String OPEN_FILES = "//*[@data-testid='folder-0']";
    private static final String EXISTING_DOCUMENT = "//*[@data-testid='document-1']";
    private static final String FILE_OPTION = "(//*[@data-testid='button-options'])[1]";
    private static final String FILE_MARK = "(//*[@data-testid='option'])[2]";

    // Elements under Marked files

    // Top corner elements
    @FindBy(xpath = PAGE_BUTTON)
    WebElement page_button;

    @FindBy(xpath = TIMER)
    WebElement timer;

    @FindBy(xpath = EXIT_BUTTON)
    WebElement exit_button;

    // Bottom Document and Email button
    @FindBy(xpath = MENU)
    WebElement menu;

    @FindBy(xpath = DOCUMENTS)
    WebElement documents;

    @FindBy(xpath = EMAIL)
    WebElement email;

    // Side buttons
    @FindBy(xpath = UPLOAD_BUTTON)
    WebElement upload_button;

    @FindBy(xpath = MY_FILES)
    WebElement my_files;

    @FindBy(xpath = SHARED_FILES)
    WebElement shared_files;

    @FindBy(xpath = MARKED_FILES)
    WebElement marked_files;

    // Upload file elements
    @FindBy(xpath = DROP_BOX)
    WebElement drop_box;

    @FindBy(xpath = SAVE_BUTTON)
    WebElement save_button;

    @FindBy(xpath = FILE_UPLOAD)
    WebElement file_upload;

    @FindBy(xpath = FILE_EXCEL)
    WebElement file_excel;

    @FindBy(xpath = FILE_DOC)
    WebElement file_doc;

    @FindBy(xpath = FILE_PDF)
    WebElement file_pdf;

    @FindBy(xpath = FILE_PP)
    WebElement file_pp;

    @FindBy(xpath = EXISTING_FILE)
    WebElement existing_file;

    // Warnings
    @FindBy(xpath = FILE_EXIST)
    WebElement file_exist;

    @FindBy(xpath = TRY_AGAIN)
    WebElement try_again;

    // Elements under Shared files

    @FindBy(xpath = OPEN_FILES)
    WebElement open_files;

    @FindBy(xpath = EXISTING_DOCUMENT)
    WebElement existing_document;

    @FindBy(xpath = FILE_OPTION)
    WebElement file_option;

    @FindBy(xpath = FILE_MARK)
    WebElement file_mark;

    public void goBack() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PAGE_BUTTON)));
        page_button.click();
    }

    public void openSharedFiles() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SHARED_FILES)));
        shared_files.click();
    }

    public WebElement checkSharedFiles() {
        return existing_document;
    }

    public void getSharedFiles() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EXISTING_DOCUMENT)));
        assertTrue(checkSharedFiles().isDisplayed());
    }

    public void openFiles() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OPEN_FILES)));
        open_files.click();
    }

    public WebElement checkSharedDoc() {
        return existing_document;
    }

    public void getSharedDoc() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EXISTING_DOCUMENT)));
        assertTrue(checkSharedDoc().isDisplayed());
    }

    public void openMarkedFiles() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MARKED_FILES)));
        marked_files.click();
    }

    public void openUpload() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UPLOAD_BUTTON)));
        upload_button.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DROP_BOX)));
    }

    public void uploadExcel() {
        driver.findElement(By.xpath(FILE_UPLOAD))
                .sendKeys(path + "/src/test/java/org/shl/selenium/va/test_data/Test_excel.xlsx");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILE_EXCEL)));
    }

    public void uploadDocument() {
        driver.findElement(By.xpath(FILE_UPLOAD))
                .sendKeys(path + "/src/test/java/org/shl/selenium/va/test_data/Test_doc.docx");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILE_DOC)));
    }

    public void uploadPdf() {
        driver.findElement(By.xpath(FILE_UPLOAD))
                .sendKeys(path + "/src/test/java/org/shl/selenium/va/test_data/Test_pdf.pdf");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILE_PDF)));
    }

    public void uploadPowerPoint() {
        driver.findElement(By.xpath(FILE_UPLOAD))
                .sendKeys(path + "/src/test/java/org/shl/selenium/va/test_data/Test_pp.pptx");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILE_PP)));
    }

    public void uploadExistingFile() {
        driver.findElement(By.xpath(FILE_UPLOAD))
                .sendKeys(path + "/src/test/java/org/shl/selenium/va/test_data/Test_exist.docx");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EXISTING_FILE)));
        driver.findElement(By.xpath(FILE_UPLOAD))
                .sendKeys(path + "/src/test/java/org/shl/selenium/va/test_data/Test_exist.docx");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILE_EXIST)));
    }

    public String getExistingMessage() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILE_EXIST)));
        WebElement fileExist = driver.findElement(By.xpath(FILE_EXIST));
        return fileExist.getText();
    }

    public void closeExistMessage() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TRY_AGAIN)));
        try_again.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DROP_BOX)));
    }

    public WebElement checkMessageClosed() {
        return drop_box;
    }

    public void goToDropBox() {
        assertTrue(checkMessageClosed().isDisplayed());
    }

    public void uploadWrongFormatMessage() {
        driver.findElement(By.xpath(FILE_UPLOAD))
                .sendKeys(path + "/src/test/java/org/shl/selenium/va/test_data/wrong_format.PNG");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILE_EXIST)));
    }

    public String getWrongFormatMessage() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILE_EXIST)));
        WebElement fileWrong = driver.findElement(By.xpath(FILE_EXIST));
        return fileWrong.getText();
    }

    public void checkUploadedExcel() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SAVE_BUTTON)));
        save_button.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UPLOAD_BUTTON)));
        List<WebElement> docElements = getCandidateDocElements();
        for (WebElement e : docElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILE_EXCEL)));

    }

    public WebElement checkExcel() {
        return file_excel;
    }

    public void getUploadedExcel() {
        assertTrue(checkExcel().isDisplayed());
    }

    public void checkUploadedDoc() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SAVE_BUTTON)));
        save_button.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UPLOAD_BUTTON)));
        List<WebElement> docElements = getCandidateDocElements();
        for (WebElement e : docElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILE_DOC)));
    }

    public WebElement checkDocument() {
        return file_doc;
    }

    public void getUploadedDoc() {
        assertTrue(checkDocument().isDisplayed());
    }

    public void checkUploadedPdf() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SAVE_BUTTON)));
        save_button.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILE_PDF)));
    }

    public WebElement checkPDF() {
        return file_pdf;
    }

    public void getUploadedPDF() {
        assertTrue(checkPDF().isDisplayed());
    }

    public void checkUploadedPP() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SAVE_BUTTON)));
        save_button.click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UPLOAD_BUTTON)));
        List<WebElement> docElements = getCandidateDocElements();
        for (WebElement e : docElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FILE_PP)));
    }

    public WebElement checkPP() {
        return file_pp;
    }

    public void markFile() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FILE_OPTION)));
        file_option.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FILE_MARK)));
        file_mark.click();
    }

    public void getUploadedPP() {
        assertTrue(checkPP().isDisplayed());
    }

    public void getAllDocElements() {
        List<WebElement> docElements = getCandidateDocElements();
        for (WebElement e : docElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public List<WebElement> getCandidateDocElements() {
        List<WebElement> candidateDocElements = new ArrayList();
        candidateDocElements.add(page_button);
        candidateDocElements.add(timer);
        candidateDocElements.add(exit_button);
        candidateDocElements.add(upload_button);
        candidateDocElements.add(my_files);
        candidateDocElements.add(shared_files);
        candidateDocElements.add(marked_files);

        return candidateDocElements;
    }
}