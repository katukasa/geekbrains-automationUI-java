package ru.geekbrains.lesson3.hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestCase1 {
    private static WebDriver driver;
    private static final String LOGIN_PAGE = "https://crm.geekbrains.space/";
    private static final String LOGIN = "Applanatest";
    private static final String PASSWORD = "Student2020!";
    private static final String projectsMenu = "//ul[@class='nav nav-multilevel main-menu']/li[@class='dropdown']/a/span[contains(., 'Проекты')]";
    private static final String projectsSubMenu = "//span[@class='title' and text()='Мои проекты']";
    private static final String button = "div[class='pull-left btn-group icons-holder']";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

//      Step 1: Авторизоваться на сайте CRM
        login();

//      Step 2: Перейти в “Проекты” → “Мои проекты”
        driver.findElement(By.xpath(projectsMenu)).click();
        driver.findElement(By.xpath(projectsSubMenu)).click();

//      Step 3: Нажать на кнопку “Создать проект”
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(button))));
        driver.findElement(By.cssSelector(button)).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("/create"));

//      Step 4: Заполнить обязательные поля:
//      Наименование (text)
        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys("kat_project1");
//      Организация (drop down)
//      Основное контактное лицо (drop down)
//      Подразделение (drop down)
//      Куратор проекта (drop down)
//      Руководитель проекта (drop down)
//      Администратор проекта (drop down) - поле без звездочки в CRM
//      Менеджер (drop down)

//        Step 5: Нажать на кнопку “Сохранить и закрыть”

        Thread.sleep(6000);

        tearDown();
    }

    private static void login() {
        driver.get(LOGIN_PAGE);

        WebElement loginTextInput = driver.findElement(By.name("_username"));
        loginTextInput.sendKeys(LOGIN);

        WebElement passwordTextInput = driver.findElement(By.name("_password"));
        passwordTextInput.sendKeys(PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();
    }

    private static void tearDown(){
        System.out.println("Test Case 1 is completed.");
        driver.quit();
    }

}
