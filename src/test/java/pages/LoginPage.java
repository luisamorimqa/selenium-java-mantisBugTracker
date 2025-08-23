package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    String pageUrl = "/login_page.php";

    private By title = By.xpath("//*[@id='login-box']/div/div[1]/h4");
    private By userField = By.id("username");
    private By entrarButton = By.xpath("//input[@type='submit']");
    private By alertMessage = By.xpath("//div[@class='alert alert-danger']/p");

    public void getPage() {
        navigateTo("chrome", pageUrl);
    }

    public void fillUserField() {
        fillField(userField, getRegisteredUser());
    }

    public void fillUserField(String value) {
        fillField(userField, value);
    }

    public void clickEntrar() {
        clickElement(entrarButton);
    }

    public void checkAlertMessage(String value) {
        checkVisibility(alertMessage);
        checkAlertMessage(alertMessage, value);
    }

    public void checkLoginPage() {
        Assert.assertTrue(checkVisibility(title));
        Assert.assertEquals("Entrar", getTextElement(title));
    }
}
