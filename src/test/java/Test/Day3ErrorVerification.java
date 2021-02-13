package Test;

import POM.MobilePage;
import POM.ShoppingCartPage;
import org.testng.annotations.Test;

public class Day3ErrorVerification extends Hook{

    MobilePage mobilePage;
    ShoppingCartPage shoppingCartPage;

    @Test
    public void runTest(){
        mobilePage=new MobilePage(driver);
        shoppingCartPage=new ShoppingCartPage(driver);

        mobilePage.clickOnMOBILE();
        mobilePage.clickOnAddToCartSony();
        shoppingCartPage.fillQTYOfSony("1000");
        shoppingCartPage.clickOnUpdate();
        shoppingCartPage.CheckErrorMessage();
        shoppingCartPage.clickOnEmptyCart();
        shoppingCartPage.checkNotification();
    }


}
