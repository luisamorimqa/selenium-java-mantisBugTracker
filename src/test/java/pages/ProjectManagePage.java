package pages;

import org.openqa.selenium.By;

public class ProjectManagePage extends BasePage {

    String pageUrl = "/manage_proj_page.php";

    public void getPage() {
        getDriver().get(getBaseUrl() + pageUrl);
    }

    private By createProjectButton = By.xpath("//button[@class='btn btn-primary btn-white btn-round']");
    private By projectsTable = By.xpath("//*[@id='main-container']/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/table");
    private By projectsName = By.xpath("//table[@class='table table-striped table-bordered table-condensed table-hover']/tbody/tr/td");

    public void clickCreateProjectButton() {
        clickElement(createProjectButton);
    }

    public void checkProjectInTable(String value) {
        checkTextInTable(projectsTable, value);
    }

    public void accessProject(String value) {
        clickTextInTable(projectsName, value);
        System.out.println("Acessando projeto");
    }

    public void checkProjectDeleted(String value) {
        checkTextNonExistentInTable(projectsTable, value);
    }

}
