package support;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.LoginPasswordPage;
import runner.RunCucumber;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class Commands extends RunCucumber {

    private static Properties properties;
    private WebDriverWait wait;

    private WebDriverWait getWait() {
        if (wait == null) {
            WebDriver driver = getDriver();
            if (driver == null) {
                throw new IllegalStateException("Driver ainda não foi inicializado!");
            }
            wait = new WebDriverWait(driver, 10);
        }
        return wait;
    }

    static {
        try (InputStream input = new FileInputStream("src/test/resources/credentials.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (Exception exception) {
            throw new RuntimeException("Erro ao carregar arquivo credentials.properties", exception);
        }
    }

    public String getRegisteredUser() {
        return properties.getProperty("username");
    }

    public String getRegisteredPassword() {
        return properties.getProperty("password");
    }

    public void waitElementBeClickable(By element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementBeVisible(By element) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public String getTextElement(By element) {
        waitElementBeVisible(element);
        return getDriver().findElement(element).getText();
    }

    public boolean checkVisibility(By element) {
        waitElementBeVisible(element);
        return getDriver().findElement(element).isDisplayed();
    }

    public void fillField(By element, String value) {

        try {
            System.out.println("Preenchendo o campo " + element);
            waitElementBeClickable(element);
            getDriver().findElement(element).clear();
            getDriver().findElement(element).sendKeys(value);
        } catch (Exception exception) {
            throw new RuntimeException("Erro ao preencher o elemento: " + element);
        }
    }

    public void clickElement(By element) {

        try {
            System.out.println("Clicando no elemento " + element);
            waitElementBeClickable(element);
            getDriver().findElement(element).click();
        } catch (Exception exception) {
            throw new RuntimeException("Erro ao clicar no elemento: " + element);
        }
    }

    public void checkAlertMessage(By element, String value) {
        checkVisibility(element);
        Assert.assertEquals("Mensagem de alerta não corresponde ao esperado!", value, getTextElement(element));
    }

    public void selectCombobox(By element, String value) {
        try {
            WebElement comboBox = getDriver().findElement(element);
            Select comboSelect = new Select(comboBox);
            comboSelect.selectByVisibleText(value);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void clickCheckBox(By element, boolean check) {
        WebElement checkBox = getDriver().findElement(element);
        boolean isChecked = Boolean.parseBoolean(checkBox.getAttribute("checked"));

        if(isChecked != check) {
            try {
                checkBox.click();
            } catch (ElementClickInterceptedException e) {
                WebElement span = checkBox.findElement(By.xpath("following-sibling::span"));
                span.click();
            } catch (Exception e) {
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", checkBox);
            }
        }
    }

    public void loginAdmin() {
        LoginPage loginPage = new LoginPage();
        LoginPasswordPage loginPasswordPage = new LoginPasswordPage();

        loginPage.getPage();
        loginPage.fillUserField();
        loginPage.clickEntrar();
        loginPasswordPage.fillPasswordField();
        loginPasswordPage.clickEntrar();
    }

    public String getInvalidPassword() {
        Random random = new Random();
        return "Pass" + random.nextInt(999999);
    }

    public void checkUrl(String value) {
        Assert.assertTrue("O redirecionamento para a url esperada não ocorreu.", wait.until(ExpectedConditions.urlContains(value)));
    }

    public void checkTextInTable(By element, String expectedText) {
        try {
            WebElement webElement = getWait().until(ExpectedConditions.visibilityOfElementLocated(element));
            Assert.assertTrue("Texto não encontrado", webElement.getText().contains(expectedText));
        } catch(Exception exception) {
            System.out.println(exception.getStackTrace());
        }
    }
}