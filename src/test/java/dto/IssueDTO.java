package dto;

public class IssueDTO {

    private String frequencia;
    private String gravidade;
    private String prioridade;
    private String atribuir;
    private String resumo;
    private String description;

    public void setFrequencia(String value) {
        this.frequencia = value;
    }

    public String getFrequencia() {
        return this.frequencia;
    }

    public void setGravidade(String value) {
        this.gravidade = value;
    }

    public String getGravidade() {
        return this.gravidade;
    }

    public void setPrioridade(String value) {
        this.prioridade = value;
    }

    public String getPrioridade() {
        return this.prioridade;
    }

    public void setAtribuir(String value) {
        this.atribuir = value;
    }

    public String getAtribuir() {
        return this.atribuir;
    }

    public void setResumo(String value) {
        this.resumo = value;
    }

    public String getResumo() {
        return this.resumo;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getDescription() {
        return this.description;
    }

}
