package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Utilities.CommonFeatures.click;
import static org.junit.Assert.assertEquals;

public class MyOrdersPage extends MainPage{

    @FindBy(linkText = "VIEW ORDER") WebElement lnkViewOrder;
    @FindBy(xpath = "//div[@class='page-title title-buttons']/h1") WebElement statusOrder;
    @FindBy(xpath = "//table[@id='my-orders-table']") WebElement tbMyOrders;
    @FindBy(linkText = "Print Order") WebElement lnkPrintOrder;
    public MyOrdersPage(WebDriver driver) {
        super(driver);
    }

    public void clikOnViewOrder(){
        click(lnkViewOrder);
    }
    public boolean isCheckStatusOrder(String expectedStatus){
        if(statusOrder.getText().contains(expectedStatus))
            return true;
        else return false;
    }

    public void isCheckOrderItems(String productName){
        String result ="";
        List<WebElement> trs=tbMyOrders.findElements(By.tagName("tr"));
        for(WebElement tr:trs){
            List<WebElement> tds=tr.findElements(By.tagName("td"));
            for (WebElement td:tds){

                    result=td.findElement(By.xpath("//h3[@class='product-name']")).getText();


            }
        }
        assertEquals(productName,result);
    }
    public void clickOnlnkPrintOrder(){
        click(lnkPrintOrder);
    }
}
