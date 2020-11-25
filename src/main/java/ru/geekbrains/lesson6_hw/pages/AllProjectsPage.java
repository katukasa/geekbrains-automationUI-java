package ru.geekbrains.lesson6_hw.pages;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.lesson6_hw.base.BasePage;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.geekbrains.lesson6_hw.common.Configuration.*;

public class AllProjectsPage extends BasePage {

    public AllProjectsPage(WebDriver driver) {
        super(driver);
    }

    public AllProjectsPage checkAllProjectsPageUrl() throws InterruptedException {
        Thread.sleep(5000);
        assertThat(driver.getCurrentUrl()).isEqualTo(BASE_URL + projects_path);
        return this;
    }

}
