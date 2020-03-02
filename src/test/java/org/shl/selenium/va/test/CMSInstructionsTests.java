package org.shl.selenium.va.test;

import org.junit.Test;
import org.shl.selenium.va.pages.cms.CMSLanding;
import org.shl.selenium.va.pages.cms.exercises.CMSExercisesLanding;
import org.shl.selenium.va.pages.cms.exercises.CMSExercisesPopUp;
import org.shl.selenium.va.pages.cms.exercises.createnew.CMSExercisesCreateNew;
import org.shl.selenium.va.pages.cms.exercises.createnew.CMSInstructions;

import static org.junit.Assert.assertEquals;

public class CMSInstructionsTests extends CmsTestMain {

    // Page Objects
    private CMSLanding objCMSLanding;
    private CMSExercisesPopUp objCMSExercisesPopUp;
    private CMSExercisesLanding objCMSExercisesLanding;
    private CMSExercisesCreateNew objCMSExercisesCreateNew;
    private CMSInstructions objCMSInstructions;

    public CMSInstructionsTests() {
        setTestUrl(CMS_URL);
    }

    /**
     * Test to get Add Step Headline and Body warning msg in Instructions and Create
     * button is Disabled. 1. Open URL 2. Enter username 3. Enter password 4. Click
     * log-in 5. Click on Exercises 6. Click Create New 7. Enter exercises name 9.
     * Click next button 10.Click on Instruction 11. Fill out Headline and Overview
     * 12. Click Add steps 13. Click in Body and get Headline warning, 14. Click in
     * Headline and get Body warning 15. Check that Create button is disabled
     */
    @Test
    public void getInstructionStepWarning() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSInstructions = new CMSInstructions(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickIntructions();
        objCMSInstructions.enterHeadline();
        objCMSInstructions.enterOverview();
        objCMSInstructions.addSteps();
        assertEquals("Headline is mandatory", objCMSInstructions.getStepHeadlineWarning());
        assertEquals("Body is mandatory", objCMSInstructions.getStepBodyWarning());
        objCMSInstructions.createButtonDisabled();
    }

    /**
     * Test to add step in Instructions. 1. Open URL 2. Enter username 3. Enter
     * password 4. Click log-in 5. Click on Exercises 6. Click Create New 7. Enter
     * exercises name 9. Click next button 10.Click on Instruction 11. Fill out
     * Headline and Overview 12. Click Add steps 13. Fill out header 14. Fill out
     * boy. 15. Click create 16. Check that elements on the step match
     */
    @Test
    public void addStep() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSInstructions = new CMSInstructions(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickIntructions();
        objCMSInstructions.enterHeadline();
        objCMSInstructions.enterOverview();
        objCMSInstructions.addSteps();
        objCMSInstructions.enterStepHeadline();
        objCMSInstructions.enterBody();
        objCMSInstructions.clickCreate();
        objCMSInstructions.checkStepElements();

    }

    /**
     * Test to add step in Instructions and remove it. 1. Open URL 2. Enter username
     * 3. Enter password 4. Click log-in 5. Click on Exercises 6. Click Create New
     * 7. Enter exercises name 9. Click next button 10.Click on Instruction 11. Fill
     * out Headline and Overview 12. Click Add steps 13. Fill out header 14. Fill
     * out boy. 15. Click create 16. Check that elements on the step match 17. Click
     * Options 18. Click remove 19. Click NO in msg and check that step is not
     * deleted 20. Repeat remove and click Yes in msg 21. Check that step is removed
     */
    @Test
    public void removeStep() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSInstructions = new CMSInstructions(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickIntructions();
        objCMSInstructions.enterHeadline();
        objCMSInstructions.enterOverview();
        objCMSInstructions.addSteps();
        objCMSInstructions.enterStepHeadline();
        objCMSInstructions.enterBody();
        objCMSInstructions.clickCreate();
        objCMSInstructions.checkStepElements();
        objCMSInstructions.cancelReoveStep();
        objCMSInstructions.removeStep();

    }

    /**
     * Test for edit existing step in Instructions 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click on Exercises 6. Click Create New 7.
     * Enter exercises name 9. Click next button 10.Click on Instruction 11. Fill
     * out Headline and Overview 12. Click Add steps 13. Fill out header 14. Fill
     * out boy. 15. Click create 16. Check that elements on the step match 17. Click
     * Options. 18. Click Edit 19. Update headline and body 20. Click save and check
     * that changes are saved.
     */
    @Test
    public void editExistingStep() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSInstructions = new CMSInstructions(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickIntructions();
        objCMSInstructions.enterHeadline();
        objCMSInstructions.enterOverview();
        objCMSInstructions.addSteps();
        objCMSInstructions.enterStepHeadline();
        objCMSInstructions.enterBody();
        objCMSInstructions.clickCreate();
        objCMSInstructions.checkStepElements();
        objCMSInstructions.editStep();
        objCMSInstructions.enterStepHeadline();
        objCMSInstructions.enterBody();
        objCMSInstructions.clickSaveChanges();
    }

}
