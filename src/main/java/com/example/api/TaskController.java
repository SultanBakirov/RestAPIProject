package com.example.api;

import com.example.dto.request.TaskRequest;
import com.example.dto.response.TaskResponse;
import com.example.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/save")
    public TaskResponse saveTask(@RequestBody TaskRequest taskRequest) {
        return taskService.saveTask(taskRequest);
    }

    @GetMapping("/getAll")
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public TaskResponse getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PutMapping("/{taskId}")
    public TaskResponse updateTask(@PathVariable Long taskId, @RequestBody TaskRequest taskRequest) {
        return taskService.updateTask(taskId, taskRequest);
    }

    @DeleteMapping("/{taskId}")
    public TaskResponse deleteTaskById(@PathVariable Long taskId) {
        return taskService.deleteTaskById(taskId);
    }
}
