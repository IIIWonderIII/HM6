package HM6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(id = "_submit")
    public WebElement buttonLogin;

    @Step("Заполняем поле логин")
    public LoginPage fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполняем поле пароль")
    public LoginPage fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку входа")
    public void submitLogin() {
        buttonLogin.click();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}

