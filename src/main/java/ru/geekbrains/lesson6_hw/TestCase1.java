package ru.geekbrains.lesson6_hw;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestCase1 {
    private static WebDriver driver;
    private static final String LOGIN_PAGE = "https://crm.geekbrains.space/";
    private static final String LOGIN = "Applanatest";
    private static final String PASSWORD = "Student2020!";
    private static final String projectsMenu = "//ul[@class='nav nav-multilevel main-menu']/li[@class='dropdown']/a/span[contains(., 'Проекты')]";
    private static final String projectsSubMenu = "//span[@class='title' and text()='Мои проекты']";
    private static final String createProjectButton = "//div[@class='pull-left btn-group icons-holder']";
    private static final String contact = "//*[@id='select2-drop']/div/input";
    private static final String company = "//*[@id='select2-drop']/div/input";
    private static final String saveButton = "//button[@class='btn btn-success action-button']";
    private static final String panelIntsHeader = "//h1[@class='oro-subtitle' and contains(text(), 'Панель инструментов')]";
    private static final String createProjectHeader = "//h1[contains(text(), 'Создать проект')]";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

//      Step 1: Авторизоваться на сайте CRM
        login();

//      Step 2: Перейти в “Проекты” → “Мои проекты”
        openMyProjects();

//      Step 3: Нажать на кнопку “Создать проект”
        createNewProject();

//      Step 4: Заполнить обязательные поля:

//      Наименование (text) - works only in debug mode :(
        driver.findElement(By.name("crm_project[name]")).sendKeys("kat_project3");

//      Организация (drop down) - через селекторы не работало, какой-то странный список, не такой как остальные
        driver.findElement(By.xpath("//span[@class='select2-chosen' and text()='Укажите организацию']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(company))));
        driver.findElement(By.xpath(company)).sendKeys("Test Organisation_10");
        driver.findElement(By.xpath(company)).sendKeys(Keys.ENTER);

//      Основное контактное лицо (drop down) - available only when "Организация" field is filled, тоже не работает через селекторы
        driver.findElement(By.xpath("//div[@class='select2-container select2']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(contact))));
        driver.findElement(By.xpath(contact)).sendKeys("Мартынов Николай");
        driver.findElement(By.xpath(contact)).sendKeys(Keys.ENTER);

//      Подразделение (drop down) - done
        Select businessUnitDropDown = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitDropDown.selectByValue("1");

//      Куратор проекта (drop down) - done
        Select curatorDropDown = new Select(driver.findElement(By.xpath("//select[@name='crm_project[curator]']")));
        curatorDropDown.selectByValue("5");

//      Руководитель проекта (drop down)
        Select headDropDown = new Select(driver.findElement(By.xpath("//select[@name='crm_project[rp]']")));
        headDropDown.selectByValue("5");

//      Менеджер (drop down)
        Select managerDropDown = new Select(driver.findElement(By.xpath("//select[@name='crm_project[manager]']")));
        managerDropDown.selectByValue("5");

//      Проверить, что все поля заполнены правильно
//        ArrayList<String> fields = new ArrayList<>(
//                Arrays.asList(
//                        "//input[contains(text(), 'kat_project3')]", // не работает :(((
//                        "//span[contains(text(), 'Test Organisation_10')]",
//                        "//span[contains(text(), 'Мартынов Николай')]",
//                        "//span[contains(text(), 'Research & Development')]",
//                        "",
//                        "",
//                        ""
//                )
//        );
//        fields.forEach(xpath -> {
//            WebElement element = driver.findElement(By.xpath(xpath));
//            Assertions.assertTrue(element.isDisplayed());
//        });

//      Step 5: Нажать на кнопку “Сохранить и закрыть”
        saveNewProject();

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

//      Пользователь видит страницу Панель Инструментов
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(panelIntsHeader))));
        Assertions.assertTrue(driver.findElement(By.xpath(panelIntsHeader)).isDisplayed());
    }

    private static void openMyProjects() {
        driver.findElement(By.xpath(projectsMenu)).click();
        driver.findElement(By.xpath(projectsSubMenu)).click();

//      Присутствует кнопка “Создать проект”
//        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(createProjectButton))));
//        Assertions.assertTrue(driver.findElement(By.xpath(createProjectButton)).isDisplayed());
    }

    private static void createNewProject() {
        driver.findElement(By.xpath(createProjectButton)).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("/create"));

//      Присутствует заголовок “Создать проект”
//        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(createProjectHeader))));
//        Assertions.assertTrue(driver.findElement(By.xpath(createProjectHeader)).isDisplayed());
    }

    private static void saveNewProject() {
        driver.findElement(By.xpath(saveButton)).click();

//      пользователь видит страницу “Все проекты”
//        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("https://crm.geekbrains.space/project/"));
//        Assertions.assertTrue(driver.findElement(By.xpath("//h1[normalize-space() = 'Все Проекты']")).isDisplayed());
//
////      и всплывающее уведомление о том, что проект успешно создан - haven't done
//
////      новый проект есть в списке проектов
//        Assertions.assertTrue(driver.findElement(By.xpath("//td[contains(text(), 'kat_project1')]")).isDisplayed());
    }

    private static void tearDown(){
        driver.quit();
    }

}
