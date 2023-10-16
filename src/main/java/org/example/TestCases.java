package org.example;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCases {
    ChromeDriver driver = new ChromeDriver();
    PageObjectsBasicCalculator pageObjectsBasicCalculator = new PageObjectsBasicCalculator(driver);
    PageObjectsNumberGame pageObjectsNumberGame = new PageObjectsNumberGame(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        pageObjectsBasicCalculator.selectBuildClick();
        pageObjectsBasicCalculator.selectedItemBuildClick("0");
        pageObjectsBasicCalculator.numberFirstInput("2");
        pageObjectsBasicCalculator.numberSecondtInput("3");
        pageObjectsBasicCalculator.selectOperationClick();
        pageObjectsBasicCalculator.selectedItemOperationClick("1");
        pageObjectsBasicCalculator.calculateButtonClick();
        pageObjectsBasicCalculator.numberAnswerValidation("-1");
        driver.quit();
    }

    @Test
    public void secondTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        pageObjectsBasicCalculator.selectBuildClick();
        pageObjectsBasicCalculator.selectedItemBuildClick("0");
        pageObjectsBasicCalculator.numberFirstInput("gs");
        pageObjectsBasicCalculator.numberSecondtInput("bu");
        pageObjectsBasicCalculator.selectOperationClick();
        pageObjectsBasicCalculator.selectedItemOperationClick("4");
        pageObjectsBasicCalculator.calculateButtonClick();
        pageObjectsBasicCalculator.numberAnswerValidation("gsbu");
        driver.quit();
    }

    @Test
    public void thirdTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver.get("https://testsheepnz.github.io/random-number.html");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        pageObjectsNumberGame.selectBuildClick();
        pageObjectsNumberGame.selectedItemBuildClick("0");
        pageObjectsNumberGame.rollTheDiceButtonClick();
        pageObjectsNumberGame.numberGuessInput("string");
        pageObjectsNumberGame.submitButtonClick();
        pageObjectsNumberGame.feedbackLabelValidation("string: Not a number!");
        driver.quit();
    }
}
