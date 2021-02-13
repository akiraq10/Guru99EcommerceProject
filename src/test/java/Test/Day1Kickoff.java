package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import static org.junit.Assert.assertEquals;

public class Day1Kickoff {

    public static void main(String[] args) throws IOException {

        FirefoxBinary firefoxBinary =new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");

        System.setProperty("webdriver.gecko.driver", "src/test/Webdriver/geckodriver.exe");

        FirefoxOptions firefoxOptions=new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        firefoxOptions.setAcceptInsecureCerts(true);


        WebDriver driver=new FirefoxDriver(firefoxOptions);
        driver.get("http://live.demoguru99.com/index.php/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);


        //check title page
        assertEquals("Home page",driver.getTitle());

        String pageContain=driver.findElement(By.tagName("h2")).getText();
        assertEquals("THIS IS DEMO SITE FOR   ",pageContain);

        //click Mobile menu
        driver.findElement(By.linkText("MOBILE")).click();
        assertEquals("Mobile",driver.getTitle());

        //select sort by NAME
        new Select(driver.findElement(By.tagName("select"))).selectByVisibleText("Name");
        takeScreenShot(driver,"sort by name");




       driver.quit();

    }

    public static void takeScreenShot(WebDriver driver,String filename)throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File desFile=new File("./src/test/IMG/"+filename+".png");
        FileUtils.copyFile(srcFile,desFile);

    }
}
