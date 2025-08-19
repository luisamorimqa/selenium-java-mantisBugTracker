package pages;

import org.openqa.selenium.By;

public class LoginPasswordPage extends BasePage {

    String pageUrl = "/login_password_page.php";

    private By passwordField = By.id("password");
    private By entrarButton = By.xpath("//input[@type='submit']");

    public void getPage() {
        navigateTo(pageUrl);
    }

    public void fillPasswordField(){
        fillField(passwordField, getRegisteredPassword());
    }

    public void fillPasswordField(String value) {
        fillField(passwordField, value);
    }

    public void fillInvalidPassword() {
        fillField(passwordField, getInvalidPassword());
    }

    public void clickEntrar() {
        clickElement(entrarButton);
    }
}