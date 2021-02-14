package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CommonFeatures {

    public static WebDriver driver;


    public static WebDriver Browser(String browser){
        switch (browser) {
            case "chrome":
                break;
            case "firefox":
                FirefoxBinary firefoxBinary =new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                System.setProperty("webdriver.gecko.driver", "src/test/Webdriver/geckodriver.exe");
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                firefoxOptions.setAcceptInsecureCerts(true);

                driver=new FirefoxDriver(firefoxOptions);
                break;
            default:
                System.out.printf(browser + "NOT existing");
                break;


        }
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        return driver;
    }

    public static WebDriver gotoWebsite(String browser,String url){
        Browser(browser);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        return driver;
    }

    public static void quit(){
        driver.quit();
    }
    public static void close(){driver.close();}




    public static void click(WebElement element){
        if(!element.isDisplayed()){
            System.out.println(element+"NOT displayed");
            return;
        }
        else element.click();
    }

    public static void fill(WebElement element,String text){
        if(!element.isDisplayed()){
            System.out.println(element+"NOT displayed");
            return;
        }
        else{
            element.clear();
            element.sendKeys(text);
        }
    }

    public static void selectByText(WebElement element,String text){
        if (!element.isSelected()){
            new Select(element).selectByVisibleText(text);
        }else return;
    }

    public static String getMainWindows(){
        return driver.getWindowHandle();
    }
    public static void switchToChildWindow(String mainWindow){


        // To handle all new opened window.
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();

        while(i1.hasNext())
        {
            String ChildWindow=i1.next();

            if(!mainWindow.equalsIgnoreCase(ChildWindow))
            {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);

            }
        }

    }

    public static void switchToParentWindows(String mainWindow){

        driver.switchTo().window(mainWindow);
    }

    public static void switchToNewWindows(){
        // switching to new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }


    public static void takeScreenShot(WebDriver driver, String filename)throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File desFile=new File("./src/test/IMG/"+filename+".png");
        FileUtils.copyFile(srcFile,desFile);

    }

    public static boolean compareList(List ls1, List ls2){
        return ls1.toString().contentEquals(ls2.toString())?true:false;
    }
}
