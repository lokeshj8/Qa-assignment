
package org.goquant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private By emailInput = By.id("email");          // update if different
    private By passwordInput = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get("https://buggy.justtestit.org/login");
    }

    public void login(String email, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).clear();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoginErrorDisplayed(){
        try {
            WebElement err = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));
            return err.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
}
