package saucedemoTest;
;
import org.junit.jupiter.api.Test;

public class Remove extends TestBase{

    @Test
    void removeMain() {
        removePage.openPage()
                .authorizationByUser()
                .clickAddProduct1()
                .clickRemoveProduct1()
                .checkDisableButtonRemove()
                .checkVisibleButtonAdd();
    }
    @Test
    void removeCart() {
        removePage.openPage()
                .authorizationByUser()
                .clickAddProduct2()
                .clickToCart()
                .clickRemoveProduct2()
                .checkDeletedProduct2();
    }

}
