package com.example.convert.task;

import com.example.dto.response.TaskResponse;
import com.example.models.entities.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskResponseConvert {

    public TaskResponse viewTask(Task task) {
        if (task == null) {
            return null;
        }
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setTaskName(task.getTaskName());
        taskResponse.setTaskText(task.getTaskText());
        taskResponse.setDeadline(task.getDeadline());
        return taskResponse;
    }

    public List<TaskResponse> getAllTasks(List<Task> tasks) {
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (Task task: tasks) {
            taskResponses.add(viewTask(task));
        }
        return taskResponses;
    }
}
