package pageobjects;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.startsWith;

public class LoginPage {
    private final WebDriver driver;
    private final String urlPage = "https://stellarburgers.nomoreparties.site/login";
    private final String email = "test@test.ts";
    private final String password = "12345678";

    //кнопка зарегистрироваться внизу страницы
    private final By registerButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    //кнопка восстановить пароль
    private final By restorePasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    //кнопка войти
    private final By signInButton = By.xpath(".//button[text()='Войти']");
    //поле ввода почты в окне входа
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    //поле ввода пароля в окне входа
    private final By passwordField = By.xpath(".//*[text()='Пароль']/following-sibling::input");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(urlPage);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Проверка успешной регистрации")
    public void checkRegistrationIsSuccessfully() {
        String textOfRestorePasswordButton = driver.findElement(restorePasswordButton).getText();
        MatcherAssert.assertThat(textOfRestorePasswordButton, startsWith("Восстановить пароль"));
    }

    @Step("Заполнение полей email и пароль")
    public void enterEmailAndPassword() {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void clickRestorePasswordButton() {
        driver.findElement(restorePasswordButton).click();
    }
}
