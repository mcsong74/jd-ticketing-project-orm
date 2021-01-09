package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.TaskDTO;
import com.cybertek.entity.Task;
import com.cybertek.enums.Status;
import com.cybertek.mapper.ProjectMapper;
import com.cybertek.mapper.TaskMapper;
import com.cybertek.repository.TaskRepository;
import com.cybertek.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskMapper taskMapper;
    private TaskRepository taskRepository;
    private ProjectMapper projectMapper;

    public TaskServiceImpl(TaskMapper taskMapper, TaskRepository taskRepository) {
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDTO findById(Long taskId) {
        Optional<Task> task=taskRepository.findById(taskId);
        if (task.isPresent()){
            return taskMapper.converToDTO(task.get());
        }
        return null;
    }

    @Override
    public List<TaskDTO> listAllTasks() {
        List<Task> tasks=taskRepository.findAll();
//        List<Task> tasks=taskRepository.findAll();
        return tasks.stream()
                .map(taskMapper::converToDTO).collect(Collectors.toList());
//        return tasks.stream()
//                .map(task-> {
//                    return taskMapper.converToDTO(task);
//                }).collect(Collectors.toList());

    }

    @Override
    public Task save(TaskDTO dto) {
        dto.setStatus(Status.OPEN);
        dto.setAssignedDate(LocalDate.now());
        Task task=taskMapper.convertToEntity(dto);

        return taskRepository.save(task);
    }

    @Override
    public void update(TaskDTO dto) {
        Optional <Task> task=taskRepository.findById(dto.getId());
        Task convertedTask=taskMapper.convertToEntity(dto);
        if(task.isPresent()){
            convertedTask.setId(task.get().getId());
            convertedTask.setStatus(task.get().getStatus());
            convertedTask.setAssignedDate(task.get().getAssignedDate());
            taskRepository.save(convertedTask);
        }
    }

    @Override
    public void delete(Long taskId) {
       Optional<Task> foundTask=taskRepository.findById(taskId);
//       Task foundTask= taskRepository.findById(taskId).get();
       if (foundTask.isPresent()){
            foundTask.get().setIsDeleted(true);
            taskRepository.save(foundTask.get());
       }

    }

    @Override
    public int totalCountNonCompletedTasks(String projectCode) {

        return taskRepository.totalCountNonCompletedTasks(projectCode);

    }

    @Override
    public int totalCountCompletedTasks(String projectCode) {

        return taskRepository.totalCountCompletedTasks(projectCode);
    }

    @Override
    public List<TaskDTO> listAllTasksByProject(ProjectDTO project) {
        List<Task> list=taskRepository.findAllByProject(projectMapper.convertToEntity(project));
        return list.stream().map(task->{
            return taskMapper.converToDTO(task);
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteByProject(ProjectDTO project) {
        List<TaskDTO> taskDTOS=listAllTasksByProject(project);
        taskDTOS.stream().forEach(taskDTO -> delete(taskDTO.getId()));


    }
}