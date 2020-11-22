package ru.geekbrains.lesson6_hw.pages;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.lesson6_hw.base.BasePage;
import ru.geekbrains.lesson6_hw.base.NavigationBar;

public class HomePage extends BasePage {

    private NavigationBar navigationBar;

    public HomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }
}
