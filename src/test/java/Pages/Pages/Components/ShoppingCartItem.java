package Pages.Pages.Components;

import org.openqa.selenium.WebElement;

public class ShoppingCartItem {

    private String productName;
    private String SKU;
    private String color;
    private boolean inStock;
    private double unitPrice;
    private int quantity;
    private int totalPrice;

    private WebElement productImageLink;
    private WebElement productNameLink;
    private WebElement increaseQuantityBtn;
    private WebElement decreaseQuantityBtn;
    private WebElement removeProductBtn;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setProductImageLink(WebElement productImageLink) {
        this.productImageLink = productImageLink;
    }

    public void setProductNameLink(WebElement productNameLink) {
        this.productNameLink = productNameLink;
    }

    public void setIncreaseQuantityBtn(WebElement increaseQuantityBtn) {
        this.increaseQuantityBtn = increaseQuantityBtn;
    }

    public void setDecreaseQuantityBtn(WebElement decreaseQuantityBtn) {
        this.decreaseQuantityBtn = decreaseQuantityBtn;
    }

    public void setRemoveProductBtn(WebElement removeProductBtn) {
        this.removeProductBtn = removeProductBtn;
    }

    public void clickProductImage(){
        productImageLink.click();
    }

    public void clickProductName(){
        productNameLink.click();
    }

    public void increaseQuantity(){
        increaseQuantityBtn.click();
    }

    public void decreaseQuantity(){
        decreaseQuantityBtn.click();
    }

    public void removeProductFromBasket(){
        removeProductBtn.click();
    }
}
