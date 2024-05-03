package seleniumPracticeRegister;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    FormPage formPage = new FormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize ="1920x1080";
        Configuration.baseUrl = "https://www.tutorialspoint.com/";
    }
}
