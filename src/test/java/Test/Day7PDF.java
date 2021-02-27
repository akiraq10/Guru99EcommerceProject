package Test;
/*  Verify that you will be able to save previously placed order as a pdf file
 *
 *   Note: This TestCase7a version is due to the below amended steps.
 *
Test Steps:
1. Go to http://live.demoguru99.com/
2. Click on My Account link
3. Login in application using previously created credential
4. Click on 'My Orders'
5. Click on 'View Order'
6. *** note: After steps 4 and 5, step 6 "RECENT ORDERS" was not displayed
   Verify the previously created order is displayed in 'RECENT ORDERS' table and status is Pending
7. Click on 'Print Order' link
8. *** note: the link was not found.
   Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.
9. *** unable to execute this step, due to issue with step 8 issue
   Click on 'Save' button and save the file in some location.
10. *** unable to execute this step, due to steps 8 and 9 issues.
    Verify Order is saved as PDF

*/


import POM.LoginOrCreateanAccountPage;
import POM.MyDashBoardPage;
import POM.MyOrdersPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class Day7PDF extends Hook{
    LoginOrCreateanAccountPage loginOrCreateanAccountPage;
    MyDashBoardPage myDashBoardPage;
    MyOrdersPage myOrdersPage;

    @Test
    public void runTest() throws IOException, InterruptedException {
        loginOrCreateanAccountPage =new LoginOrCreateanAccountPage(driver);
        myDashBoardPage=new MyDashBoardPage(driver);
        myOrdersPage=new MyOrdersPage(driver);

        loginOrCreateanAccountPage.clickOnAccount();
        loginOrCreateanAccountPage.clickOnMyAccount();
        loginOrCreateanAccountPage.loginToAccount(email,pass);
        myDashBoardPage.clickOnMyOrders();
        myOrdersPage.clikOnViewOrder();
        switchToNewWindows();
        myOrdersPage.isCheckStatusOrder("SPENDING");
        myOrdersPage.isCheckOrderItems("LG LCD");
        myOrdersPage.clickOnlnkPrintOrder();
        Runtime.getRuntime().exec("src/test/java/AutoIT/savePDF.exe");
        Thread.sleep(3000);
    }


}
