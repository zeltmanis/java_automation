package org.shl.selenium.va.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.shl.selenium.va.utils.Utils;
import org.shl.selenium.va.pages.reviewer.InterviewPrepPage;
import org.shl.selenium.va.pages.reviewer.Landing;
import org.shl.selenium.va.pages.reviewer.landing.InterviewTask;
import org.shl.selenium.va.test.TestMain;

public class ReviewerTests extends TestMain {

	// Page Objects
	private Landing objLanding;
	private InterviewTask objInterviewTask;
	private InterviewPrepPage objInterviewPrepPage;

	public ReviewerTests() {
		setTestUrl(REVIEWER_URL);
	}

	private boolean isElementPresent(By xpath) {
		return false;
	}

	/**
	 * Test to verify that authorized user is able to access application
	 * 
	 * 1. Open URL 2. Enter username 3. Enter password 4. Click log-in 5. Verify by
	 * page title that user is logged-in and landing page is opened 6. Check that
	 * all elements on Landing page are visible
	 */
	@Test
	public void testloginUser() throws InterruptedException {
		objLanding = new Landing(driver);

		objLanding.loginUser();
	}

	// /**CURRENTLY REMOVED DUE TO NOT FIXED USER NAMES
	// * Test to enter userID and get the correct user 1. Open URL 2. Enter username
	// * 3. Enter password 4. Click log-in 5. Enter userID 6. Click search button 7.
	// * Check that correct user name is returned 8. Repeat for different user to
	// make
	// * sure that correct names are returned from DB
	// */

	// @Test
	// public void findUser() throws InterruptedException {
	// objLanding = new Landing(driver);

	// objLanding.loginUser();
	// objLanding.enterUserId("user9");
	// objLanding.clickSearchButton();
	// assertEquals("John Doe", objLanding.getUserName());

	// objLanding.enterUserId("user10");
	// objLanding.clickSearchButton();
	// assertEquals("Max Payne", objLanding.getUserName());
	// }

	/**
	 * Test that message is received when incorrect userID is entered 1. Open URL 2.
	 * Enter username 3. Enter password 4. Click log-in 5. Enter incorrect userID 6.
	 * Click search button 7. Check that message for incorrect userID is received
	 */
	@Test
	public void incorrectUserID() throws InterruptedException {
		objLanding = new Landing(driver);

		objLanding.loginUser();
		objLanding.enterUserId("fakeID");
		objLanding.clickSearchButton();
		assertEquals("User fakeID not found", objLanding.getUserNameNotFound());
	}

	/**
	 * Test elements for interview 1 preparation screen 1. Open URL 2. Enter
	 * username 3. Enter password 4. Click log-in 5. Enter user 6. Click search
	 * button 7. Click Start button on interview 2 8. Check elements on interview 1
	 * preparation screen
	 */

	@Test
	public void checkInterviewPrepElements() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.getReviewerInterviewElements();
		objInterviewTask.clickStart();
		assertEquals("Offline", objInterviewPrepPage.getStatus());

	}

	/**
	 * Test that Tag name must be unique 1. Open URL 2. Enter username 3. Enter
	 * password 4. Click log-in 5. Enter user 6. Click search button 7. Click Start
	 * button on interview 1 8. Check all existing elements 9. Enter Tag name 10.
	 * Enter the same Tag name again 11. Get Warning message that Tag names must be
	 * unique
	 */
	@Test
	public void existingTagMsg() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.getReviewerInterviewElements();
		objInterviewTask.clickStart();

		String[] tag = Utils.generateRandomWords(1);
		objInterviewPrepPage.enterTag(tag[0]);
		objInterviewPrepPage.addTag();
		objInterviewPrepPage.enterTag(tag[0]);
		objInterviewPrepPage.checkError();
		assertEquals("This tag already exists", objInterviewPrepPage.getExistTag());

	}

	/**
	 * Test that Tag name must be unique, case sensitive 1. Open URL 2. Enter
	 * username 3. Enter password 4. Click log-in 5. Enter user 6. Click search
	 * button 7. Click Start button on interview 1 8. Check all existing elements 9.
	 * Enter Tag name 10. Enter the same Tag name again 11. Get Warning message that
	 * Tag names must be unique
	 */
	@Test

	public void existingTagMsgUppercase() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.getReviewerInterviewElements();
		objInterviewTask.clickStart();

		String[] tag = Utils.generateRandomWords(1);
		objInterviewPrepPage.enterTag(tag[0]);
		objInterviewPrepPage.addTag();
		objInterviewPrepPage.enterTag(tag[0].toUpperCase());
		assertEquals("This tag already exists", objInterviewPrepPage.getExistTag());
	}

	/**
	 * Test that 30 characters for tag is maximum 1. Open URL 2. Enter username 3.
	 * Enter password 4. Click log-in 5. Enter user 6. Click search button 7. Click
	 * Start button on interview 1 8. Check all existing elements 9. Enter Tag name
	 * 30 characters long 10. Get Warning message that Tag name max is 30 char
	 */
	@Test
	public void max30CharMsg() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.getReviewerInterviewElements();
		objInterviewTask.clickStart();

		String tag = "abcdyabcdyabcdyabcdyabcdyabcdyz";
		objInterviewPrepPage.enterTag(tag);
		assertEquals("Maximum length for a tag is 30 characters", objInterviewPrepPage.getMax30CharMsg());

	}

	/**
	 * Test that Add button does not appears for empty tag 1. Open URL 2. Enter
	 * username 3. Enter password 4. Click log-in 5. Enter user 6. Click search
	 * button 7. Click Start button on interview 1 8. Check all existing elements 9.
	 * Enter empty tag - space 10. Add button does not appear
	 */
	@Test
	public void emptyTag() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.getReviewerInterviewElements();
		objInterviewTask.clickStart();
		String tag = "   ";
		objInterviewPrepPage.emptyTag(tag);
	}

	/**
	 * Test for Reviewer to add tags in preparation screen 1. Open URL 2. Enter
	 * username 3. Enter password 4. Click log-in 5. Enter user 6. Click search
	 * button 7. Click Start button on interview 1 8. Add some tags 9. Check that
	 * tags are added and appear
	 */
	@Test
	public void addTagsReviewerPrep() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.getReviewerInterviewElements();
		objInterviewTask.clickStart();

		WebDriverWait wait = new WebDriverWait(driver, 20);

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

	}

	/**
	 * Test for Reviewer to delete Tag 1. Open URL 2. Enter username 3. Enter
	 * password 4. Click log-in 5. Enter user 6. Click search button 7. Click Start
	 * button on interview 1 8. Add some tags 9. Check that tags are added and
	 * appear 10. Click on a tag to delete it 11. Check that tag is deleted
	 */

	@Test
	public void removingTagsReviewerPrep() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.getReviewerInterviewElements();
		objInterviewTask.clickStart();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// Create 2 Tags with randomgenerator
		String[] tag = Utils.generateRandomWords(1);

		objInterviewPrepPage.enterTag(tag[0]);
		objInterviewPrepPage.addTag();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class, '') and text()='" + tag[0] + "']")));

		String[] tag2 = Utils.generateRandomWords(1);
		objInterviewPrepPage.enterTag(tag2[0]);
		objInterviewPrepPage.addTag();

		// Check that Tags are created
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class, '') and text()='" + tag2[0] + "']")));

		// Click to delete the Tags
		driver.findElement(By.xpath("//div[contains(@class, '') and text()='" + tag[0] + "']//img")).click();

		// Check that the Tags are deleted
		assertTrue(!isElementPresent(By.xpath("//div[contains(@class, '') and text()='" + tag[0] + "']")));

		// Click to delete the Tags
		driver.findElement(By.xpath("//div[contains(@class, '') and text()='" + tag2[0] + "']//img")).click();

		// Check that the Tags are deleted
		assertTrue(!isElementPresent(By.xpath("//div[contains(@class, '') and text()='" + tag2[0] + "']")));

	}

	/**
	 * Test to go back from Reviewer preparation page 1. Open URL 2. Enter username
	 * 3. Enter password 4. Click log-in 5. Enter user 6. Click search button 7.
	 * Click Start button on interview 1 8. Click back button
	 * 
	 */
	@Test
	public void goBackFromPrepPage() throws InterruptedException {
		objLanding = new Landing(driver);
		objInterviewTask = new InterviewTask(driver);
		objInterviewPrepPage = new InterviewPrepPage(driver);

		objLanding.loginUser();
		objLanding.enterUserId("candidate1");
		objLanding.clickSearchButton();
		objInterviewTask.getReviewerInterviewElements();
		objInterviewTask.clickStart();
		objInterviewPrepPage.clickBack();
		objLanding.getLandingPageElements();
	}
}
