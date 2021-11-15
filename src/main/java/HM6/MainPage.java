package HM6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseView {
    NavigationBar navigationBar;

    public MainPage(WebDriver driver) {
        super(driver);
        navigationBar = new NavigationBar(driver);
    }
}

