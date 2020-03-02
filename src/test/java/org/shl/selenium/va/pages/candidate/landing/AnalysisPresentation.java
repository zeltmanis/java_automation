package org.shl.selenium.va.pages.candidate.landing;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnalysisPresentation {
    WebDriver driver;
    WebDriverWait wait;

    private StartTask objStartTask;

    public AnalysisPresentation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 30);
    }

    private boolean isElementPresent(By xpath) {
        return false;
    }

    private static final String ICON = "(//*[@data-testid='icon-task'])[1]";
    private static final String TASK_NAME = "(//*[@data-testid='name-task'])[1]";
    private static final String START_BUTTON = "(//*[@data-testid='button-task-start'])[1]";
    private static final String ANALYSIS_EXERCISE = "//*[text()='Analysis Presentation']";

    @FindBy(xpath = ICON)
    WebElement icon;

    @FindBy(xpath = TASK_NAME)
    WebElement task_name;

    @FindBy(xpath = START_BUTTON)
    WebElement start_button;

    @FindBy(xpath = ANALYSIS_EXERCISE)
    WebElement analysis_exercise;

    public void clickStart() {
        objStartTask = new StartTask(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(START_BUTTON)));
        start_button.click();
        List<WebElement> taskElements = objStartTask.getStartTaskElements();
        for (WebElement e : taskElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public void getExercise() {
        assertTrue(!isElementPresent(By.xpath(ANALYSIS_EXERCISE)));
    }

    public List<WebElement> getCandidateAnalysisElements() {
        List<WebElement> candidateAnalysisElements = new ArrayList();
        candidateAnalysisElements.add(icon);
        candidateAnalysisElements.add(task_name);
        candidateAnalysisElements.add(start_button);

        return candidateAnalysisElements;
    }
}
