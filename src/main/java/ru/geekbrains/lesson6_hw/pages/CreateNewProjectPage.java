package ru.geekbrains.lesson6_hw.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.lesson6_hw.base.BasePage;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.geekbrains.lesson6_hw.common.Configuration.*;

public class CreateNewProjectPage extends BasePage {

    public CreateNewProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "*//input[@name='crm_project[name]']")
    private WebElement projectNameField;
    @FindBy(xpath = "*//span[@class='select2-chosen' and text()='Укажите организацию']")
    private WebElement companyField;
    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    private WebElement companySearchField;
    @FindBy(xpath = "*//div[@class='select2-container select2']")
    private WebElement contactField;
    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    private WebElement contactSearchField;
    @FindBy(xpath = "//select[@name='crm_project[businessUnit]']")
    private WebElement businessUnitField;
    @FindBy(xpath = "//select[@name='crm_project[curator]']")
    private WebElement curatorField;
    @FindBy(xpath = "//select[@name='crm_project[rp]']")
    private WebElement headField;
    @FindBy(xpath = "//select[@name='crm_project[manager]']")
    private WebElement managerField;
    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    private WebElement saveButton;

    public CreateNewProjectPage checkCreateNewProjectPageUrl(){
        assertThat(driver.getCurrentUrl()).isEqualTo
                (BASE_URL + projects_path + create_path);
        return this;
    }

    public CreateNewProjectPage fillReqFields(){
//      Наименование
        projectNameField.sendKeys(new_project_name);

//      Организация
        companyField.click();
        companySearchField.sendKeys(company_name);
        companySearchField.sendKeys(Keys.ENTER);

//      Основное контактное лицо
        contactField.click();
        contactSearchField.sendKeys(contact_name);
        contactSearchField.sendKeys(Keys.ENTER);

//      Подразделение
        Select businessUnitDropDown = new Select(businessUnitField);
        businessUnitDropDown.selectByValue("1");

//      Куратор проекта
        Select curatorDropDown = new Select(curatorField);
        curatorDropDown.selectByValue("40");

//      Руководитель проекта
        Select headDropDown = new Select(headField);
        headDropDown.selectByValue("33");

//      Менеджер
        Select managerDropDown = new Select(managerField);
        managerDropDown.selectByValue("5");

        return this;
    }

//      Проверить, что все поля заполнены правильно
        public CreateNewProjectPage checkFields(){

            ArrayList<String> fields = new ArrayList<>(
                    Arrays.asList(
                            check_company_name,
                            check_contact_name,
                            check_curator_name,
                            check_department,
                            check_head_name,
                            check_manager_name
                    )
            );
            fields.forEach(xpath -> {
                WebElement element = driver.findElement(By.xpath(xpath));
                Assertions.assertTrue(element.isDisplayed());
            });
            return this;
        }

    public AllProjectsPage saveNewProject(){
        saveButton.click();
        return new AllProjectsPage(driver);
    }

}
