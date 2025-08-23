package datatest;

import dto.ProjectDTO;
import support.SharedData;

import static support.FakeData.*;

public class ProjectDatatest {

    public static ProjectDTO setValue() {

        ProjectDTO projectDTO = new ProjectDTO();

        projectDTO.setNome(getProjectName());
        projectDTO.setEstado(getProjectState());
        projectDTO.setHabilitado(getBoolean());
        projectDTO.setHerdarCategorias(getBoolean());
        projectDTO.setVisibilidade(getProjectVisibilidade());
        projectDTO.setDescricao(getProjectDescription());

        SharedData.set("projectDTO", projectDTO);
        return projectDTO;
    }
}
