package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import datatest.ProjectDatatest;
import dto.ProjectDTO;
import pages.AddProjectPage;
import pages.LoginPage;
import pages.ProjectCreatedPage;
import pages.ProjectManagePage;
import support.SharedData;

public class ProjectSteps {

    LoginPage loginPage = new LoginPage();
    ProjectManagePage projectManagePage = new ProjectManagePage();
    AddProjectPage addProjectPage = new AddProjectPage();
    ProjectCreatedPage projectCreatedPage = new ProjectCreatedPage();

    @Dado("^que estou logado como administrador$")
    public void que_estou_logado_como_administrador() {
       loginPage.loginAdmin();
       ProjectDTO projectDTO = ProjectDatatest.setValue();
    }

    @Dado("^estou na tela de gerenciamento de projetos$")
    public void estou_na_tela_de_gerenciamento_de_projetos() {
        projectManagePage.getPage();
    }

    @Quando("^clico em Criar novo projeto$")
    public void clico_em_Criar_novo_projeto() {
        projectManagePage.clickCreateProjectButton();
    }

    @Quando("^preencho os dados do projeto$")
    public void preencho_o_nome_do_projeto() {
        ProjectDTO projectDTO = SharedData.get("projectDTO");
        addProjectPage.checkAddProjectPage();
        addProjectPage.fillProjectName(projectDTO.getNome());
        addProjectPage.checkHerdarCategorias(projectDTO.getHerdarCategorias());
        addProjectPage.selectProjectStatus(projectDTO.getEstado());
        addProjectPage.selectVisibilityProject(projectDTO.getVisibilidade());
        addProjectPage.fillDescriptionField(projectDTO.getDescricao());
    }

    @Quando("^clico em Adicionar projeto$")
    public void clico_em_Adicionar_projeto() {
        addProjectPage.clickAddProjectButton();
    }

    @Então("^o projeto deve ser criado com sucesso$")
    public void o_projeto_deve_ser_criado_com_sucesso() {
        ProjectDTO projectDTO = SharedData.get("projectDTO");

        projectCreatedPage.checkSuccessMessage("Operação realizada com sucesso.");
        projectManagePage.checkProjectInTable(projectDTO.getNome());
    }
}