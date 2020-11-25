package ru.geekbrains.lesson6_hw.tests;

import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson6_hw.base.BaseTest;
import ru.geekbrains.lesson6_hw.pages.LoginPage;

import static ru.geekbrains.lesson6_hw.common.Configuration.*;

public class CreateNewProjectTest extends BaseTest {

    @Test
    void createNewProjectTest() throws InterruptedException {
        new LoginPage(driver)
                .authorization(STUDENT_LOGIN, STUDENT_PASSWORD)
                .checkBaseUrl()

                .openMyProjectsPage()
                .checkMyProjectsUrl()

                .clickOnCreateNewProjectButton()
                .checkCreateNewProjectPageUrl()

                .fillReqFields()
                .checkFields()

                .saveNewProject()
                .checkAllProjectsPageUrl()
        ;

    }
}
