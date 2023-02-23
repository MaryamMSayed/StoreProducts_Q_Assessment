package pages;

import helper_pages.ElementsActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Phones {
    private final WebDriver driver;
    private final By ClickOnLapTopsCategory = By.xpath("/html/body/div[5]/div/div[1]/div/a[3]");

    public Phones(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check that Phones Category has items ")
    public Phones checkPhonesCategoryHasItems() {
        List<WebElement> products = driver.findElements(By.tagName("a"));
        if (products.size() > 0) {
            System.out.println("Phones Category has " + " Products ");
        }

        return this;
    }

    @Step("Click on Laptops Category ")
    public Laptops ClickOnLaptopsCategoryFromPhonesPage() {
        ElementsActions.click(driver, ClickOnLapTopsCategory);
        return new Laptops(driver);
    }
}
