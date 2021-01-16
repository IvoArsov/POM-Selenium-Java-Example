package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver browser;
    WebDriverWait wait;

    private By logInLinkLocator = By.cssSelector("a.login");
    private By siteLogoLocator = By.cssSelector("#header_logo > a");


    public BasePage(WebDriver browserDriver){

        browser = browserDriver;
        // Wait for page load
        wait = new WebDriverWait(browser, 10);
    }

    protected void waitForPageTitle(String pageTitle){
        wait.until(ExpectedConditions.titleContains(pageTitle));
    }

    public LoginPage navigateToLoginPage(){
        WebElement logInLink = browser.findElement(logInLinkLocator);
        logInLink.click();
        return new LoginPage(browser);
    }

    public HomePage navigateToHomePage(){
        WebElement backToHomeBtn = browser.findElement(siteLogoLocator);
        backToHomeBtn.click();
        return new HomePage(browser);
    }
}
