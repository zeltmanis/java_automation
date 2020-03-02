package org.shl.selenium.va.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.shl.selenium.va.pages.candidate.CandidateEmailExercise;
import org.shl.selenium.va.pages.candidate.CandidateEmailIntro;
import org.shl.selenium.va.pages.candidate.landing.AnalysisPresentation;
import org.shl.selenium.va.pages.candidate.landing.StartTask;
import org.shl.selenium.va.pages.startpage.CognitoAuthDialog;
import org.shl.selenium.va.pages.candidate.CandidateDocument;

public class CandidateDocumentTests extends TestMain {

    private static final String SITE_TEST_USER = "candidate1";
    private static final String SITE_TEST_PASSWORD = "Password@1";

    // Page Objects
    private CandidateEmailIntro objCandidateEmailIntro;
    private CognitoAuthDialog objCognitoAuthDialog;
    private CandidateEmailExercise objCandidateEmailExercise;
    private CandidateDocument objCandidateDocument;
    private StartTask objStartTask;
    private AnalysisPresentation objAnalysisPresentation;

    public CandidateDocumentTests() {
        setTestUrl(CANDIDATE_URL);
    }

    /**
     * Test to go to Documents and check elements 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click to start Interview 1 6. Click
     * Startbutton to start e-mail exercise 7. Click on Documents 8. Check elements
     */
    @Test
    public void checkDocumentElements() throws InterruptedException {
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
        objCandidateEmailExercise.switchDocuments();
        objCandidateDocument.getCandidateDocElements();
    }

    /**
     * Test to go back from exercise 1. Open URL 2. Enter username 3. Enter password
     * 4. Click log-in 5. Click to start Interview 1 6. Click Start button to start
     * e-mail exercise 7. Click on Documents 8. Click Page button to go back to
     * intro 9. Check that Exercise Intro page is open 10. Click Page button to move
     * from Intro back to Document page
     */
    @Test
    public void goBackToIntro() throws InterruptedException {
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
        objCandidateDocument.goBack();
        objCandidateEmailIntro.checkPageElements();
        objCandidateEmailIntro.switchPage();
        objCandidateDocument.getCandidateDocElements();
    }

    /**
     * Test to upload Excel and confirm upload 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click to start Interview 1 6. Click Start
     * button to start e-mail exercise 7. Click on Documents 8. Click on Upload 9.
     * Upload Excel file 10. Save it 11. Confirm that excel file is uploaded
     */
    @Test
    public void uploadExcel() throws InterruptedException {
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
        objCandidateDocument.openUpload();
        objCandidateDocument.uploadExcel();
        objCandidateDocument.checkUploadedExcel();
        objCandidateDocument.getUploadedExcel();
    }

    /**
     * Test to upload Document file and confirm upload 1. Open URL 2. Enter username
     * 3. Enter password 4. Click log-in 5. Click to start Interview 1 6. Click
     * Start button to start e-mail exercise 7. Click on Documents 8. Click on
     * Upload 9. Upload Document file 10. Save it 11. Confirm that Document file is
     * uploaded
     */
    @Test
    public void uploadDocument() throws InterruptedException {
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
        objCandidateDocument.openUpload();
        objCandidateDocument.uploadDocument();
        objCandidateDocument.checkUploadedDoc();
        objCandidateDocument.getUploadedDoc();
    }

    /**
     * Test to upload PDF file and confirm upload 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click to start Interview 1 6. Click Start
     * button to start e-mail exercise 7. Click on Documents 8. Click on Upload 9.
     * Click on PDF 10. Click on Upload 11. Upload PDF file 12. Save it 13. Confirm
     * that PDF file is uploaded
     */
    @Test
    public void uploadPdf() throws InterruptedException {
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
        objCandidateDocument.openUpload();
        objCandidateDocument.uploadPdf();
        objCandidateDocument.checkUploadedPdf();
        objCandidateDocument.getUploadedPDF();
    }

    /**
     * Test to upload PowerPoint file and confirm upload 1. Open URL 2. Enter
     * username 3. Enter password 4. Click log-in 5. Click to start Interview 1 6.
     * Click Start button to start e-mail exercise 7. Click on Documents 8. Click on
     * Upload 9. Click on PDF 10. Click on Upload 11. Upload PowerPoint file 12.
     * Save it 13. Confirm that PP file is uploaded
     */
    @Test
    public void uploadPP() throws InterruptedException {
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
        objCandidateDocument.openUpload();
        objCandidateDocument.uploadPowerPoint();
        objCandidateDocument.checkUploadedPP();
        objCandidateDocument.getUploadedPP();
    }

    /**
     * Test to upload existing file and get warning message 1. Open URL 2. Enter
     * username 3. Enter password 4. Click log-in 5. Click to start Interview 1 6.
     * Click Start button to start e-mail exercise 7. Click on Documents 8. Click on
     * Upload 9. Get message that file exist 10. Click button try again 11. Check
     * that message is closed
     */
    @Test
    public void uploadExistingFileMsg() throws InterruptedException {
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
        objCandidateDocument.openUpload();
        objCandidateDocument.uploadExistingFile();
        assertEquals("Files with these names already exists Test_exist.docx, Test_exist.docx",
                objCandidateDocument.getExistingMessage());
        objCandidateDocument.goToDropBox();
    }

    /**
     * Test to upload wrong format file and get warning message 1. Open URL 2. Enter
     * username 3. Enter password 4. Click log-in 5. Click to start Interview 1 6.
     * Click Start button to start e-mail exercise 7. Click on Documents 8. Click on
     * Upload 9. Get message that file is in wrong format 10. Click button try again
     * 11. Check that message is closed
     */
    @Test
    public void uploadWrongFormatMsg() throws InterruptedException {
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
        objCandidateDocument.openUpload();
        objCandidateDocument.uploadWrongFormatMessage();
        assertEquals("We don’t support this file type wrong_format.PNG", objCandidateDocument.getWrongFormatMessage());
        objCandidateDocument.goToDropBox();
    }

    /**
     * Test to open Shared files 1. Open URL 2. Enter username 3. Enter password 4.
     * Click log-in 5. Click to start Interview 1 6. Click Start button to start
     * e-mail exercise 7. Click on Documents 8. Click on Shared Files 9. Check that
     * there are docs 10. Click on AWS folder 11. Check that
     */
    @Test
    public void openSharedFiles() throws InterruptedException {
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
        objCandidateDocument.openSharedFiles();
        objCandidateDocument.checkSharedFiles();
        objCandidateDocument.openFiles();
        objCandidateDocument.getSharedDoc();
    }

    /**
     * Test 1. Open URL 2. Enter username 3. Enter password 4. Click log-in 5. Click
     * to start Interview 1 6. Click Start button to start e-mail exercise 7. Click
     * on Documents 8. Click Marked files 9. Check that it contains marked file
     */
    @Test
    public void openMarkedFiles() {
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
        objCandidateDocument.markFile();
        objCandidateDocument.openMarkedFiles();
        objCandidateDocument.getSharedFiles();
    }
}