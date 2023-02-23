package pages;

import helper_pages.ElementsActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RandomProductPage {
    private final WebDriver driver;
    private final By clickOnAddToCartButton = By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a");
    private final By OpenCartPage = By.id("cartur");

    public RandomProductPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Add the selected product to cart")
    public RandomProductPage addTheSelectedRandomItemToCart() {
        ElementsActions.click(driver, clickOnAddToCartButton);
        return this;
    }

    @Step("Accept Add to cart Alert")
    public RandomProductPage acceptAlert() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.getText().contains("Product added.");
        alert.accept();
        return this;
    }

    @Step("Open Cart Page ")
    public CartPage openCartPage() {
        ElementsActions.click(driver, OpenCartPage);
        return new CartPage(driver);
    }
}
