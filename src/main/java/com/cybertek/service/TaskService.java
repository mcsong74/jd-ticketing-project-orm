package com.cybertek.service;

import com.cybertek.dto.TaskDTO;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TaskService {
    TaskDTO findById(Long taskId);
    List<TaskDTO> listAllTasks();
    Task save(TaskDTO dto);

    void update(TaskDTO dto);
    void delete(Long taskId);


}
