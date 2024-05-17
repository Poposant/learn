package saucedemoTest;

import org.junit.jupiter.api.Test;

public class ErrorPayProduct extends TestBase{
    @Test
    void unsuccessfulPayProduct() {
        errorPayPage.openPage()
                .authorizationUser()
                .addProductToCart()
                .clickToCart()
                .clickCheckout()
                .clickContinue()
                .checkErrorForm();
    }

}
