package POM;

import Interfaces.interActions;
import Utilities.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

//import static Utilities.CommonFeatures.*;
import static org.junit.Assert.assertEquals;

public class MainPage extends CommonActions implements interActions {

    WebDriver driver;

    @FindBy(linkText = "MOBILE")
    WebElement lnkMOBILE;

    @FindBy(linkText = "TV")
    WebElement lnkTV;

    @FindBy(linkText = "ACCOUNT") WebElement lnkACCOUNT;
    @FindBy(linkText = "Register") WebElement lnkRegisterAccount;
    @FindBy(linkText = "My Account") WebElement lnkMyAccount;

    @FindBy(tagName = "h2")
    WebElement pageContain;

    public MainPage(WebDriver driver){

        this.driver=driver;
        //This initElements method will create all WebElements
        AjaxElementLocatorFactory ajax=new AjaxElementLocatorFactory(driver,30);
        PageFactory.initElements(ajax, this);


    }

    public void isCheckPageTitle(String namePage){
        assertEquals(namePage,driver.getTitle());

    }
    public void clickOnMOBILE(){
        clickOn(lnkMOBILE);
    }

    public void cliccOnTV(){
        clickOn(lnkTV);
    }
    public void clickOnAccount(){
        clickOn(lnkACCOUNT);
    }
    public void clickOnRegisterAccount(){
        clickOn(lnkRegisterAccount);
    }
    public void clickOnMyAccount(){
        clickOn(lnkMyAccount);
    }




}
