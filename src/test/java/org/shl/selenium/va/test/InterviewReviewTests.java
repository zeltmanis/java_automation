package org.shl.selenium.va.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.shl.selenium.va.pages.WarningMessage;
import org.shl.selenium.va.pages.reviewer.Interview;
import org.shl.selenium.va.pages.reviewer.InterviewPrepPage;
import org.shl.selenium.va.pages.reviewer.InterviewReview;
import org.shl.selenium.va.pages.reviewer.Landing;
import org.shl.selenium.va.pages.reviewer.landing.InterviewTask;
import org.shl.selenium.va.test.TestMain;

public class InterviewReviewTests extends TestMain {

	// Page Objects
	private Landing objLanding;
	private InterviewReview objInterviewReview;
	private InterviewTask objInterviewTask;
	private InterviewPrepPage objInterviewPrepPage;
	private Interview objInterview;
	private WarningMessage objWarningMessage;

	public InterviewReviewTests() {
		setTestUrl(REVIEWER_URL);
	}

	/**
	 * Test to verify that back button in review page works 1. Open URL 2. Enter
	 * username 3. Enter password 4. Click log-in 5. Enter userID 6. Click search
	 * button 7. Click Review button on saved interview 8. In Review page click back
	 * button 9. Verify that user is brought back
	 */
	@Test
	public void backButtonTest() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickBack();
		objLanding.getLandingPageElements();

	}

	/**
	 * Test to open Tagging Tab and check all elements 1. Open URL 2. Enter username
	 * 3. Enter password 4. Click log-in 5. Enter userID 6. Click search button 7.
	 * Click Review button on saved interview 8. Click Tagging Tab and check
	 * elements
	 */

	@Test
	public void taggingElementTest() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickTagging();

	}

	/**
	 * Test to open Rating Tab and check all elements 1. Open URL 2. Enter username
	 * 3. Enter password 4. Click log-in 5. Enter userID 6. Click search button 7.
	 * Click Review button on saved interview 8. Click Rating Tab and check elements
	 */
	@Test
	public void ratingElementTest() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickRating();

	}

	/**
	 * Test to open Rating Tab, expand and check elements on Skill1 1. Open URL 2.
	 * Enter username 3. Enter password 4. Click log-in 5. Enter userID 6. Click
	 * search button 7. Click Review button on saved interview 8. Click Rating Tab
	 * 9. Expand Skill1 (Entrepreneurial and Commercial Thinking) 10. Check elements
	 * for Skill1
	 */
	@Test
	public void skill1ElementTest() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickRating();
		objInterviewReview.expandSkill1();
	}

	/**
	 * Test to open Rating Tab, expand and check elements on Skill2 1. Open URL 2.
	 * Enter username 3. Enter password 4. Click log-in 5. Enter userID 6. Click
	 * search button 7. Click Review button on saved interview 8. Click Rating Tab
	 * 9. Expand Skill2 (Persuading and Influencing) 10. Check elements for Skill2
	 */
	@Test
	public void skill2ElementTest() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickRating();
		objInterviewReview.expandSkill2();
	}

	/**
	 * Test to open Rating Tab, expand and check elements on Skill3 1. Open URL 2.
	 * Enter username 3. Enter password 4. Click log-in 5. Enter userID 6. Click
	 * search button 7. Click Review button on saved interview 8. Click Rating Tab
	 * 9. Expand Skill3 (Formulating Strategies and Concepts) 10. Check elements for
	 * Skill3
	 */
	@Test
	public void skill3ElementTest() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickRating();
		objInterviewReview.expandSkill3();
	}

	/**
	 * Test to open Rating Tab, expand and check elements on Skill4 1. Open URL 2.
	 * Enter username 3. Enter password 4. Click log-in 5. Enter userID 6. Click
	 * search button 7. Click Review button on saved interview 8. Click Rating Tab
	 * 9. Expand Skill4 (Delivering Results and Meeting Customer Expectations) 10.
	 * Check elements for Skill4
	 */
	@Test
	public void skill4ElementTest() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickRating();
		objInterviewReview.expandSkill4();
	}

	/**
	 * Test to Expand all Skills in Rating tab 1. Open URL 2. Enter username 3.
	 * Enter password 4. Click log-in 5. Enter userID 6. Click search button 7.
	 * Click Review button on saved interview 8. Click Rating Tab 9. Click Expand
	 * all and check that all skills have expanded
	 */
	@Test
	public void expandSkillsTest() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickRating();
		objInterviewReview.expandAll();
	}

	/**
	 * Test rating buttons and rating labels 1. Open URL 2. Enter username 3. Enter
	 * password 4. Click log-in 5. Enter userID 6. Click search button 7. Click
	 * Review button on saved interview 8. Click Rating Tab 9. Click Very Poor
	 * rating and check that label is changed 10. Click Poor rating and check label
	 * 11. Click Satisfactory rating and check label 12. Click Good rating and check
	 * label 13. Click Excellent rating and check label
	 */
	@Test
	public void checkRatingLabelVeryPoor() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickRating();
		objInterviewReview.expandSkill1();
		assertEquals("Very Poor", objInterviewReview.veryPoorRating());

	}

	/**
	 * Test rating buttons and rating labels 1. Open URL 2. Enter username 3. Enter
	 * password 4. Click log-in 5. Enter userID 6. Click search button 7. Click
	 * Review button on saved interview 8. Click Rating Tab 9. Click Very Poor
	 * rating and check that label is changed 10. Click Poor rating and check label
	 * 11. Click Satisfactory rating and check label 12. Click Good rating and check
	 * label 13. Click Excellent rating and check label
	 */
	@Test
	public void checkRatingLabelPoor() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickRating();
		objInterviewReview.expandSkill1();
		assertEquals("Poor", objInterviewReview.poorRating());

	}

	/**
	 * Test rating buttons and rating labels 1. Open URL 2. Enter username 3. Enter
	 * password 4. Click log-in 5. Enter userID 6. Click search button 7. Click
	 * Review button on saved interview 8. Click Rating Tab 9. Click Very Poor
	 * rating and check that label is changed 10. Click Poor rating and check label
	 * 11. Click Satisfactory rating and check label 12. Click Good rating and check
	 * label 13. Click Excellent rating and check label
	 */
	@Test
	public void checkRatingLabelSatisfactory() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickRating();
		objInterviewReview.expandSkill1();
		assertEquals("Satisfactory", objInterviewReview.satisfactoryRating());

	}

	/**
	 * Test rating buttons and rating labels 1. Open URL 2. Enter username 3. Enter
	 * password 4. Click log-in 5. Enter userID 6. Click search button 7. Click
	 * Review button on saved interview 8. Click Rating Tab 9. Click Very Poor
	 * rating and check that label is changed 10. Click Poor rating and check label
	 * 11. Click Satisfactory rating and check label 12. Click Good rating and check
	 * label 13. Click Excellent rating and check label
	 */
	@Test
	public void checkRatingLabelGood() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickRating();
		objInterviewReview.expandSkill1();
		assertEquals("Good", objInterviewReview.goodRating());

	}

	/**
	 * Test rating buttons and rating labels 1. Open URL 2. Enter username 3. Enter
	 * password 4. Click log-in 5. Enter userID 6. Click search button 7. Click
	 * Review button on saved interview 8. Click Rating Tab 9. Click Very Poor
	 * rating and check that label is changed 10. Click Poor rating and check label
	 * 11. Click Satisfactory rating and check label 12. Click Good rating and check
	 * label 13. Click Excellent rating and check label
	 */
	@Test
	public void checkRatingLabelExcellent() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickRating();
		objInterviewReview.expandSkill1();
		assertEquals("Excellent", objInterviewReview.excellentRating());

	}

	/**
	 * Test to check that when rating is filled out the icon increase the number 1.
	 * Open URL 2. Enter username 3. Enter password 4. Click log-in 5. Enter userID
	 * 6. Click search button 7. Click Review button on saved interview 8. Click
	 * Rating Tab 9. Expand Skill 2 10. Fill out 3 ratings 11. Check that number in
	 * Icon increases to 3
	 */
	@Test
	public void ratingIcon() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickRating();
		objInterviewReview.expandSkill2forIcon();
		assertEquals("3/6", objInterviewReview.checkRatingIcon());
	}

	/**
	 * Test leave feedback in video 1. Open URL 2. Enter username 3. Enter password
	 * 4. Click log-in 5. Enter userID 6. Click search button 7. Click Tagging tab
	 * 8. Click on video bar to leave a tag 9. Enter Feedback for that stop
	 */
	@Test
	public void leaveFeedback() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();

		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickTagging();
		objInterviewReview.tagVideo();
		objInterviewReview.enterFeedback("AutomationTest");
		objInterviewReview.getVideoFeedback();
	}

	/**
	 * Test for searching specific tag 1. Open URL 2. Enter username 3. Enter
	 * password 4. Click log-in 5. Enter userID 6. Click search button 7. Click
	 * Tagging tab 8. Enter feedback and click add 9. In search bar enter and filter
	 * out feedback tag 10. Check that other tags are not appearing
	 */
	@Test
	public void searchVideoTag() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewReview = new InterviewReview(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);
		objInterview = new Interview(driver);
		objWarningMessage = new WarningMessage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.clickStart();
		objInterviewPrepPage.startVideo();
		objInterview.clickFinishButton();
		objWarningMessage.clickYes();
		objInterviewTask.clickReviw();
		objInterviewReview.clickTagging();
		objInterviewReview.searchVideoTag();
	}
}