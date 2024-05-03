package saucedemoTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import saucedemoTest.LoginPage;

public class TestBase {

    LoginPage loginPage = new LoginPage();
    ErrorPayPage errorPayPage = new ErrorPayPage();
    PayPage payPage = new PayPage();
    ViewPage viewPage = new ViewPage();
    ViewCartPage viewCartPage = new ViewCartPage();
    RemovePage removePage = new RemovePage();

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "firefox";
        System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");
        System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox");
    }

}

