package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class ProjectCreatedPage extends BasePage {

    String pageUrl = "/manage_proj_create.php";

    private By successMessage = By.xpath("//*[@id='main-container']/div[2]/div[2]/div/div/div/div[2]/p");

    public void validaUrl() {
        checkUrl(pageUrl);
    }

    public void checkSuccessMessage(String value) {
        String message = getTextElement(successMessage);
        Assert.assertEquals(value, message);
    }
}