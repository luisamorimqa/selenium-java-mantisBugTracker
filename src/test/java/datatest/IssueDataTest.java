package datatest;

import dto.IssueDTO;
import support.SharedData;

import static support.FakeData.*;

public class IssueDataTest {

    public static IssueDTO setValue() {
        IssueDTO issueDTO = new IssueDTO();

        issueDTO.setFrequencia(getIssueFrequencia());
        issueDTO.setGravidade(getIssueGravidade());
        issueDTO.setPrioridade(getIssuePrioridade());
        issueDTO.setAtribuir(getRandomUser());
        issueDTO.setResumo(getRandomParagrph());
        issueDTO.setDescription(getRandomParagrph());

        SharedData.set("issueDTO", issueDTO);
        return issueDTO;
    }
}
