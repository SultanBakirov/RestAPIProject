package com.example.services;

import com.example.dto.request.TaskRequest;
import com.example.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse saveTask(TaskRequest taskRequest);

    List<TaskResponse> getAllTasks();

    TaskResponse getTaskById(Long taskId);

    TaskResponse deleteTaskById(Long taskId);

    TaskResponse updateTask(Long taskId, TaskRequest taskRequest);

}
