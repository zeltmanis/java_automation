package org.shl.selenium.va.test;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.shl.selenium.va.utils.Utils;
import org.shl.selenium.va.utils.OsValidator;
import org.shl.selenium.va.utils.ApiExercise;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.junit.runner.Description;

import java.io.IOException;

//Here are stored URL for pages and webdriver

public class TestMain {

    private ApiExercise apiExercsie = new ApiExercise();
    public final static String CANDIDATE_URL = "https://vivid-vadevqa.eu.shl.zone";
    public final static String CMS_URL = "https://vivid-vadevqa.eu.shl.zone/cms";
    public final static String REVIEWER_URL = "https://vivid-vadevqa.eu.shl.zone/assessor";
    public static String WEBDRIVER = "";
    public static boolean HEADLESS_ENABLED = true;

    public String testUrl;
    public WebDriver driver;
    long exercise_id;

    public TestMain() {
        detectEnvironment();
    }

    static void detectEnvironment() {
        if (OsValidator.isWindows()) {
            System.out.println("Running on Windows");
            WEBDRIVER = "webdriver/geckodriver.exe";
            HEADLESS_ENABLED = false;
        } else {
            System.out.println("Running on unix");
            WEBDRIVER = "webdriver/geckodriver";
            HEADLESS_ENABLED = true;
        }
    }

    public static boolean getHeadlessEnabled() {
        detectEnvironment();
        return HEADLESS_ENABLED;
    }

    public void setTestUrl(final String url) {
        testUrl = url;
    }

    public void assignExercise() throws ParseException {
        exercise_id = apiExercsie.assignExercise("analysis_presentation_en");
    }

    public void removeExercise() throws IOException {
        apiExercsie.removeExercise(exercise_id);
    }

    @Before
    public void prepare() throws ParseException {

        assignExercise();

        System.setProperty("webdriver.gecko.driver", WEBDRIVER);

        // Set Firefox Headless mode as TRUE
        final FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(HEADLESS_ENABLED);
        options.addPreference("permissions.default.microphone", 1);
        options.addPreference("permissions.default.camera", 1);

        // Instantiate Web Driver
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
        driver.get(testUrl);
    }

    public void teardown() throws IOException {
        driver.quit();
        removeExercise();
    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {

        @Override
        protected void failed(final Throwable e, final Description description) {
            try {
                System.out.println("Test failed:" + description);
                System.out.println("Taking a screenshot..");
                Utils.captureScreenshot(driver, description.getDisplayName());
                teardown();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        protected void succeeded(final Description description) {
            try {
                teardown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}
