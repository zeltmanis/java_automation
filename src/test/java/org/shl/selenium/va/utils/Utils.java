package org.shl.selenium.va.utils;

import java.util.Random;
import org.openqa.selenium.WebDriver;

//screenshot
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public abstract class Utils {

    /**
     * This is a random word generator. Used to create unique Tags.
     * 
     */
    public static String[] generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName) {

        String path = System.getProperty("user.dir");
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,
                    new File(path + "/src/test/java/org/shl/selenium/va/screenShots/" + screenshotName + ".png"));
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
            e.printStackTrace();
        }
    }

}
