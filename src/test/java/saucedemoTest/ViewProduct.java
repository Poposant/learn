package saucedemoTest;

import org.junit.jupiter.api.Test;

public class ViewProduct extends TestBase{

    @Test
    void ViewProductMain() {
        viewPage.openPage()
                .authorizationByUser()
                .clickForProductName()
                .checkProductCard();
    }

    @Test
    void ViewProductCart() {
        viewPage.openPage()
                .authorizationByUser()
                .clickProductBackpack()
                .clickByCart()
                .clickNameBackpack()
                .checkProductCard();
    }

    @Test
    void ViewProductPay() {
        viewPage.openPage()
                .authorizationByUser()
                .clickProductOnesie()
                .clickByCart()
                .clickChecout()
                .setUserInformation()
                .clickContinue()
                .clickOnesieProduct()
                .checkOnesieCard();
    }
}
