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

    // Ищем и кликаем по выпадашке Build
    @FindBy(xpath = "//*[contains(@id, 'buildNumber')]")
    private WebElement selectBuild;

    public void selectBuildClick() {
        selectBuild.click();
    }

    // Ищем и кликаем по нужному элементу выпадашки Build
    @FindBy(xpath = "//*[contains(@id, 'buildNumber')] //*[contains(@value, '%s')]")
    private WebElement selectedBuildItem;

    public void selectedItemBuildClick(String value) {
        // Используем Duration для указания времени ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = String.format("//*[contains(@id, 'buildNumber')] //*[contains(@value, '%s')]", value);
        // Ожидаем, пока элемент станет видимым
        WebElement itemToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        itemToClick.click();
    }

    // Ищем и кликаем по кнопке Roll the dice
    @FindBy(xpath = "//*[contains(@id, 'rollDiceButton')]")
    private WebElement rollTheDiceButton;

    public void rollTheDiceButtonClick() {
        rollTheDiceButton.click();
    }

    // Ищем и вводим значение в input
    @FindBy(xpath = "//*[contains(@id, 'numberGuess')]")
    private WebElement numberGuess;

    public void numberGuessInput(String input) {
        // Используем Duration для указания времени ожидания
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = "//*[contains(@id, 'numberGuess')]";
        WebElement numberGuess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        numberGuess.sendKeys(input);
    }

    // Ищем и кликаем по кнопке Submit
    @FindBy(xpath = "//*[contains(@id, 'submitButton')]")
    private WebElement submitButton;

    public void submitButtonClick() {
        submitButton.click();
    }

    // Ищем label с ответом и сверяем его значение с заданым нами
    @FindBy(xpath = "//*[contains(@id, 'feedbackLabel')] //i")
    private WebElement feedbackLabel;

    public void feedbackLabelValidation(String expected) {
        Assert.assertEquals(expected, feedbackLabel.getText());
    }
}
