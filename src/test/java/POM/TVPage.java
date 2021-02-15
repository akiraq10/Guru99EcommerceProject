package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static Utilities.CommonFeatures.*;

public class TVPage extends MainPage{

    @FindBy(xpath = "//li[1]/div/div[3]/ul[@class='add-to-links']//a[@class='link-wishlist']")
    WebElement lnkAddToWishlistLG;
    @FindBy(xpath = "//li[2]/div/div[3]/ul[@class='add-to-links']//a[@class='link-wishlist']")
    WebElement lnkAddToWishlistSAMSUNG;



    public TVPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnAddToWishlistLG(){
        click(lnkAddToWishlistLG);
    }
}
