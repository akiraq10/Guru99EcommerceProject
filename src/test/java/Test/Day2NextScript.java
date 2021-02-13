package Test;

import POM.MobilePage;
import POM.SonyPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

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
