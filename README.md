# Basic calculator and The number game UI-autotests

## Technology :

    Java
    Maven
    Selenium

## Task :

Написать UI - автотесты для следующих сайтов:

https://testsheepnz.github.io/BasicCalculator.html  
https://testsheepnz.github.io/random-number.html

## Case №1

1. Открыть сайт https://testsheepnz.github.io/BasicCalculator.html
2. Проскроллить вниз до конца
3. Выбрать сборку (Build) «Prototype»
4. Ввести в поле First number значение «2»
5. Ввести в поле Second number значение «3»
6. Выбрать операцию (Operation) «Subtract»
7. Нажать на кнопку «Calculate»
8. Проверить, что в поле ответа (Answer) значение равно «-1»

## Case №2

1. Открыть сайт https://testsheepnz.github.io/BasicCalculator.html
2. Проскроллить вниз до конца
3. Выбрать сборку (Build) «Prototype»
4. Ввести в поле First number значение «gs»
5. Ввести в поле Second number значение «bu»
6. Выбрать операцию (Operation) «Concatenate»
7. Нажать на кнопку «Calculate»
8. Проверить, что в поле ответа (Answer) значение равно «gsbu»

## Case №3

1. Открыть сайт https://testsheepnz.github.io/random-number.html
2. Проскроллить вниз до конца
3. Выбрать сборку (Select Build) «Demo»
4. Нажать на кнопку «Roll the dice»
5. Ввести в поле значение «string»
6. Нажать на кнопку «Submit»
7. Проверить, что появилось сообщение «string: Not a number!»

## Development Environment :

    Инструменты разработки : java 21, Selenium
    IDE : IntelliJ IDEA 2023.2.3 (Community Edition)
    ОС : Microsoft Windows 10 Pro

## Code :

       - Исходный код выполняет тесты для каждого кейса, описанных выше

       - Для тестирования всех кейсов достаточно запустить главный файл "TestCases.java"
