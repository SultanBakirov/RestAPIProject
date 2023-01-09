package com.example.convert.task;

import com.example.dto.request.TaskRequest;
import com.example.models.entities.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskRequestConvert {

    public Task create(TaskRequest taskRequest) {
        if (taskRequest == null) {
            return null;
        }
        Task task = new Task();
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadline(taskRequest.getDeadline());
        return task;
    }

    public void update(Task task, TaskRequest taskRequest) {
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadline(taskRequest.getDeadline());
    }
}
