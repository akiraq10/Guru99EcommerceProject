package Interfaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface interActions {
     WebDriver browser(String browser);
     WebDriver gotoHttp(String browser,String https);
     void quitBrowser();
     void closeBrowser();
     void clickOn(WebElement element);
     void fill(WebElement element,String text);
     void checkOn(WebElement element);
     void selectByText(WebElement element,String text);
     void switchToNewWindows();

}
