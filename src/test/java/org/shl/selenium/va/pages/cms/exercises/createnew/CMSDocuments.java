package org.shl.selenium.va.pages.cms.exercises.createnew;

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

public class CMSDocuments {

    private WebDriver driver;
    WebDriverWait wait;

    public CMSDocuments(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    private boolean isElementPresent(By xpath) {
        return false;
    }

    String[] tag = Utils.generateRandomWords(1);

    // Page element buttons
    private static final String CHOOSE_FILE = "//*[@data-testid='button-choose-from-files']";
    private static final String CREATE_FOLDER = "//*[@data-testid='button-create-folder']";

    // Page elements for folder
    private static final String OPTIONS = "/html/body/div[2]/div/div/div/form/div[2]/div[4]/div/div[2]/div[1]/div[1]";
    private static final String EDIT = "(//*[@data-testid='option'])[1]";
    private static final String REMOVE = "(//*[@data-testid='option'])[2]";

    // Page elements for file
    private static final String FILE_OPTION = "//*[@data-testid='panel-file-list']/../..//div[@tabindex='0']";
    private static final String FILE_REMOVE = "//div[text()='Remove']";

    // Choose from files pop-up elements
    private static final String NAME = "//*[@data-testid='title-name']";
    private static final String CLOSE = "//*[@data-testid='button-close']";
    private static final String ADD_FILES = "//*[@data-testid='button-next']";
    private static final String ADD_FILES_TO_FOLDER = "(//*[@data-testid='button-next'])[2]";
    private static final String CHECKBOX = "(//*[@data-testid='checkbox'])[2]";
    private static final String DELETE_FILE = "/html/body/div[5]/div/div/div/div[2]/div/div/svg[1]";
    private static final String FILE_NAME = "//div[text()='AWS_Appsync.pdf']";
    private static final String FOLDER_CHOOSE_FILE = "//*[@data-testid='modal-cms-folder']//*[@data-testid='button-choose-from-files']";

    // Create folder pop-up elements
    private static final String FOLDER_NAME = "//*[@data-testid='modal-cms-folder']//div[text()='Folder name']";
    private static final String NAME_BOX = "//*[@data-testid='modal-cms-folder']//input";
    private static final String DISCARD_CHANGES = "//*[@data-testid='button-close']";
    private static final String SAVE_CHANGES = "//*[@data-testid='button-next']";
    private static final String CHOOSE_FROM_FILE = "//*[@data-testid='modal-cms-folder']//*[@data-testid='button-choose-from-files']";

    // Page element buttons
    @FindBy(xpath = CHOOSE_FILE)
    WebElement choose_file;

    @FindBy(xpath = CREATE_FOLDER)
    WebElement create_folder;

    // Page elements for folder
    @FindBy(xpath = OPTIONS)
    WebElement options;

    @FindBy(xpath = EDIT)
    WebElement edit;

    @FindBy(xpath = REMOVE)
    WebElement remove;

    // Choose from files pop-up elements
    @FindBy(xpath = NAME)
    WebElement name;

    @FindBy(xpath = CLOSE)
    WebElement close;

    @FindBy(xpath = ADD_FILES)
    WebElement add_files;

    @FindBy(xpath = ADD_FILES_TO_FOLDER)
    WebElement add_files_to_folder;

    @FindBy(xpath = CHECKBOX)
    WebElement checkbox;

    @FindBy(xpath = DELETE_FILE)
    WebElement delete_file;

    @FindBy(xpath = FILE_NAME)
    WebElement file_name;

    @FindBy(xpath = FOLDER_CHOOSE_FILE)
    WebElement folder_choose_file;

    // Page elements for file
    @FindBy(xpath = FILE_OPTION)
    WebElement file_option;

    @FindBy(xpath = FILE_REMOVE)
    WebElement file_remove;

    // Create folder pop-up elements
    @FindBy(xpath = FOLDER_NAME)
    WebElement folder_name;

    @FindBy(xpath = NAME_BOX)
    WebElement name_box;

    @FindBy(xpath = DISCARD_CHANGES)
    WebElement discard_changes;

    @FindBy(xpath = SAVE_CHANGES)
    WebElement save_changes;

    public WebElement checkChooseFiles() {
        return choose_file;
    }

    public WebElement checkCreateFolder() {
        return create_folder;
    }

    public WebElement checkEdit() {
        return edit;
    }

    public void clickChooseFiles() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHOOSE_FILE)));
        choose_file.click();
        List<WebElement> fileElements = getChooseFilesElements();
        for (WebElement e : fileElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void clickClose() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CLOSE)));
        close.click();
        assertTrue(checkChooseFiles().isDisplayed());
    }

    public void clickDiscardChanges() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DISCARD_CHANGES)));
        discard_changes.click();
        assertTrue(checkCreateFolder().isDisplayed());
        assertTrue(!isElementPresent(By.xpath("//div[text()='" + tag[0] + "']")));
    }

    public void clickSaveChanges() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SAVE_CHANGES)));
        save_changes.click();
        assertTrue(checkCreateFolder().isDisplayed());
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + tag[0] + "']")));
    }

    public void clickCreateFolder() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE_FOLDER)));
        create_folder.click();
        List<WebElement> elements = getCreateFolderElements();
        for (WebElement e : elements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void clickOptions() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OPTIONS)));
        options.click();
        assertTrue(checkEdit().isDisplayed());
    }

    public void clickRemove() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(REMOVE)));
        remove.click();
    }

    public void clickEdit() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EDIT)));
        edit.click();
        List<WebElement> elements = getCreateFolderElements();
        for (WebElement e : elements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }

    }

    public void clearFolderName() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_BOX)));
        name_box.clear();
    }

    public void checkRemoved() {
        assertTrue(checkCreateFolder().isDisplayed());
        assertTrue(!isElementPresent(By.xpath("//div[text()='" + tag[0] + "']")));
    }

    public void textFolderName(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_BOX)));
        name_box.sendKeys(text);
    }

    public void enterFolderName() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_BOX)));
        textFolderName(tag[0]);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_BOX)));
    }

    public void clickChooseFolderFile() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FOLDER_CHOOSE_FILE)));
        folder_choose_file.click();
    }

    public void selectFile() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKBOX)));
        checkbox.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_FILES)));
        add_files.click();
        assertTrue(checkAddedFileInFolder().isDisplayed());
    }

    public void selectFileToFolder() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CHECKBOX)));
        checkbox.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_FILES_TO_FOLDER)));
        add_files_to_folder.click();
        assertTrue(checkAddedFileInFolder().isDisplayed());
    }

    public void removeFileFromFoledr() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DELETE_FILE)));
        delete_file.click();
        assertTrue(!isElementPresent(By.xpath("//div[text()='AWS_Appsync.pdf']")));
    }

    public void removeFile() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FILE_OPTION)));
        file_option.click();
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FILE_REMOVE)));
        file_remove.click();
        assertTrue(!isElementPresent(By.xpath("//div[text()='AWS_Appsync.pdf']")));
    }

    public WebElement checkAddedFileInFolder() {
        return file_name;
    }

    public List<WebElement> getChooseFilesElements() {
        List<WebElement> ChooseFilesElements = new ArrayList();
        ChooseFilesElements.add(name);
        ChooseFilesElements.add(close);
        ChooseFilesElements.add(add_files);

        return ChooseFilesElements;
    }

    public List<WebElement> getCreateFolderElements() {
        List<WebElement> createFolderElements = new ArrayList();
        createFolderElements.add(folder_name);
        createFolderElements.add(name_box);
        createFolderElements.add(discard_changes);
        createFolderElements.add(save_changes);

        return createFolderElements;
    }

}