package helper_pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperPages {
    static WebDriverWait wait;

    public static WebDriverWait getExplicitWait(WebDriver driver) {
        return wait = new WebDriverWait(driver, 10);
    }

    public static void actions(WebDriver driver, By by, ActionType actionType) {
        Actions actions = new Actions(driver);
        switch (actionType) {
            case MOUSE_HOVER:
                actions.moveToElement(driver.findElement(by)).perform();
                break;
            case DOUBLE_CLICK:
                actions.doubleClick(driver.findElement(by)).perform();
                break;
        }
    }


    public enum ActionType {
        MOUSE_HOVER, DOUBLE_CLICK
    }


}

