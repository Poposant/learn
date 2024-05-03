package saucedemoTest;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.getRandomString;

public class PayPage {
    public PayPage openPage() {
        open("https://www.saucedemo.com/");
        $(".login_credentials_wrap-inner").shouldHave(text("Accepted usernames are"));
        return this;
    }

    public PayPage authorizationUser() {
        String userName = "standard_user";
        String password = "secret_sauce";
        $("#user-name").setValue(userName);
        $("#password").setValue(password);
        $("#login-button").click();
        $("#inventory_container").shouldHave(text("Sauce Labs Backpack"));
        return this;
    }

    public PayPage addProductToCart() {
        $("#add-to-cart-sauce-labs-backpack").click();
        $("#add-to-cart-sauce-labs-bike-light").click();
        $("#add-to-cart-sauce-labs-bolt-t-shirt").click();
        $("#add-to-cart-sauce-labs-fleece-jacket").click();
        $("#add-to-cart-sauce-labs-onesie").click();
        return this;
    }

    public PayPage clickToCart() {
        $("#shopping_cart_container").click();
        return this;
    }

    public PayPage clickCheckout() {
        $("#checkout").click();
        return this;
    }

    public PayPage setUserInformation() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String postalCode = getRandomString(10);
        $("#first-name").setValue(firstName);
        $("#last-name").setValue(lastName);
        $("#postal-code").setValue(postalCode);
        return this;
    }

    public PayPage clickContinue() {
        $("#continue").click();
        return this;
    }

    public PayPage chekProduct() {
        $("#item_4_title_link").shouldBe(Condition.exist);
        $("#item_0_title_link").shouldBe(Condition.exist);
        $("#item_1_title_link").shouldBe(Condition.exist);
        $("#item_5_title_link").shouldBe(Condition.exist);
        $("#item_2_title_link").shouldBe(Condition.exist);
        return this;
    }

    public PayPage clickFinish() {
        $("#finish").click();
        return this;
    }

    public PayPage checkSuccessfulPurchase() {
        $("#checkout_complete_container").shouldHave(text("Thank you for your order!"));
        return this;
    }

}

