package org.shl.selenium.va.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.shl.selenium.va.utils.Utils;
import org.shl.selenium.va.pages.WarningMessage;
import org.shl.selenium.va.pages.reviewer.Interview;
import org.shl.selenium.va.pages.reviewer.InterviewPrepPage;
import org.shl.selenium.va.pages.reviewer.Landing;
import org.shl.selenium.va.pages.reviewer.landing.InterviewTask;
import org.shl.selenium.va.test.TestMain;

public class InterviewTests extends TestMain {

    // Page Objects
    private Landing objLanding;
    private InterviewPrepPage objInterviewPrepPage;
    private Interview objInterview;
    private InterviewTask objInterviewTask;
    private WarningMessage objWarningMessage;

    public InterviewTests() {
        setTestUrl(REVIEWER_URL);
    }

    /**
     * Test to check running interview elements 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Enter userID 6. Click search button 7.
     * Start interview2 8. Click to start video 9. Check all page elements
     */
    @Test
    public void checkInterviewElements() throws InterruptedException {
        objLanding = new Landing(driver);
        objInterviewPrepPage = new InterviewPrepPage(driver);
        objInterview = new Interview(driver);
        objInterviewTask = new InterviewTask(driver);

        objLanding.loginUser();
        objLanding.enterUserId("candidate1");
        objLanding.clickSearchButton();
        objInterviewTask.getReviewerInterviewElements();
        assertEquals("Scheduled", objInterviewTask.getVideoStatus());
        objInterviewTask.clickStart();
        objInterviewPrepPage.startVideo();
        objInterview.getInterviewElements();
    }

    /**
     * Test to check finish video message and buttons 1. Open URL 2. Enter username
     * 3. Enter password 4. Click log-in 5. Enter userID 6. Click search button 7.
     * Start interview2 8. Click to start video 9. Click to finish video interview
     * 10. Check the message 11. Click no and return to interview 12. Click to
     * finish video interview 13. Click yes - interview finished, user back to
     * landing page
     */
    @Test
    public void finishInterview() throws InterruptedException {
        objLanding = new Landing(driver);
        objInterviewPrepPage = new InterviewPrepPage(driver);
        objInterview = new Interview(driver);
        objInterviewTask = new InterviewTask(driver);
        objWarningMessage = new WarningMessage(driver);

        objLanding.loginUser();
        objLanding.enterUserId("candidate1");
        objLanding.clickSearchButton();
        objInterviewTask.getReviewerInterviewElements();
        assertEquals("Scheduled", objInterviewTask.getVideoStatus());
        objInterviewTask.clickStart();
        objInterviewPrepPage.startVideo();
        objInterview.clickFinishButton();
        assertEquals("Are you sure that you want to finish this task?", objWarningMessage.getMessage());
        objWarningMessage.clickNo();
        objInterview.clickFinishButton();
        objWarningMessage.clickYes();
        assertEquals("Completed", objInterviewTask.getVideoStatus());
        assertEquals("Review", objInterviewTask.getVideoButton());
    }

    /**
     * Test to create new tag in interview preparation screen and see it in
     * interview screen
     * 
     * 1. Open URL 2. Enter username 3. Enter password 4. Click log-in 5. Enter
     * userID 6. Click search button 7. Start interview2 8. Create and add Tags 9.
     * Start video 10. Check that created tags appear
     */
    @Test
    public void createTagForInterview() throws InterruptedException {
        objLanding = new Landing(driver);
        objInterviewPrepPage = new InterviewPrepPage(driver);
        objInterview = new Interview(driver);
        objInterviewTask = new InterviewTask(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        objLanding.loginUser();
        objLanding.enterUserId("candidate1");
        objLanding.clickSearchButton();
        objInterviewTask.getReviewerInterviewElements();
        objInterviewTask.clickStart();

        String[] tag = Utils.generateRandomWords(1);
        objInterviewPrepPage.enterTag(tag[0]);
        objInterviewPrepPage.addTag();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(@class, '') and text()='" + tag[0] + "']")));

        String[] tag2 = Utils.generateRandomWords(1);
        objInterviewPrepPage.enterTag(tag2[0]);
        objInterviewPrepPage.addTag();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(@class, '') and text()='" + tag2[0] + "']")));

        objInterviewPrepPage.startVideo();
        objInterview.getInterviewElements();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(@class, '') and text()='" + tag[0] + "']")));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[contains(@class, '') and text()='" + tag2[0] + "']")));
    }

    /**
     * Test for adding a feedback to interview video 1. Open URL 2. Enter username
     * 3. Enter password 4. Click log-in 5. Enter userID 6. Click search button 7.
     * Start interview2 8. Start video 9. Enter feedback and add it 10. Check that
     * feedback is added under video
     */
    @Test
    public void addFeedbackToInterview() throws InterruptedException {
        objLanding = new Landing(driver);
        objInterviewTask = new InterviewTask(driver);
        objInterviewPrepPage = new InterviewPrepPage(driver);
        objInterview = new Interview(driver);

        objLanding.loginUser();
        objLanding.enterUserId("candidate1");
        objLanding.clickSearchButton();
        objInterviewTask.getReviewerInterviewElements();
        objInterviewTask.clickStart();
        objInterviewPrepPage.startVideo();
        objInterview.enterFeedback("Automation Feedback");
        objInterview.getAddedFeedback();
    }

    /**
     * Test to delete added tag and feedback 1. Open URL 2. Enter username 3. Enter
     * password 4. Click log-in 5. Enter userID 6. Click search button 7. Start
     * interview2 8. Start video 9. Click on Tag to add it to video 10. Check that
     * Tag is added 11. Delete Tag
     */
    @Test
    public void deleteVideoTag() throws InterruptedException {
        objLanding = new Landing(driver);
        objInterviewTask = new InterviewTask(driver);
        objInterviewPrepPage = new InterviewPrepPage(driver);
        objInterview = new Interview(driver);

        objLanding.loginUser();
        objLanding.enterUserId("candidate1");
        objLanding.clickSearchButton();
        objInterviewTask.getReviewerInterviewElements();
        objInterviewTask.clickStart();
        objInterviewPrepPage.startVideo();
        objInterview.hoverTag();
        objInterview.addTag();
        objInterview.getVideoTag();
        objInterview.deleteTag();
    }
}