package com.contactmanager.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.contactmanager.entity.Task;

@Component
public class TaskModelAssembler
        implements RepresentationModelAssembler<Task, EntityModel<Task>> {

    @Override
    public @NonNull EntityModel<Task> toModel(Task task) {

        return EntityModel.of(
                task,

                linkTo(
                        methodOn(TaskController.class)
                                .getTask(task.getId()))
                        .withSelfRel(),

                linkTo(
                        methodOn(TaskController.class)
                                .getAllTasks())
                        .withRel("tasks")
        );
    }
}