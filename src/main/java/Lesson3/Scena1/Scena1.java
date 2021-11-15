package Lesson3.Scena1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Scena1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);
        Thread.sleep(5000);

        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));

        WebElement expensesMenuItem = menuItems.stream().filter(e -> e.getText().equals("Проекты")).findFirst().get();

        Actions actions = new Actions(driver);
        actions.moveToElement(expensesMenuItem).build().perform();
        driver.findElement(By.xpath("//span[.='Все проекты']")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@class='btn back icons-holder-text ']")).click();

        Thread.sleep(5000);

        driver.findElement(By.name("crm_project[name]")).sendKeys("abrakadabra");

        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");

        Select selectProjectCurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        selectProjectCurator.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select selectProjectMentor = new Select(driver.findElement(By.name("crm_project[rp]")));
        selectProjectMentor.selectByVisibleText("Амелин Владимир");

        Select selectProjectAdmin = new Select(driver.findElement(By.name("crm_project[administrator]")));
        selectProjectAdmin.selectByVisibleText("Горячев Алексей");

        Select selectProjectManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        selectProjectManager.selectByVisibleText("Прохорова Алла");

        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();ßs
    }

    static void login(WebDriver driver) {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}