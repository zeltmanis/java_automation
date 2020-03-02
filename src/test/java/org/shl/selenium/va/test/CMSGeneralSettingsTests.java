package org.shl.selenium.va.test;

import org.junit.Test;
import org.shl.selenium.va.pages.cms.CMSLanding;
import org.shl.selenium.va.pages.cms.exercises.CMSExercisesLanding;
import org.shl.selenium.va.pages.cms.exercises.CMSExercisesPopUp;
import org.shl.selenium.va.pages.cms.exercises.createnew.CMSExercisesCreateNew;
import org.shl.selenium.va.pages.cms.exercises.createnew.CMSGeneralSettings;

public class CMSGeneralSettingsTests extends CmsTestMain {

    // Page Objects
    private CMSLanding objCMSLanding;
    private CMSExercisesPopUp objCMSExercisesPopUp;
    private CMSExercisesLanding objCMSExercisesLanding;
    private CMSGeneralSettings objCMSGeneralSettings;
    private CMSExercisesCreateNew objCMSExercisesCreateNew;

    public CMSGeneralSettingsTests() {
        setTestUrl(CMS_URL);
    }

    /**
     * Test to check all elements for General settings 1. Open URL 2. Enter username
     * 3. Enter password 4. Click log-in 5. Click on Exercises 6. Click Create New
     * 7. Check that NEXT button is inactive 8. Enter exercises name 9. Check that
     * NEXT button is active 10. Click next button 11. Check head elements in this
     * page. 12. Check Exercise elements 13. Check Job elements 14. Check Date and
     * domain elements
     * 
     */
    @Test
    public void generalSettingsElementCheck() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSGeneralSettings = new CMSGeneralSettings(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSGeneralSettings.getExerciseElements();
        objCMSGeneralSettings.getJobElements();
        objCMSGeneralSettings.getDateElements();
    }

    /**
     * Test to check that fields are inactive when only Desktop simulation is
     * chosen. 1. Open URL 2. Enter username 3. Enter password 4. Click log-in 5.
     * Click on Exercises 6. Click Create New 7. Enter exercises name 8. Click next
     * button 9. Check head elements in this page. 10. Unchecked Meeting checkbox
     * 11. Check that Name of task for meeting is inactive
     */
    @Test
    public void inactiveFieldDesktopSim() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSGeneralSettings = new CMSGeneralSettings(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSGeneralSettings.getExerciseElements();
        objCMSGeneralSettings.onlyDesktopSimulation();
    }

    /**
     * Test to check that fields are inactive when only Meeting is chosen. 1. Open
     * URL 2. Enter username 3. Enter password 4. Click log-in 5. Click on Exercises
     * 6. Click Create New 7. Enter exercises name 8. Click next button 9. Check
     * head elements in this page. 10. Unchecked Desktop simulation 11. Check that
     * Name of task for meeting is inactive, todays date and time are inactive
     */
    @Test
    public void inactiveFieldsMeeting() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSGeneralSettings = new CMSGeneralSettings(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSGeneralSettings.getExerciseElements();
        objCMSGeneralSettings.onlyMeeting();
    }

    /**
     * Test to fill out all fields in General Settings 1. Open URL 2. Enter username
     * 3. Enter password 4. Click log-in 5. Click on Exercises 6. Click Create New
     * 7. Enter exercises name 8. Click next button 9. Check head elements in this
     * page. 10.Fill out all fields and dropdowns
     */
    @Test
    public void fillOutGeneralSettings() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSGeneralSettings = new CMSGeneralSettings(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
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

    }
}