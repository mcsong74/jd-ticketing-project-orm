package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.entity.Project;
import com.cybertek.enums.Status;
import com.cybertek.mapper.ProjectMapper;
import com.cybertek.mapper.RoleMapper;
import com.cybertek.mapper.UserMapper;
import com.cybertek.repository.ProjectRepository;
import com.cybertek.service.ProjectService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectMapper projectMapper;
    private ProjectRepository projectRepository;
    private UserMapper userMapper;


    public ProjectServiceImpl(ProjectMapper projectMapper, ProjectRepository projectRepository, UserMapper userMapper) {
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
        this.userMapper = userMapper;
    }

    @Override
    public ProjectDTO getByProjectDto(String code) {
        return null;
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        List<Project> projects=projectRepository.findAll(Sort.by("projectCode"));
        return projects.stream()
                .map(projectMapper::convertToDTO).collect(Collectors.toList());
//        return projects.stream()
//                .map(prj->{
//                    return projectMapper.convertToDTO(prj);
//                }).collect(Collectors.toList());

    }

    @Override
    public void save(ProjectDTO dto) {
        dto.setProjectStatus(Status.OPEN);
        Project obj= projectMapper.convertToEntity(dto);
//        obj.setAssignedManager(userMapper.convertToEntity(dto.getAssignedManager()));
        projectRepository.save(obj);

    }

    @Override
    public ProjectDTO update(ProjectDTO dto) {
        return null;
    }

    @Override
    public void delete(String code) {
        Project project = projectRepository.findByProjectCode(code); //get Entity from database
        project.setIsDeleted(true); //set isDeleted value true in the Entity
        projectRepository.save(project);//save the updated entity to data base
    }
}
