package ru.geekbrains.lesson6_hw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.lesson6_hw.base.BasePage;

import static org.assertj.core.api.Assertions.*;
import static ru.geekbrains.lesson6_hw.common.Configuration.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li[@class='dropdown']/a/span[contains(., 'Проекты')]")
    private WebElement projectsMenu;
    @FindBy(xpath = "//span[@class='title' and text()='Мои проекты']")
    private WebElement projectsSubMenu;

    public HomePage checkBaseUrl(){
        assertThat(driver.getCurrentUrl()).isEqualTo(BASE_URL);
        return this;
    }

    public MyProjectsPage openMyProjectsPage(){
        projectsMenu.click();
        projectsSubMenu.click();
        return new MyProjectsPage(driver);
    }

}
