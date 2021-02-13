package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SonyPage extends MobilePage{

    @FindBy(id = "product-price-1")
    WebElement price;


    public SonyPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice(){
        return priceSONY.getText();
    }
}
