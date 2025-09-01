package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class CreateIssuePage extends BasePage {

    String pageUrl = "/bug_report_page.php";

    private By categoryLabel = By.xpath("//th[@class='category']/label[@for='category_id']");
    private By frequenciaLabel = By.xpath("//th[@class='category']/label[@for='reproducibility']");
    private By gravidadeLabel = By.xpath("//th[@class='category']/label[@for='severity']");
    private By priorityLabel = By.xpath("//th[@class='category']/label[@for='priority']");
    private By profileIdLabel = By.xpath("//th[@class='category']/label[@for='profile_id']");

    private By categoryCombo = By.id("category_id");
    private By frequenciaCombo = By.id("reproducibility");
    private By gravidadeCombo = By.id("severity");
    private By priorityCombo = By.id("priority");
    private By atribuiraCombo = By.id("handler_id");
    private By resumoField = By.id("summary");
    private By descriptionField = By.id("description");

    private By criarIssueButton = By.xpath("//*[@id='report_bug_form']/div/div[2]/div[2]/input");

    public void getPage() {
        navigateTo(pageUrl);
    }

    public void selectCategory(String value) {
        selectCombobox(categoryCombo, value);
    }

    public void selectFrequencia(String value) {
        selectCombobox(frequenciaCombo, value);
    }

    public void selectGravidade(String value) {
        selectCombobox(gravidadeCombo, value);
    }

    public void selectPriority(String value) {
        selectCombobox(priorityCombo, value);
    }

    public void clickCriarIssueButton() {
        clickElement(criarIssueButton);
    }

    public void selectAtribuir(String value) {
        selectCombobox(atribuiraCombo, value);
    }

    public void fillResumo(String value) {
        fillField(resumoField, value);
    }

    public void fillDescription(String value) {
        fillField(descriptionField, value);
    }

    public void checkCreateIssuePage() {
        Assert.assertEquals("Categoria", getDriver().findElement(categoryLabel).getText());
        Assert.assertEquals("Freqüência", getDriver().findElement(frequenciaLabel).getText());
        Assert.assertEquals("Gravidade", getDriver().findElement(gravidadeLabel).getText());
        Assert.assertEquals("Prioridade", getDriver().findElement(priorityLabel).getText());
        Assert.assertEquals("Selecionar Perfil", getDriver().findElement(profileIdLabel).getText());
    }
}