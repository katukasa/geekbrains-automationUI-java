package ru.geekbrains.lesson6_hw.tests.navigation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.lesson6_hw.base.BaseTest;
import ru.geekbrains.lesson6_hw.enums.NavigationBarTabs;
import ru.geekbrains.lesson6_hw.pages.LoginPage;

import static ru.geekbrains.lesson6_hw.common.Configuration.*;

public class NavigationTest extends BaseTest {

    private static NavigationBarTabs[] navigationTabProvider() {
        return NavigationBarTabs.values();
    }

    @ParameterizedTest
    @MethodSource("navigationTabProvider")
    void checkMainNavigationTabsTest(NavigationBarTabs barTab) {
        new LoginPage(driver)
                .authorization(STUDENT_LOGIN, STUDENT_PASSWORD)
                .getPageNavigation()
                .checkTabVisibility(barTab);
    }
}
