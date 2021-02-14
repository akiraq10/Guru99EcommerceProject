


package Test;

import POM.MobilePage;
import POM.ProductComparisionListPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static Utilities.CommonFeatures.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Day4HandlingPopupWindows extends Hook{

    MobilePage mobilePage;
    ProductComparisionListPage productComparisionListPage;

    /*
Test Steps:
1. Goto http://live.demoguru99.com/
2. Click on ‘MOBILE’ menu
3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Sony Xperia & Iphone)
4. Click on ‘COMPARE’ button. A popup window opens
5. Verify the pop-up window and check that the products are reflected in it
   Heading "COMPARE PRODUCTS" with selected products in it.
6. Close the Popup Windows
*/


    @Test
    public void runTest() throws IOException, InterruptedException {
//        String mainWindow=driver.getWindowHandle();
        mobilePage=new MobilePage(driver);
        productComparisionListPage =new ProductComparisionListPage(driver);
        mobilePage.clickOnMOBILE();
        mobilePage.clickOnAddToCompareSony();
        mobilePage.clickOnAddToCompareIP();
        List<String> productsAdded=mobilePage.listCompare();
        mobilePage.clickOnCompare();
        switchToNewWindows();
        productComparisionListPage.checkHeading();
        List<String> listProductAtCompare=productComparisionListPage.listProduct();
        assertTrue(compareList(productsAdded,listProductAtCompare));
        productComparisionListPage.clickOnCloseWindow();
        switchToNewWindows();
    }
}
