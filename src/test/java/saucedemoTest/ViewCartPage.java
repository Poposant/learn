package saucedemoTest;

import com.codeborne.selenide.Condition;

import javax.swing.text.View;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ViewCartPage {

    public ViewCartPage openPage(){
        open("https://www.saucedemo.com/");
        $(".login_credentials_wrap-inner").shouldHave(text("Accepted usernames are"));
        return this;
    }

    public ViewCartPage authorizationByUser(){
        String userName = "standard_user";
        String password = "secret_sauce";
        $("#user-name").setValue(userName);
        $("#password").setValue(password);
        $("#login-button").click();
        $("#inventory_container").shouldHave(text("Sauce Labs Backpack"));
        return this;
    }

    public ViewCartPage clickShoppingCart() {
        $("#shopping_cart_container").click();
        return this;
    }

    public ViewCartPage checkEmptyCart() {
        $(".header_secondary_container").shouldHave(text("Your Cart"));
        $(".cart_item").shouldNotBe(Condition.exist);
        return this;
    }

    public ViewCartPage clickProduct1(){
        $("#add-to-cart-sauce-labs-bolt-t-shirt").click();
        return this;
    }
    public ViewCartPage clickProduct2(){
        $("#add-to-cart-sauce-labs-fleece-jacket").click();
        return this;
    }

    public ViewCartPage checkAddedProduct (){
        $("#remove-sauce-labs-bolt-t-shirt").shouldHave(text("Remove"));
        $("#remove-sauce-labs-fleece-jacket").shouldHave(text("Remove"));
        $("#shopping_cart_container").shouldHave(text("2"));
        return this;
    }

    public ViewCartPage clickProduct3(){
        $("#add-to-cart-sauce-labs-bike-light").click();
        return this;
    }
    public ViewCartPage clickProduct4(){
        $("#add-to-cart-sauce-labs-onesie").click();
        return this;
    }

    public ViewCartPage checkProductToCart() {
        $(".cart_item").shouldBe(Condition.exist);
        return this;
    }
}
