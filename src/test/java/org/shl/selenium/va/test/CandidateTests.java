package org.shl.selenium.va.test;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;
import org.shl.selenium.va.pages.WarningMessage;
import org.shl.selenium.va.pages.candidate.CandidateEmailExercise;
import org.shl.selenium.va.pages.candidate.CandidateEmailIntro;
import org.shl.selenium.va.pages.candidate.landing.AnalysisPresentation;
import org.shl.selenium.va.pages.candidate.landing.StartTask;
import org.shl.selenium.va.pages.startpage.CognitoAuthDialog;
import org.shl.selenium.va.utils.ApiExercise;

public class CandidateTests extends TestMain {

    private static final String SITE_TEST_USER = "candidate1";
    private static final String SITE_TEST_PASSWORD = "Password@1";

    // Page Objects
    private CandidateEmailIntro objCandidateEmailIntro;
    private CandidateEmailExercise objCandidateEmailExercise;
    private CognitoAuthDialog objCognitoAuthDialog;
    private StartTask objStartTask;
    private AnalysisPresentation objAnalysisPresentation;
    private WarningMessage objWarningMessage;
    private ApiExercise objApiExercise;

    public CandidateTests() {
        setTestUrl(CANDIDATE_URL);
    }

    /**
     * Test Multi task exercise and video statuses 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click to start Multi task exercise 6. Check
     * all elements 7. Start Email Exercise 8. Exit exercise 9. Open Multi task 10.
     * Check status on finished Email exercise 11. Check start button is now on
     * VIDEO exercise
     *
     * @throws IOException
     */
    @Test
    public void multiTaskExerciseStatus() {
        objCognitoAuthDialog = new CognitoAuthDialog(driver);
        objCandidateEmailIntro = new CandidateEmailIntro(driver);
        objCandidateEmailExercise = new CandidateEmailExercise(driver);
        objAnalysisPresentation = new AnalysisPresentation(driver);
        objStartTask = new StartTask(driver);
        objWarningMessage = new WarningMessage(driver);
        objApiExercise = new ApiExercise();

        objCognitoAuthDialog.loginToVA(SITE_TEST_USER, SITE_TEST_PASSWORD);
        objAnalysisPresentation.clickStart();
        objStartTask.getStartTaskElements();
        assertEquals("Not started", objStartTask.getExerciseStatus());
        assertEquals("Scheduled", objStartTask.getVideoStatus());
        objStartTask.startExercise();
        objCandidateEmailIntro.startExercise();
        objCandidateEmailExercise.clickExitButton();
        assertEquals("Are you sure that you want to finish this task?", objWarningMessage.getMessage());
        objWarningMessage.clickYes();
        assertEquals("Completed", objStartTask.getExerciseStatus());
        assertEquals("Scheduled", objStartTask.getVideoStatus());
        objStartTask.startMultiTaskVideo();
        objApiExercise.resetExercise(exercise_id);
        driver.navigate().refresh();
    }

}
