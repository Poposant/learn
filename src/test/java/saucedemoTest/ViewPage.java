package saucedemoTest;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ViewPage {
    public ViewPage openPage() {
        open("https://www.saucedemo.com/");
        $(".login_credentials_wrap-inner").shouldHave(text("Accepted usernames are"));
        return this;
    }

    public ViewPage authorizationByUser() {
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $("#inventory_container").shouldHave(text("Sauce Labs Backpack"));
        return this;
    }

    public ViewPage clickForProductName() {
        $(".inventory_item_name").shouldHave(text("Sauce Labs Backpack")).click();
        return this;
    }

    public ViewPage checkProductCard() {
        $("#back-to-products").shouldBe(Condition.exist);
        $(".inventory_details_name").shouldHave(text("Sauce Labs Backpack"));
        return this;
    }

    public ViewPage clickProductBackpack() {
        $("#add-to-cart-sauce-labs-backpack").click();
        return this;
    }

    public ViewPage clickByCart() {
        $("#shopping_cart_container").click();
        return this;
    }

    public ViewPage clickNameBackpack() {
        $(".inventory_item_name").shouldBe(text("Sauce Labs Backpack")).click();
        return this;
    }

    public ViewPage clickProductOnesie() {
        $("#add-to-cart-sauce-labs-onesie").click();
        return this;
    }

    public ViewPage clickChecout() {
        $("#checkout").click();
        return this;
    }

    public ViewPage setUserInformation() {
        String firstName = "Bob";
        String lastName = "Coline";
        String postalCode = "124578987";
        $("#first-name").setValue(firstName);
        $("#last-name").setValue(lastName);
        $("#postal-code").setValue(postalCode);
        return this;
    }

    public ViewPage clickContinue() {
        $("#continue").click();
        return this;
    }

    public ViewPage clickOnesieProduct() {
        $("#item_2_title_link").$(byText("Sauce Labs Onesie")).click();
        return this;
    }

    public ViewPage checkOnesieCard() {
        $("#back-to-products").shouldBe(Condition.exist);
        $(".inventory_details_name").shouldHave(text("Sauce Labs Onesie"));
        return this;
    }
}
