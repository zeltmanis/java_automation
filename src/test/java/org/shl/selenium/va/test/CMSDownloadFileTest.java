package org.shl.selenium.va.test;

import org.junit.Assert;
import org.junit.Test;
import org.shl.selenium.va.pages.cms.CMSLanding;
import org.shl.selenium.va.pages.cms.files.CMSFilesLanding;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.shl.selenium.va.utils.Utils;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.UUID;

import org.junit.runner.Description;

public class CMSDownloadFileTest {

    // Page Objects
    private CMSLanding objCMSLanding;
    private CMSFilesLanding objCMSFilesLanding;

    public String testUrl;
    public WebDriver driver;
    File folder;

    @Before
    public void prepare() {

        new TestMain();
        // Code to call out Reviewer page
        testUrl = TestMain.CMS_URL;

        System.setProperty("webdriver.gecko.driver", TestMain.WEBDRIVER);

        // Set Firefox Headless mode as TRUE
        final FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(TestMain.getHeadlessEnabled());
        options.addPreference("permissions.default.microphone", 1);
        options.addPreference("permissions.default.camera", 1);

        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();
        final FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.dir", folder.getAbsolutePath());
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.defaultFolder", folder.getAbsolutePath());
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "image/jpeg, application/pdf, application/octet-stream");
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("pdfjs.disabled", true);
        options.setProfile(profile);

        // Instantiate Web Driver
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get(testUrl);
    }

    /**
     * Test to check if file can be downloaded. 1. Open URL 2. Enter username 3.
     * Enter password 4. Click log-in 5. Click Files 6. Click on file to initiate
     * download. 7. Check that file is downloaded
     */
    @Test
    public void downloadFile() throws InterruptedException {
        objCMSLanding = new CMSLanding(driver);
        objCMSFilesLanding = new CMSFilesLanding(driver);

        objCMSLanding.loginCMS();
        objCMSLanding.openFiles();
        objCMSFilesLanding.downloadFile();
        //  TODO: check
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            assertTrue(listOfFiles.length > 0);
        } else {
            Assert.fail();
        }
        for (File file : listOfFiles) {
            assertTrue(file.length() > 0);
        }
    }

    public void teardown() {
        driver.quit();
    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {

        @Override
        protected void failed(final Throwable e, final Description description) {
            System.out.println("Test failed:" + description);
            System.out.println("Taking a screenshot..");
            Utils.captureScreenshot(driver, description.getDisplayName());
            teardown();
        }

        @Override
        protected void succeeded(final Description description) {
            teardown();
            for (File file : folder.listFiles()) {
                file.delete();
            }
            folder.delete();
        }
    };
}