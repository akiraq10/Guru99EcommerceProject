package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static Utilities.CommonFeatures.*;
import static org.junit.Assert.assertEquals;

public class MyWishlistPage extends MainPage{

    @FindBy(xpath = "//button[@title='Share Wishlist']") WebElement btnShareWishlist;
    @FindBy(id = "email_address") WebElement txtEmailAddress;
    @FindBy(id="message") WebElement txtMessage;
    @FindBy(className = "success-msg") WebElement msgSuccessful;

    public MyWishlistPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnShareWishlist(){
        click(btnShareWishlist);
    }
    public void fillEmailAddress(String email){
        fill(txtEmailAddress,email);
    }

    public void fillMessage(String message){
        fill(txtMessage,message);
    }
    public void checkShareSuccessful(){
        assertEquals("Your Wishlist has been shared.",msgSuccessful.getText());
    }
}
