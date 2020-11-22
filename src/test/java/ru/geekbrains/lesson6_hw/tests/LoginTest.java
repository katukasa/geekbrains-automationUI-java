package ru.geekbrains.lesson6_hw.tests;

import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson6_hw.base.BaseTest;
import ru.geekbrains.lesson6_hw.pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.geekbrains.lesson6_hw.common.Configuration.*;

public class LoginTest extends BaseTest {

    @Test
    void loginTest(){
        new LoginPage(driver)
                .enterLogin(STUDENT_LOGIN)
                .enterPassword(STUDENT_PASSWORD)
                .clickLoginButton()
                .checkUrt(BASE_URL);
//        assertThat(driver.getCurrentUrl()).isEqualTo(BASE_URL);
    }


}
