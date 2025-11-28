package org.goquant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    private By cartUrl = By.xpath("//a[contains(@href,'cart')]");
    private By checkoutButton = By.cssSelector("a#checkout, button#checkout"); // fallback

    public CartPage(WebDriver driver){
        super(driver);
    }

    public void openCart(){
        driver.get("https://buggy.justtestit.org/cart");
    }

    public boolean isItemInCart(String productName){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + productName + "')]"))).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public void proceedToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}
