package ru.geekbrains.lesson6_hw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.lesson6_hw.base.BasePage;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.geekbrains.lesson6_hw.common.Configuration.*;

public class MyProjectsPage extends BasePage {

    public MyProjectsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='pull-left btn-group icons-holder']")
    private WebElement createProjectButton;

    public MyProjectsPage checkMyProjectsUrl(){
        assertThat(driver.getCurrentUrl()).isEqualTo(BASE_URL + PROJECTS_PATH + MY_PROJECTS_PATH);
        return this;
    }

    public CreateNewProjectPage clickOnCreateNewProjectButton(){
        createProjectButton.click();
        return new CreateNewProjectPage(driver);
    }
}
