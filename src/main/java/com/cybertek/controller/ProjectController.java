package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
//    ProjectService projectService;
//    UserService userService;
//    TaskService taskService;
//    public ProjectController(ProjectService projectService, UserService userService, TaskService taskService) {
//        this.projectService = projectService;
//        this.userService = userService;
//        this.taskService=taskService;
//    }
//
//    @GetMapping("/create")
//    public String createProject(Model model){
//        model.addAttribute("project", new ProjectDTO());
////        List<UserDTO> managerList=userService.findAll().stream()
////                .filter(user->user.getRole().getDescription().equals("Manager"))
////                .collect(Collectors.toList());
////        model.addAttribute("managerList", managerList);
//        model.addAttribute("project", new ProjectDTO());
//        model.addAttribute("managerList", userService.findAll().stream()
//                .filter(user->user.getRole().getDescription().equals("Manager"))
//                .collect(Collectors.toList()));
//        model.addAttribute("projectlist", projectService.findAll());
//
//        return "/project/create";
//    }
//    @PostMapping("/create")
//    public String insertProject(ProjectDTO project){
//        projectService.save(project);
//        project.setProjectStatus(Status.OPEN);
//        return "redirect:/project/create";
//    }
//    @GetMapping("/delete/{projectcode}")
//    public String deleteProject(@PathVariable("projectcode") String projectcode){
//        projectService.deleteById(projectcode);
//        return "redirect:/project/create";
//    }
//
//    @GetMapping("/update/{projectcode}")
//    public String editProject(@PathVariable("projectcode") String projectcode, Model model){
//        model.addAttribute("project", projectService.findById(projectcode));
//        model.addAttribute("managerlist", userService.findManagers());
////        model.addAttribute("managerlist", userService.findAll().stream()
////                .filter(user->user.getRole().getDescription().equals("Manager"))
////                .collect(Collectors.toList()));
//        model.addAttribute("projectlist", projectService.findAll());
//        return "/project/update";
//    }
//
//    @PostMapping("/update/{projectcode}")
//    public String updateProject(@PathVariable("projectcode") String projectcode, ProjectDTO project){
////        project.setProjectStatus(projectService.findById(projectcode).getProjectStatus()); //implemented to service
//        projectService.updateByObj(project);
//        //redirect replaced below commented
////        model.addAttribute("project", new ProjectDTO());
////        model.addAttribute("managerlist", userService.findAll().stream()
////                .filter(user->user.getRole().getDescription().equals("Manager"))
////                .collect(Collectors.toList()));
////        model.addAttribute("projectlist", projectService.findAll());
//        return "redirect:/project/create";
//    }
//
//    @GetMapping("/complete/{projectcode}")
//    public String completeProject(@PathVariable("projectcode") String projectcode){
////        projectService.findById(projectcode).setProjectStatus(Status.COMPLETE);
//        projectService.complete(projectService.findById(projectcode));
//        return "redirect:/project/create";
//    }
//
//
//    @GetMapping("/manager/complete")
//    public String getProjectByManager(Model model){
//
////        List<ProjectDTO> projects=projectService.findAll().stream()
////                .filter(p->p.getAssignedManager().equals(userService.findById("john@cybertek.com")))
////                .collect(Collectors.toList());
//        model.addAttribute("projects", getCountedListOfProjectDTOByManager(userService.findById("john@cybertek.com")));
//
//
//
//        return "/manager/project-status";
//    }
//
//    public List<ProjectDTO> getCountedListOfProjectDTOByManager(UserDTO manager){
//        List<ProjectDTO> list=projectService.findAll().stream()
//                .filter(p->p.getAssignedManager().equals(manager))
//                .map(p->{
//                    List<TaskDTO> taskList=taskService.findTaskByManager(manager);
//                    int completedCount=(int) taskList.stream()
//                            .filter(t->t.getProject().equals(p) && t.getStatus().equals(Status.COMPLETE)).count();
//                    int inCompleteCount=(int) taskList.stream()
//                            .filter(t->t.getProject().equals(p) && t.getStatus() != Status.COMPLETE).count();
//
//                    p.setCompletedTaskCount(completedCount);
//                    p.setUnfinishedTaskCount(inCompleteCount);
////                    return new ProjectDTO( p.getProjectName(),p.getProjectCode(),
////                            userService.findById(p.getAssignedManager().getUserName()),
////                            p.getStartDate(), p.getEndDate(), p.getProjectDetails(), p.getProjectStatus(),
////                            completedCount, inCompleteCount);
//                    return p;
//                }).collect(Collectors.toList());
//        return list;
//    }
//
//
//





}
