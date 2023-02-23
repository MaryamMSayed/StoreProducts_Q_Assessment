package pages;

import helper_pages.ElementsActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CartPage {
    private final WebDriver driver;
    private final By clickOnDeleteButton = By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[4]/a");
    private final By clickOnHomePageButton = By.xpath("/html/body/nav/div/div/ul/li[1]/a");
    private final By clickOnPlaceOrderButton = By.xpath("/html/body/div[6]/div/div[2]/button");
    private final By inputUserNameAtCheckOut = By.xpath("//*[@id=\"name\"]");
    private final By inputUserCountryAtCheckOut = By.xpath("//*[@id=\"country\"]");
    private final By inputUserCityAtCheckOut = By.xpath("//*[@id=\"city\"]");
    private final By inputUserCreditCardAtCheckOut = By.xpath("//*[@id=\"card\"]");
    private final By inputUserMonthAtCheckOut = By.xpath("//*[@id=\"month\"]");
    private final By inputUserYearAtCheckOut = By.xpath("//*[@id=\"year\"]");
    private final By clickOnPurchaseButton = By.xpath("/html/body/div[3]/div/div/div[3]/button[2]");
    private final By successPurchaseMessage = By.xpath("/html/body/div[10]/h2");
    private final By closeSuccessMessagePopup = By.xpath("/html/body/div[10]/div[7]/div/button");
    SoftAssert successMessage = new SoftAssert();

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on Delete button")
    public CartPage clickOnDeleteButton() {
        ElementsActions.click(driver, clickOnDeleteButton);

        return this;
    }

    @Step("Open Home page from nav bar")
    public Homepage openHomePage() {
        ElementsActions.click(driver, clickOnHomePageButton);
        return new Homepage(driver);
    }

    @Step("Click on Place Order Button")
    public CartPage clickOnPlaceOrderButton() {
        ElementsActions.click(driver, clickOnPlaceOrderButton);
        return this;
    }

    @Step("Complete a successfull Purchase")
    public CartPage completeSuccessfullPurchase(String name, String country, String city, String creditCard, String month, String year) {
        ElementsActions.type(driver, inputUserNameAtCheckOut, name, true);
        ElementsActions.type(driver, inputUserCountryAtCheckOut, country, true);
        ElementsActions.type(driver, inputUserCityAtCheckOut, city, true);
        ElementsActions.type(driver, inputUserCreditCardAtCheckOut, creditCard, true);
        ElementsActions.type(driver, inputUserMonthAtCheckOut, month, true);
        ElementsActions.type(driver, inputUserYearAtCheckOut, year, true);
        ElementsActions.click(driver, clickOnPurchaseButton);
        return this;
    }

    @Step("Get the success Message")
    public CartPage getSuccessPopupText() {
        String SuccessMessage = driver.findElement(successPurchaseMessage).getText();
        System.out.println("Volaaaaa \uD83E\uDD73\uD83E\uDD73\uD83E\uDD73");
        successMessage.assertEquals(SuccessMessage, "Thank you for your purchase!");

        return this;
    }

    @Step("Close the purchase confirmation popup")
    public void closeSuccessMessagePopUp() {
        ElementsActions.click(driver, closeSuccessMessagePopup);
        new Homepage(driver);
    }

}
