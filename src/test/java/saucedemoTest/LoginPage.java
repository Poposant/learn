package saucedemoTest;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.getRandomString;

public class LoginPage {

    String invalidPassword = getRandomString(10);
    Faker faker = new Faker();
    String invalidUsername = faker.name().username();

    public LoginPage openPage() {
        open("https://www.saucedemo.com/");
        $(".login_credentials_wrap-inner").shouldHave(text("Accepted usernames are"));
        return this;
    }

    public LoginPage setUserName() {
        $("#user-name").setValue("standard_user");
        return this;
    }

    public LoginPage setPassword() {
        $("#password").setValue("secret_sauce");
        return this;
    }

    public LoginPage clickLoginButton() {
        $("#login-button").click();
        return this;
    }

    public LoginPage checkAuthorization() {
        $("#inventory_container").shouldHave(text("Sauce Labs Backpack"));
        return this;
    }

    public LoginPage clickMenuButton() {
        $("#react-burger-menu-btn").click();
        return this;
    }

    public LoginPage clickLogoutButton() {
        $("#logout_sidebar_link").click();
        return this;
    }

    public LoginPage checkLogout() {
        $(".login_credentials_wrap-inner").shouldHave(text("Accepted usernames are"));
        return this;
    }

    public LoginPage setInvalidPassword(){
        $("#password").setValue(invalidPassword);
        return this;
    }

    public LoginPage checkErrorMessage() {
        $(".error-message-container").shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
        return this;
    }

    public LoginPage checkErrorMessageFill(){
        $(".error-message-container").shouldHave(text("Epic sadface: Password is required"));
        return this;
    }
    public LoginPage checkErrorMessageFill1(){
        $(".error-message-container").shouldHave(text("Epic sadface: Username is required"));
        return this;
    }
    public LoginPage setInvalidUserName(){
        $("#user-name").setValue(invalidUsername);
        return this;
    }
}
