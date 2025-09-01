package pages;

import org.openqa.selenium.By;

public class EditProjectPage extends BasePage {

    private By nameProjectField = By.id("project-name");
    private By descriptionProjectField = By.id("project-description");
    private By atualizeProjectButton = By.xpath("//*[@id='manage-proj-update-form']/div/div[3]/input");
    private By deleteProjectButton = By.xpath("//*[@id='project-delete-form']/fieldset/input[3]");
    private By confirmationMessage = By.xpath("//*[@id='main-container']/div[2]/div[2]/div/div/div[2]/p");
    private By confirmationDeleteButton = By.xpath("//*[@id='main-container']/div[2]/div[2]/div/div/div[2]/form/input[4]");

    public void fillNameProjectField(String value) {
        fillField(nameProjectField, value);
    }

    public void fillDescriptionField(String value) {
        fillField(descriptionProjectField, value);
    }

    public void clickAtualizeProjectButton() {
        clickElement(atualizeProjectButton);
    }

    public void clickDeleteProjectButton() {
        clickElement(deleteProjectButton);
    }

    public void checkConfirmationMessage(String value) {
        checkAlertMessage(confirmationMessage, value);
    }

    public void clickConfirmDeleteProject() {
        clickElement(confirmationDeleteButton);
    }
}
