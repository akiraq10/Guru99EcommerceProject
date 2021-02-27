package Test;

/*  Verify user is able to purchase product using registered email id(USE CHROME BROWSER)
Test Steps:
1. Go to http://live.demoguru99.com/
2. Click on my account link
3. Login in application using previously created credential
4. Click on MY WISHLIST link
5. In next page, Click ADD TO CART link
6. Enter general shipping country, state/province and zip for the shipping cost estimate
7. Click Estimate
8. Verify Shipping cost generated
9. Select Shipping Cost, Update Total
10. Verify shipping cost is added to total
11. Click "Proceed to Checkout"
12a. Enter Billing Information, and click Continue
12b. Enter Shipping Information, and click Continue
13. In Shipping Method, Click Continue
14. In Payment Information select 'Check/Money Order' radio button. Click Continue
15. Click 'PLACE ORDER' button
16. Verify Oder is generated. Note the order number

NOTE: PROCEED TO CHECKOUT (step 6 ) was taken out, so as to allow the Estimate button step to get processed.
      Rest of the steps renumbered accordingly.
*/

import POM.*;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static Utilities.CommonFeatures.*;

public class Day6PurchaseProducts extends Hook{
    LoginOrCreateanAccountPage loginOrCreateanAccountPage;
    MyDashBoardPage myDashBoardPage;
    MyWishlistPage myWishlistPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;


    @Test
    public void runTest(){
        loginOrCreateanAccountPage =new LoginOrCreateanAccountPage(driver);
        myDashBoardPage=new MyDashBoardPage(driver);
        myWishlistPage=new MyWishlistPage(driver);
        shoppingCartPage=new ShoppingCartPage(driver);
        checkoutPage =new CheckoutPage(driver);

        loginOrCreateanAccountPage.clickOnAccount();
        loginOrCreateanAccountPage.clickOnMyAccount();
        loginOrCreateanAccountPage.loginToAccount(email,pass);
        myDashBoardPage.clickOnMyWishlist();
        myWishlistPage.clickOnAddToCart();
        shoppingCartPage.clickOnProceedToCheckout();
        checkoutPage.selectNewAddress();
        checkoutPage.fillFirstName("asd");
        checkoutPage.fillMiddleName("dasda");
        checkoutPage.fillLastName("asdasdsa");
        checkoutPage.fillAddress("ABC");
        checkoutPage.fillCity("New York");
        checkoutPage.selectProvince("New York");
        checkoutPage.fillZip("542896");
        checkoutPage.selectCountry("United States");
        checkoutPage.fillTelephone("12345678");
        checkoutPage.clickOnContinueAtTab("BillInfo");

        String FlatRate=checkoutPage.getFlatRate();
        checkoutPage.clickOnContinueAtTab("ShipMethod");
        checkoutPage.switchToNewTab();
        checkoutPage.checkMoneyOrder();
        checkoutPage.clickOnContinueAtTab("PaymentInfo");
        checkoutPage.switchToNewTab();
        String feeShipping=checkoutPage.getFeeShipping();
        assertEquals(FlatRate,feeShipping);
        checkoutPage.clickOnPlaceOrder();
        checkoutPage.switchToNewTab();
        String yourOrderNumber=checkoutPage.getYourNumberOrder();
        System.out.printf(yourOrderNumber);








    }

}
