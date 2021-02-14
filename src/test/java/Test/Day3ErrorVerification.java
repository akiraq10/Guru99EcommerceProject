package Test;

import POM.MobilePage;
import POM.ShoppingCartPage;
import org.testng.annotations.Test;

/*
Test Steps:
1. Goto http://live.demoguru99.com/
2. Click on ‘MOBILE’ menu
3. In the list of all mobile , click on ‘ADD TO CART’ for Sony Xperia mobile
4. Change ‘QTY’ value to 1000 and click ‘UPDATE’ button. Expected that an error is displayed
   "The requested quantity for "Sony Xperia" is not available.
5. Verify the error message
6. Then click on ‘EMPTY CART’ link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
7. Verify cart is empty
*/


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
