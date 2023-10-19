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

public class PageObjectsNumberGame {

    public WebDriver driver;
    public PageObjectsNumberGame(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Ищем выпадашку Build
    @FindBy(xpath = "//*[contains(@id, 'buildNumber')]")
    private WebElement selectBuild;

    // Ищем нужный элемент выпадашки Build
    @FindBy(xpath = "//*[contains(@id, 'buildNumber')] //*[contains(@value, '%s')]")
    private WebElement selectedBuildItem;

    // Ищем кнопку Roll the dice
    @FindBy(xpath = "//*[contains(@id, 'rollDiceButton')]")
    private WebElement rollTheDiceButton;

    // Ищем input
    @FindBy(xpath = "//*[contains(@id, 'numberGuess')]")
    private WebElement numberGuess;

    // Ищем кнопку Submit
    @FindBy(xpath = "//*[contains(@id, 'submitButton')]")
    private WebElement submitButton;

    // Ищем label с ответом
    @FindBy(xpath = "//*[contains(@id, 'feedbackLabel')] //i")
    private WebElement feedbackLabel;


    // Кликаем по выпадашке Build
    public void selectBuildClick() {
        selectBuild.click();
    }

    // Кликаем по нужному элементу выпадашки Build
    public void selectedItemBuildClick(String value) {
        // Используем Duration для указания времени ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = String.format("//*[contains(@id, 'buildNumber')] //*[contains(@value, '%s')]", value);
        // Ожидаем, пока элемент станет видимым
        WebElement itemToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        itemToClick.click();
    }

    // Кликаем по кнопке Roll the dice
    public void rollTheDiceButtonClick() {
        rollTheDiceButton.click();
    }

    // Вводим значение в input
    public void numberGuessInput(String input) {
        // Используем Duration для указания времени ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = "//*[contains(@id, 'numberGuess')]";
        WebElement numberGuess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        numberGuess.sendKeys(input);
    }

    // Кликаем по кнопке Submit
    public void submitButtonClick() {
        submitButton.click();
    }

    // Сверяем значение label с заданым нами
    public void feedbackLabelValidation(String expected) {
        Assert.assertEquals(expected, feedbackLabel.getText());
    }
}
