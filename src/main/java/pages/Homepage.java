package pages;

import helper_pages.ElementsActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class Homepage {
    // Initiating a WebDriver
    private final WebDriver driver;

    // Inspecting Elements
    private final By ClickOnSignUpButton = By.id("signin2");
    private final By ClickOnLoginButton = By.id("login2");
    private final By SignUpUserNameTextField = By.id("sign-username");
    private final By SignUpPasswordTextField = By.id("sign-password");
    private final By ClickOnSignUpConfirmButton = By.xpath("/html/body/div[2]/div/div/div[3]/button[2]");
    private final By LoginUserNameTextField = By.id("loginusername");
    private final By LoginUserPasswordTextField = By.id("loginpassword");
    private final By LoginConfirmButton = By.xpath("/html/body/div[3]/div/div/div[3]/button[2]");
    private final By ClickOnPhonesCategory = By.xpath("/html/body/div[5]/div/div[1]/div/a[2]");
    private final By productCommonSelector = By.cssSelector("a.hrefch");


    // Create Constructor matching super
    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    //Home Page Methods
    @Step("Click on Sign up Button")
    public Homepage clickOnSignUpButtonFromHomePage() {
        ElementsActions.click(driver, ClickOnSignUpButton);
        return this;
    }

    @Step("Type User Name at Sign up Form")
    public Homepage TypeUserNameAtSignUpPopUP(String userName) {
        ElementsActions.click(driver, SignUpUserNameTextField);
        ElementsActions.type(driver, SignUpUserNameTextField, userName, true);
        return this;
    }

    @Step("Type User Password at Sign up form ")
    public Homepage TypeUserPasswordAtSignUpPopUP(String Password) {
        ElementsActions.click(driver, SignUpPasswordTextField);
        ElementsActions.type(driver, SignUpPasswordTextField, Password, true);
        return this;
    }

    @Step("Click on Sign up Button at Sign up Pop up ")
    public Homepage ClickOnSignUpButtonFromSignUpPopUp() {
        ElementsActions.click(driver, ClickOnSignUpConfirmButton);

        return this;
    }

    @Step("Accept Sign up Alert")
    public Homepage AcceptAlert() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.getText().contains("Sign up successful.");
        alert.accept();
        return this;
    }

    @Step("Click on Login Button")
    public Homepage clickOnLoginButtonFromHomePage() {
        ElementsActions.click(driver, ClickOnLoginButton);
        return this;
    }

    @Step("Type User Name at Login Form ")
    public Homepage TypeUserNameAtLoginPopup(String UserName) {
        ElementsActions.click(driver, LoginUserNameTextField);
        ElementsActions.type(driver, LoginUserNameTextField, UserName, true);
        return this;
    }

    @Step("Type User Password at Login Form ")
    public Homepage TypeUserPasswordAtLoginPopup(String Password) {
        ElementsActions.click(driver, LoginUserPasswordTextField);
        ElementsActions.type(driver, LoginUserPasswordTextField, Password, true);
        return this;
    }

    @Step(" Confirm Log in")
    public Homepage ConfirmLogin() {
        ElementsActions.click(driver, LoginConfirmButton);
        return this;
    }

    @Step("Click on Phones Category ")
    public Phones ClickOnPhonesCategoryFromHomePage() {
        ElementsActions.click(driver, ClickOnPhonesCategory);

        return new Phones(driver);
    }

    @Step("Select Random Product")
    public RandomProductPage addRandomProductToCartFromHomePage() {
        List<WebElement> products = driver.findElements(productCommonSelector);
        Random random = new Random();
        products.get(random.nextInt(products.size())).click();
        return new RandomProductPage(driver);
    }


}
