package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

public class MyDashBoardPage extends MainPage{

    @FindBy(className = "success-msg") WebElement msgRegisterSuccessful;

    public MyDashBoardPage(WebDriver driver) {
        super(driver);
    }

    public void checkRegisterSuccessful(){
        assertEquals("Thank you for registering with Main Website Store.",msgRegisterSuccessful.getText());
    }
}
