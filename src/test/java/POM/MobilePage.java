package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Utilities.CommonFeatures.*;

public class MobilePage extends MainPage{

    @FindBy(linkText = "SONY XPERIA") WebElement lnkSONY;
    @FindBy(linkText = "IPHONE") WebElement lnkIP;
    @FindBy(linkText = "SAMSUNG GALAXY") WebElement lnkSS;
    @FindBy(id = "product-price-1") WebElement priceSONY;
    @FindBy(id="product-price-2") WebElement priceIP;
    @FindBy(id="product-price-3") WebElement priceSS;

    @FindBy(xpath = "//li[1]//button[@title='Add to Cart']") WebElement btnAddToCartOfSony;
    @FindBy(xpath = "//li[2]//button[@title='Add to Cart']") WebElement btnAddToCartOfIP;
    @FindBy(xpath = "//li[3]//button[@title='Add to Cart']") WebElement btnAddToCartOfSS;



     public  MobilePage(WebDriver driver){
         super(driver);
     }


     public String getPriceSONY(){
         return priceSONY.getText();
     }
    public String getPriceIP(){
        return priceIP.getText();
    }

    public String getPriceSS(){
        return priceSS.getText();
    }
    public void clickOnSony(){
         click(lnkSONY);
    }
    public void clickOnAddToCartSony(){
         click(btnAddToCartOfSony);
    }








}
