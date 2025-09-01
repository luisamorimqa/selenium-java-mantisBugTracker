package pages;

import support.Commands;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class BasePage extends Commands {

    public String getBaseUrl() {
        Properties properties = new Properties();

        try(InputStream input = new FileInputStream("src/test/resources/credentials.properties")) {
            properties.load(input);
            return properties.getProperty("baseUrl");
        }
        catch (Exception exception) {
            return String.valueOf(exception);
        }
    }

    public void navigateTo(String navegador, String value) {
        getDriver(navegador).get(getBaseUrl() + value);
    }

    public void navigateTo(String value) {
        getDriver().get(getBaseUrl() + value);
    }
}