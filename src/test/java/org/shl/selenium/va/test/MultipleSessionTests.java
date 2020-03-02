package org.shl.selenium.va.test;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.shl.selenium.va.pages.WarningMessage;
import org.shl.selenium.va.pages.candidate.CandidateDocument;
import org.shl.selenium.va.pages.candidate.CandidateEmailExercise;
import org.shl.selenium.va.pages.candidate.CandidateEmailIntro;
import org.shl.selenium.va.pages.candidate.CandidateLanding;
import org.shl.selenium.va.pages.reviewer.ExerciseReview;
import org.shl.selenium.va.pages.reviewer.Interview;
import org.shl.selenium.va.pages.reviewer.InterviewPrepPage;
import org.shl.selenium.va.pages.reviewer.InterviewReview;
import org.shl.selenium.va.pages.reviewer.Landing;
import org.shl.selenium.va.pages.reviewer.landing.ExerciseTask;
import org.shl.selenium.va.pages.startpage.CognitoAuthDialog;
import org.shl.selenium.va.pages.candidate.landing.AnalysisPresentation;
import org.shl.selenium.va.pages.candidate.landing.StartTask;
import org.shl.selenium.va.test.TestMain;

import static org.junit.Assert.assertEquals;

public class MultipleSessionTests {

	// Test Credentials for Reviewer and Candidate
	private static final String SITE_TEST_USER = "reviewer1";
	private static final String SITE_TEST_PASSWORD = "Password@1";
	private static final String SITE_TEST_CANDIDATE = "candidate1";
	private static final String SITE_TEST_PASSWORD_CANDIDATE = "Password@1";

	private String testUrl;
	private WebDriver driver;
	private WebDriver driver2;

	// Page Objects
	private CognitoAuthDialog objCognitoAuthDialog;
	private Landing objLanding;
	private CandidateLanding objCandidateLanding;
	private InterviewPrepPage objInterviewPrepPage;
	private CandidateEmailIntro objCandidateEmailIntro;
	private CandidateEmailExercise objCandidateEmailExercise;
	private InterviewReview objInterviewReview;
	private CandidateDocument objCandidateDocument;
	private ExerciseReview objExerciseReview;
	private StartTask objStartTask;
	private AnalysisPresentation objAnalysisPresentation;
	private ExerciseTask objExerciseTask;
	private Interview objInterview;
	private WarningMessage objWarningMessage;
	private WarningMessage objWarningMessage2;
	private TestMain objTestMain;

	@Before
	public void prepare() throws ParseException {
		objTestMain = new TestMain();
		objTestMain.assignExercise();

		new TestMain();
		// Code to call out Reviewer page
		testUrl = TestMain.REVIEWER_URL;

		System.setProperty("webdriver.gecko.driver", TestMain.WEBDRIVER);

		// Set Firefox Headless mode as TRUE
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(TestMain.getHeadlessEnabled());
		options.addPreference("permissions.default.microphone", 1);
		options.addPreference("permissions.default.camera", 1);

		// Instantiate Web Driver
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(50, SECONDS);
		driver.get(testUrl);
		driver.manage().window().maximize();

		// Code to call out Candidate page
		testUrl = TestMain.CANDIDATE_URL;

		System.setProperty("webdriver.gecko.driver", TestMain.WEBDRIVER);

		// Set Firefox Headless mode as TRUE
		FirefoxOptions options2 = new FirefoxOptions();
		options2.setHeadless(TestMain.getHeadlessEnabled());
		options2.addPreference("permissions.default.microphone", 1);
		options2.addPreference("permissions.default.camera", 1);

		// Instantiate Web Driver
		driver2 = new FirefoxDriver(options2);
		driver2.manage().timeouts().implicitlyWait(50, SECONDS);
		driver2.get(testUrl);
		driver2.manage().window().maximize();
	}

	/**
	 * Here the Reviewer is logging in into Reviewer page.
	 */
	public void loginUser() throws InterruptedException {
		objCognitoAuthDialog = new CognitoAuthDialog(driver);
		objLanding = new Landing(driver);

		// Verify Cognito Form before login
		assertTrue("VA Cognito Login page logo should be visible", objCognitoAuthDialog.getCognitoLogo().isDisplayed());

		assertTrue("The page title should be changed as expected",
				objCognitoAuthDialog.getLoginTitle().equals("Signin"));

		// Login to the VA Tool
		objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);

		// Verify that we are on Landing page
		await().atMost(5, SECONDS).until(() -> {
			return "SHL reviewer".equals(objLanding.getTitle());
		});
		Assertions.assertThat(objLanding.getTitle()).isEqualTo("SHL reviewer");
		assertTrue("VA Landing page logo should be visible", objLanding.getPageLogo().isDisplayed());
	}

	/**
	 * Here is the log in for Candidate to log in in candidate page.
	 */
	public void loginCandidate(WebDriver driver2) throws InterruptedException {
		loginCandidate(driver2, SITE_TEST_CANDIDATE, SITE_TEST_PASSWORD_CANDIDATE);
	}

	/**
	 * Here is the log in for Candidate to log in in candidate page.
	 */
	public void loginCandidate(WebDriver driver2, String candidate, String password) throws InterruptedException {
		objCognitoAuthDialog = new CognitoAuthDialog(driver2);
		objCandidateLanding = new CandidateLanding(driver2);

		// Verify Cognito Form before login
		assertTrue("VA Cognito Login page logo should be visible", objCognitoAuthDialog.getCognitoLogo().isDisplayed());

		assertTrue("The page title should be changed as expected",
				objCognitoAuthDialog.getLoginTitle().equals("Signin"));

		// Login to the VA Tool
		objCognitoAuthDialog.loginToVA(candidate, password);

		// Verify that we are on Landing page
		await().atMost(5, SECONDS).until(() -> {
			return "SHL candidate".equals(objCandidateLanding.getTitle());
		});
		Assertions.assertThat(objCandidateLanding.getTitle()).isEqualTo("SHL candidate");
		// assertTrue("VA Landing page logo should be visible",
		// objCandidateLanding.getPageLogo().isDisplayed());
	}

	/**
	 * Test to check if Reviewer sees Candidate sent e-mail and uploaded document
	 * under "Exercise" 1. Log in as candidate 2. Start exercise 3. Replay to email
	 * 4. Go to documents 5. Upload PDF 6. Log in as Reviewer 7. Open Review
	 * Exercise 8. Open e-mail Tab and check sent email 9. Open document Tab and
	 * check uploaded PDF
	 */
	@Test
	public void reviewExerciseElements() throws InterruptedException {
		objCandidateLanding = new CandidateLanding(driver2);
		objCandidateEmailIntro = new CandidateEmailIntro(driver2);
		objCandidateEmailExercise = new CandidateEmailExercise(driver2);
		objCandidateDocument = new CandidateDocument(driver2);
		objAnalysisPresentation = new AnalysisPresentation(driver2);
		objStartTask = new StartTask(driver2);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objLanding = new Landing(driver);
		objExerciseReview = new ExerciseReview(driver);
		objExerciseTask = new ExerciseTask(driver);
		objWarningMessage2 = new WarningMessage(driver2);

		loginCandidate(driver2, "candidate1", "Password@1");
		objAnalysisPresentation.clickStart();
		objStartTask.getStartTaskElements();
		assertEquals("Not started", objStartTask.getExerciseStatus());
		assertEquals("Scheduled", objStartTask.getVideoStatus());
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
		objCandidateEmailExercise.checkSentEmail();
		objCandidateEmailExercise.hoverMenu();
		objCandidateEmailExercise.switchDocuments();
		objCandidateDocument.openUpload();
		objCandidateDocument.uploadPdf();
		objCandidateDocument.checkUploadedPdf();
		objCandidateDocument.getUploadedPDF();
		objCandidateEmailExercise.clickExitButton();
		objWarningMessage2.clickYes();

		loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objExerciseTask.reviewExercise();
		// Thread sleep is because there is loader that does not have id and cannot be
		// tracked. So the test needs to wait to be loaded.
		Thread.sleep(2000);
		objExerciseReview.clickEmailTab();
		objExerciseReview.clickDocumentTab();
	}

	/**
	 * Test to check if Reviewer sees Candidate sent e-mail and uploaded document
	 * under "VIDEO" 1. Log in as candidate 2. Start exercise 3. Replay to email 4.
	 * Go to documents 5. Upload PDF 6. Log in as Reviewer 7. Open Review VIDEO 8.
	 * Open document Tab and check uploaded PDF 9. Open e-mail Tab and check sent
	 * email
	 * 
	 */
	@Test
	public void reviewerVideoElements() throws InterruptedException {
		objCandidateLanding = new CandidateLanding(driver2);
		objCandidateEmailIntro = new CandidateEmailIntro(driver2);
		objCandidateEmailExercise = new CandidateEmailExercise(driver2);
		objCandidateDocument = new CandidateDocument(driver2);
		objAnalysisPresentation = new AnalysisPresentation(driver2);
		objStartTask = new StartTask(driver2);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objLanding = new Landing(driver);
		objExerciseReview = new ExerciseReview(driver);
		objExerciseTask = new ExerciseTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);
		objWarningMessage2 = new WarningMessage(driver2);

		loginCandidate(driver2, "candidate1", "Password@1");
		objAnalysisPresentation.clickStart();
		objStartTask.getStartTaskElements();
		assertEquals("Not started", objStartTask.getExerciseStatus());
		assertEquals("Scheduled", objStartTask.getVideoStatus());
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
		objCandidateEmailExercise.checkSentEmail();
		objCandidateEmailExercise.hoverMenu();
		objCandidateEmailExercise.switchDocuments();
		objCandidateDocument.openUpload();
		objCandidateDocument.uploadPdf();
		objCandidateDocument.checkUploadedPdf();
		objCandidateDocument.getUploadedPDF();
		objCandidateEmailExercise.clickExitButton();
		objWarningMessage2.clickYes();

		loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objExerciseTask.startVideo();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objExerciseTask.startVideo();
		// Thread sleep is because there is loader that does not have id and cannot be
		// tracked. So the test needs to wait to be loaded.
		Thread.sleep(2000);
		objInterviewReview.clickDocumentTab();
		objInterviewReview.clickEmailTab();
	}

	@After
	public void tearDown() throws IOException {
		driver.quit();
		driver2.quit();
		objTestMain.removeExercise();

	}

}