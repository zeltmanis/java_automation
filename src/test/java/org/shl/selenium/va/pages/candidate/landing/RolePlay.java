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

public class RolePlay {
    WebDriver driver;
    WebDriverWait wait;

    private StartTask objStartTask;

    public RolePlay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 30);
    }

    private static final String ICON = "(//*[@data-testid='icon-task'])[2]";
    private static final String TASK_NAME = "(//*[@data-testid='name-task'])[2]";
    private static final String START_BUTTON = "(//*[@data-testid='button-task-start'])[2]";

    @FindBy(xpath = ICON)
    WebElement icon;

    @FindBy(xpath = TASK_NAME)
    WebElement task_name;

    @FindBy(xpath = START_BUTTON)
    WebElement start_button;

    public void clickStart() {
        objStartTask = new StartTask(driver);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(START_BUTTON)));
        start_button.click();
        List<WebElement> taskElements = objStartTask.getStartTaskElements();
        for (WebElement e : taskElements) {
            assertTrue("Element " + e + " is not visible", e.isDisplayed());
        }
    }

    public List<WebElement> getCandidateRoleplayElements() {
        List<WebElement> candidateRolePlayElements = new ArrayList();
        candidateRolePlayElements.add(icon);
        candidateRolePlayElements.add(task_name);
        candidateRolePlayElements.add(start_button);

        return candidateRolePlayElements;
    }
}