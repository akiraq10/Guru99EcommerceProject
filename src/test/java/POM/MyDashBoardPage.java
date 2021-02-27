package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static Utilities.CommonFeatures.*;

public class MyDashBoardPage extends MainPage{

    @FindBy(className = "success-msg") WebElement msgRegisterSuccessful;
    @FindBy(linkText = "MY WISHLIST") WebElement lnkMyWishList;
    @FindBy(linkText = "MY ORDERS") WebElement lnkMyOrders;


    public MyDashBoardPage(WebDriver driver) {
        super(driver);
    }

    public void checkRegisterSuccessful(){
        assertEquals("Thank you for registering with Main Website Store.",msgRegisterSuccessful.getText());
    }
    public void clickOnMyWishlist(){
        click(lnkMyWishList);
    }
    public void clickOnMyOrders(){
        clickOn(lnkMyOrders);
    }

}
