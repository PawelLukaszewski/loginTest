package pl.pawellukaszewski.universal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.pawellukaszewski.cfg.WebDriverConfig;

public class WebPageMethods {

    private WebDriverWait wait = new WebDriverWait(WebDriverConfig.getWebDriverInstance(), 10);

    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    protected void clickHiddenElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverConfig.getWebDriverInstance();
        js.executeScript("arguments[0].click();", element);
    }

    protected void setTextToElement(WebElement element, String textToSet) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(textToSet);
    }

    protected boolean isTextPresent(String xpath) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (TimeoutException e) {
            return false;
        }
        return WebDriverConfig.getWebDriverInstance().findElement(By.xpath(xpath)).isDisplayed();
    }

    protected void waitUntilVisibility(By whichSelector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(whichSelector));
    }

    protected void waitUntilElementIsHidden(By whichSelector) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(whichSelector));
    }

    protected void selectValueDropDown(String byWhichSelector, String textOrValue, boolean isByText) {
        Select selectCountry = new Select(WebDriverConfig.getWebDriverInstance().findElement(By.id(byWhichSelector)));
        if (isByText) {
            selectCountry.selectByVisibleText(textOrValue);
        } else {
            selectCountry.selectByValue(textOrValue);
        }
    }
}
