package org.shl.selenium.va.pages.cms.exercises.createnew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CMSRatingForms {

    private WebDriver driver;
    WebDriverWait wait;

    public CMSRatingForms(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 10);
    }

    // Page elements
    private static final String ADD_COMPETENCIES = "//*[@data-testid='button-add-competencies']";
    private static final String RATING_SCALE_TITLE = "//*[@class='sc-kJdAmE gbaCZi']";
    private static final String RATING_DROP_DOWN = "//*[@class=' css-1vrloku']";

    // Rating rows
    private static final String VALUE_1_TITLE = "(//*[@data-testid='label'])[1]";
    private static final String VALUE_1_BOX = "(//*[@data-testid='input'])[1]";
    private static final String VALUE_2_TITLE = "(//*[@data-testid='label'])[2]";
    private static final String VALUE_2_BOX = "(//*[@data-testid='input'])[2]";
    private static final String VALUE_3_TITLE = "(//*[@data-testid='label'])[3]";
    private static final String VALUE_3_BOX = "(//*[@data-testid='input'])[3]";
    private static final String VALUE_4_TITLE = "(//*[@data-testid='label'])[4]";
    private static final String VALUE_4_BOX = "(//*[@data-testid='input'])[4]";
    private static final String VALUE_5_TITLE = "(//*[@data-testid='label'])[5]";
    private static final String VALUE_5_BOX = "(//*[@data-testid='input'])[5]";

    // Choose rating scale
    private static final String VALUE_3 = "//*[@id='react-select-6-option-0']//*[@tabindex='3']";

    // Page elements
    @FindBy(xpath = ADD_COMPETENCIES)
    WebElement add_competencies;

    @FindBy(xpath = RATING_SCALE_TITLE)
    WebElement rating_scale_title;

    @FindBy(xpath = RATING_DROP_DOWN)
    WebElement rating_drop_down;

    @FindBy(xpath = VALUE_1_TITLE)
    WebElement value_1_title;

    @FindBy(xpath = VALUE_1_BOX)
    WebElement value_1_box;

    @FindBy(xpath = VALUE_2_TITLE)
    WebElement value_2_title;

    @FindBy(xpath = VALUE_2_BOX)
    WebElement value_2_box;

    @FindBy(xpath = VALUE_3_TITLE)
    WebElement value_3_title;

    @FindBy(xpath = VALUE_3_BOX)
    WebElement value_3_box;

    @FindBy(xpath = VALUE_4_TITLE)
    WebElement value_4_title;

    @FindBy(xpath = VALUE_4_BOX)
    WebElement value_4_box;

    @FindBy(xpath = VALUE_5_TITLE)
    WebElement value_5_title;

    @FindBy(xpath = VALUE_5_BOX)
    WebElement value_5_box;

    // Choose rating scale
    @FindBy(xpath = VALUE_3)
    WebElement value_3;

    public void clickAddCompetencies() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_COMPETENCIES)));
        add_competencies.click();
    }

    public void openRatingScale() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(RATING_DROP_DOWN)));
        rating_drop_down.click();
    }

    public void selectValue3() {
        this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(VALUE_3)));
        value_3.click();
    }

}