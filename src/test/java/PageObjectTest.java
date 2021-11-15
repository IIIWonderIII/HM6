
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.logging.Level;

@Story("CRM Geekbrains")
public class PageObjectTest {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {

        ChromeOptions options = new ChromeOptions();

        driver = new EventFiringWebDriver(new ChromeDriver(options));
        driver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://crm.geekbrains.space/");
    }

    @Test
    @Flaky
    @TmsLink("1234")
    @Feature("Заявки на расход")
    @DisplayName("Создание заявки на расход")
    @Description("Проверка создания заявки на расход")
    void loginTest() {
        new LoginPage(driver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();

        new MainPage(driver).navigationBar.openNavBarItem("Расходы");
        new ExpensesSubMenu(driver).expensesSubMenuItemClick();
        new ExpensesPage(driver).clickCreateExpenseRequest();
        new CreateExpensePage(driver)
                .fillDescription("test")
                .selectBusinessUnit("Research & Development")
                .selectExpenditure("01101 - ОС: вычислительная техника инфраструктуры")
                .selectPlannedDate("18")
                .fillInputSumPlan("100")
                .clickSaveAndCloseButton();

        webDriverWait.until(ExpectedConditions.invisibilityOf(new BaseView(driver).loader));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[.='Заявка на расход сохранена']")).isDisplayed());

        driver.get("https://docs.qameta.io/allure/latest/");
    }

    @AfterEach
    void tearDown() {
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);

        Iterator<LogEntry> iterator = browserLogs.iterator();
        while (iterator.hasNext()) {
            Allure.addAttachment("Лог в консоли браузера", iterator.next().getMessage());
        }

        for (LogEntry log: browserLogs) {
            System.out.println(log.getMessage());
        }
        driver.quit();
    }
}
