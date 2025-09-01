package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import datatest.ProjectDatatest;
import dto.ProjectDTO;
import pages.*;
import support.SharedData;

public class ProjectSteps {

    LoginPage loginPage = new LoginPage();
    ProjectManagePage projectManagePage = new ProjectManagePage();
    AddProjectPage addProjectPage = new AddProjectPage();
    ProjectCreatedPage projectCreatedPage = new ProjectCreatedPage();
    EditProjectPage editProjectPage = new EditProjectPage();

    @Dado("^que estou logado como administrador$")
    public void que_estou_logado_como_administrador() {
       loginPage.loginAdmin();
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
        ProjectDTO projectDTO = ProjectDatatest.setValue();
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

    @Dado("^tenho um projeto ja cadastrado$")
    public void tenho_um_projeto_ja_cadastrado() {
        ProjectDTO projectDTO = ProjectDatatest.setValue();
        addProjectPage.createProject(projectDTO);
    }

    @Quando("^acesso o projeto$")
    public void edito_o_projeto() {
        ProjectDTO projectDTO = SharedData.get("projectDTO");
        projectManagePage.accessProject(projectDTO.getNome());
    }

    @Quando("^altero suas informações$")
    public void altero_sua_descrição() {
        ProjectDTO projectDTO = SharedData.get("projectDTO");

        String novoNome = projectDTO.getNome() + " ALTERADO! ALTERADO! ";
        editProjectPage.fillNameProjectField(novoNome);
        editProjectPage.clickAtualizeProjectButton();
    }

    @Então("^as alterações devem ser salvas corretamente$")
    public void as_alterações_devem_ser_salvas_corretamente() {
        ProjectDTO projectDTO = SharedData.get("projectDTO");
        String novoNome = projectDTO.getNome() + " ALTERADO! ALTERADO! ";
        projectManagePage.checkProjectInTable(novoNome);

        System.out.println("NOME VALIDADO!!!!!");
    }


    @Quando("^clico no botão de deleção$")
    public void clico_no_botão_de_deleção() {
        editProjectPage.clickDeleteProjectButton();
    }

    @Quando("^confirmo a deleção$")
    public void confirmo_a_deleção() {
        editProjectPage.checkConfirmationMessage("Você tem certeza que deseja apagar este projeto e todas as tarefas relacionadas?");
        editProjectPage.clickConfirmDeleteProject();
    }

    @Então("^o projeto deve ser deletado com sucesso$")
    public void o_projeto_deve_ser_deletado_com_sucesso() {
        ProjectDTO projectDTO = SharedData.get("projectDTO");
        projectManagePage.checkProjectDeleted(projectDTO.getNome());
    }
}