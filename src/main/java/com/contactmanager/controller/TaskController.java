package com.contactmanager.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactmanager.entity.Task;
import com.contactmanager.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;
    private final TaskModelAssembler assembler;

    public TaskController(
            TaskService service,
            TaskModelAssembler assembler) {

        this.service = service;
        this.assembler = assembler;
    }

    // @Operation(summary = "Get all tasks")
    @GetMapping
    public CollectionModel<EntityModel<Task>> getAllTasks() {

        List<EntityModel<Task>> tasks =
                service.getAllTasks()
                        .stream()
                        .map(assembler::toModel)
                        .collect(Collectors.toList());

        return CollectionModel.of(tasks);
    }

    // @Operation(summary = "Get task by ID")
    @GetMapping("/{id}")
    public EntityModel<Task> getTask(
            @PathVariable Long id) {

        return assembler.toModel(
                service.getTask(id)
        );
    }

    // @Operation(summary = "Create new task")
    @PostMapping
    public EntityModel<Task> createTask(
            @Valid @RequestBody Task task) {

        Task savedTask =
                service.createTask(task);

        return assembler.toModel(savedTask);
    }

    // @Operation(summary = "Update existing task")
    @PutMapping("/{id}")
    public EntityModel<Task> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody Task task) {

        Task updatedTask =
                service.updateTask(id, task);

        return assembler.toModel(updatedTask);
    }

    // @Operation(summary = "Delete task")
    @DeleteMapping("/{id}")
    public void deleteTask(
            @PathVariable Long id) {

        service.deleteTask(id);
    }
}