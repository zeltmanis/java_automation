package org.shl.selenium.va.test;

import org.junit.Test;
import org.shl.selenium.va.pages.candidate.CandidateEmailExercise;
import org.shl.selenium.va.pages.candidate.CandidateEmailIntro;
import org.shl.selenium.va.pages.candidate.CandidateLanding;
import org.shl.selenium.va.pages.candidate.landing.AnalysisPresentation;
import org.shl.selenium.va.pages.candidate.landing.StartTask;

public class CandidateEmailIntroTests extends TestMain {

	// Page Objects
	private CandidateLanding objCandidateLanding;
	private CandidateEmailIntro objCandidateEmailIntro;
	private CandidateEmailExercise objCandidateEmailExercise;
	private StartTask objStartTask;
	private AnalysisPresentation objAnalysisPresentation;
	public CandidateEmailIntroTests() {
		setTestUrl(CANDIDATE_URL);
	}

	/**
	 * Test to start exercise and check all elements 1. Open URL 2. Enter username
	 * 3. Enter password 4. Click log-in 5. Click to start Interview 1 6. Check all
	 * page elements
	 */
	@Test
	public void candidateExerciseElements() throws InterruptedException {
		objCandidateLanding = new CandidateLanding(driver);
		objCandidateEmailIntro = new CandidateEmailIntro(driver);
		objAnalysisPresentation = new AnalysisPresentation(driver);
		objStartTask = new StartTask(driver);

		objCandidateLanding.loginCandidate(driver);
		objAnalysisPresentation.clickStart();
		objStartTask.startExercise();
		objCandidateEmailIntro.checkPageElements();

	}

	/**
	 * Test to expand task1 and check elements 1. Open URL 2. Enter username 3.
	 * Enter password 4. Click log-in 5. Click to start Interview 1 6. Click to
	 * expand task1
	 */
	@Test
	public void expandTask1() throws InterruptedException {
		objCandidateLanding = new CandidateLanding(driver);
		objCandidateEmailIntro = new CandidateEmailIntro(driver);
		objAnalysisPresentation = new AnalysisPresentation(driver);
		objStartTask = new StartTask(driver);

		objCandidateLanding.loginCandidate(driver);
		objAnalysisPresentation.clickStart();
		objStartTask.startExercise();
		objCandidateEmailIntro.expandTask1();
		objCandidateEmailIntro.getTask1Text();

	}

	/**
	 * Test to expand task1 and check elements 1. Open URL 2. Enter username 3.
	 * Enter password 4. Click log-in 5. Click to start Interview 1 6. Click to
	 * expand task1
	 */
	@Test
	public void expandTask2() throws InterruptedException {
		objCandidateLanding = new CandidateLanding(driver);
		objCandidateEmailIntro = new CandidateEmailIntro(driver);
		objAnalysisPresentation = new AnalysisPresentation(driver);
		objStartTask = new StartTask(driver);

		objCandidateLanding.loginCandidate(driver);
		objAnalysisPresentation.clickStart();
		objStartTask.startExercise();
		objCandidateEmailIntro.getTask2Text();

	}

	/**
	 * Test to check that candidate email exercise start button changes to continue
	 * 1. Open URL 2. Enter username 3. Enter password 4. Click log-in 5. Click to
	 * start Interview 1 6. Check that button is called Start 7. Start exercise 8.
	 * Move back to Intro page 9. Check that button is called Continue
	 */
	@Test
	public void candidateContinueEmail() throws InterruptedException {
		objCandidateLanding = new CandidateLanding(driver);
		objCandidateEmailIntro = new CandidateEmailIntro(driver);
		objCandidateEmailExercise = new CandidateEmailExercise(driver);
		objAnalysisPresentation = new AnalysisPresentation(driver);
		objStartTask = new StartTask(driver);

		objCandidateLanding.loginCandidate(driver);
		objAnalysisPresentation.clickStart();
		objStartTask.startExercise();
		objCandidateEmailIntro.checkStartButton();
		objCandidateEmailIntro.startExercise();
		objCandidateEmailExercise.moveBack();
		objCandidateEmailIntro.getContinueButton();
	}

}
