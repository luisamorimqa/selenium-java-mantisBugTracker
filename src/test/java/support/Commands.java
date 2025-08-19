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

    public void waitElementBeClickable(By element, Integer time) {
        WebDriverWait wait = new WebDriverWait(getDriver(), time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementBeVisible(By element, Integer time) {
        WebDriverWait wait = new WebDriverWait(getDriver(), time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public String getTextElement(By element) {
        waitElementBeVisible(element, 5000);
        return getDriver().findElement(element).getText();
    }

    public boolean checkVisibility(By element) {
        waitElementBeVisible(element, 5000);
        return getDriver().findElement(element).isDisplayed();
    }

    public void fillField(By element, String value) {
        System.out.println("###############################################################################");
        try {
            System.out.println("*************** Preenchendo o campo " + element + " ***************");
            waitElementBeClickable(element, 5000);
            getDriver().findElement(element).sendKeys(value);
            System.out.println("*************** Campo preenchido ***************");
        }
        catch(Exception exception) {
            System.out.println("*************** Ocorreu um erro ao preencher o elemento " + element + " ***************");
            System.out.println(exception);
        }
    }

    public void clickElement(By element) {
        System.out.println("###############################################################################");
        try {
            System.out.println("*************** Clicando no elemento " + element + " ***************");
            waitElementBeClickable(element,5000);
            getDriver().findElement(element).click();
            System.out.println("*************** Clique realizado ***************");
        }
        catch(Exception exception) {
            System.out.println("*************** Ocorreu um erro ao clicar no elemento " + element + " ***************");
            System.out.println(exception);
        }
    }

    public void checkAlertMessage(By element, String value) {
        checkVisibility(element);
        Assert.assertEquals(value, getTextElement(element));
    }

    public String getRegisteredUser() {
        Properties properties = new Properties();

        try(InputStream input = new FileInputStream("src/test/resources/credentials.properties")) {
            properties.load(input);
            return properties.getProperty("username");
        } catch (Exception exception) {
            return String.valueOf(exception);
        }
    }

    public String getRegisteredPassword() {
        Properties properties = new Properties();

        try(InputStream input = new FileInputStream("src/test/resources/credentials.properties")) {
            properties.load(input);
            return properties.getProperty("password");
        }
        catch(Exception exception) {
            return String.valueOf(exception);
        }
    }

    public String getInvalidPassword() {

        Random random = new Random();
        return "Pass" + random.nextInt(999999);
    }
}