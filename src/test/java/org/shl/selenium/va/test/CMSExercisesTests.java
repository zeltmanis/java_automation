package org.shl.selenium.va.test;

import org.junit.Test;
import org.shl.selenium.va.pages.cms.CMSLanding;
import org.shl.selenium.va.pages.cms.exercises.CMSExercisesLanding;
import org.shl.selenium.va.pages.cms.exercises.CMSExercisesPopUp;
import org.shl.selenium.va.pages.cms.exercises.createnew.CMSExercisesCreateNew;
import org.shl.selenium.va.pages.cms.exercises.createnew.CMSGeneralSettings;
import static org.junit.Assert.assertEquals;

public class CMSExercisesTests extends CmsTestMain {

    // Page Objects
    private CMSLanding objCMSLanding;
    private CMSExercisesPopUp objCMSExercisesPopUp;
    private CMSExercisesLanding objCMSExercisesLanding;
    private CMSGeneralSettings objCMSGeneralSettings;
    private CMSExercisesCreateNew objCMSExercisesCreateNew;

    public CMSExercisesTests() {
        setTestUrl(CMS_URL);
    }

    /**
     * Test to open Exercises and check elements 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click on Exercises 6.Check elements
     */
    @Test
    public void checkExercisesElements() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
    }

    /**
     * Test to get create NEW pop up and close it. 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click on Exercises 6. Click Create New 7.
     * Check pop-up elements 8. Click close and get back to exercise landing page.
     */
    @Test
    public void closeCreatNewPopUp() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.closPopUp();
    }

    // /** Validation has been removed, it is allowed to make exercises with same
    // name.
    // * Test to get warning that exercises name already exist. 1. Open URL 2. Enter
    // * username 3. Enter password 4. Click log-in 5. Click on Exercises 6. Click
    // * Create New 7. Enter exercises name 8. Click next button 11. Click Save as
    // * Draft. 12. Click create new Exercise. 13. Enter the same exercise name 14.
    // * Check that warning appears 15.Check NEXT button is disabled
    // *
    // *
    // */
    // @Test
    // public void getExistingNameWarning() throws InterruptedException {
    // objCMSLanding = new CMSLanding(driver);
    // objCMSExercisesLanding = new CMSExercisesLanding(driver);
    // objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
    // objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);

    // objCMSLanding.loginCMS();
    // objCMSLanding.openExercises();
    // objCMSExercisesLanding.clickCreateNew();
    // objCMSExercisesPopUp.exerciseName();
    // objCMSExercisesPopUp.clickNext();
    // objCMSExercisesCreateNew.clickSaveAsDraft();
    // objCMSExercisesLanding.clickCreateNew();
    // objCMSExercisesPopUp.exerciseName();
    // assertEquals("This name already exists",
    // objCMSExercisesPopUp.getNameExist());
    // objCMSExercisesPopUp.nextButtonDisabled();
    // }

    /**
     * Test to start creating new Exercise and check head elements on Create New
     * page 1. Open URL 2. Enter username 3. Enter password 4. Click log-in 5. Click
     * on Exercises 6. Click Create New 7. Check that NEXT button is inactive 8.
     * Enter exercises name 9. Check that NEXT button is active 10. Click next
     * button 11. Check head elements in this page
     * 
     */
    @Test
    public void createNewExerciseHeadElements() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();

    }

    /**
     * Test to REMOVE exercise 1. Open URL 2. Enter username 3. Enter password 4.
     * Click log-in 5. Click on Exercises 6. Click Create New 7. Enter exercises
     * name 8. Click next button. 9. Click save as draft 10. Click Option on created
     * exercise 11. Click remove 12. Check that exercise is removed
     */
    @Test
    public void deleteExercise() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSGeneralSettings = new CMSGeneralSettings(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        String name = objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSGeneralSettings.getExerciseElements();
        objCMSExercisesCreateNew.clickSaveAsDraft();
        objCMSExercisesLanding.clickOptions(name);
        objCMSExercisesLanding.removeExercise(name);
    }

    /**
     * Test to edit existing exercise 1. Open URL 2. Enter username 3. Enter
     * password 4. Click log-in 5. Click on Exercises 6. Click Create New 7. Enter
     * exercises name 8. Click next button. 9. Click save as draft 10. Click Option
     * on created exercise 11.Click edit 12. Edit domain name. 13. Click save as
     * draft
     */
    @Test
    public void editExercise() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSGeneralSettings = new CMSGeneralSettings(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        String name = objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSGeneralSettings.getExerciseElements();
        objCMSGeneralSettings.selectLanguage();
        objCMSGeneralSettings.enterNameForEmail();
        objCMSGeneralSettings.enterNameForMeeting();
        objCMSGeneralSettings.enterDomainName();
        objCMSGeneralSettings.selectLevel();
        objCMSGeneralSettings.selectIndustry();
        objCMSGeneralSettings.selectType();
        objCMSExercisesCreateNew.clickSaveAsDraft();
        objCMSExercisesLanding.clickOptions(name);
        objCMSExercisesLanding.editExercise();
        objCMSGeneralSettings.enterDomainName();
        objCMSExercisesCreateNew.clickSaveAsDraft();
    }

    /**
     * test
     * 
     */
    @Test
    public void ratignTest() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();

    }

}