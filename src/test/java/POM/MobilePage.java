package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//li[1]//a[text()='Add to Compare']") WebElement lnkAddToCompareSony;
    @FindBy(xpath = "//li[2]/div/div[3]/ul/li[2]/a") WebElement lnkAddToCompareIP;
    @FindBy(xpath = "//li[3]/div/div[3]/ul/li[2]/a") WebElement lnkAddToCompareSS;

    @FindBy(xpath = "//button[@title='Compare']") WebElement btnCompare;

    @FindBy(xpath = "//ol[@id='compare-items']") WebElement listCompare;




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
    public void clickOnAddToCompareSony(){
         click(lnkAddToCompareSony);
    }
    public void clickOnAddToCompareIP(){
         click(lnkAddToCompareIP);
    }

    public void clickOnCompare(){
         click(btnCompare);
    }

    public List<String> listCompare(){

         List<String> productName= new ArrayList<>();

         List<WebElement> lis=listCompare.findElements(By.tagName("p"));
         for(WebElement li:lis){
             productName.add(li.getText());

         }

         return productName;
    }












}
