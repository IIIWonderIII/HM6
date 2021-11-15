package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HMCrmTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);
        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a/span[.='Расходы']"))).build().perform();
        driver.findElement(By.xpath("//span[.='Заявки на расходы']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[.='Создать заявку на расход']")).click();

        Thread.sleep(5000);
        driver.findElement(By.name("crm_expense_request[description]")).sendKeys("test");

        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_expense_request[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");

        Select expendetureSelect = new Select(driver.findElement(By.name("crm_expense_request[expenditure]")));
        expendetureSelect.selectByVisibleText("04102 - Лицензии и патенты");

        driver.findElement(By.name("crm_expense_request[sumPlan]")).sendKeys("125");
        driver.findElement(By.xpath("//input[contains(@id,'datePlan')and @placeholder='Укажите дату']")).click();
        driver.findElement(By.xpath("//a[.='12']")).click();
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();

        Thread.sleep(5000);
        driver.quit();
    }
    static void login(WebDriver driver){
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}

