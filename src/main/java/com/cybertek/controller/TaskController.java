package com.cybertek.controller;

import com.cybertek.dto.TaskDTO;
import com.cybertek.service.ProjectService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;
//
//
    @GetMapping("/create")
    public String createTask(Model model) {
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projectlist", projectService.listAllProjects());
        model.addAttribute("employeelist", userService.listAllByRole("employee"));
        model.addAttribute("tasklist", taskService.listAllTasks());
        return "/task/create";
    }
//
    @PostMapping("/create")
    public String addTask(TaskDTO task, Model model) {
        taskService.save(task);
////        task.setId((long) (taskService.findAll().size()+1));
//        task.setId(UUID.randomUUID().getMostSignificantBits());
//        task.setAssignedDate(LocalDate.now());
//        task.setStatus(Status.OPEN);

//        taskService.save(task);


        return "redirect:/task/create";
    }
//
    @GetMapping("/delete/{id}")
    public String deleteTask(TaskDTO task) {
        taskService.delete(task.getId());
        return "redirect:/task/create";
    }
//
    @GetMapping("/update/{id}")
    public String editTask(@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("projectlist", projectService.listAllProjects());
        model.addAttribute("employeelist", userService.listAllByRole("Employee"));
        model.addAttribute("tasklist", taskService.listAllTasks());
        return "/task/update";
    }

    @PostMapping("/update/{id}")
    public String editTask(TaskDTO task) {
//        task.setStatus(taskService.findById(id).getStatus());     //implemented to TaskServiceImpl
//        task.setAssignedDate(taskService.findById(id).getAssignedDate()); //implemented to TaskServiceImpl
        taskService.update(task);

        return "redirect:/task/create";
    }
//
//    @GetMapping("/employee/pending")
//    public String pendingTasks(Model model) {
//        model.addAttribute("task", new TaskDTO());
//        model.addAttribute("projectlist", projectService.findAll());
//        model.addAttribute("employeelist", userService.findEmployees());
//        model.addAttribute("tasklist", taskService.findTasksByEmployee(userService.findById("bill@cybertek.com")));
//        return "/employee/pending-tasks";
//    }
//
//    @GetMapping("/employee/update/{id}")
//    public String editPendingTask(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("task", taskService.findById(id));
//        model.addAttribute("projectlist", projectService.findAll());
//        model.addAttribute("employeelist", userService.findEmployees());
//        model.addAttribute("tasklist", taskService.findTasksByEmployee(userService.findById("bill@cybertek.com")));
//        return "/employee/update";
//    }
//
//    @PostMapping("/employee/update/{id}")
//    public String updatePendingTask(TaskDTO task, Model model) {
//        taskService.findById(task.getId()).setStatus(task.getStatus());
//
////        model.addAttribute("task", new TaskDTO());
////        model.addAttribute("projectlist", projectService.findAll());
////        model.addAttribute("employeelist", userService.findEmployees());
////        model.addAttribute("tasklist", taskService.findTasksByEmployee(userService.findById("bill@cybertek.com")));
//        return "redirect:/task/employee/pending";
//    }
//
//    @GetMapping("/employee/archived")
//    public String archived(Model model) {
////        model.addAttribute("tasklist", taskService.findAll());
//        model.addAttribute("tasklist",
//                taskService.findTasksByEmployee(userService.findById("bill@cybertek.com")).stream()
//                        .filter(task -> task.getStatus().equals(Status.COMPLETE))
//                        .collect(Collectors.toList()));
//        return "/employee/archived";
//    }

}
