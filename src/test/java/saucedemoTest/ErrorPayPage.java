package saucedemoTest;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ErrorPayPage {
    public ErrorPayPage openPage() {
        open("https://www.saucedemo.com/");
        $(".login_credentials_wrap-inner").shouldHave(text("Accepted usernames are"));
        return this;
    }

    public ErrorPayPage authorizationUser() {
        String userName = "standard_user";
        String password = "secret_sauce";
        $("#user-name").setValue(userName);
        $("#password").setValue(password);
        $("#login-button").click();
        $("#inventory_container").shouldHave(text("Sauce Labs Backpack"));
        return this;
    }

    public ErrorPayPage addProductToCart() {
        $("#add-to-cart-sauce-labs-backpack").click();
        $("#add-to-cart-sauce-labs-bike-light").click();
        $("#add-to-cart-sauce-labs-bolt-t-shirt").click();
        $("#add-to-cart-sauce-labs-fleece-jacket").click();
        $("#add-to-cart-sauce-labs-onesie").click();
        return this;
    }

    public ErrorPayPage clickToCart() {
        $("#shopping_cart_container").click();
        return this;
    }

    public ErrorPayPage clickCheckout() {
        $("#checkout").click();
        return this;
    }

    public ErrorPayPage setUserInformation() {
        String firstName = "Bob";
        String lastName = "Coline";
        String postalCode = "124578987";
        $("#first-name").setValue(firstName);
        $("#last-name").setValue(lastName);
        $("#postal-code").setValue(postalCode);
        return this;
    }

    public ErrorPayPage clickContinue() {
        $("#continue").click();
        return this;
    }

    public ErrorPayPage chekProduct() {
        $("#item_4_title_link").shouldBe(Condition.exist);
        $("#item_0_title_link").shouldBe(Condition.exist);
        $("#item_1_title_link").shouldBe(Condition.exist);
        $("#item_5_title_link").shouldBe(Condition.exist);
        $("#item_2_title_link").shouldBe(Condition.exist);
        return this;
    }

    public ErrorPayPage clickFinish() {
        $("#finish").click();
        return this;
    }

    public ErrorPayPage checkSuccessfulPurchase() {
        $("#checkout_complete_container").shouldHave(text("Thank you for your order!"));
        return this;
    }

    public ErrorPayPage checkErrorForm(){
        $(".error-message-container").$(byText("Error: First Name is required")).shouldBe(Condition.exist);
        return this;
    }

}

