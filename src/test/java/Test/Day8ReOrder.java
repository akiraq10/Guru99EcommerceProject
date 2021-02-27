package Test;
/*  Verify you are able to change or reorder previously added product
 *  Test Data = QTY = 10
Test Steps:
1. Go to http://live.demoguru99.com/
2. Click on my account link
3. Login in application using previously created credential
4. Click on 'REORDER' link , change QTY & click Update
5. Verify Grand Total is changed
6. Complete Billing & Shipping Information
7. Verify order is generated and note the order number

Expected outcomes:
1) Grand Total is Changed
2) Order number is generated
*/

import POM.*;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class Day8ReOrder extends Hook{
    LoginOrCreateanAccountPage loginOrCreateanAccountPage;
    MyDashBoardPage myDashBoardPage;
    MyWishlistPage myWishlistPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;

    @Test
    public void runTest(){
        String grandTotalsBefore;
        String grandTotalsAfer;
        loginOrCreateanAccountPage =new LoginOrCreateanAccountPage(driver);
        myDashBoardPage=new MyDashBoardPage(driver);
        myWishlistPage=new MyWishlistPage(driver);
        shoppingCartPage=new ShoppingCartPage(driver);
        checkoutPage =new CheckoutPage(driver);

        loginOrCreateanAccountPage.clickOnAccount();
        loginOrCreateanAccountPage.clickOnMyAccount();
        loginOrCreateanAccountPage.loginToAccount(email,pass);
        myDashBoardPage.clickOnReOrder();

        grandTotalsBefore=shoppingCartPage.getGrandTotals();
        shoppingCartPage.fillQTYOfTVLG("10");
        shoppingCartPage.clickOnUpdate();
        grandTotalsAfer= shoppingCartPage.getGrandTotals();
        if(grandTotalsBefore==grandTotalsAfer){
            System.out.printf("not changed");
        }else System.out.printf("changed");
        shoppingCartPage.clickOnProceedToCheckout();
        checkoutPage.clickOnContinueAtTab("BillInfo");
        checkoutPage.clickOnContinueAtTab("ShipMethod");
        checkoutPage.checkMoneyOrder();
        checkoutPage.clickOnContinueAtTab("PaymentInfo");
        checkoutPage.clickOnPlaceOrder();
        String yourOrderNumber=checkoutPage.getYourNumberOrder();
        System.out.printf(yourOrderNumber);



    }
}
