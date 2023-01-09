package com.example.services.impls;

import com.example.convert.task.TaskRequestConvert;
import com.example.convert.task.TaskResponseConvert;
import com.example.dto.request.TaskRequest;
import com.example.dto.response.TaskResponse;
import com.example.models.entities.Task;
import com.example.repositories.TaskRepository;
import com.example.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskRequestConvert taskRequestConvert;
    private final TaskResponseConvert taskResponseConvert;

    @Override
    public TaskResponse saveTask(TaskRequest taskRequest) {
        Task task = taskRequestConvert.create(taskRequest);
        taskRepository.save(task);
        return taskResponseConvert.viewTask(task);
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        return taskResponseConvert.getAllTasks(taskRepository.findAll());
    }

    @Override
    public TaskResponse getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId).get();
        return taskResponseConvert.viewTask(task);
    }

    @Override
    public TaskResponse deleteTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId).get();
        taskRepository.delete(task);
        return taskResponseConvert.viewTask(task);
    }

    @Override
    public TaskResponse updateTask(Long taskId, TaskRequest taskRequest) {
        Task task = taskRepository.findById(taskId).get();
        taskRequestConvert.update(task, taskRequest);
        return taskResponseConvert.viewTask(taskRepository.save(task));
    }
}
