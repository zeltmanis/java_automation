package org.shl.selenium.va.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.shl.selenium.va.pages.WarningMessage;
import org.shl.selenium.va.pages.cms.CMSLanding;
import org.shl.selenium.va.pages.cms.exercises.CMSExercisesLanding;
import org.shl.selenium.va.pages.cms.exercises.CMSExercisesPopUp;
import org.shl.selenium.va.pages.cms.exercises.createnew.CMSDocuments;
import org.shl.selenium.va.pages.cms.exercises.createnew.CMSExercisesCreateNew;

public class CMSDocumentsTests extends CmsTestMain {

    // Page Objects
    private CMSLanding objCMSLanding;
    private CMSExercisesPopUp objCMSExercisesPopUp;
    private CMSExercisesLanding objCMSExercisesLanding;
    private CMSExercisesCreateNew objCMSExercisesCreateNew;
    private CMSDocuments objCMSDocuments;
    private WarningMessage objWarningMessage;

    public CMSDocumentsTests() {
        setTestUrl(CMS_URL);
    }

    /**
     * Test to check - choose files for exercise. 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click on Exercises 6. Click Create New 7.
     * Enter exercises name 9. Click next button 10. Click Documents 11. Click
     * choose from files 12. Check elements 13. Close pop-up
     */
    @Test
    public void checkDocumentsChooseFiles() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSDocuments = new CMSDocuments(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickDocuments();
        objCMSDocuments.clickChooseFiles();
        objCMSDocuments.clickClose();
    }

    /**
     * Test to check discard created folder under Documents. 1. Open URL 2. Enter
     * username 3. Enter password 4. Click log-in 5. Click on Exercises 6. Click
     * Create New 7. Enter exercises name 9. Click next button 10. Click Documents
     * 11. Click Create folder 12. Check elements 13. Enter folder name 14.Click
     * Discard changes
     */
    @Test
    public void checkDocumentsCreateFolder() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSDocuments = new CMSDocuments(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickDocuments();
        objCMSDocuments.clickCreateFolder();
        objCMSDocuments.enterFolderName();
        objCMSDocuments.clickDiscardChanges();
    }

    /**
     * Test to create folder and save under Documents. 1. Open URL 2. Enter username
     * 3. Enter password 4. Click log-in 5. Click on Exercises 6. Click Create New
     * 7. Enter exercises name 9. Click next button 10. Click Documents 11. Click
     * Create folder 12. Check elements 13. Enter folder name 14. Click save and
     * check that it is saved
     */
    @Test
    public void createDocumentsFolder() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSDocuments = new CMSDocuments(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickDocuments();
        objCMSDocuments.clickCreateFolder();
        objCMSDocuments.enterFolderName();
        objCMSDocuments.clickSaveChanges();
    }

    /**
     * Test to create folder and delete it. 1. Open URL 2. Enter username 3. Enter
     * password 4. Click log-in 5. Click on Exercises 6. Click Create New 7. Enter
     * exercises name 9. Click next button 10. Click Documents 11. Click Create
     * folder 12. Check elements 13. Enter folder name 14. Click save and check that
     * it is saved 15. Click option 16. Click REMOVE button 17. Check warning msg
     * 18. Click No button 19. Click option and remove 20. Click Yes button 21.
     * Check that folder is deleted
     */
    @Test
    public void deleteDocumentFolder() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSDocuments = new CMSDocuments(driver);
        objWarningMessage = new WarningMessage(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickDocuments();
        objCMSDocuments.clickCreateFolder();
        objCMSDocuments.enterFolderName();
        objCMSDocuments.clickSaveChanges();
        objCMSDocuments.clickOptions();
        objCMSDocuments.clickRemove();
        assertEquals("Are you sure you want to delete this folder?", objWarningMessage.getMessage());
        objWarningMessage.clickNo();
        objCMSDocuments.clickOptions();
        objCMSDocuments.clickRemove();
        objWarningMessage.clickYes();
        objCMSDocuments.checkRemoved();
    }

    /**
     * Test to edit folder name for Document. 1. Open URL 2. Enter username 3. Enter
     * password 4. Click log-in 5. Click on Exercises 6. Click Create New 7. Enter
     * exercises name 9. Click next button 10. Click Documents 11. Click Create
     * folder 12. Check elements 13. Enter folder name 14. Click save and check that
     * it is saved 15. Click option 16. Click edit 17. Delete and enter new name 18.
     * Save it and check that new names is saved
     * 
     */
    @Test
    public void editDocumentFolder() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSDocuments = new CMSDocuments(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickDocuments();
        objCMSDocuments.clickCreateFolder();
        objCMSDocuments.enterFolderName();
        objCMSDocuments.clickSaveChanges();
        objCMSDocuments.clickOptions();
        objCMSDocuments.clickEdit();
        objCMSDocuments.clearFolderName();
        objCMSDocuments.enterFolderName();
        objCMSDocuments.clickSaveChanges();

    }

    /**
     * Test to add a file in folder 1. Open URL 2. Enter username 3. Enter password
     * 4. Click log-in 5. Click on Exercises 6. Click Create New 7. Enter exercises
     * name 9. Click next button 10. Click Documents 11. Click Create folder 12.
     * Check elements 13. Enter folder name. 14. Click Choose from files 15. Add a
     * file 16. Save folder 17. Click edit folder and check that file is still there
     */
    @Test
    public void addFileToFolder() throws InterruptedException {

        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSDocuments = new CMSDocuments(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickDocuments();
        objCMSDocuments.clickCreateFolder();
        objCMSDocuments.enterFolderName();
        objCMSDocuments.clickChooseFolderFile();
        objCMSDocuments.selectFileToFolder();
        objCMSDocuments.clickSaveChanges();
        objCMSDocuments.clickOptions();
        objCMSDocuments.clickEdit();
        objCMSDocuments.checkAddedFileInFolder();

    }

    /**
     * Test add and remove file in Document 1. Open URL 2. Enter username 3. Enter
     * password 4. Click log-in 5. Click on Exercises 6. Click Create New 7. Enter
     * exercises name 9. Click next button 10. Click Documents 11. Click choose from
     * file 12. Choose file and add 13. Check that file is added 14. Click options
     * and remove 15. Check that file is removed
     */
    @Test
    public void addFileToDocument() throws InterruptedException {

        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSDocuments = new CMSDocuments(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickDocuments();
        objCMSDocuments.clickChooseFiles();
        objCMSDocuments.selectFile();
        objCMSDocuments.removeFile();

    }
}