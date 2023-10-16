package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageObjectsBasicCalculator {

    public WebDriver driver;
    public PageObjectsBasicCalculator(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Ищем и кликаем по выпадашке Build
    @FindBy(xpath = "//*[contains(@id, 'selectBuild')]")
    private WebElement selectBuild;

    public void selectBuildClick() {
        selectBuild.click();
    }

    // Ищем и кликаем по нужному элементу выпадашки Build
    @FindBy(xpath = "//*[contains(@id, 'selectBuild')] //*[contains(@value, '%s')]")
    private WebElement selectedBuildItem;

    public void selectedItemBuildClick(String value) {
        // Используем Duration для указания времени ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = String.format("//*[contains(@id, 'selectBuild')] //*[contains(@value, '%s')]", value);
        // Ожидаем, пока элемент станет видимым
        WebElement itemToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        itemToClick.click();
    }

    // Ищем и вводим значение в первый input
    @FindBy(xpath = "//*[contains(@id, 'number1Field')]")
    private WebElement numberFirst;

    public void numberFirstInput(String input) {
        numberFirst.sendKeys(input);
    }

    // Ищем и вводим значение во второй input
    @FindBy(xpath = "//*[contains(@id, 'number2Field')]")
    private WebElement numberSecond;

    public void numberSecondtInput(String input) {
        numberSecond.sendKeys(input);
    }

    // Ищем и кликаем по выпадашке Operation
    @FindBy(xpath = "//*[contains(@id, 'selectOperationDropdown')]")
    private WebElement selectOperation;

    public void selectOperationClick() {
        selectOperation.click();
    }

    // Ищем и кликаем по нужному элементу выпадашки Operation
    @FindBy(xpath = "//*[contains(@id, 'selectOperationDropdown')] //*[contains(@value, '%s')]")
    private WebElement selectedOperationItem;

    public void selectedItemOperationClick(String value) {
        // Используем Duration для указания времени ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = String.format("//*[contains(@id, 'selectOperationDropdown')] //*[contains(@value, '%s')]", value);
        // Ожидаем, пока элемент станет видимым
        WebElement itemToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        itemToClick.click();
    }

    // Ищем и кликаем по кнопке Calculate
    @FindBy(xpath = "//*[contains(@id, 'calculateButton')]")
    private WebElement calculateButton;

    public void calculateButtonClick() {
        calculateButton.click();
    }

    // Ищем поле Answer и сверяем его значение с заданым нами
    @FindBy(xpath = "//*[contains(@id, 'numberAnswerField')]")
    private WebElement numberAnswer;

    public void numberAnswerValidation(String expected) {
        Assert.assertEquals(expected, numberAnswer.getAttribute("value"));
    }
}
