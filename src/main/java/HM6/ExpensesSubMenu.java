package HM6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExpensesSubMenu extends BaseView {

    public ExpensesSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Заявки на расходы']")
    public WebElement expensesSubMenuItem;

    @Step("Клик на подменю 'Заявки на расходы'")
    public void expensesSubMenuItemClick() {
        expensesSubMenuItem.click();
    }
}

