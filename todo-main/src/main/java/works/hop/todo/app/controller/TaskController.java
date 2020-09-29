package works.hop.todo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import works.hop.todo.domain.model.Result;
import works.hop.todo.domain.model.Task;
import works.hop.todo.domain.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    final TaskService taskService;

    public TaskController(@Autowired TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        Result<List<Task>> result = taskService.getAllTasks();
        if (result.getError() == null) {
            return ResponseEntity.ok(result.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{name}")
    public ResponseEntity<Task> createTask(@PathVariable String name) {
        Result<Task> result = taskService.createTask(name);
        if (result.getError() == null) {
            return ResponseEntity.ok(result.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateTask(@PathVariable Long id) {
        Result<Task> result = taskService.updateTask(id);
        if (result.getError() == null) {
            return ResponseEntity.ok(result.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteTask(@PathVariable Long id) {
        Result<Integer> result = taskService.deleteTask(id);
        if (result.getError() == null) {
            return ResponseEntity.ok(result.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
