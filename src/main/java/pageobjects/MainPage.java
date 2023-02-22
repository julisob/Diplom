package pageobjects;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.hamcrest.CoreMatchers.startsWith;

public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public void open() {
        driver.get(urlPage);
    }

    //страница
    private final String urlPage = "https://stellarburgers.nomoreparties.site/";

    //кнопка "Личный кабинет"
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    //кнопка войти в аккаунт
    private final By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");

    //кнопка оформить заказ
    private final By makeOrderButton = By.xpath(".//button[contains(text(),'Оформить заказ')]");

    //кнопка булки
    private final By bunsButton = By.xpath(".//div[span[text()='Булки']]");

    //кнопка соусы
    private final By saucesButton = By.xpath(".//div[span[text()='Соусы']]");

    //кнопка начинки
    private final By fillingsButton = By.xpath(".//div[span[text()='Начинки']]");

    public void clickAccountButton() {
        driver.findElement(personalAccountButton).click();
    }
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
    public void checkOrderButton() {
        String textOrderButton = driver.findElement(makeOrderButton).getText();
        MatcherAssert.assertThat(textOrderButton, startsWith("Оформить заказ"));
    }
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }
    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }
    public void clickFillingsButton() {
        driver.findElement(fillingsButton).click();
    }
    public MainPage checkGoToTheBunsSection(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // time out after 5 seconds
        clickBunsButton();
        wait.until(ExpectedConditions.attributeContains(bunsButton,
                "class",
                "tab_tab_type_current"));
        return this;
    }
    public MainPage checkGoToTheSaucesSection(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // time out after 5 seconds
        clickSaucesButton();
        wait.until(ExpectedConditions.attributeContains(saucesButton,
                "class",
                "tab_tab_type_current"));
        return this;
    }
    public MainPage checkGoToTheFillingsSection(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // time out after 5 seconds
        clickFillingsButton();
        wait.until(ExpectedConditions.attributeContains(fillingsButton,
                "class",
                "tab_tab_type_current"));
        return this;
    }
}
