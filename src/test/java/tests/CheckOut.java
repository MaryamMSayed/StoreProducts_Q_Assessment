package tests;

import data.LoadProperties;
import helper_tests.Helper;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Homepage;

import java.util.concurrent.TimeUnit;

public class CheckOut {
    public static WebDriver driver;
    String userName = LoadProperties.userData.getProperty("username");
    String Password = LoadProperties.userData.getProperty("password");
    String Name = LoadProperties.userData.getProperty("name");
    String Country = LoadProperties.userData.getProperty("country");
    String City = LoadProperties.userData.getProperty("city");
    String creditCard = LoadProperties.userData.getProperty("creditCard");
    String Month = LoadProperties.userData.getProperty("month");
    String Year = LoadProperties.userData.getProperty("year");


    @Parameters("browser")
    @BeforeClass
    public void startDriver(@Optional("firefox") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://www.demoblaze.com/index.html");
    }

    @Test(description = "Complete successful checkout with random item")
    @Description("User Will be able to Sign up , Then Login , Then Check all Categories have items  " +
            "Add random item to the cart " + "Remove the Item " + "Add the Item Again" +
            "And Then Log out")
    @Severity(SeverityLevel.CRITICAL)
    public void testUserCanCompleteSuccessfulCheckoutWithRandomItem() {
        new Homepage(driver).clickOnSignUpButtonFromHomePage().TypeUserNameAtSignUpPopUP(userName)
                .TypeUserPasswordAtSignUpPopUP(Password).ClickOnSignUpButtonFromSignUpPopUp().AcceptAlert()
                .clickOnLoginButtonFromHomePage().TypeUserNameAtLoginPopup(userName)
                .TypeUserPasswordAtLoginPopup(Password).ConfirmLogin().ClickOnPhonesCategoryFromHomePage()
                .checkPhonesCategoryHasItems().ClickOnLaptopsCategoryFromPhonesPage()
                .checkLaptopsCategoryHasItems().ClickOnMonitorsCategoryFromLaptopsPage()
                .checkMonitorsCategoryHasItemsAndSelectRandomItem().addTheSelectedRandomItemToCart().acceptAlert().openCartPage().clickOnDeleteButton()
                .openHomePage().addRandomProductToCartFromHomePage().addTheSelectedRandomItemToCart().acceptAlert().openCartPage()
                .clickOnPlaceOrderButton().completeSuccessfullPurchase(Name, Country, City, creditCard, Month, Year).getSuccessPopupText().closeSuccessMessagePopUp();


    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());

        }
    }

    @AfterClass
    public void stopDriver() {

        driver.quit();
    }
}
