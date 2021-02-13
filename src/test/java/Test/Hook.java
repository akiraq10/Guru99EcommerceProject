package Test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static Utilities.CommonFeatures.*;

public class Hook {

    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver=gotoWebsite("firefox","http://live.demoguru99.com/index.php/");

    }
    @AfterTest
    public void tearDown(){
        close();

    }
}
