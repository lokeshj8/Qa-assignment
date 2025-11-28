package org.goquant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private By searchBox = By.name("search"); // update if needed
    private By firstProduct = By.cssSelector(".product-list .product-card a"); // example

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get("https://buggy.justtestit.org/");
    }

    public void search(String keyword){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).clear();
        driver.findElement(searchBox).sendKeys(keyword);
        driver.findElement(searchBox).submit();
    }

    public void openFirstProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
    }
}
