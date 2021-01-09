package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAccountPage {

    WebDriver browser;
    WebDriverWait wait;

    public UserAccountPage(WebDriver browserDriver){
        browser = browserDriver;

        // Wait for page load
        WebDriverWait wait = new WebDriverWait(browser, 10);
    }

    public void backToHomePage(){
        WebElement backToHomeBtn = browser.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a/i"));
        backToHomeBtn.click();
    }
}
