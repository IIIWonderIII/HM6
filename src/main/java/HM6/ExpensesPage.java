package HM6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExpensesPage extends BaseView {
    public ExpensesPage(WebDriver driver) {
        super(driver);
    }

    private final String byXpathButtonCreateExpenseRequestLocator = "//a[.='Создать заявку на расход']";
    @FindBy(xpath = byXpathButtonCreateExpenseRequestLocator)
    public WebElement buttonCreateExpenseRequest;

    @Step("Клик на кнопку создания заявки на расход")
    public CreateExpensePage clickCreateExpenseRequest() {
        webDriverWait.until(ExpectedConditions.visibilityOf(loader));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(byXpathButtonCreateExpenseRequestLocator)));
        buttonCreateExpenseRequest.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CreateExpensePage.byXpathSaveAndCloseButtonLocator)));
        return new CreateExpensePage(driver);
    }
}

