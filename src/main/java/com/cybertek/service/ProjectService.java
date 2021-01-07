package com.cybertek.service;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.entity.Project;

import java.util.List;

public interface ProjectService {
    ProjectDTO getByProjectDto(String code);
    List<ProjectDTO> listAllProjects();
    void save(ProjectDTO dto);
    void update(ProjectDTO dto);
    void delete(String projectCode);

    void complete(String projectCode);

}
