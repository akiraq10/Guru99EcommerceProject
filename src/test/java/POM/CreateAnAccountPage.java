package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static Utilities.CommonFeatures.*;
public class CreateAnAccountPage extends MainPage{

    @FindBy(id="firstname") WebElement txtFirstName;
    @FindBy(id="middlename") WebElement txtMiddleName;
    @FindBy(id="lastname") WebElement txtLastName;
    @FindBy(id="email_address") WebElement txtEmailAddress;
    @FindBy(id="password") WebElement txtPassword;
    @FindBy(id="confirmation") WebElement txtConfirmPassword;
    @FindBy(id="is_subscribed") WebElement chkSubscribed;
    @FindBy(xpath = "//button[@title='Register']") WebElement btnRegister;



    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }
    public void fillFirstName(String firstName){
        fill(txtFirstName,firstName);
    }
    public void fillMiddleName(String middleName){
        fill(txtMiddleName,middleName);
    }
    public void fillLastName(String lastName){
        fill(txtLastName,lastName);
    }
    public void fillEmail(String email){
        fill(txtEmailAddress,email);
    }
    public void fillPassword(String password){
        fill(txtPassword,password);
    }
    public void fillConfirmPassword(String confirmPassword){
        fill(txtConfirmPassword,confirmPassword);
    }
    public void checkSubscribed(){
        check(chkSubscribed);
    }
    public void clickOnRegister(){
        click(btnRegister);
    }
}
