package pages;

import helper_pages.ElementsActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Laptops {
    private final WebDriver driver;
    private final By ClickOnMonitorsCategory = By.xpath("/html/body/div[5]/div/div[1]/div/a[4]");

    public Laptops(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check that Laptops Category has items ")
    public Laptops checkLaptopsCategoryHasItems() {
        List<WebElement> products = driver.findElements(By.tagName("a"));
        if (products.size() > 0) {
            System.out.println("Laptops Category has " + " Products ");
        }

        return this;
    }

    @Step("Click on Laptops Category ")
    public Monitors ClickOnMonitorsCategoryFromLaptopsPage() {
        ElementsActions.click(driver, ClickOnMonitorsCategory);
        return new Monitors(driver);
    }
}
