package Test;

import POM.MobilePage;
import POM.SonyPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

/*
Test Steps:
1. Goto http://live.demoguru99.com/
2. Click on ‘MOBILE’ menu
3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
4. Click on Sony Xperia mobile
5. Read the Sony Xperia mobile from detail page. Product value in list and details page should be equal ($100).
*/


public class Day2NextScript extends Hook{
    MobilePage mobilePage;
    SonyPage sonyPage;
    String priceSonyAtMobilePage;
    String priceSonyAtSonyPage;

    @Test
    public void runTest(){
        mobilePage =new MobilePage(driver);
        sonyPage =new SonyPage(driver);

        mobilePage.clickOnMOBILE();

        priceSonyAtMobilePage=mobilePage.getPriceSONY();
        System.out.println(priceSonyAtMobilePage);

        mobilePage.clickOnSony();
        priceSonyAtSonyPage=sonyPage.getPrice();
        System.out.println(priceSonyAtSonyPage);
        assertEquals(priceSonyAtMobilePage,priceSonyAtSonyPage);


    }
}
