package ru.geekbrains.lesson6_hw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.lesson6_hw.base.BasePage;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.geekbrains.lesson6_hw.common.Configuration.*;

public class CreateNewProjectPage extends BasePage {

    public CreateNewProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    private WebElement saveButton;

    public CreateNewProjectPage checkCreateNewProjectPageUrl(){
        assertThat(driver.getCurrentUrl()).isEqualTo(BASE_URL + PROJECTS_PATH + CREATE_NEW_PROJECT_PATH);
        return this;
    }

    public AllProjectsPage saveNewProject(){
        saveButton.click();
        return new AllProjectsPage(driver);
    }

}
