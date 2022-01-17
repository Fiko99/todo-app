package com.example.todoapp.logic;

import com.example.todoapp.model.ProjectRepository;
import com.example.todoapp.model.TaskGroupRepository;
import com.example.todoapp.model.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LogicConfiguration {
    @Bean
    ProjectService projectService(ProjectRepository repository, TaskGroupRepository taskGroupRepository, TaskGroupService taskGroupService) {
        return new ProjectService(repository, taskGroupRepository, taskGroupService);
    }

    @Bean
    TaskGroupService taskGroupService(TaskGroupRepository repository, TaskRepository taskRepository) {
        return new TaskGroupService(repository, taskRepository);
    }
}
