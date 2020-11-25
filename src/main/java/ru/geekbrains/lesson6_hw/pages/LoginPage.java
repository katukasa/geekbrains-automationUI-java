package ru.geekbrains.lesson6_hw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.lesson6_hw.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement inputLogin;
    @FindBy(xpath = "//input[@name='_password']")
    private WebElement inputPassword;
    @FindBy(xpath = ".//button[@name='_submit']")
    private WebElement buttonSingIn;

    public HomePage authorization(String login, String password){
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSingIn.click();
        return new HomePage(driver);
    }

}
