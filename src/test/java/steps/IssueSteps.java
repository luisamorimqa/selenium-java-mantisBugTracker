package steps;

import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import datatest.IssueDataTest;
import dto.IssueDTO;
import pages.CreateIssuePage;
import pages.CreatedIssuePage;

public class IssueSteps {

    CreateIssuePage createIssuePage = new CreateIssuePage();
    CreatedIssuePage createdIssuePage = new CreatedIssuePage();

    @Quando("^acesso a tela Create Issue$")
    public void acesso_a_tela_Create_Issue() {
        createIssuePage.getPage();
        createIssuePage.checkCreateIssuePage();
    }

    @Quando("^preencho os campos obrigatórios$")
    public void preencho_os_campos_obrigatórios() {
        IssueDTO issueDTO = IssueDataTest.setValue();

        createIssuePage.selectFrequencia(issueDTO.getFrequencia());
        createIssuePage.selectGravidade(issueDTO.getGravidade());
        createIssuePage.selectPriority(issueDTO.getPrioridade());
        createIssuePage.selectAtribuir(issueDTO.getAtribuir());
        createIssuePage.fillResumo(issueDTO.getResumo());
        createIssuePage.fillDescription(issueDTO.getDescription());
    }

    @Quando("^salvo a issue$")
    public void salvo_a_issue() {
       createIssuePage.clickCriarIssueButton();
    }

    @Então("^a issue deve ser criada e aparecer na lista de issues do projeto$")
    public void a_issue_deve_ser_criada_e_aparecer_na_lista_de_issues_do_projeto() {
        createdIssuePage.checkSuccessMessage("Operação realizada com sucesso.");
    }
}
