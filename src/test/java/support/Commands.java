package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class Commands extends RunCucumber {

    private static Properties properties;

    static {
        try(InputStream input = new FileInputStream("src/test/resources/credentials.properties")) {
            properties = new Properties();
            properties.load(input);
        }
        catch(Exception exception) {
            throw new RuntimeException("Erro ao carregar arquivo credentials.properties", exception);
        }
    }

    public void waitElementBeClickable(By element, Integer time) {
        WebDriverWait wait = new WebDriverWait(getDriver(), time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementBeVisible(By element, Integer time) {
        WebDriverWait wait = new WebDriverWait(getDriver(), time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public String getTextElement(By element) {
        waitElementBeVisible(element, 5);
        return getDriver().findElement(element).getText();
    }

    public boolean checkVisibility(By element) {
        waitElementBeVisible(element, 5);
        return getDriver().findElement(element).isDisplayed();
    }

    public void fillField(By element, String value) {

        try {
            System.out.println("Preenchendo o campo " + element);
            waitElementBeClickable(element, 5);
            getDriver().findElement(element).clear();
            getDriver().findElement(element).sendKeys(value);
        }
        catch(Exception exception) {
            throw new RuntimeException("Erro ao preencher o elemento: " + element);
        }
    }

    public void clickElement(By element) {

        try {
            System.out.println("Clicando no elemento " + element);
            waitElementBeClickable(element,5);
            getDriver().findElement(element).click();
        }
        catch(Exception exception) {
            throw new RuntimeException("Erro ao clicar no elemento: " + element);
        }
    }

    public void checkAlertMessage(By element, String value) {
        checkVisibility(element);
        Assert.assertEquals("Mensagem de alerta não corresponde ao esperado!", value, getTextElement(element));
    }

    public String getRegisteredUser() {
        return properties.getProperty("username");
    }

    public String getRegisteredPassword() {
        return properties.getProperty("password");
    }

    public String getInvalidPassword() {

        Random random = new Random();
        return "Pass" + random.nextInt(999999);
    }
}