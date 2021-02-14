package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static Utilities.CommonFeatures.*;
import static org.junit.Assert.assertEquals;

public class ProductComparisionListPage extends MainPage{

    @FindBy(xpath = "//h1") WebElement pageHeading;

    @FindBy(xpath = "//button[@title='Close Window']")
    WebElement btnCloseWindow;

    @FindBy(xpath = "//table/tbody[1]") WebElement tblProductComparison;


    public ProductComparisionListPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCloseWindow(){
        click(btnCloseWindow);
    }

    public void checkHeading(){
        assertEquals("COMPARE PRODUCTS",pageHeading.getText());
    }

    public List<String> listProduct(){
        List<String> products=new ArrayList<>();
        List<WebElement> tds=tblProductComparison.findElements(By.xpath("//tr//td/h2[@class='product-name']"));
        for (WebElement td:tds){
                products.add(td.getText());
           }
        return products;


    }
}
