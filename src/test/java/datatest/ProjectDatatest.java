package datatest;

import dto.ProjetoDTO;
import support.SharedData;

import static support.FakeData.*;

public class ProjetoDatatest {

    public static ProjetoDTO setValue() {

        ProjetoDTO projetoDTO = new ProjetoDTO();

        projetoDTO.setNome(getProjectName());
        projetoDTO.setEstado(getProjectState());
        projetoDTO.setHabilitado(getBoolean());
        projetoDTO.setHerdarCategorias(getBoolean());
        projetoDTO.setVisibilidade(getProjectVisibilidade());
        projetoDTO.setDescricao(getProjectDescription());

        SharedData.set("projetoDTO", projetoDTO);
        return projetoDTO;
    }
}
