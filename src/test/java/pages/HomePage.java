package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    String pageUrl = "/account_page.php";

    private By titleHomePage = By.xpath("//*[@id='navbar-container']/div[1]/a/span");
    private By userButton = By.xpath("//a[@data-toggle='dropdown']/i[2]");
    private By sairButton = By.xpath("//*[@id='navbar-container']/div[2]/ul/li[3]/ul/li[4]/a/i");

    public void getUrl() {
        navigateTo(pageUrl);
    }

    public void checkTitle() {
        Assert.assertEquals("MantisBT", getTextElement(titleHomePage));
    }

    public void clickSair() {
        clickElement(userButton);
        clickElement(sairButton);
    }

    public void checkPage() {
        checkTitle();
    }
}
