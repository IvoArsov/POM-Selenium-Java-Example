package Pages;

import Pages.Pages.Components.ShoppingCartItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ShopingCartSummaryPage extends BasePage {

    private By productQuantityStringLocator = By.id("summary_products_quantity");
    private By shoppingCartTableLocator = By.id("cart_summary");
    private By totalPriceLocator = By.id("total_product");

    private By cartTableLocator = By.xpath("//table[@id='cart_summary']/thead/tr[1]/th");

    private By rowProductNameLocator = By.cssSelector("td.cart_description > p.product-name > a");
    private By rowSKULocator = By.cssSelector("td.cart_description > small.cart_ref");
    private By rowColorLocator = By.cssSelector("td.cart_description > small:nth-child(3) > a");
    private By rowInStockLocator = By.cssSelector("td.cart_avail > span");
    private By rowUnitPriceLocator = By.cssSelector("td.cart_unit > span.price > span.price");
    private By rowQuantityLocator = By.cssSelector("td.cart_quantity > input.cart_quantity_input");
    private By rowTotalPriceLocator = By.cssSelector("td.cart_total > span.price");

    private By rowProductImageLinkLocator = By.cssSelector("td.cart_product > a");
    private By rowProductNameLinkLocator = By.cssSelector("td.cart_product > a");
    private By rowIncreaseQuantityButtonLocator = By.cssSelector("td.cart_product > a");
    private By rowDecreaseQuantityButtonLocator = By.cssSelector("td.cart_product > a");
    private By rowRemoveProductButtonLocator = By.cssSelector("td.cart_product > a");

    public ShopingCartSummaryPage(WebDriver browserDriver){
        super(browserDriver);

        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityStringLocator));
    }

    public int getQuantityOfCheckoutProducts(){
        String productQuantityString = browser.findElement(productQuantityStringLocator).getText();
        int spaceLocation = productQuantityString.indexOf(" ");
        int numProducts = Integer.parseInt(productQuantityString.substring(0, spaceLocation));
        return numProducts;
    }

    public List<ShoppingCartItem> getShoppingCart() throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartTableLocator));
        //validateShoppingCart();
        WebElement shoppingCartTable = browser.findElement(shoppingCartTableLocator);
        List<WebElement> tableRows = shoppingCartTable.findElements(By.cssSelector("tbody > tr"));
        List<ShoppingCartItem> cartItems = new ArrayList<ShoppingCartItem>();

        for (WebElement row : tableRows) {
            ShoppingCartItem cartItem = new ShoppingCartItem();

            cartItem.setProductName(row.findElement(rowProductNameLocator).getText().trim());
            cartItem.setSKU(row.findElement(rowSKULocator).getText().trim());
            cartItem.setColor(row.findElement(rowColorLocator).getText().trim());
            cartItem.setInStock(row.findElement(rowInStockLocator).getText().trim().toLowerCase().equals("in stock"));
            cartItem.setUnitPrice(Double.parseDouble(row.findElement(rowUnitPriceLocator).getText().trim().substring(1)));
            cartItem.setQuantity(Integer.parseInt(row.findElement(rowQuantityLocator).getAttribute("value")));
            cartItem.setTotalPrice((int) Double.parseDouble(row.findElement(rowTotalPriceLocator).getText().trim().substring(1)));

            cartItem.setProductImageLink(row.findElement(rowProductImageLinkLocator));
            cartItem.setProductNameLink(row.findElement(rowProductNameLinkLocator));
            cartItem.setIncreaseQuantityBtn(row.findElement(rowIncreaseQuantityButtonLocator));
            cartItem.setDecreaseQuantityBtn(row.findElement(rowDecreaseQuantityButtonLocator));
            cartItem.setRemoveProductBtn(row.findElement(rowRemoveProductButtonLocator));

            cartItems.add(cartItem);
        }

        return cartItems;
    }
}
