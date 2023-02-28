import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.ProfilePage;
import java.time.Duration;

public class LogoutTest {
    private WebDriver driver;
    private MainPage mainPage;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        mainPage.open();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете.")
    public void logOut() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        new WebDriverWait(driver, Duration.ofSeconds(5));
        mainPage.clickAccountButton();
        profilePage.clickLogoutButton();
        loginPage.checkRegistrationIsSuccessfully();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}