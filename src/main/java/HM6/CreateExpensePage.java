package HM6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateExpensePage extends BaseView {
    public CreateExpensePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_expense_request[description]")
    public WebElement inputDescription;

    @Step("Заполнить описание")
    public CreateExpensePage fillDescription(String description) {
        inputDescription.sendKeys(description);
        return this;
    }

    @FindBy(name = "crm_expense_request[businessUnit]")
    public WebElement selectBusinessUnit;

    @Step("Выбрать бизнес юнит")
    public CreateExpensePage selectBusinessUnit(String option) {
        new Select(selectBusinessUnit).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_expense_request[expenditure]")
    public WebElement selectExpenditure;

    @Step("Выбрать Expenditure")
    public CreateExpensePage selectExpenditure(String option) {
        new Select(selectExpenditure).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'datePlan') and @placeholder='Укажите дату']")
    public WebElement plannedDate;

    @FindBy(xpath = "//a[contains(@class,'ui-state-default')]")
    public List<WebElement> calendarDates;

    @Step("Выбрать планируемую дату")
    public CreateExpensePage selectPlannedDate(String date) {
        plannedDate.click();
        calendarDates.stream().filter(element -> element.getText().equals(date)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_expense_request_sumPlan-uid')]")
    public WebElement inputSumPlan;

    @Step("Выбрать сумму")
    public CreateExpensePage fillInputSumPlan(String sum) {
        inputSumPlan.sendKeys(sum);
        return this;
    }

    public static final String byXpathSaveAndCloseButtonLocator = "//button[contains(., 'Сохранить и закрыть')]";
    @FindBy(xpath = byXpathSaveAndCloseButtonLocator)
    public WebElement saveAndCloseButton;

    @Step("Нажать на кнопку сохранения")
    public CreateExpensePage clickSaveAndCloseButton() {
        saveAndCloseButton.click();
        return this;
    }
}

