package pl.pawellukaszewski;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.pawellukaszewski.cfg.WebDriverConfig;

public class RejestracaKontaTest {

    private StronaGlownaPage stronaGlownaPage;

    private boolean init = true;


    @BeforeMethod
    public void init() {
        if (init) {
            WebDriverConfig.Initialize();
            stronaGlownaPage = PageFactory.initElements(WebDriverConfig.getWebDriverInstance(), StronaGlownaPage.class);
            init = false;
        }

    }

    @Test
    public void zarejestrujUzytkownika() {
        WebDriverConfig.getWebDriverInstance().get(StronaGlownaData.WEBSITE_URL);
        stronaGlownaPage.clickGoToService();
        stronaGlownaPage.clickEmailButton();
        stronaGlownaPage.fillLabels(StronaGlownaData.FILL_LOGIN_LABEL, StronaGlownaData.FILL_PASSWORD_LABEL);
        stronaGlownaPage.clickLogOutButton();
        stronaGlownaPage.clickBacktToMainSite();

    }


//    @AfterMethod
//    public void close() {
//        WebDriverConfig.closeDriver();
//    }

}
