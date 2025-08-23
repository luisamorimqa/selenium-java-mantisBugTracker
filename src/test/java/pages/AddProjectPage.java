package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class AddProjectPage extends BasePage {

    String pageUrl = "/manage_proj_create_page.php";

    public void getPage() {
        getDriver().get(getBaseUrl() + pageUrl);
    }

    private By pageTitle = By.xpath("//*[@id='manage-project-create-form']/div/div[1]/h4");
    private By projectNameField = By.id("project-name");
    private By projectStatusCombo = By.id("project-status");
    private By herdarCategoriasGlobaisCheck = By.xpath("//input[@id='project-inherit-global']");
    private By visibilityProjectCombo = By.id("project-view-state");
    private By projectDescriptionField = By.id("project-description");
    private By addProjectButton = By.xpath("//*[@id='manage-project-create-form']/div/div[3]/input");

    public void fillProjectName(String value) {
        fillField(projectNameField, value);
    }

    public void selectProjectStatus(String value) {
        selectCombobox(projectStatusCombo, value);
    }

    public void checkHerdarCategorias(boolean value) {
        clickCheckBox(herdarCategoriasGlobaisCheck, value);
    }

    public void selectVisibilityProject(String value) {
        selectCombobox(visibilityProjectCombo, value);
    }

    public void fillDescriptionField(String value) {
        fillField(projectDescriptionField, value);
    }

    public void clickAddProjectButton() {
        clickElement(addProjectButton);
    }

    public void checkAddProjectPage() {
        Assert.assertEquals("Adicionar projeto", getTextElement(pageTitle));
    }

}
