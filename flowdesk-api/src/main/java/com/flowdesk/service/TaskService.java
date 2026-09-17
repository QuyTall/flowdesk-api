package com.flowdesk.service;

import com.flowdesk.dto.TaskRequest;
import com.flowdesk.dto.TaskResponse;
import com.flowdesk.entity.Task;
import com.flowdesk.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskResponse addTask(TaskRequest request) {
        Task task = Task.builder()
                .title(request.getTitle())
                .priority(request.getPriority())
                .deadline(request.getDeadline())
                .status("Todo")
                .completed(false)
                .build();

        Task saved = taskRepository.save(task);
        return toResponse(saved);
    }

    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
    public TaskResponse completeTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus("Done");
        task.setCompleted(true);
        return toResponse(taskRepository.save(task));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    private TaskResponse toResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .status(task.getStatus())
                .priority(task.getPriority())
                .deadline(task.getDeadline())
                .completed(task.isCompleted())
                .build();
    }
}