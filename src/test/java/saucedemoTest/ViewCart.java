package saucedemoTest;

import org.junit.jupiter.api.Test;

public class ViewCart extends TestBase{

    @Test
    void viewEmptyTheCart(){
        viewCartPage.openPage()
                .authorizationByUser()
                .clickShoppingCart()
                .checkEmptyCart();

    }

    @Test
    void addToCart(){
        viewCartPage.openPage()
                .authorizationByUser()
                .clickProduct1()
                .clickProduct2()
                .checkAddedProduct();

    }

    @Test
    void viewAddedItemsInCart() {
        viewCartPage.openPage()
                .authorizationByUser()
                .clickProduct3()
                .clickProduct4()
                .checkProductToCart();

    }
}
