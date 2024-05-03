package saucedemoTest;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RemovePage {

    public RemovePage openPage(){
        open("https://www.saucedemo.com/");
        $(".login_credentials_wrap-inner").shouldHave(text("Accepted usernames are"));
        return this;
    }

    public RemovePage authorizationByUser(){
        String userName = "standard_user";
        String password = "secret_sauce";
        $("#user-name").setValue(userName);
        $("#password").setValue(password);
        $("#login-button").click();
        $("#inventory_container").shouldHave(text("Sauce Labs Backpack"));
        return this;
    }

   public RemovePage clickAddProduct1() {
       $("#add-to-cart-sauce-labs-bolt-t-shirt").click();
       return this;
   }

   public RemovePage clickRemoveProduct1() {
       $("#remove-sauce-labs-bolt-t-shirt").click();
       return this;
   }

   public RemovePage checkDisableButtonRemove(){
       $("#remove-sauce-labs-bolt-t-shirt").shouldNotBe(Condition.exist);
       return this;
   }
   public RemovePage checkVisibleButtonAdd() {
       $("#add-to-cart-sauce-labs-bolt-t-shirt").shouldBe(Condition.exist);
        return this;
   }

   public RemovePage clickAddProduct2(){
       $("#add-to-cart-sauce-labs-fleece-jacket").click();
       return this;
   }

   public RemovePage clickToCart(){
       $("#shopping_cart_container").click();
       return this;
   }

   public RemovePage clickRemoveProduct2(){
       $("#remove-sauce-labs-fleece-jacket").click();
       return this;
   }

   public RemovePage checkDeletedProduct2() {
       $("#remove-sauce-labs-fleece-jacket").shouldNotBe(Condition.exist);
       $(".cart_item").shouldNotBe(Condition.exist);
       return this;
   }

}
