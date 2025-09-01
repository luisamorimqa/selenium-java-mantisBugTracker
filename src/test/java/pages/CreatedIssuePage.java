package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class CreatedIssuePage extends BasePage {

    private By successMessage = By.xpath("//*[@id='main-container']/div[2]/div[2]/div/div/div/div[2]/p");

    public void checkSuccessMessage(String value) {
        String message = getTextElement(successMessage);
        Assert.assertEquals(value, message);
    }
}
