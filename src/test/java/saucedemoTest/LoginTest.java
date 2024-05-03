package saucedemoTest;

import org.junit.jupiter.api.Test;

public class LoginTest extends TestBase {
    @Test
    void authorizationTest() {
        loginPage.openPage()
                .setUserName()
                .setPassword()
                .clickLoginButton()
                .checkAuthorization();
    }

    @Test
    void logoutTest() {
        loginPage.openPage()
                .setUserName()
                .setPassword()
                .clickLoginButton()
                .checkAuthorization()
                .clickMenuButton()
                .clickLogoutButton()
                .checkLogout();
    }

    @Test
    void invalidLoginTest1() {
        loginPage.openPage()
                .setUserName()
                .setInvalidPassword()
                .clickLoginButton()
                .checkErrorMessage();
    }

    @Test
    void invalidLoginTest2() {
        loginPage.openPage()
                .setUserName()
                .clickLoginButton()
                .checkErrorMessageFill();
    }

    @Test
    void invalidLoginTest3() {
        loginPage.openPage()
                .setPassword()
                .clickLoginButton()
                .checkErrorMessageFill1();
    }

    @Test
    void invalidLoginTest4() {
        loginPage.openPage()
                .setInvalidUserName()
                .setPassword()
                .clickLoginButton()
                .checkErrorMessage();
    }
}
