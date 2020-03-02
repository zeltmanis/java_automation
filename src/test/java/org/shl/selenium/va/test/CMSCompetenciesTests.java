package org.shl.selenium.va.test;

import org.junit.Test;
import org.shl.selenium.va.pages.cms.CMSLanding;
import org.shl.selenium.va.pages.WarningMessage;
import org.shl.selenium.va.pages.cms.CMSCompetencies;
import static org.junit.Assert.assertEquals;

public class CMSCompetenciesTests extends CmsTestMain {

	// Page Objects
	private CMSLanding objCMSLanding;
	private CMSCompetencies objCMSCompetencies;
	private WarningMessage objWarningMessage;

	public CMSCompetenciesTests() {
		setTestUrl(CMS_URL);
	}

	/**
	 * Test to log in and check elements 1. Open URL 2. Enter username 3. Enter
	 * password 4. Click log-in 5. Check elements on CMS page
	 */
	@Test
	public void checkCMSElements() throws InterruptedException {
		objCMSLanding = new CMSLanding(driver);

		objCMSLanding.loginCMS();
	}

	/**
	 * Test elements for competencies page and for creating new competencies 1. Open
	 * URL 2. Enter username 3. Enter password 4. Click log-in 5. Check elements on
	 * CMS page 6. Go to competencies 7. Check elements under competencies 8. Click
	 * Create New 9. Check elements for new competencies
	 */
	@Test
	public void checkCompetenciesElements() throws InterruptedException {
		objCMSLanding = new CMSLanding(driver);
		objCMSCompetencies = new CMSCompetencies(driver);

		objCMSLanding.loginCMS();
		objCMSLanding.openCompetencies();
		objCMSCompetencies.clickCreateNew();
	}

	/**
	 * Test to create new competencies and save it 1. Open URL 2. Enter username 3.
	 * Enter password 4. Click log-in 5.Check elements on page 6. Click Create new
	 * competency 7. Fill out the name 8. Fill out Behaviors 9. Fill out Create Tags
	 * 10. Click create button 11. Check that competencies is created and visible
	 */
	@Test
	public void createNewCompetencie() throws InterruptedException {
		objCMSLanding = new CMSLanding(driver);
		objCMSCompetencies = new CMSCompetencies(driver);

		objCMSLanding.loginCMS();
		objCMSLanding.openCompetencies();
		objCMSCompetencies.clickCreateNew();
		objCMSCompetencies.enterName("Automation test");
		objCMSCompetencies.enterBehaviours();
		objCMSCompetencies.enterTags();
		objCMSCompetencies.clickCreate();
		objCMSLanding.getCreatedCompetencie();

	}

	/**
	 * Test to enter and delete Behaviors tag 1. Open URL 2. Enter username 3. Enter
	 * password 4. Click log-in 5.Check elements on page 6. Click Create new
	 * competency 7. Fill out the name 8. Add Behaviors tag 9. check that it is
	 * added 10. Delete behaviors tag. Check that it is deleted
	 */
	@Test
	public void deleteBehavioursTag() throws InterruptedException {
		objCMSLanding = new CMSLanding(driver);
		objCMSCompetencies = new CMSCompetencies(driver);

		objCMSLanding.loginCMS();
		objCMSLanding.openCompetencies();
		objCMSCompetencies.clickCreateNew();
		objCMSCompetencies.enterName("Delete Behaviours Tag");
		objCMSCompetencies.deleteBehaviours();
	}

	/**
	 * Test to enter and delete Competencies tag 1. Open URL 2. Enter username 3.
	 * Enter password 4. Click log-in 5.Check elements on page 6. Click Create new
	 * competency 7. Fill out the name 8. Add Competencies tag 9. check that it is
	 * added 10. Delete Competencies tag. Check that it is deleted
	 */
	@Test
	public void deleteCompetenciesTag() throws InterruptedException {
		objCMSLanding = new CMSLanding(driver);
		objCMSCompetencies = new CMSCompetencies(driver);

		objCMSLanding.loginCMS();
		objCMSLanding.openCompetencies();
		objCMSCompetencies.clickCreateNew();
		objCMSCompetencies.enterName("Delete Competencies Tag");
		objCMSCompetencies.deleteCompetenciesTag();
	}

	/**
	 * * Test to create new competencies and delete 1. Open URL 2. Enter username 3.
	 * Enter password 4. Click log-in 5.Check elements on page 6. Click Create new
	 * competency 7. Fill out the name 8. Fill out Behaviors 9. Fill out Create Tags
	 * 10. Click create button 11. Check that competencies is created and visible
	 * 12. open competencies options 13. click delete 14. in warning message click
	 * NO 15. Competency is not deleted, open option 16. click delete 17. click yes
	 * 18. Check that competency is deleted
	 */
	@Test
	public void deletCreatedCompetency() throws InterruptedException {
		objCMSLanding = new CMSLanding(driver);
		objCMSCompetencies = new CMSCompetencies(driver);
		objWarningMessage = new WarningMessage(driver);

		objCMSLanding.loginCMS();
		objCMSLanding.openCompetencies();
		objCMSCompetencies.clickCreateNew();
		objCMSCompetencies.enterName("Delete Automation Test");
		objCMSCompetencies.enterBehaviours();
		objCMSCompetencies.enterTags();
		objCMSCompetencies.clickCreate();
		objCMSLanding.openOptions();
		objCMSLanding.clickDelete();
		objWarningMessage.clickNo();
		objCMSLanding.openOptions();
		objCMSLanding.clickDelete();
		assertEquals("Are you sure that you want to delete competency?", objWarningMessage.getMessage());
		objWarningMessage.clickYes();
		objCMSLanding.checkDeletedCompetency();

	}

	/**
	 * Test to create new competencies and edit it and save it. 1. Open URL 2. Enter
	 * username 3. Enter password 4. Click log-in 5.Check elements on page 6. Click
	 * Create new competency 7. Fill out the name 8. Fill out Behaviors 9. Fill out
	 * Create Tags 10. Click create button 11. Check that competencies is created
	 * and visible 12. open competencies options 13. click edit. 14. change name,
	 * add tags 15. click Save button 16. check that new competency is saved
	 */
	@Test
	public void editExistingCompetencie() throws InterruptedException {
		objCMSLanding = new CMSLanding(driver);
		objCMSCompetencies = new CMSCompetencies(driver);

		objCMSLanding.loginCMS();
		objCMSLanding.openCompetencies();
		objCMSCompetencies.clickCreateNew();
		objCMSCompetencies.enterName("Edit Automation Test");
		objCMSCompetencies.enterBehaviours();
		objCMSCompetencies.enterTags();
		objCMSCompetencies.clickCreate();
		objCMSLanding.clickEdit();
		objCMSCompetencies.enterName("Changed Test Automation");
		objCMSCompetencies.enterBehaviours();
		objCMSCompetencies.enterTags();
		objCMSCompetencies.clickSave();
		objCMSLanding.getEditedCompetencie();

	}

	/**
	 * Test removed, it is now allowed to input all type of input Test that only
	 * alphabetical characters are allowed for tags 1. Open URL 2. Enter username 3.
	 * Enter password 4. Click log-in 5.Check elements on page 6. Click Create new
	 * competency 7. Enter tag with numbers 8.Check that error message appears.
	 */
	// @Test
	// public void onlyCharTagMessage() throws InterruptedException {
	// objCMSLanding = new CMSLanding(driver);
	// objCMSCompetencies = new CMSCompetencies(driver);

	// objCMSLanding.loginCMS();
	// objCMSLanding.openCompetencies();
	// objCMSCompetencies.clickCreateNew();
	// objCMSCompetencies.getWarningOnlyChar();
	// assertEquals("Only alphabetical characters are allowed",
	// objCMSCompetencies.getWarningOnlyChar());
	// }

	/**
	 * Test that Tag name must be unique 1. Open URL 2. Enter username 3. Enter
	 * password 4. Click log-in 5.Check elements on page 6. Click Create new
	 * competency 7. Enter same tag twice 8.Check that error message appears.
	 */
	@Test
	public void existingTagMessage() throws InterruptedException {
		objCMSLanding = new CMSLanding(driver);
		objCMSCompetencies = new CMSCompetencies(driver);

		objCMSLanding.loginCMS();
		objCMSLanding.openCompetencies();
		objCMSCompetencies.clickCreateNew();
		objCMSCompetencies.getWarningExistingTag();
		assertEquals("This tag already exists", objCMSCompetencies.getWarningExistingTag());
	}

	/**
	 * Test that Tag name must be unique, case sensitive 1. Open URL 2. Enter
	 * username 3. Enter password 4. Click log-in 5.Check elements on page 6. Click
	 * Create new competency 7. Enter tag in lower case, and in Uppercase 8.Check
	 * that error message appears.
	 */
	@Test
	public void existingTagUppercaseMsg() throws InterruptedException {
		objCMSLanding = new CMSLanding(driver);
		objCMSCompetencies = new CMSCompetencies(driver);

		objCMSLanding.loginCMS();
		objCMSLanding.openCompetencies();
		objCMSCompetencies.clickCreateNew();
		objCMSCompetencies.getWarningUppercaseTag();
		assertEquals("This tag already exists", objCMSCompetencies.getWarningUppercaseTag());
	}

	/**
	 * Test that 30 characters for tag is maximum 1. Open URL 2. Enter username 3.
	 * Enter password 4. Click log-in 5.Check elements on page 6. Click Create new
	 * competency 7. Enter tag 30 char long 8.Check that error message appears.
	 */
	@Test
	public void max30CharTagMessage() throws InterruptedException {
		objCMSLanding = new CMSLanding(driver);
		objCMSCompetencies = new CMSCompetencies(driver);

		objCMSLanding.loginCMS();
		objCMSLanding.openCompetencies();
		objCMSCompetencies.clickCreateNew();
		objCMSCompetencies.get30CharMessage();
		assertEquals("Maximum length for a tag is 30 characters", objCMSCompetencies.get30CharMessage());
	}

	/**
	 * Test that Behaviors Tag name must be unique 1. Open URL 2. Enter username 3.
	 * Enter password 4. Click log-in 5.Check elements on page 6. Click Create new
	 * competency 7. Enter same Behavior tag twice 8.Check that error message
	 * appears.
	 */
	@Test
	public void existingBehivoursMsg() throws InterruptedException {
		objCMSLanding = new CMSLanding(driver);
		objCMSCompetencies = new CMSCompetencies(driver);

		objCMSLanding.loginCMS();
		objCMSLanding.openCompetencies();
		objCMSCompetencies.clickCreateNew();
		objCMSCompetencies.getWarningExistingBehaviours();
		assertEquals("This behaviour already exists", objCMSCompetencies.getWarningExistingBehaviours());
	}

	/**
	 * Test that Behaviors Tag name must be unique, case sensitive 1. Open URL 2.
	 * Enter username 3. Enter password 4. Click log-in 5.Check elements on page 6.
	 * Click Create new competency 7. Enter tag in lower case, and in Uppercase
	 * 8.Check that error message appears.
	 */
	@Test
	public void behavioursTagUppercaseMsg() throws InterruptedException {
		objCMSLanding = new CMSLanding(driver);
		objCMSCompetencies = new CMSCompetencies(driver);

		objCMSLanding.loginCMS();
		objCMSLanding.openCompetencies();
		objCMSCompetencies.clickCreateNew();
		objCMSCompetencies.getMsgBehaviourTagUpper();
		assertEquals("This behaviour already exists", objCMSCompetencies.getMsgBehaviourTagUpper());
	}
}