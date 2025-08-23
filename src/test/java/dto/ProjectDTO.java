package dto;

public class ProjectDTO {

    private String nome;
    private String estado;
    private boolean habilitado;
    private boolean herdarCategorias;
    private String visibilidade;
    private String descricao;

    public ProjectDTO() {}

    public ProjectDTO(String nome, String estado, boolean habilitado, boolean herdarCategorias, String visibilidade, String descricao) {
        this.nome = nome;
        this.estado = estado;
        this.habilitado = habilitado;
        this.herdarCategorias = herdarCategorias;
        this.visibilidade = visibilidade;
        this.descricao = descricao;
    }

    public void setNome(String value) {
        this.nome = value;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEstado(String value) {
        this.estado = value;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setHabilitado(boolean value) {
        this.habilitado = value;
    }

    public boolean getHabilitado() {
        return this.habilitado;
    }

    public void setHerdarCategorias(boolean value) {
        this.herdarCategorias = value;
    }

    public boolean getHerdarCategorias() {
        return this.herdarCategorias;
    }

    public void setVisibilidade(String value) {
        this.visibilidade = value;
    }

    public String getVisibilidade(){
        return this.visibilidade;
    }

    public void setDescricao(String value) {
        this.descricao = value;
    }

    public String getDescricao() {
        return this.descricao;
    }
}