package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Monitors {
    private final WebDriver driver;
    private final By productCommonSelector = By.cssSelector("a.hrefch");

    public Monitors(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check that Monitors Category has items ")
    public RandomProductPage checkMonitorsCategoryHasItemsAndSelectRandomItem() {
        List<WebElement> products = driver.findElements(productCommonSelector);
        if (products.size() > 0) {
            System.out.println("Monitors Category has " + " Products ");
        }
        Random random = new Random();
        products.get(random.nextInt(products.size())).click();

        return new RandomProductPage(driver);
    }
}
