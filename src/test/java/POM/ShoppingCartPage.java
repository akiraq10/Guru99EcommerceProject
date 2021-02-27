package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Utilities.CommonFeatures.*;
import static org.junit.Assert.assertEquals;

public class ShoppingCartPage extends MainPage{


    @FindBy(xpath = "//td[@class='product-cart-actions']//input[@data-cart-item-id='MOB001']") WebElement txtQTYSony;
    @FindBy(xpath = "//td[@class='product-cart-actions']//input[@data-cart-item-id='TV001']") WebElement txtQTYLGLCD;
    @FindBy(xpath = "//button[@title='Proceed to Checkout']") WebElement btnProceedToCheckout;
    @FindBy(xpath = "//button[@title='Update']") WebElement btnUpdate;
    @FindBy(xpath = "//li[@class='error-msg']") WebElement errorMessage;
    @FindBy(xpath = "//table[@id='shopping-cart-totals-table']//tr/td[2]/strong/span[@class='price']") WebElement GrandTotal;

    @FindBy(id="empty_cart_button") WebElement btnEmptyCart;
    @FindBy(xpath = "//div[@class='page-title']//h1") WebElement msgNotification;
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void fillQTYOfSony(String value){
        fill(txtQTYSony,value);
    }
    public void clickOnUpdate(){
        click(btnUpdate);
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public void CheckErrorMessage(){
        String expectResult="Some of the products cannot be ordered in requested quantity.";
        assertEquals(expectResult,getErrorMessage());
    }

    public void clickOnEmptyCart(){
        click(btnEmptyCart);
    }

    public String getMessageNotification(){
        return msgNotification.getText();
    }
    public void checkNotification(){
        String expectResult="SHOPPING CART IS EMPTY";
        assertEquals(expectResult,getMessageNotification());
    }
    public void clickOnProceedToCheckout(){
        click(btnProceedToCheckout);
    }
    public void fillQTYOfTVLG(String number){
        fill(txtQTYLGLCD,number);
    }

    public String getGrandTotals(){

     return GrandTotal.getText();


    }


}
