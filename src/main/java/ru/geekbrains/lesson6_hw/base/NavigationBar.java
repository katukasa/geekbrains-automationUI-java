package ru.geekbrains.lesson6_hw.base;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.geekbrains.lesson6_hw.enums.NavigationBarTabs;

public class NavigationBar extends BasePage {

    public NavigationBar(WebDriver driver){
        super(driver);
    }

    public SubMenu moveCursorToNavigationTab(NavigationBarTabs tab){
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(tab.getBy()))
                .build()
                .perform();

        switch (tab){
            case EXPENSES:
                return new ExpenseSubMenu(driver);
            default:
                throw new IllegalArgumentException("Not implemented");
        }
    }

    public NavigationBar checkTabVisibility (NavigationBarTabs tab){
        Assertions.assertTrue(driver.findElement(tab.getBy()).isDisplayed());
        return this;
    }

}
