package com.cybertek.service;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.TaskDTO;
import com.cybertek.entity.Task;

import java.util.List;

public interface TaskService {
    TaskDTO findById(Long taskId);
    List<TaskDTO> listAllTasks();
    Task save(TaskDTO dto);

    void update(TaskDTO dto);
    void delete(Long taskId);

    int totalCountNonCompletedTasks(String projectCode);
    int totalCountCompletedTasks(String projectCode);

    List<TaskDTO> listAllTasksByProject(ProjectDTO project);
    void deleteByProject(ProjectDTO project);


}
