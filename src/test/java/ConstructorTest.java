import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.MainPage;
import java.time.Duration;

public class ConstructorTest {
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
    @DisplayName("Проверка переходов к разделу «Соусы»")
    public void navigationThroughMenuSauce() {
        mainPage.checkGoToTheSaucesSection();
    }

    @Test
    @DisplayName("Проверка переходов к разделу «Булки»")
    public void navigationThroughMenuBuns() {
        mainPage.clickSaucesButton();
        mainPage.checkGoToTheBunsSection();
    }

    @Test
    @DisplayName("Проверка переходов к разделу «Начинки»")
    public void navigationThroughMenuFillings() {
        mainPage.checkGoToTheFillingsSection();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}