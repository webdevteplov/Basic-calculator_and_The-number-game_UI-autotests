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

    // Ищем выпадашку Build
    @FindBy(xpath = "//*[contains(@id, 'selectBuild')]")
    private WebElement selectBuild;

    // Ищем нужный элементт выпадашки Build
    @FindBy(xpath = "//*[contains(@id, 'selectBuild')] //*[contains(@value, '%s')]")
    private WebElement selectedBuildItem;

    // Ищем первый input
    @FindBy(xpath = "//*[contains(@id, 'number1Field')]")
    private WebElement numberFirst;

    // Ищем второй input
    @FindBy(xpath = "//*[contains(@id, 'number2Field')]")
    private WebElement numberSecond;

    // Ищем выпадашку Operation
    @FindBy(xpath = "//*[contains(@id, 'selectOperationDropdown')]")
    private WebElement selectOperation;

    // Ищем нужный элемент выпадашки Operation
    @FindBy(xpath = "//*[contains(@id, 'selectOperationDropdown')] //*[contains(@value, '%s')]")
    private WebElement selectedOperationItem;

    // Ищем кнопку Calculate
    @FindBy(xpath = "//*[contains(@id, 'calculateButton')]")
    private WebElement calculateButton;

    // Ищем поле Answer
    @FindBy(xpath = "//*[contains(@id, 'numberAnswerField')]")
    private WebElement numberAnswer;


    // Кликаем по выпадашке Build
    public void selectBuildClick() {
        selectBuild.click();
    }

    // Кликаем по нужному элементу выпадашки Build
    public void selectedItemBuildClick(String value) {
        // Используем Duration для указания времени ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = String.format("//*[contains(@id, 'selectBuild')] //*[contains(@value, '%s')]", value);
        // Ожидаем, пока элемент станет видимым
        WebElement itemToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        itemToClick.click();
    }

    // Вводим значение в первый input
    public void numberFirstInput(String input) {
        numberFirst.sendKeys(input);
    }

    // Вводим значение во второй input
    public void numberSecondtInput(String input) {
        numberSecond.sendKeys(input);
    }

    // Кликаем по выпадашке Operation
    public void selectOperationClick() {
        selectOperation.click();
    }

    // Кликаем по нужному элементу выпадашки Operation
    public void selectedItemOperationClick(String value) {
        // Используем Duration для указания времени ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = String.format("//*[contains(@id, 'selectOperationDropdown')] //*[contains(@value, '%s')]", value);
        // Ожидаем, пока элемент станет видимым
        WebElement itemToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        itemToClick.click();
    }

    // Кликаем по кнопке Calculate
    public void calculateButtonClick() {
        calculateButton.click();
    }

    // Сверяем значение поля Answer с заданым нами значением
    public void numberAnswerValidation(String expected) {
        Assert.assertEquals(expected, numberAnswer.getAttribute("value"));
    }
}
