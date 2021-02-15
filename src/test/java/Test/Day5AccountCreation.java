package Test;

import POM.*;
import org.testng.annotations.Test;

/*
Verify can create an account in e-Commerce site and can share wishlist to other people using email.
Test Steps:
1. Go to http://live.demoguru99.com/
2. Click on my account link
3. Click Create an Account link and fill New User information except Email ID
4. Click Register
5. Verify Registration is done. Expected account registration done.
6. Go to TV menu
7. Add product in your wish list - use product - LG LCD
8. Click SHARE WISHLIST
9. In next page enter Email and a message and click SHARE WISHLIST
10.Check wishlist is shared. Expected wishlist shared successfully.

*/


public class Day5AccountCreation extends Hook{

    CreateAnAccountPage createAnAccountPage;
    MyDashBoardPage myDashBoardPage;
    MyWishlistPage myWishlistPage;
    TVPage tvPage;

    @Test
    public void runTest(){
        mainPage=new MainPage(driver);
        createAnAccountPage =new CreateAnAccountPage(driver);
        myDashBoardPage =new MyDashBoardPage(driver);
        myWishlistPage=new MyWishlistPage(driver);
        tvPage =new TVPage(driver);

        mainPage.clickOnAccount();
        mainPage.clickOnRegisterAccount();

        createAnAccountPage.fillFirstName("first11");
        createAnAccountPage.fillMiddleName("middle1");
        createAnAccountPage.fillLastName("last1");
        createAnAccountPage.fillEmail("emailtext12@gmail.com");
        createAnAccountPage.fillPassword("123456");
        createAnAccountPage.fillConfirmPassword("123456");
        createAnAccountPage.checkSubscribed();
        createAnAccountPage.clickOnRegister();

        myDashBoardPage.checkRegisterSuccessful();
        myDashBoardPage.cliccOnTV();

        tvPage.clickOnAddToWishlistLG();

        myWishlistPage.clickOnShareWishlist();
        myWishlistPage.fillEmailAddress("Email123@gmail.com");
        myWishlistPage.fillMessage("share1");
        myWishlistPage.clickOnShareWishlist();
        myWishlistPage.checkShareSuccessful();


    }
}
