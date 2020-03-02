package org.shl.selenium.va.test;

import org.junit.Test;
import org.shl.selenium.va.pages.WarningMessage;
import org.shl.selenium.va.pages.cms.CMSLanding;
import org.shl.selenium.va.pages.cms.exercises.CMSExercisesLanding;
import org.shl.selenium.va.pages.cms.exercises.CMSExercisesPopUp;
import org.shl.selenium.va.pages.cms.exercises.createnew.CMSEmailContent;
import org.shl.selenium.va.pages.cms.exercises.createnew.CMSExercisesCreateNew;
import static org.junit.Assert.assertEquals;

public class CMSEmailContentTests extends CmsTestMain {

    // Page Objects
    private CMSLanding objCMSLanding;
    private CMSExercisesPopUp objCMSExercisesPopUp;
    private CMSExercisesLanding objCMSExercisesLanding;
    private CMSExercisesCreateNew objCMSExercisesCreateNew;
    private CMSEmailContent objCMSEmailContent;
    private WarningMessage objWarningMessage;

    public CMSEmailContentTests() {
        setTestUrl(CMS_URL);
    }

    /**
     * Test to create and add email to exercise. 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click on Exercises 6. Click Create New 7.
     * Enter exercises name 9. Click next button 10. Click email content 11. Check
     * pop-up elements 12. Enter from 13. Enter subject 14. Enter body 15. Save
     * changes 16. Check that e-mail is added 17. Check sender and subject
     */
    @Test
    public void addEmail() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSEmailContent = new CMSEmailContent(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickEmailContent();
        objCMSEmailContent.clickAddEmail();
        objCMSEmailContent.enterFrom("John Doe");
        objCMSEmailContent.enterSubject("Test email 123!");
        objCMSEmailContent.enterEmailBody("Sample text 123!");
        objCMSEmailContent.clickSave();
        assertEquals("John Doe", objCMSEmailContent.getEmailFrom());
        assertEquals("Test email 123!", objCMSEmailContent.getEmailSubject());
    }

    /**
     * Test to create and add email to exercise. 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click on Exercises 6. Click Create New 7.
     * Enter exercises name 9. Click next button 10. Click email content 11. Check
     * pop-up elements 12. Enter from 13. Enter subject 14. Enter body 15. Save
     * changes 16. Check that e-mail is added 17. Check sender and subject 18. Click
     * e-mail options 19.Click remove 20. Click no 21. Check email not deleted 22.
     * click Options 23. Click remove 24. Click Yes 25. Check email is deleted.
     */
    @Test
    public void deleteEmail() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSEmailContent = new CMSEmailContent(driver);
        objWarningMessage = new WarningMessage(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickEmailContent();
        objCMSEmailContent.clickAddEmail();
        objCMSEmailContent.enterFrom("Jane Doe");
        objCMSEmailContent.enterSubject("Delete this email");
        objCMSEmailContent.enterEmailBody("Sample text 123!");
        objCMSEmailContent.clickSave();
        assertEquals("Jane Doe", objCMSEmailContent.getEmailFrom());
        assertEquals("Delete this email", objCMSEmailContent.getEmailSubject());
        objCMSEmailContent.openEmailOptions();
        objCMSEmailContent.clickRemove();
        assertEquals("Are you sure you want to delete this email?", objWarningMessage.getMessage());
        objWarningMessage.clickNo();
        assertEquals("Delete this email", objCMSEmailContent.getEmailSubject());
        objCMSEmailContent.openEmailOptions();
        objCMSEmailContent.clickRemove();
        objWarningMessage.clickYes();
        objCMSEmailContent.checkEmailDeleted();
    }

    /**
     * Test to create email with attachment and add to exercise. 1. Open URL 2.
     * Enter username 3. Enter password 4. Click log-in 5. Click on Exercises 6.
     * Click Create New 7. Enter exercises name 9. Click next button 10. Click email
     * content 11. Check pop-up elements 12. Enter from 13. Enter subject 14. Click
     * to add attachment 15. Choose attachment 16. Add chosen attachment 17. Check
     * that attachment is present 18. Save created e-mail 19. Check that Attachment
     * is present in created e-mail.
     */
    @Test
    public void addEmailWithPdf() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSEmailContent = new CMSEmailContent(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickEmailContent();
        objCMSEmailContent.clickAddEmail();
        objCMSEmailContent.enterFrom("John Doe");
        objCMSEmailContent.enterSubject("Test email 123!");
        objCMSEmailContent.enterEmailBody("Sample text 123!");
        objCMSEmailContent.clickAddAttachment();
        objCMSEmailContent.selectAttachment();
        objCMSEmailContent.clickAddFiles();
        assertEquals("AWS_Appsync.pdf", objCMSEmailContent.getAttachment());
        objCMSEmailContent.clickSave();
        assertEquals("AWS_Appsync.pdf", objCMSEmailContent.getAttachment());
    }

    /**
     * Test to edit email and remove attachment. 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click on Exercises 6. Click Create New 7.
     * Enter exercises name 9. Click next button 10. Click email content 11. Check
     * pop-up elements 12. Enter from 13. Enter subject 14. Click to add attachment
     * 15. Choose attachment 16. Add chosen attachment 17. Check that attachment is
     * present 18. Save created e-mail 19. Check that Attachment is present in
     * created e-mail. 20. Click options and edit 21. Change from and subject 22.
     * Remove attachment 23. Save changes 24. Check that from, subject changed and
     * attachment removed
     */
    @Test
    public void editEmailRemovePdf() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSExercisesLanding = new CMSExercisesLanding(driver);
        objCMSExercisesPopUp = new CMSExercisesPopUp(driver);
        objCMSExercisesCreateNew = new CMSExercisesCreateNew(driver);
        objCMSEmailContent = new CMSEmailContent(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openExercises();
        objCMSExercisesLanding.clickCreateNew();
        objCMSExercisesPopUp.exerciseName();
        objCMSExercisesPopUp.clickNext();
        objCMSExercisesCreateNew.clickEmailContent();
        objCMSEmailContent.clickAddEmail();
        objCMSEmailContent.enterFrom("John Doe");
        objCMSEmailContent.enterSubject("Test email 123!");
        objCMSEmailContent.enterEmailBody("Sample text 123!");
        objCMSEmailContent.clickAddAttachment();
        objCMSEmailContent.selectAttachment();
        objCMSEmailContent.clickAddFiles();
        assertEquals("AWS_Appsync.pdf", objCMSEmailContent.getAttachment());
        objCMSEmailContent.clickSave();
        assertEquals("AWS_Appsync.pdf", objCMSEmailContent.getAttachment());
        objCMSEmailContent.openEmailOptions();
        objCMSEmailContent.clickEdit();
        objCMSEmailContent.enterFrom("Mike Tyson");
        objCMSEmailContent.enterSubject("Edit e-mail");
        objCMSEmailContent.enterEmailBody("New text");
        objCMSEmailContent.removeAttachment();
        objCMSEmailContent.checkRemovedAttachment();
        objCMSEmailContent.clickSave();
        assertEquals("Mike Tyson", objCMSEmailContent.getEmailFrom());
        assertEquals("Edit e-mail", objCMSEmailContent.getEmailSubject());
        objCMSEmailContent.checkRemovedAttachment();

    }

}