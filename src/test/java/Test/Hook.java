package Test;

import Interfaces.interActions;
import POM.MainPage;
import Utilities.CommonActions;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

//import static Utilities.CommonFeatures.*;

public class Hook extends CommonActions implements interActions {
    String email="emailtext12@gmail.com";
    String pass="123456";

    WebDriver driver;
    MainPage mainPage;
    @BeforeTest
    public void setup(){
        driver=gotoHttp("firefox","http://live.demoguru99.com/index.php/");

    }
    @AfterTest
    public void tearDown(){
        closeBrowser();

    }
}
