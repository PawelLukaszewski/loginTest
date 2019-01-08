package pl.pawellukaszewski;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.pawellukaszewski.universal.WebPageMethods;

public class StronaGlownaPage extends WebPageMethods {

    private WebDriver driver;
    private WebDriverWait wait;

    public StronaGlownaPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    @FindBy(xpath = StronaGlownaData.GO_TO_SERVICE)
    private WebElement goToService;
    @FindBy(xpath = StronaGlownaData.Email)
    private WebElement emailButton;
    @FindBy(xpath = StronaGlownaData.LOGIN_BUTTON)
    private WebElement clickLoginButoon;
    @FindBy(xpath = StronaGlownaData.LOGIN_LABEL)
    private WebElement loginLabel;
    @FindBy(xpath = StronaGlownaData.PASSWORD_LABEL)
    private WebElement passwordLabel;
    @FindBy(xpath = StronaGlownaData.LOGOUT_BUTTON)
    private WebElement clickLogOut;
    @FindBy(xpath = StronaGlownaData.BACK_TO_MAIN_SITE)
    private WebElement clickBacktToMainSite;


    public void clickGoToService() {
        goToService.click();
    }

    public void clickEmailButton() {
        clickHiddenElement(emailButton);
    }

    public void fillLabels(String login, String password) {
        setTextToElement(loginLabel, StronaGlownaData.FILL_LOGIN_LABEL);
        setTextToElement(passwordLabel, StronaGlownaData.FILL_PASSWORD_LABEL);
        clickLoginButoon.click();
    }



    public void clickLogOutButton() {
        clickElement(clickLogOut);
    }

    public void clickBacktToMainSite() {
        clickElement(clickBacktToMainSite);
    }

//    public void clickLoginButton() {
//        clickLoginButoon.click();
//
//    }
}