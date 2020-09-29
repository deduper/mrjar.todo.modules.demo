package works.hop.todo.domain.service;

import works.hop.todo.domain.model.Result;
import works.hop.todo.domain.model.Task;

import java.util.List;

public interface TaskService {

    Result<Task> createTask(String task);

    Result<Task> updateTask(Long id);

    Result<List<Task>> getAllTasks();

    Result<Integer> deleteTask(Long id);
}
