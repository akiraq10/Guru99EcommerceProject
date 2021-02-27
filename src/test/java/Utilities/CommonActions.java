package Utilities;

import Interfaces.interActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CommonActions implements interActions {

    WebDriver driver;


    public WebDriver browser(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/Webdriver/chromedriver.exe");
                ChromeOptions chromeOptions=new ChromeOptions();
//                chromeOptions.addArguments("--headless");
                chromeOptions.setAcceptInsecureCerts(true);
                driver = new ChromeDriver(chromeOptions);

                break;
            case "firefox":
                FirefoxBinary firefoxBinary =new FirefoxBinary();
//                firefoxBinary.addCommandLineOptions("--headless");
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
        driver.manage().window().maximize();
        return driver;
    }


    public WebDriver gotoHttp(String browser, String https) {
        browser(browser);
        driver.get(https);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        return driver;
    }


    public void quitBrowser() {
        driver.quit();

    }


    public void closeBrowser() {
        driver.close();

    }


    public void clickOn(WebElement element) {
        if(!element.isDisplayed()){
            System.out.println(element+"NOT displayed");
            return;
        }
        else element.click();

    }


    public void fill(WebElement element, String text) {
        if(!element.isDisplayed()){
            System.out.println(element+"NOT displayed");
            return;
        }
        else{
            element.clear();
            element.sendKeys(text);
        }

    }


    public void checkOn(WebElement element) {
        if(!element.isSelected()){
            element.click();
        }else return;


    }


    public void selectByText(WebElement element, String text) {
        if (!element.isSelected()){
            new Select(element).selectByVisibleText(text);
        }else return;

    }


    public void switchToNewWindows() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

    }
}
