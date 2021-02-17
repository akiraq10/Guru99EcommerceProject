package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static Utilities.CommonFeatures.*;

public class LoginOrCreateanAccountPage extends MainPage{

    @FindBy(id="email") WebElement txtEmail;
    @FindBy(id="pass") WebElement txtPassword;
    @FindBy(linkText = "Forgot Your Password?") WebElement lnkForgotYourPassword;
    @FindBy(xpath = "//button[@title='Login']") WebElement btnLogin;




    public LoginOrCreateanAccountPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmail(String email){
        fill(txtEmail,email);
    }
    public void fillPassword(String pass){
        fill(txtPassword,pass);
    }
    public void clickOnLogin(){
        click(btnLogin);
    }

    public void loginToAccount(String email, String pass){
        fillEmail(email);
        fillPassword(pass);
        clickOnLogin();
    }
}
