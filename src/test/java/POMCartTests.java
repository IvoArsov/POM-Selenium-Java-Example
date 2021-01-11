import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Pages.*;

// Linear Shopping Cart tests for Java
public class POMCartTests {

    @Test
    public void POMAddToCartTest() {

        // initialisation
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, 10);
        browser.manage().window().maximize();

        // go to website
        browser.get("http://automationpractice.com/");

        // navigate to login page
        HomePage homePage = new HomePage(browser);
        homePage.navigateToLoginPage();

        // login
        LoginPage loginPage = new LoginPage(browser);
        loginPage.login("arsov.ivaylo@gmail.com", "pass547*");

        // back to home page
        UserAccountPage userAccountPage = new UserAccountPage(browser);
        userAccountPage.navigateToHomePage();

        // select the first product
//        List<WebElement> productNameLinks = homePage.getProductNameLinks();
//        productNameLinks.get(0).click();
        homePage.selectFirstProduct();


        // add 1 item to the shopping cart
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(browser);
        productDetailsPage.addProductToCart();

        // proceed to checkout
        AddToCartConfirmationPopUp addToCartConfirmationPopUp = new AddToCartConfirmationPopUp(browser);
        addToCartConfirmationPopUp.proceedToCheckout();

        // verify we have 1 item in the shopping cart
        ShopingCartSummaryPage shopingCartSummaryPage = new ShopingCartSummaryPage(browser);
        int numProducts = shopingCartSummaryPage.getQuantityOfCheckoutProducts();

        assertEquals(numProducts, 1, "Expected number of products in shopping cart was 1 but actual value was: " + Integer.toString(numProducts));

        browser.quit();
    }
}
