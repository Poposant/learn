package saucedemoTest;

import org.junit.jupiter.api.Test;

public class PayProduct extends TestBase {
    @Test
    void successfulPayProduct() {
        payPage.openPage()
                .authorizationUser()
                .addProductToCart()
                .clickToCart()
                .clickCheckout()
                .setUserInformation()
                .clickContinue()
                .chekProduct()
                .clickFinish()
                .checkSuccessfulPurchase();
    }
}
