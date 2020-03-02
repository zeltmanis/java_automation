package org.shl.selenium.va.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.shl.selenium.va.pages.candidate.CandidateEmailExercise;
import org.shl.selenium.va.pages.candidate.CandidateEmailIntro;
import org.shl.selenium.va.pages.candidate.landing.AnalysisPresentation;
import org.shl.selenium.va.pages.candidate.landing.StartTask;
import org.shl.selenium.va.pages.startpage.CognitoAuthDialog;
import org.shl.selenium.va.pages.WarningMessage;
import org.shl.selenium.va.pages.candidate.CandidateDocument;
import org.shl.selenium.va.test.TestMain;

public class CandidateEmailTests extends TestMain {

    private static final String SITE_TEST_USER = "candidate1";
    private static final String SITE_TEST_PASSWORD = "Password@1";

    // Page Objects
    private CandidateEmailIntro objCandidateEmailIntro;
    private CognitoAuthDialog objCognitoAuthDialog;
    private CandidateEmailExercise objCandidateEmailExercise;
    private CandidateDocument objCandidateDocument;
    private StartTask objStartTask;
    private AnalysisPresentation objAnalysisPresentation;
    private WarningMessage objWarningMessage;

    public CandidateEmailTests() {
        setTestUrl(CANDIDATE_URL);
    }

    /**
     * Test 1. Open URL 2. Enter username 3. Enter password 4. Click log-in 5. Click
     * to start Interview 1 6. Click Start button to start e-mail exercise 7. Check
     * page elements
     */
    @Test
    public void emailElementsTest() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.getCandidateAnalysisElements();
        objAnalysisPresentation.clickStart();
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        objCandidateEmailExercise.checkEmailElements();
    }

    /**
     * Test 1. Open URL 2. Enter username 3. Enter password 4. Click log-in 5. Click
     * to start Interview 1 6. Click Start button to start e-mail exercise 7. Click
     * Page button to move back to intro page 8. Click Page button to move to e-mail
     * page again
     */
    @Test
    public void emailGoBackTest() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.clickStart();
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        objCandidateEmailExercise.moveBack();
        objCandidateEmailIntro.checkPageElements();
        objCandidateEmailIntro.switchPage();
        objCandidateEmailExercise.checkEmailElements();
    }

    /**
     * Test to click exit and choose no to return to back to exercise 1. Open URL 2.
     * Enter username 3. Enter password 4. Click log-in 5. Click to start Interview
     * 1 6. Click Start button to start e-mail exercise 7. Click EXIT button 8.
     * Click NO button on warning screen
     */
    @Test
    public void cancelExitEmailExercise() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);
        objWarningMessage = new WarningMessage(driver);

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.clickStart();
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        objCandidateEmailExercise.clickExitButton();
        assertEquals("Are you sure that you want to finish this task?", objWarningMessage.getMessage());
        objWarningMessage.clickNo();
    }

    /**
     * Test to switch between Documents and Email 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click to start Interview 1 6. Click Start
     * button to start e-mail exercise 7. Click on Documents 8. Click on Email
     */
    @Test
    public void switchDocToEmail() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objCandidateDocument = new CandidateDocument(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.clickStart();
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        objCandidateEmailExercise.checkEmailElements();
        objCandidateEmailExercise.switchDocuments();
        objCandidateDocument.getAllDocElements();
        objCandidateDocument.openFiles();
        objCandidateEmailExercise.hoverMenu();
        objCandidateEmailExercise.switchEmail();
    }

    /**
     * Test to check elements for composing e-mail 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click to start Interview 1 6. Click Start
     * button to start e-mail exercise 7. Click compose e-mail 8. Check elements for
     * composing e-mail
     */
    @Test
    public void checkComposeEmailElements() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.clickStart();
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        objCandidateEmailExercise.composeEmail();
        objCandidateEmailExercise.checkComposeEmailElements();
    }

    /**
     * Test to open received e-mail and check elements 1. Open URL 2. Enter username
     * 3. Enter password 4. Click log-in 5. Click to start Interview 1 6. Click
     * Start button to start e-mail exercise 7. Click to open 1st received e-mail
     * anc check elements
     */
    @Test
    public void checkEmailElements() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.clickStart();
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        objCandidateEmailExercise.openEmailWithPDF();
        objCandidateEmailExercise.checkReceivedEmailElements();
    }

    /**
     * Test to open received e-mail and click back button to close it 1. Open URL 2.
     * Enter username 3. Enter password 4. Click log-in 5. Click to start Interview
     * 1 6. Click Start button to start e-mail exercise 7. Open received e-mail 8.
     * Click back button and close received e-mail
     */
    @Test
    public void closeReceivedEmail() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.clickStart();
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        objCandidateEmailExercise.openEmail();
        objCandidateEmailExercise.closeEmail();
    }

    /**
     * Test to mark opened e-mail and check if e-mail appears under Marked e-mails
     * and unmark email 1. Open URL 2. Enter username 3. Enter password 4. Click
     * log-in 5. Click to start Interview 1 6. Click Start button to start e-mail
     * exercise 7. Open received e-mail 8. Click to mark e-mai 9. Click MAR KED
     * e-mail and check that marked e-mail is there 10. Click to unmark e-mail
     */
    @Test
    public void markReceivedEmail() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.clickStart();
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        objCandidateEmailExercise.openEmail();
        objCandidateEmailExercise.markOpenedEmail();
        // Thread sleep is because network is not working properly. The replay system
        // should be fixed.
        Thread.sleep(2000);
        objCandidateEmailExercise.openMarked();
        objCandidateEmailExercise.markedEmailCheck();
        objCandidateEmailExercise.unmarkOpenEmail();
    }

    /**
     * Test to open received e-mail and replay 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click to start Interview 1 6. Click Start
     * button to start e-mail exercise 7. Open received e-mail 8. Click on replay
     * button 9. Enter some text and click Send button 10. Under Sent items check
     * sent e-mail
     */
    @Test
    public void replayToEmail() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.clickStart();
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        objCandidateEmailExercise.openEmail();
        objCandidateEmailExercise.clickReplay();
        objCandidateEmailExercise.enterTextEmail("This is automated test");
        // Thread sleep is because network is not working properly. The replay system
        // should be fixed.
        Thread.sleep(2000);
        objCandidateEmailExercise.clickSend();
        objCandidateEmailExercise.openSent();
        objCandidateEmailExercise.getSentEmail();
    }

    /**
     * Test to replay to email, but don't send it and save it to draft 1. Open URL
     * 2. Enter username 3. Enter password 4. Click log-in 5. Click to start
     * Exercise 6. Click Start button to start e-mail exercise 7. Open received
     * e-mail 8. Click on replay button 9. Enter some text and click to close it 10.
     * Go to Drafts and check draft e-mail
     */
    @Test
    public void saveAsDraft() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.clickStart();
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        objCandidateEmailExercise.openEmail();
        objCandidateEmailExercise.clickReplay();
        objCandidateEmailExercise.enterTextEmail("This is automated test");
        // Thread sleep is because network is not working properly. The replay system
        // should be fixed.
        Thread.sleep(2000);
        objCandidateEmailExercise.getCandidateEmailElements();
        objCandidateEmailExercise.closeEmailBox();
        objCandidateEmailExercise.openDrafts();
        objCandidateEmailExercise.getSentEmail();
    }

    /**
     * Test to check unreaded e-mail icon and that it reduces 1. Open URL 2. Enter
     * username 3. Enter password 4. Click log-in 5. Click to start Interview 1 6.
     * Click Start button to start e-mail exercise 7. Check Icon for unreaded email
     * (21) 8. Open and close email 9. Check Icon for unreaded email (20)
     */
    @Test
    public void acheckUnreadedEmailIcon() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.clickStart();
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        assertEquals("22", objCandidateEmailExercise.unreadedEmailCount());
    }

    /**
     * Test to open e-mail and open attachment in the e-mail 1. Open URL 2. Enter
     * username 3. Enter password 4. Click log-in 5. Click to start Interview 1 6.
     * Click Start button to start e-mail exercise 7. Click to open e-mail with
     * attachment 8. Open attachment 9. Check attachment elements 10. Close
     * attachment
     */
    @Test
    public void openEmailAttachment() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.clickStart();
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        objCandidateEmailExercise.openEmailWithPDF();
        objCandidateEmailExercise.openAttachment();
        objCandidateEmailExercise.closeAttachment();
    }

    /**
     * Test open attachment without opening the e-mail 1. Open URL 2. Enter username
     * 3. Enter password 4. Click log-in 5. Click to start Interview 1 6. Click
     * Start button to start e-mail exercise 7. Click on attachment Icon to open
     * file 9. Check attachment elements
     */
    @Test
    public void openEmailFile() throws InterruptedException {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.clickStart();
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        objCandidateEmailExercise.openEmailFile();
    }
}